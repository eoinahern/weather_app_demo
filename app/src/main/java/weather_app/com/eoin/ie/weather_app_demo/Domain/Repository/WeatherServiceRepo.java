package weather_app.com.eoin.ie.weather_app_demo.Domain.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import weather_app.com.eoin.ie.weather_app_demo.Domain.Entity.Location;
import weather_app.com.eoin.ie.weather_app_demo.Domain.Entity.WeatherEntity;

/**
 * Created by eoin_a on 04/06/2016.
 * used to connect to our service on the web
 */
public interface WeatherServiceRepo {

   @GET("{lat},{long}")
   Call<Location> getLocationData(@Path("lat") String lat, @Path("long") String longitude);
}
