package weather_app.com.eoin.ie.weather_app_demo.Data.d.CacheStrategy;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class CachingStrategyImp implements CachingStrategy {

    //check if database has data.
    //also check if last coords are within certain distance of curent coords.


    @Override
    public boolean CheckDBValid() {
        return false;
    }
}
