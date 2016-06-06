package weather_app.com.eoin.ie.weather_app_demo.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by eoin_a on 06/06/2016.
 *
 * Cached client. used to cache data from the sever requests.
 * also uses a singleton instance as required.  from the docs i need
 * a singleton because "Otherwise the two cache instances will stomp on each other,
 * corrupt the response cache, and possibly crash your program."
 * therefore, this gets instantiated in the AppModule.
 */
public class CachedHttpClient {

    private OkHttpClient client;
    private Context cont;
    private ConnectivityManager connmanager;

    public CachedHttpClient(Context contin)
    {
        cont = contin;
        connmanager = (ConnectivityManager) cont.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public OkHttpClient getClient()
    {
        client = new OkHttpClient
                .Builder()
                .cache(new Cache(cont.getCacheDir(), 1 * 1024 * 1024)) // 1 MB probably a lot more than i need.
                .addInterceptor(new Interceptor() {
                    @Override public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if (checkConn()) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();

                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        }
                        return chain.proceed(request);
                    }
                })
                .build();

        return client;
    }


    /**
     * ideally this should be its own class
     * @return bool
     */

    private boolean checkConn()
    {
        NetworkInfo ni = connmanager.getActiveNetworkInfo();
        return ((ni != null) && (ni.isConnectedOrConnecting()));
    }




}
