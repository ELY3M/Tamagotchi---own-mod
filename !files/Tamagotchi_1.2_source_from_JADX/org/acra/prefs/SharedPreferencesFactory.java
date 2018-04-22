package org.acra.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import org.acra.config.ACRAConfiguration;

public class SharedPreferencesFactory {
    private final ACRAConfiguration config;
    private final Context context;

    public SharedPreferencesFactory(@NonNull Context context, @NonNull ACRAConfiguration config) {
        this.context = context;
        this.config = config;
    }

    @NonNull
    public SharedPreferences create() {
        if (this.context == null) {
            throw new IllegalStateException("Cannot call ACRA.getACRASharedPreferences() before ACRA.init().");
        } else if ("".equals(this.config.sharedPreferencesName())) {
            return PreferenceManager.getDefaultSharedPreferences(this.context);
        } else {
            return this.context.getSharedPreferences(this.config.sharedPreferencesName(), this.config.sharedPreferencesMode());
        }
    }
}
