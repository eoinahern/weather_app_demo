package weather_app.com.eoin.ie.weather_app_demo.DI.Components;

import dagger.Component;
import weather_app.com.eoin.ie.weather_app_demo.DI.Modules.WebModule;
import weather_app.com.eoin.ie.weather_app_demo.DI.Scopes.ActivityScope;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.InjectedBasePresenter;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.MvpBasePresenter;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.WeatherCallbackImp;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.WeatherView;

/**
 * Created by eoin_a on 05/06/2016.
 */
@ActivityScope
@Component(modules = {WebModule.class}, dependencies = {AppComponent.class})
public interface WebComponent {

    void inject(InjectedBasePresenter presenter);
}
