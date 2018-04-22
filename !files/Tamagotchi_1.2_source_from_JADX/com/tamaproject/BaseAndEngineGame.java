package com.tamaproject;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public abstract class BaseAndEngineGame extends BaseGameActivity {
    private static final int SOUND = 1;
    private static final int VIBRATE = 0;
    String TAG = "BaseAndEngineGame";
    protected boolean soundOn = false;
    protected boolean vibrateOn = false;

    public abstract void pauseSound();

    public abstract void resumeSound();

    public boolean onCreateOptionsMenu(Menu pMenu) {
        pMenu.add(0, 0, 0, "Enable Vibration");
        pMenu.add(0, 1, 0, "Enable Sound");
        return super.onCreateOptionsMenu(pMenu);
    }

    public boolean onPrepareOptionsMenu(Menu pMenu) {
        pMenu.findItem(0).setTitle(this.vibrateOn ? "Disable Vibration" : "Enable Vibration");
        pMenu.findItem(1).setTitle(this.soundOn ? "Disable Sound" : "Enable Sound");
        return super.onPrepareOptionsMenu(pMenu);
    }

    public boolean onMenuItemSelected(int pFeatureId, MenuItem pItem) {
        boolean z = false;
        switch (pItem.getItemId()) {
            case 0:
                if (!this.vibrateOn) {
                    z = true;
                }
                this.vibrateOn = z;
                savePreferences("VIBRATE", this.vibrateOn ? "true" : "false");
                return true;
            case 1:
                if (!this.soundOn) {
                    z = true;
                }
                this.soundOn = z;
                savePreferences("SOUND", this.soundOn ? "true" : "false");
                if (this.soundOn) {
                    resumeSound();
                    return true;
                }
                pauseSound();
                return true;
            default:
                return super.onMenuItemSelected(pFeatureId, pItem);
        }
    }

    private void savePreferences(String key, String value) {
        Editor editor = getPreferences(0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    protected void loadOptions() {
        SharedPreferences sharedPreferences = getPreferences(0);
        String savedVibrate = sharedPreferences.getString("VIBRATE", "");
        if ("true".equals(sharedPreferences.getString("SOUND", ""))) {
            this.soundOn = true;
        }
        if ("true".equals(savedVibrate)) {
            this.vibrateOn = true;
        }
    }
}
