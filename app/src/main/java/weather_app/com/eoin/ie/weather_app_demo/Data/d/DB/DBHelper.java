package weather_app.com.eoin.ie.weather_app_demo.Data.d.DB;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;

/**
 * Created by eoin_pc on 20/10/2016.
 * use realm to get data from DB
 */

public class DBHelper {

    @Inject
    public DBHelper()
    {

    }

    public Observable<List<DailyWeatherItem>> getDailyWeather(){

    }
}
