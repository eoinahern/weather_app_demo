package weather_app.com.eoin.ie.weather_app_demo.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;

/**
 * Created by eoin_pc on 20/10/2016.
 */

public class SharedPrefsHelper {

    public static final String PREFS_HELPER = "prefs";
    private Context cont;
    private SharedPreferences sharedprefs;
    private SharedPreferences.Editor edit;

    @Inject
    public SharedPrefsHelper(Context cont)
    {
        this.cont = cont;
        sharedprefs = cont.getSharedPreferences(PREFS_HELPER, Context.MODE_PRIVATE);
        edit = sharedprefs.edit();
    }


    public boolean addElement(String key, String val)
    {
        return edit.putString(key, val).commit();
    }


    public String getElement(String key)
    {
        return  sharedprefs.getString(key, "");
    }



}
