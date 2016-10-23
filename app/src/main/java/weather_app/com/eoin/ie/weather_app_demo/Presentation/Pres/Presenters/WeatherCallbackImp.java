package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Presenters;

import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.Location;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.ViewInterfaces.WeatherView;

/**
 * Created by eoin_a on 01/06/2016.
 */
public class WeatherCallbackImp extends MvpBasePresenter<WeatherView> implements  WeatherCallback {


    @Override
    public void getWeatherData() {
       //Call call = repo.getLocationData("53.3498", "6.2603");


       /* call.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.isSuccessful()) {
                    WeatherView v = getView();

                    if(isAttached()) {
                        v.onCompleted((Location) response.body());
                        return;
                    }
                }

                Log.d("on response failed", response.message());
                if(isAttached())
                    getView().onFailed();
            }

            @Override
            public void onFailure(Call call, Throwable t)
            {
                //e.g no connection.
                Log.d("error message", t.getMessage());
                Log.d("error cause", t.getCause().toString());
                if(isAttached())
                    getView().onFailed();
            }
        });*/
    }
}
