package weather_app.com.eoin.ie.weather_app_demo.Domain.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eoin_a on 01/06/2016.
 */
public class WeatherEntity implements Parcelable {

    private String type;
    private String icon;
    private String time;
    private int resicon;

    public WeatherEntity()
    {

    }

    public WeatherEntity(Parcel p)
    {
        type = p.readString();
        icon = p.readString();
        time = p.readString();
        resicon = p.readInt();

    }

    @Override
    public int describeContents() {
        return 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(type);
        dest.writeString(icon);
        dest.writeString(time);
        dest.writeInt(resicon);

    }

    public static final Parcelable.Creator<WeatherEntity> CREATOR
            = new Parcelable.Creator<WeatherEntity>() {

        @Override
        public WeatherEntity createFromParcel(Parcel in) {
            return new WeatherEntity(in);
        }

        @Override
        public WeatherEntity[] newArray(int size) {
            return new WeatherEntity[size];
        }
    };
}
