package weather_app.com.eoin.ie.weather_app_demo.DI.Modules;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather_app.com.eoin.ie.weather_app_demo.DI.Scopes.ActivityScope;
import weather_app.com.eoin.ie.weather_app_demo.Domain.Repository.WeatherServiceRepo;

/**
 * Created by eoin_a on 05/06/2016.
 */
@Module
public class WebModule {

    private String apikey = "63f0914cdd082e76d25b40161cbe70c4";


    public WebModule()
    {

    }


    @Provides
    @Named("api_key")
    public String apikey()
    {
      return apikey;
    }

    @Provides
    @Named("base_url")
    public String getUrl(@Named("api_key")String apikey)
    {
        return "https://api.forecast.io/forecast/" +  apikey + "/" ;
    }


    @ActivityScope
    @Provides
    public WeatherServiceRepo getRetrofit(@Named("base_url") String url, OkHttpClient client)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(WeatherServiceRepo.class);
    }

}
