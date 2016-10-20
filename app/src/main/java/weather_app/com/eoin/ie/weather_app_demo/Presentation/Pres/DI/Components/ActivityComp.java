package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components;

import dagger.Component;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Scopes.ActivityScope;

/**
 * Created by eoin_a on 02/06/2016.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface ActivityComp {

}
