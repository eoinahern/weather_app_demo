package weather_app.com.eoin.ie.weather_app_demo.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eoin_a on 23/10/2016.
 */


public class SharedPrefsHelperTest {



    private  Context mockcont;
    private SharedPreferences mockprefs;
    private SharedPrefsHelper classundertest;
    private SharedPreferences.Editor mockedit;
    String key = "hello";
    String val = "val";



    @Before
    public void setup()
    {
        mockcont = Mockito.mock(Context.class);
        mockprefs = Mockito.mock(SharedPreferences.class);
        mockedit = Mockito.mock(SharedPreferences.Editor.class);

        when(mockcont.getSharedPreferences(SharedPrefsHelper.PREFS_HELPER, Context.MODE_PRIVATE))
                .thenReturn(mockprefs);
        when(mockprefs.edit()).thenReturn(mockedit);

        classundertest = new SharedPrefsHelper(mockcont);
    }


    @Test
    public void testAddValue()
    {

        when(mockedit.putString(key,val)).thenReturn(mockedit);
        when(mockedit.commit()).thenReturn(true);

        boolean bool = classundertest.addElement(key, val);

        Mockito.verify(mockedit).putString(key, val);
        Mockito.verify(mockedit).commit();

        Assert.assertTrue(bool);

    }

    @Test
    public void testGetValue()
    {
        String returnval = "boo";
        when(mockprefs.getString(key, "")).thenReturn(returnval);
        String strval =  classundertest.getElement(key);
        verify(mockprefs).getString(key, "");
        Assert.assertEquals(strval, returnval);
    }


}