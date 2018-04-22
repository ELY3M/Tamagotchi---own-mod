package com.tamaproject.util;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import android.annotation.SuppressLint;

public class handlejson {

   private String weather = "none";
   private String main = "none";
   private String temp = "temperature";

   private String urlString = null;

   public volatile boolean parsingComplete = true;
   public handlejson(String url){
      this.urlString = url;
   }


   public String getWeather() {
      return weather;
   }
   public String getmain() {
        return main;
    }
   public String getTemp() {
      return temp;
   }

   @SuppressLint("NewApi")
   public void readAndParseJSON(String in) {
      try {
         JSONObject reader = new JSONObject(in);

         //JSONObject getweather  = reader.getJSONObject("weather");
         //get weather
         JSONArray weatherarray = reader.getJSONArray("weather");
         JSONObject weatherobject = weatherarray.getJSONObject(0);
         main = weatherobject.getString("main");
         weather = weatherobject.getString("description");
         //get temp
         JSONObject gettemp  = reader.getJSONObject("main");
         temp = gettemp.getString("temp");
         parsingComplete = false;

        } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }

   }
   public void fetchJSON(){
      Thread thread = new Thread(new Runnable(){
         @Override
         public void run() {
         try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
         InputStream stream = conn.getInputStream();

      String data = convertStreamToString(stream);

      readAndParseJSON(data);
         stream.close();

         } catch (Exception e) {
            e.printStackTrace();
         }
         }
      });

       thread.start(); 		
   }
   static String convertStreamToString(java.io.InputStream is) {
      java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
      return s.hasNext() ? s.next() : "";
   }
}
