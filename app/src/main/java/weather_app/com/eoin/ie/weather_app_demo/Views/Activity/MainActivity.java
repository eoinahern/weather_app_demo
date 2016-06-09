package weather_app.com.eoin.ie.weather_app_demo.Views.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import weather_app.com.eoin.ie.weather_app_demo.Domain.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Domain.Entity.Location;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.WeatherCallbackImp;
import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtil;
import weather_app.com.eoin.ie.weather_app_demo.Views.Adapters.MainWeatherRecviewAdpt;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.WeatherView;
import weather_app.com.eoin.ie.weather_app_demo.WeatherApp;


public class MainActivity extends MvpActivity<WeatherView, WeatherCallbackImp> implements WeatherView
{
    //@BindView(R.id.weather_recview) RecyclerView forecastview;
    //@BindView(R.id.progbar)ProgressBar progbar;

    //butterknife not binding views??

    private MainWeatherRecviewAdpt weatheraapter;
    private GridLayoutManager gridlmanager;

    RecyclerView forecastview;

    @Inject Gson gson;
    @Inject SharedPreferences preferences;
    @Inject SharedPreferences.Editor edit;
    @Inject Handler mainhandler;
    @Inject DateFormatterUtil dateformatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife.bind(this);
        WeatherApp.getComponent().inject(this);

        forecastview = (RecyclerView) findViewById(R.id.weather_recview);
        gridlmanager =  new GridLayoutManager(this, 2);
        forecastview.setLayoutManager(gridlmanager);

        presenter.attachView(this);
        presenter.getWeatherData();

    }


    @Override
    protected WeatherCallbackImp createPresenter() {
        return new WeatherCallbackImp();
    }




    /**
     * callback from presenter on success
     *
     */


    @Override
    public void onCompleted(final Location loc) {

        createRecyclerView(loc.daily.data);
    }


    public void createRecyclerView(ArrayList<DailyWeatherItem> weatheritems)
    {
        weatheraapter = new MainWeatherRecviewAdpt(weatheritems, dateformatter);
        forecastview.setAdapter(weatheraapter);
    }


    /**
     *
     * show message on screen. server error etc.
     * hide recview. show different error view!!
     */

    @Override
    public void onFailed() {
        Log.d("response failed", "failed data return!!");
    }


    @Override
    public void onPause()
    {
        super.onPause();
    }
}
