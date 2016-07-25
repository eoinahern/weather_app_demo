package weather_app.com.eoin.ie.weather_app_demo.Presenters;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import weather_app.com.eoin.ie.weather_app_demo.DI.Components.WebComponent;
import weather_app.com.eoin.ie.weather_app_demo.DI.Modules.WebModule;
import weather_app.com.eoin.ie.weather_app_demo.Domain.Repository.WeatherServiceRepo;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.MvpView;

/**
 * Created by eoin_a on 04/06/2016.
 */
public class MvpBasePresenter<V extends MvpView> extends InjectedBasePresenter implements MvpPresenter<V> {

    WeakReference<V> view;

    @Override
    public void attachView(V viewin) {
        view = new WeakReference<>(viewin);
    }


    public boolean isAttached() {
       return (view != null ) ? true : false;
    }


    public V getView() {
        return view == null ? null : view.get();
    }

    @Override
    public void detachView(boolean retainInstance) {
            if(!retainInstance)
            {
                view.clear();
                view = null;
            }
    }
}
