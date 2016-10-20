package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Presenters;

import java.lang.ref.WeakReference;

import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.ViewInterfaces.MvpView;

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
