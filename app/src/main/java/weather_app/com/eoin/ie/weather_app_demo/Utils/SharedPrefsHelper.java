package weather_app.com.eoin.ie.weather_app_demo.Utils;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class SharedPrefsHelper {


    private Context cont;

    @Inject
    public SharedPrefsHelper(Context cont)
    {
         this.cont = cont;
    }



}
