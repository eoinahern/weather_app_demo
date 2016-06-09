package weather_app.com.eoin.ie.weather_app_demo.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by eoin_a on 09/06/2016.
 */
public class DateFormatterUtilImp implements  DateFormatterUtil{


    private Calendar calendar;
    private TimeZone timezone;

    public DateFormatterUtilImp()
    {
        calendar = Calendar.getInstance();
        timezone = calendar.getTimeZone();
    }

    public String convertToDay(long time) {

        Date date = new Date(time * 1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        formatter.setTimeZone(timezone);
        return formatter.format(date);
    }




}
