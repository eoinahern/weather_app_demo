package weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces;

import weather_app.com.eoin.ie.weather_app_demo.Domain.Entity.Location;

/**
 * Created by eoin_a on 01/06/2016.
 */
public interface WeatherView extends MvpView {

    void onCompleted(Location loc);
    void onFailed();
}
