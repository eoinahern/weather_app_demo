package weather_app.com.eoin.ie.weather_app_demo.Views.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

import weather_app.com.eoin.ie.weather_app_demo.DI.Modules.AppModule;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.MvpPresenter;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.MvpView;
import weather_app.com.eoin.ie.weather_app_demo.WeatherApp;

/**
 * Created by eoin_a on 01/06/2016.
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter> extends AppCompatActivity implements MvpView {


    protected P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(this);
    }


    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }


    protected abstract P createPresenter();

}
