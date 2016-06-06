package weather_app.com.eoin.ie.weather_app_demo.Domain.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eoin_a on 06/06/2016.
 */
public class DailyWeatherItem implements Parcelable {


    public long time;
    public String summary;
    public String icon;
    public long sunriseTime;
    public long sunsetTime;
    public float precipProbability;
    public float temperatureMin;
    public long temperatureMinTime;
    public float temperatureMax;
    public long temperatureMaxTime;
    public long apparentTemperatureMaxTime;
    public float dewPoint;
    public float windSpeed;
    public float humidity;
    public float pressure;
    public float cloudCover;


    public DailyWeatherItem()
    {

    }

    public DailyWeatherItem(Parcel in)
    {

        time = in.readLong();
        summary = in.readString();
        icon = in.readString();
        sunriseTime = in.readLong();
        sunsetTime = in.readLong();
        precipProbability = in.readFloat();
        temperatureMin = in.readFloat();
        temperatureMinTime= in.readLong();
        temperatureMax= in.readFloat();
        temperatureMaxTime=  in.readLong();
        apparentTemperatureMaxTime= in.readLong();
        dewPoint  = in.readFloat();
        windSpeed = in.readFloat();
        humidity= in.readFloat();
        pressure= in.readFloat();
        cloudCover= in.readFloat();


    }

    public static final Parcelable.Creator<DailyWeatherItem> CREATOR
            = new Parcelable.Creator<DailyWeatherItem>() {

        @Override
        public DailyWeatherItem createFromParcel(Parcel in) {
            return new DailyWeatherItem(in);
        }

        @Override
        public DailyWeatherItem[] newArray(int size) {
            return new DailyWeatherItem[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(time);
        dest.writeString(summary);
        dest.writeString(icon);
        dest.writeLong(sunriseTime);
        dest.writeLong(sunsetTime);
        dest.writeFloat(precipProbability);
        dest.writeFloat(temperatureMin);
        dest.writeLong(temperatureMinTime);
        dest.writeFloat(temperatureMax);
        dest.writeLong(temperatureMaxTime);
        dest.writeLong(apparentTemperatureMaxTime);
        dest.writeFloat(dewPoint);
        dest.writeFloat(windSpeed);
        dest.writeFloat(humidity);
        dest.writeFloat(pressure);
        dest.writeFloat(cloudCover);

    }
}
