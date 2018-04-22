package com.tamaproject.util;

import android.annotation.SuppressLint;
import com.google.android.gms.plus.PlusShare;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.json.JSONObject;

public class handlejson {
    private String main = ISVGConstants.VALUE_NONE;
    public volatile boolean parsingComplete = true;
    private String temp = "temperature";
    private String urlString = null;
    private String weather = ISVGConstants.VALUE_NONE;

    class C05831 implements Runnable {
        C05831() {
        }

        public void run() {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(handlejson.this.urlString).openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                InputStream stream = conn.getInputStream();
                handlejson.this.readAndParseJSON(handlejson.convertStreamToString(stream));
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public handlejson(String url) {
        this.urlString = url;
    }

    public String getWeather() {
        return this.weather;
    }

    public String getmain() {
        return this.main;
    }

    public String getTemp() {
        return this.temp;
    }

    @SuppressLint({"NewApi"})
    public void readAndParseJSON(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            JSONObject weatherobject = reader.getJSONArray("weather").getJSONObject(0);
            this.main = weatherobject.getString("main");
            this.weather = weatherobject.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
            this.temp = reader.getJSONObject("main").getString("temp");
            this.parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchJSON() {
        new Thread(new C05831()).start();
    }

    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
