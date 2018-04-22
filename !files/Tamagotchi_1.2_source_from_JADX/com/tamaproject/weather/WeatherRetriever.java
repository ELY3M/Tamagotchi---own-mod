package com.tamaproject.weather;

import android.util.Log;
import com.tamaproject.util.GoogleWeatherParser;

public class WeatherRetriever {
    static String TAG = "tamaproject WeatherRetriever";
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?&units=imperial&appid=203f88cca6d4acd6e36630ad9f5b2c5e&";

    public static CurrentConditions getCurrentConditions(double latitude, double longitude) {
        String s = "http://api.openweathermap.org/data/2.5/weather?&units=imperial&appid=203f88cca6d4acd6e36630ad9f5b2c5e&lat=" + latitude + "&lon=" + longitude;
        Log.i(TAG, "final weather url: " + s);
        CurrentConditions cc = GoogleWeatherParser.getCurrentConditions(s);
        Log.i(TAG, "weather: " + cc);
        return cc;
    }
}
