package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components;

import dagger.Component;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Modules.WebModule;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Scopes.ActivityScope;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Presenters.InjectedBasePresenter;

/**
 * Created by eoin_a on 05/06/2016.
 */
@ActivityScope
@Component(modules = {WebModule.class}, dependencies = {AppComponent.class})
public interface WebComponent {

    void inject(InjectedBasePresenter presenter);
}
