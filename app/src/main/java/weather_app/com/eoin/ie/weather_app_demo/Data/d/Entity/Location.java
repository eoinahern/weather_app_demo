package weather_app.com.eoin.ie.weather_app_demo.Data.d.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eoin_a on 01/06/2016.
 */
public class Location implements Parcelable {


    public String timezone;
    public float latitude;
    public float longitude;
    public DailyWeather daily;

    //private List<WeatherEntity> weatherlist;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLonitude() {
        return longitude;
    }

    public void setLonitude(float lonitude) {
        this.longitude = lonitude;
    }



    public Location() {

    }


    public Location(Parcel p)
    {
        daily = p.readParcelable(DailyWeather.class.getClassLoader());
        timezone = p.readString();
        latitude = p.readFloat();
        longitude = p.readFloat();


    }

    public static final Parcelable.Creator<Location> CREATOR
            = new Parcelable.Creator<Location>() {

        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeParcelable(daily, flags);
        dest.writeString(timezone);
        dest.writeFloat(latitude);
        dest.writeFloat(longitude);


    }
}
