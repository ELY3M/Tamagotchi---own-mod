package com.tamaproject.util;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.util.Log;

import javax.net.ssl.HttpsURLConnection;

public class handlejson {

   private static final String TAG = "Tama Game handlejson";
   private String agent = "my own written app email: elymbmx@gmail.com";
   private String temp = "Temp";
   private String weather = "Weather";
   //private String icon = "Weatherimage";
   private String urlString = null;

   public volatile boolean parsingComplete = true;
   public handlejson(String url){
      this.urlString = url;
   }


   public String getTemp() {
      return temp;
   }
   public String getWeather() {
      return weather;
   }
   //public String getIcon() { return icon; }

   @SuppressLint("NewApi")
   public void readAndParseJSON(String in) {
      try {
         JSONObject reader = new JSONObject(in);

         JSONObject current  = reader.getJSONObject("currentobservation");
         temp = current.getString("Temp");
         weather = current.getString("Weather");
         //icon = current.getString("Weatherimage");
         parsingComplete = false;

      } catch (Exception e) {
         Log.i(TAG, "failed to readAndParseJSON(...)...");
         e.printStackTrace();
      }

   }
   public void fetchJSON(){
      Thread thread = new Thread(new Runnable(){
         @Override
         public void run() {
            try {
               URL url = new URL(urlString);
               HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
               Log.d(TAG, agent);
               conn.setRequestProperty("User-Agent", agent);
               conn.setRequestProperty("Accept", "application/vnd.noaa.dwml+xml;version=1");

               conn.setReadTimeout(10000 /* milliseconds */);
               conn.setConnectTimeout(10000 /* milliseconds */);
               conn.setRequestMethod("GET");
               conn.setDoInput(true);
               // Starts the query
               conn.connect();
               InputStream stream = conn.getInputStream();

               String data = convertStreamToString(stream);

               readAndParseJSON(data);
               stream.close();
            } catch (NullPointerException np) {
               Log.i(TAG, "NullPointerException in fetchJSON()...");
               np.printStackTrace();
            } catch (IOException io) {
               Log.i(TAG, "IOException in fetchJSON()...");
               io.printStackTrace();
            } catch (Exception e) {
               Log.i(TAG, "Exception in fetchJSON()...");
               e.printStackTrace();
            }
         }
      });
      Log.i(TAG, "fetchJSON() thread start");
      thread.start();
      Log.i(TAG, "fetchJSON() end...");
   }

   static String convertStreamToString(java.io.InputStream is) {
      java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
      return s.hasNext() ? s.next() : "";
   }
}
