package weather_app.com.eoin.ie.weather_app_demo.Data.d.Repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;

import weather_app.com.eoin.ie.weather_app_demo.Data.d.Web.WeatherService;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class WebDataSource implements DataSource {


    private WeatherService ws;

    @Inject
    public WebDataSource(WeatherService ws)
    {
        this.ws = ws;
    }


    @Override
    public Observable<List<DailyWeatherItem>> getDailyWeather() {
        Observable<List<DailyWeatherItem>>  obs = ws.getLocationData("11", "11").map(x -> x.daily.data);
        return obs;
    }
}
