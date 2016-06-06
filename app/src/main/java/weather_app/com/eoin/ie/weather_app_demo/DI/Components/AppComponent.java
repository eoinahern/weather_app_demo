package weather_app.com.eoin.ie.weather_app_demo.DI.Components;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import weather_app.com.eoin.ie.weather_app_demo.DI.Modules.AppModule;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.MvpBasePresenter;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.MvpPresenter;
import weather_app.com.eoin.ie.weather_app_demo.Views.Activity.MainActivity;
import weather_app.com.eoin.ie.weather_app_demo.Views.Activity.MvpActivity;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.MvpView;

/**
 * Created by eoin_a on 02/06/2016.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    SharedPreferences prefs();
    SharedPreferences.Editor editor();
    Context cont();
    Gson gson();
    OkHttpClient client();

    void inject(MainActivity act);

}
