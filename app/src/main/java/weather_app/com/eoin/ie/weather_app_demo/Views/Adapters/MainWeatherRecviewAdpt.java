package weather_app.com.eoin.ie.weather_app_demo.Views.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import weather_app.com.eoin.ie.weather_app_demo.Domain.Entity.DailyWeatherItem;
import weather_app.com.eoin.ie.weather_app_demo.R;
import weather_app.com.eoin.ie.weather_app_demo.Utils.DateFormatterUtil;
import weather_app.com.eoin.ie.weather_app_demo.Views.ViewHolders.WeatherItemViewHolder;

/**
 * Created by eoin_a on 01/06/2016.
 */
public class MainWeatherRecviewAdpt  extends RecyclerView.Adapter  {

    public List<DailyWeatherItem> weatheritems;
    private DateFormatterUtil formatter;

    public MainWeatherRecviewAdpt(List<DailyWeatherItem> weatherin, DateFormatterUtil formatterin)
    {
        weatheritems =  weatherin;
        formatter = formatterin;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_weather_pane_layout,parent, false);
        return new WeatherItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int pos) {
        WeatherItemViewHolder vh =  (WeatherItemViewHolder) holder;
        DailyWeatherItem item = weatheritems.get(pos);

        float maxtemp = item.temperatureMax;
        vh.temp.setText(String.valueOf(maxtemp) + "\u2109");
        vh.day.setText(String.valueOf(formatter.convertToDay(item.time)));
    }

    @Override
    public int getItemCount() {
        return weatheritems.size();
    }


}
