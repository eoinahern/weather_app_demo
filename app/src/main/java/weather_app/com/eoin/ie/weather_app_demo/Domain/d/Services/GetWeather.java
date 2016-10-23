package weather_app.com.eoin.ie.weather_app_demo.Domain.d.Services;

import java.util.List;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;

/**
 * Created by eoin_a on 23/10/2016.
 */

public interface GetWeather {
    Observable<List<DailyWeatherItem>> getWeather();
}
