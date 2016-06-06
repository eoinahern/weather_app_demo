package weather_app.com.eoin.ie.weather_app_demo.Views.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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
import weather_app.com.eoin.ie.weather_app_demo.Views.Adapters.MainWeatherRecviewAdpt;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.WeatherView;
import weather_app.com.eoin.ie.weather_app_demo.WeatherApp;


public class MainActivity extends MvpActivity<WeatherView, WeatherCallbackImp> implements WeatherView
{
    @BindView(R.id.weather_recview) RecyclerView forecastview;
    @BindView(R.id.progbar)ProgressBar progbar;

    private MainWeatherRecviewAdpt weatheraapter;
    private LinearLayoutManager llmanager;


    //not used at present!!
    @Inject Gson gson;
    @Inject SharedPreferences preferences;
    @Inject SharedPreferences.Editor edit;
    @Inject Handler mainhandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        WeatherApp.getComponent().inject(this);

        presenter.attachView(this);
        presenter.getWeatherData();

        llmanager = new LinearLayoutManager(getContext());

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


        Log.d("lat, lon", String.valueOf(loc.latitude) +  " " + String.valueOf(loc.longitude));
        Log.d("lat, stuff", String.valueOf(loc.timezone));
        Log.d("dat count", String.valueOf(loc.daily.data.size()));
        createRecyclerView(loc.daily.data);


    }


    public void createRecyclerView(ArrayList<DailyWeatherItem> weatheritems)
    {

       // llmanager = new LinearLayoutManager(this);
        weatheraapter = new MainWeatherRecviewAdpt(weatheritems);
        //forecastview.setLayoutManager(llmanager);
        forecastview.setLayoutManager(new LinearLayoutManager(this));
        forecastview.setAdapter(weatheraapter);
        //forecastview.setLayoutManager(new LinearLayoutManager(this));


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
