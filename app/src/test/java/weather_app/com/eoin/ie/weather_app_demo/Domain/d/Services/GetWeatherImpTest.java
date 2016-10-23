package weather_app.com.eoin.ie.weather_app_demo.Domain.d.Services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Domain.d.WeatherRepository;

/**
 * Created by eoin_a on 23/10/2016.
 */
public class GetWeatherImpTest {



    @Mock private Subscription mocksubscription;
    @Mock private TestSubscriber<List<DailyWeatherItem>> mocksub;
    @Mock private WeatherRepository mockweatherrepo;
    @Mock private Observable<List<DailyWeatherItem>> mockobs;
    @Mock private Scheduler main, other;


    private GetWeatherImp getWeather;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        getWeather = new GetWeatherImp(mockweatherrepo, mocksub, Schedulers.test(), Schedulers.test());

    }

    @Test
    public void testUnsubscribe()
    {

    }


    @Test
    public void testGetWeather()
    {
        //
    }



    private List<DailyWeatherItem> mocklist()
    {
        List<DailyWeatherItem> wlist = new ArrayList<>();

        DailyWeatherItem dw1 = new DailyWeatherItem();
        dw1.setTime(100l);
        dw1.setSummary("warm");
        dw1.setIcon("icon");

        wlist.add(dw1);

        DailyWeatherItem dw2 = new DailyWeatherItem();
        dw2.setTime(200l);
        dw2.setSummary("cold");
        dw2.setIcon("sun");

        wlist.add(dw2);

        return wlist;
    }

}