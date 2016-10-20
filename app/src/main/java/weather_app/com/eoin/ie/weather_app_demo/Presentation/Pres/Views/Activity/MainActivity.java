package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.Location;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Presenters.WeatherCallbackImp;
import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtil;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Adapters.MainWeatherRecviewAdpt;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.ViewInterfaces.WeatherView;
import weather_app.com.eoin.ie.weather_app_demo.WeatherApp;


public class MainActivity extends MvpActivity<WeatherView, WeatherCallbackImp> implements WeatherView
{
    //@BindView(R.id.weather_recview) RecyclerView forecastview;
    //@BindView(R.id.progbar)ProgressBar progbar;

    //butterknife not binding views??

    private MainWeatherRecviewAdpt weatheraapter;
    private ProgressBar progbar;
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
        progbar = (ProgressBar) findViewById(R.id.progbar);
        gridlmanager =  new GridLayoutManager(this, 2);
        forecastview.setLayoutManager(gridlmanager);

        presenter.attachView(this);
        presenter.getWeatherData();
    }


    private void setWindowTransition(int listsize)
    {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setDuration(800);
            slide.setSlideEdge(Gravity.RIGHT);
            TransitionManager.beginDelayedTransition(forecastview,slide);
            forecastview.setTransitionGroup(true);
            forecastview.setVisibility(View.VISIBLE);
        }
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
        weatheraapter = new MainWeatherRecviewAdpt(this,weatheritems, dateformatter);
        forecastview.setAdapter(weatheraapter);
        progbar.setVisibility(View.INVISIBLE);
        setWindowTransition(weatheritems.size());
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
