package weather_app.com.eoin.ie.weather_app_demo.Data.d;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Repository.DataSource;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Repository.WeatherFactory;
import weather_app.com.eoin.ie.weather_app_demo.Domain.d.WeatherRepository;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class WeatherRepositoryImp implements WeatherRepository {

    private WeatherFactory fact;


    @Inject
    public WeatherRepositoryImp(WeatherFactory factory)
    {
        this.fact = factory;
    }


    @Override
    public Observable<List<DailyWeatherItem>> getWeatherList() {
        return fact.getDataSource().getDailyWeather();
    }
}
