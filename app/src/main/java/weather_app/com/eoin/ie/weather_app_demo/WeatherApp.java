package weather_app.com.eoin.ie.weather_app_demo;

import android.app.Application;

import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components.AppComponent;
//import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components.DaggerAppComponent;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Modules.AppModule;

/**
 * Created by eoin_a on 02/06/2016.
 */
public class WeatherApp extends Application {

    public static AppComponent appcomponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        //appcomponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getComponent()
    {
        return appcomponent;
    }

}
