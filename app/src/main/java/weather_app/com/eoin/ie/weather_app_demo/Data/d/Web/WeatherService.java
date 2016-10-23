package weather_app.com.eoin.ie.weather_app_demo.Data.d.Web;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.Location;

/**
 * Created by eoin_a on 04/06/2016.
 * used to connect to our service on the web
 */
public interface WeatherService {
   @GET("{lat},{long}")
   Observable<Location> getLocationData(@Path("lat") String lat, @Path("long") String longitude);
}
