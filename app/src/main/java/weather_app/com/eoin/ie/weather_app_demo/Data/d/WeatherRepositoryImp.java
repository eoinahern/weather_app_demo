package weather_app.com.eoin.ie.weather_app_demo.Data.d;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.CacheStrategy.CachingStrategy;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.DB.DBHelper;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.GlobalLocation.GeoLocation;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Web.WeatherService;
import weather_app.com.eoin.ie.weather_app_demo.Domain.d.WeatherRepository;
import weather_app.com.eoin.ie.weather_app_demo.Utils.SharedPrefsHelper;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class WeatherRepositoryImp implements WeatherRepository {


    private SharedPrefsHelper sharedprefs;
    private CachingStrategy cachingStrategy;
    private GeoLocation geolocation;
    private DBHelper db;
    private WeatherService weatherservice;


    @Inject
    public WeatherRepositoryImp(CachingStrategy cache, SharedPrefsHelper sharedprefs, GeoLocation geoloc,
                                DBHelper db, WeatherService weatherservice )
    {
        this.cachingStrategy = cache;
        this.sharedprefs = sharedprefs;
        this.geolocation = geoloc;
        this.db = db;
        this.weatherservice = weatherservice;
    }


    @Override
    public Observable<List<DailyWeatherItem>> getWeatherList() {
        //return fact.getDataSource().getDailyWeather();

        if(cachingStrategy.CheckDBValid())
        {
          return   db.getDailyWeather();
        }

        return weatherservice.getLocationData("11", "11").map(o -> o.daily.data);
    }


}
