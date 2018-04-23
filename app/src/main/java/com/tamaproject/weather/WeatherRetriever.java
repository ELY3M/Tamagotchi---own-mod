package com.tamaproject.weather;

import android.util.Log;

import com.tamaproject.util.WeatherParser;

/**
 * Gets the current conditions from Google given a latitude and longitude
 * 
 * @author Jonathan
 * 
 */
public class WeatherRetriever
{
	static String TAG = "tama WeatherRetriever";
    //private static final String XML_SOURCE = "http://www.google.com/ig/api?weather=,,,";
	private static final String URL = "http://api.openweathermap.org/data/2.5/weather?&units=imperial&appid=203f88cca6d4acd6e36630ad9f5b2c5e&";
	//http://api.openweathermap.org/data/2.5/weather?&units=imperial&mode=xml&appid=203f88cca6d4acd6e36630ad9f5b2c5e&lat=40.104&lon=-75.458

    public static CurrentConditions getCurrentConditions(double latitude, double longitude)
    {

	String s = URL + "lat=" + latitude + "&lon=" + longitude;
	Log.i(TAG, "final weather url: " +s);

	CurrentConditions cc = WeatherParser.getCurrentConditions(s);
		Log.i(TAG, "weather: " + cc);
	return cc;
    }
}
