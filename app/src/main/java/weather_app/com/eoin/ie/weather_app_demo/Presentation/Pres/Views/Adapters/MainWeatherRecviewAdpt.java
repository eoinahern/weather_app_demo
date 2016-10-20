package weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtil;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Activity.DetailsActivity;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.Activity.MainActivity;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.ViewHolders.WeatherItemViewHolder;
import weather_app.com.eoin.ie.weather_app_demo.Presentation.Pres.Views.listeners.AdapterListener;

/**
 * Created by eoin_a on 01/06/2016.
 */
public class MainWeatherRecviewAdpt  extends RecyclerView.Adapter implements AdapterListener {

    public List<DailyWeatherItem> weatheritems;
    private DateFormatterUtil formatter;
    private Context cont;

    public MainWeatherRecviewAdpt(Context contin,List<DailyWeatherItem> weatherin, DateFormatterUtil formatterin)
    {
        weatheritems =  weatherin;
        formatter = formatterin;
        cont = contin;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_weather_pane_layout,parent, false);
        return new WeatherItemViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int pos) {

        WeatherItemViewHolder vh =  (WeatherItemViewHolder) holder;
        DailyWeatherItem item = weatheritems.get(pos);
        float maxtemp = item.temperatureMax;
        vh.temp.setText(String.valueOf(maxtemp) + "\u2109");
        vh.day.setText(String.valueOf(formatter.convertToDay(item.time)));
    }

    public void animateIntent(ImageView view) {
        Intent intent = new Intent(cont, DetailsActivity.class);
        String transitionName = cont.getString(R.string.transition_string);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                ((MainActivity) cont), view, transitionName);
        ActivityCompat.startActivity(((MainActivity) cont), intent, options.toBundle());
    }

    @Override
    public int getItemCount() {
        return weatheritems.size();
    }



}
