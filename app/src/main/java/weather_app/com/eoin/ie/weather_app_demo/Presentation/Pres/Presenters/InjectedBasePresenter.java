package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Presenters;

import javax.inject.Inject;

//import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components.DaggerAppComponent;
//import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components.DaggerWebComponent;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Modules.WebModule;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Web.WeatherService;
import weather_app.com.eoin.ie.weather_app_demo.WeatherApp;

/**
 * Created by eoin_a on 06/06/2016.
 *
 * base class.  used to inject required classes
 * as dagger 2 wont let you inject into classes with generics.
 * unless you declare the concrete generic type.
 * examples of how to deal with this here. i prefer my solution.
 * https://medium.com/@patrykpoborca/dagger-2-and-base-classes-generics-and-presenter-injection-7d82053080c#.j2f8bcrkt
 *
 */
public class InjectedBasePresenter {


    @Inject
    WeatherService repo;

    public InjectedBasePresenter()
    {
       // DaggerWebComponent.builder().webModule(new WebModule()).appComponent(WeatherApp.getComponent()).build().inject(this);
    }
}
