package weather_app.com.eoin.ie.weather_app_demo.Data.d.Repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.DB.DBHelper;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeather;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;

/**
 * Created by eoin_pc on 20/10/2016.
 */
 public class DBDataSource implements DataSource {


    private DBHelper dbhelper;


    @Inject
    public DBDataSource(DBHelper dbhelper)
    {
        this.dbhelper = dbhelper;
    }


    @Override
    public Observable<List<DailyWeatherItem>> getDailyWeather() {
        return dbhelper.getDailyWeather();
    }
}
