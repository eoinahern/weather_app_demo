package weather_app.com.eoin.ie.weather_app_demo.Data.d.CacheStrategy;

import weather_app.com.eoin.ie.weather_app_demo.Utils.NetworkCheckerHelper;
import weather_app.com.eoin.ie.weather_app_demo.Utils.SharedPrefsHelper;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class CachingStrategyImp implements CachingStrategy {

    //check if database has data.
    //also check if last coords are within certain distance of curent coords.


    private NetworkCheckerHelper networkcheck;
    private SharedPrefsHelper sharedprefshelp;


    public CachingStrategyImp(NetworkCheckerHelper net, SharedPrefsHelper shared)
    {
        this.networkcheck = net;
        this.sharedprefshelp = shared;

    }


    @Override
    public boolean CheckDBValid() {
        return false;
    }
}
