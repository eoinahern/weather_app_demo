package weather_app.com.eoin.ie.weather_app_demo.Views.Activity;

import android.os.Bundle;

import weather_app.com.eoin.ie.weather_app_demo.Presenters.DetailsCallback;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.DetailsCallbackImp;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.MvpPresenter;
import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.DetailsView;

/**
 * Created by eoin_a on 04/06/2016.
 */
public class DetailsActivity extends MvpActivity<DetailsView, DetailsCallbackImp>  implements DetailsView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        presenter.attachView(this);
    }

    @Override
    protected DetailsCallbackImp createPresenter() {

        //not required at present
        //as repo not called.


        return new DetailsCallbackImp();
    }

    /**
     * create the actitity view
     */

    @Override
    public void SetUpView() {

    }


    /**
     * handle view animations
     *
     */

    @Override
    public void SetupAnimatons() {

    }
}
