package weather_app.com.eoin.ie.weather_app_demo.Domain.d.Services;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Domain.d.WeatherRepository;

/**
 * Created by eoin_a on 23/10/2016.
 */

public class GetWeatherImp implements GetWeather {



    private Subscription subscription;
    private Subscriber<List<DailyWeatherItem>> sub;
    private Scheduler mainsch, newthsch;
    private WeatherRepository weatherrepo;
    public Observable<List<DailyWeatherItem>> weatherobs;

    @Inject
    public GetWeatherImp(WeatherRepository weatherrepo, Subscriber<List<DailyWeatherItem>> sub, Scheduler mainsch, Scheduler newthsch)
    {
        this.sub = sub;
        this.mainsch = mainsch;
        this.newthsch = newthsch;
        this.weatherrepo = weatherrepo;
    }


    @Override
    public void Unsubscribe() {

        if(subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    @Override
    public void getWeather() {

       subscription = weatherrepo.getWeatherList()
                .subscribeOn(newthsch)
                .observeOn(mainsch)
                .subscribe(sub);

    }









}
