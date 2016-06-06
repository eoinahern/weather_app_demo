package weather_app.com.eoin.ie.weather_app_demo.Domain.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by eoin_a on 06/06/2016.
 */
public class DailyWeather  implements Parcelable{

    public String summary;
    public String icon;
    public ArrayList<DailyWeatherItem> data;



    public DailyWeather()
    {

    }

    public DailyWeather(Parcel in)
    {

        data = in.createTypedArrayList(DailyWeatherItem.CREATOR);
        summary = in.readString();
        icon = in.readString();


    }

    public static final Parcelable.Creator<DailyWeather> CREATOR
            = new Parcelable.Creator<DailyWeather>() {

        @Override
        public DailyWeather createFromParcel(Parcel in) {
            return new DailyWeather(in);
        }

        @Override
        public DailyWeather[] newArray(int size) {
            return new DailyWeather[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeTypedList(data);
        dest.writeString(summary);
        dest.writeString(icon);

    }
}
