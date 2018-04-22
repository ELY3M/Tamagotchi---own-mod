package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.acra.config.ACRAConfiguration;

final class SharedPreferencesCollector {
    private final ACRAConfiguration config;
    private final Context context;

    public SharedPreferencesCollector(@NonNull Context context, @NonNull ACRAConfiguration config) {
        this.context = context;
        this.config = config;
    }

    @NonNull
    public String collect() {
        String sharedPrefId;
        StringBuilder result = new StringBuilder();
        Map<String, SharedPreferences> sharedPrefs = new TreeMap();
        sharedPrefs.put("default", PreferenceManager.getDefaultSharedPreferences(this.context));
        for (String sharedPrefId2 : this.config.additionalSharedPreferences()) {
            sharedPrefs.put(sharedPrefId2, this.context.getSharedPreferences(sharedPrefId2, 0));
        }
        for (Entry<String, SharedPreferences> entry : sharedPrefs.entrySet()) {
            sharedPrefId2 = (String) entry.getKey();
            Map<String, ?> prefEntries = ((SharedPreferences) entry.getValue()).getAll();
            if (prefEntries.isEmpty()) {
                result.append(sharedPrefId2).append('=').append("empty\n");
            } else {
                for (Entry<String, ?> prefEntry : prefEntries.entrySet()) {
                    if (!filteredKey((String) prefEntry.getKey())) {
                        Object prefValue = prefEntry.getValue();
                        result.append(sharedPrefId2).append('.').append((String) prefEntry.getKey()).append('=');
                        result.append(prefValue == null ? "null" : prefValue.toString());
                        result.append("\n");
                    }
                }
                result.append('\n');
            }
        }
        return result.toString();
    }

    private boolean filteredKey(@NonNull String key) {
        for (String regex : this.config.excludeMatchingSharedPreferencesKeys()) {
            if (key.matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
