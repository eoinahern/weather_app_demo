package weather_app.com.eoin.ie.weather_app_demo.Data.d.Repository;

import javax.inject.Inject;

import weather_app.com.eoin.ie.weather_app_demo.Data.d.CacheStrategy.CachingStrategy;


/**
 * Created by eoin_pc on 20/10/2016.
 */

public class WeatherFactory {

    private CachingStrategy cache;
    private DBDataSource dbsource;
    private WebDataSource websource;


    @Inject
    public WeatherFactory(DBDataSource dbsource, WebDataSource websource, CachingStrategy cache)
    {
        this.cache = cache;
        this.dbsource = dbsource;
        this.websource = websource;
    }


    public DataSource getDataSource()
    {
        if(cache.CheckDBValid())
        {
            return dbsource;
        }


        return websource;
    }




}
