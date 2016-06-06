package weather_app.com.eoin.ie.weather_app_demo.Views.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import weather_app.com.eoin.ie.weather_app_demo.R;

/**
 * Created by eoin_a on 06/06/2016.
 */
public class WeatherItemViewHolder extends RecyclerView.ViewHolder {

    public TextView weathertype;



    public WeatherItemViewHolder(View view) {
        super(view);
        weathertype = (TextView) view.findViewById(R.id.type_txt);
    }
}
