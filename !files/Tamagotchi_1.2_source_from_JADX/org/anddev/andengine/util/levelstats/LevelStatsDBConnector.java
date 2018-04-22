package org.anddev.andengine.util.levelstats;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.anddev.andengine.util.Callback;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.SimplePreferences;
import org.anddev.andengine.util.StreamUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class LevelStatsDBConnector {
    private static final String PREFERENCES_LEVELSTATSDBCONNECTOR_PLAYERID_ID = "preferences.levelstatsdbconnector.playerid";
    private final int mPlayerID;
    private final String mSecret;
    private final String mSubmitURL;

    public LevelStatsDBConnector(Context pContext, String pSecret, String pSubmitURL) {
        this.mSecret = pSecret;
        this.mSubmitURL = pSubmitURL;
        int playerID = SimplePreferences.getInstance(pContext).getInt(PREFERENCES_LEVELSTATSDBCONNECTOR_PLAYERID_ID, -1);
        if (playerID != -1) {
            this.mPlayerID = playerID;
            return;
        }
        this.mPlayerID = MathUtils.random(1000000000, Integer.MAX_VALUE);
        SimplePreferences.getEditorInstance(pContext).putInt(PREFERENCES_LEVELSTATSDBCONNECTOR_PLAYERID_ID, this.mPlayerID).commit();
    }

    public void submitAsync(int pLevelID, boolean pSolved, int pSecondsElapsed) {
        submitAsync(pLevelID, pSolved, pSecondsElapsed, null);
    }

    public void submitAsync(int pLevelID, boolean pSolved, int pSecondsElapsed, Callback<Boolean> pCallback) {
        final int i = pLevelID;
        final boolean z = pSolved;
        final int i2 = pSecondsElapsed;
        final Callback<Boolean> callback = pCallback;
        new Thread(new Runnable() {
            public void run() {
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(LevelStatsDBConnector.this.mSubmitURL);
                    List<NameValuePair> nameValuePairs = new ArrayList(5);
                    nameValuePairs.add(new BasicNameValuePair("level_id", String.valueOf(i)));
                    nameValuePairs.add(new BasicNameValuePair("solved", z ? "1" : "0"));
                    nameValuePairs.add(new BasicNameValuePair("secondsplayed", String.valueOf(i2)));
                    nameValuePairs.add(new BasicNameValuePair("player_id", String.valueOf(LevelStatsDBConnector.this.mPlayerID)));
                    nameValuePairs.add(new BasicNameValuePair("secret", String.valueOf(LevelStatsDBConnector.this.mSecret)));
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        if (StreamUtils.readFully(httpResponse.getEntity().getContent()).equals("<success/>")) {
                            if (callback != null) {
                                callback.onCallback(Boolean.valueOf(true));
                            }
                        } else if (callback != null) {
                            callback.onCallback(Boolean.valueOf(false));
                        }
                    } else if (callback != null) {
                        callback.onCallback(Boolean.valueOf(false));
                    }
                } catch (Throwable e) {
                    Debug.m63e(e);
                    if (callback != null) {
                        callback.onCallback(Boolean.valueOf(false));
                    }
                }
            }
        }).start();
    }
}
