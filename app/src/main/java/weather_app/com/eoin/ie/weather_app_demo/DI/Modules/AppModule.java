package weather_app.com.eoin.ie.weather_app_demo.DI.Modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import weather_app.com.eoin.ie.weather_app_demo.Utils.CachedHttpClient;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtil;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtilImp;
import weather_app.com.eoin.ie.weather_app_demo.WeatherApp;

/**
 * Created by eoin_a on 02/06/2016.
 */

@Module
public class AppModule {


    private WeatherApp app;

    public AppModule(WeatherApp appin)
    {
      app = appin;
    }

    @Provides
    @Singleton
    public Context getContext()
    {
        return app;
    }

    @Provides
    @Singleton
    public SharedPreferences getprefs()
    {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    public SharedPreferences.Editor getPrefsEdit()
    {
       return PreferenceManager.getDefaultSharedPreferences(app).edit();
    }


    @Provides
    @Singleton
    public Gson getGson()
    {
       return new Gson();
    }


    @Provides
    @Singleton
    public Handler getHandler()
    {
        return  new Handler(Looper.getMainLooper());
    }


    @Provides
    @Singleton
    public OkHttpClient getClient()
    {
        return new CachedHttpClient(app).getClient();
    }

    @Provides
    @Singleton
    public DateFormatterUtil getDateFormatter()
    {
        return new DateFormatterUtilImp();
    }



}
