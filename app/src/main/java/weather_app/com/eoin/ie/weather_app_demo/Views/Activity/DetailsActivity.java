package weather_app.com.eoin.ie.weather_app_demo.Views.Activity;

import android.os.Bundle;
import android.widget.ImageView;

import weather_app.com.eoin.ie.weather_app_demo.Presenters.DetailsCallback;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.DetailsCallbackImp;
import weather_app.com.eoin.ie.weather_app_demo.Presenters.MvpPresenter;
import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewInterfaces.DetailsView;

/**
 * Created by eoin_a on 04/06/2016.
 */
public class DetailsActivity extends MvpActivity<DetailsView, DetailsCallbackImp>  implements DetailsView{


    private ImageView mainiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        mainiv = (ImageView) findViewById(R.id.mainimview);




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
