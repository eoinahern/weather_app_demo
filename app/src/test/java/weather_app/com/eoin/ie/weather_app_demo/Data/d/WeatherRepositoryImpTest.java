package weather_app.com.eoin.ie.weather_app_demo.Data.d;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.CacheStrategy.CachingStrategy;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.DB.DBHelper;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.GlobalLocation.GeoLocation;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Web.WeatherService;
import weather_app.com.eoin.ie.weather_app_demo.Utils.SharedPrefsHelper;

import static org.junit.Assert.*;

/**
 * Created by eoin_a on 23/10/2016.
 */
public class WeatherRepositoryImpTest {


    //dependencies
    @Mock private CachingStrategy mockcaching;
    @Mock private DBHelper mockdb;
    @Mock private WeatherService mockws;
    @Mock  private GeoLocation mockgeo;
    @Mock private SharedPrefsHelper mockprefs;
    @Mock private Observable<List<DailyWeatherItem>> mockobs;

    private WeatherRepositoryImp weatherrepo;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        weatherrepo = new WeatherRepositoryImp(mockcaching, mockprefs, mockgeo,
                mockdb, mockws);
    }

    @Test
    public void getWeatherListTest()
    {
        Mockito.when(mockcaching.CheckDBValid()).thenReturn(true);
        Mockito.when(mockdb.getDailyWeather()).thenReturn(mockobs);


        Observable<List<DailyWeatherItem>> retobs = weatherrepo.getWeatherList();
        Mockito.verify(mockcaching).CheckDBValid();
        Mockito.verify(mockdb).getDailyWeather();
        Assert.assertEquals(retobs, mockobs) ;
    }


}