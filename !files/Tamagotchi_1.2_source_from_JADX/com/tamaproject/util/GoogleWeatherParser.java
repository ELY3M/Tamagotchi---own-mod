package com.tamaproject.util;

import android.util.Log;
import com.tamaproject.weather.CurrentConditions;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class GoogleWeatherParser {
    static String TAG = "tama GoogleWeatherParser";
    static String condition = ISVGConstants.VALUE_NONE;
    static String main = ISVGConstants.VALUE_NONE;
    static String temperature = "0";

    public static CurrentConditions getCurrentConditions(String url) {
        CurrentConditions cc = new CurrentConditions();
        Log.i(TAG, "url: " + url);
        handlejson obj = new handlejson(url);
        obj.fetchJSON();
        do {
        } while (obj.parsingComplete);
        condition = obj.getWeather();
        main = obj.getmain();
        temperature = obj.getTemp();
        Log.i(TAG, "condition: " + condition + " main: " + main + " temp: " + temperature);
        double finaltemp = Math.ceil(Double.valueOf(temperature).doubleValue());
        cc.setCondition(condition);
        cc.setMain(main);
        cc.setTempF((int) finaltemp);
        Log.i(TAG, "cc: " + cc);
        return cc;
    }
}
