package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.listeners.AdapterListener;

/**
 * Created by eoin_a on 06/06/2016.
 */
public class WeatherItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView day;
    public TextView temp;
    public ImageView imview;
    private AdapterListener listener;

    public WeatherItemViewHolder(View view, AdapterListener listenerin) {
        super(view);
        view.setOnClickListener(this);
        listener = listenerin;
        day = (TextView) view.findViewById(R.id.day_text);
        temp = (TextView) view.findViewById(R.id.temp_text);
        imview = (ImageView) view.findViewById(R.id.imview);
    }

    @Override
    public void onClick(View v) {
            //Context cont =  v.getContext();
            //Intent i = new Intent(cont,DetailsActivity.class);
            //cont.startActivity(i);
        listener.animateIntent(imview);
    }


    private void animateImageViewTrans()
    {



    }
}
