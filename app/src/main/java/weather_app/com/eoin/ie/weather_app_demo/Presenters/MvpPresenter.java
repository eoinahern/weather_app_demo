package weather_app.com.eoin.ie.weather_app_demo.Presenters;

import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.MvpView;

/**
 * Created by eoin_a on 01/06/2016.
 */
public interface MvpPresenter<V extends MvpView> {

     void attachView(V view);
     void detachView(boolean retainInstance);
}
