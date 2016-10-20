package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Presenters.MvpPresenter;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.ViewInterfaces.MvpView;

/**
 * Created by eoin_a on 01/06/2016.
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter> extends AppCompatActivity implements MvpView {


    protected P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(this);
    }


    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }


    protected abstract P createPresenter();

}
