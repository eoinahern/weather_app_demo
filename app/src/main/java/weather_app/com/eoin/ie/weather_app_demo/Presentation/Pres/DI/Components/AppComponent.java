package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Components;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.DI.Modules.AppModule;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtil;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Activity.MainActivity;
import weather_app.com.eoin.ie.weather_app_demo.Utils.SharedPrefsHelper;

/**
 * Created by eoin_a on 02/06/2016.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    SharedPrefsHelper prefs();
    Context cont();
    Gson gson();
    OkHttpClient client();
    DateFormatterUtil formatter();

    void inject(MainActivity act);

}
