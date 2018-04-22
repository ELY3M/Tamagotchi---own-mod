package org.acra.collector;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.support.annotation.NonNull;
import org.acra.ACRA;

final class DeviceFeaturesCollector {
    private DeviceFeaturesCollector() {
    }

    @NonNull
    public static String getFeatures(@NonNull Context ctx) {
        StringBuilder result = new StringBuilder();
        try {
            for (FeatureInfo feature : ctx.getPackageManager().getSystemAvailableFeatures()) {
                String featureName = feature.name;
                if (featureName != null) {
                    result.append(featureName);
                } else {
                    result.append("glEsVersion = ").append(feature.getGlEsVersion());
                }
                result.append("\n");
            }
        } catch (Throwable e) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, "Couldn't retrieve DeviceFeatures for " + ctx.getPackageName(), e);
            result.append("Could not retrieve data: ");
            result.append(e.getMessage());
        }
        return result.toString();
    }
}
