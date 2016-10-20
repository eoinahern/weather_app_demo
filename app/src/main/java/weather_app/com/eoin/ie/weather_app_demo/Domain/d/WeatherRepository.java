package weather_app.com.eoin.ie.weather_app_demo.Domain.d;

import java.util.List;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public interface WeatherRepository {
    public Observable<List<DailyWeatherItem>> getWeatherList();
}
