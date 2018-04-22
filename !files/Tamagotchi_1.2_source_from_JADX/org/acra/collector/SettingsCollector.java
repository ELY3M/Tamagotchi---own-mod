package org.acra.collector;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;

final class SettingsCollector {
    private static final String ERROR = "Error: ";
    private final ACRAConfiguration config;
    private final Context context;

    public SettingsCollector(@NonNull Context context, @NonNull ACRAConfiguration config) {
        this.context = context;
        this.config = config;
    }

    @NonNull
    public String collectSystemSettings() {
        StringBuilder result = new StringBuilder();
        for (Field key : System.class.getFields()) {
            if (!key.isAnnotationPresent(Deprecated.class) && key.getType() == String.class) {
                try {
                    String value = System.getString(this.context.getContentResolver(), (String) key.get(null));
                    if (value != null) {
                        result.append(key.getName()).append("=").append(value).append("\n");
                    }
                } catch (IllegalArgumentException e) {
                    ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e);
                } catch (IllegalAccessException e2) {
                    ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e2);
                }
            }
        }
        return result.toString();
    }

    @NonNull
    public String collectSecureSettings() {
        StringBuilder result = new StringBuilder();
        for (Field key : Secure.class.getFields()) {
            if (!key.isAnnotationPresent(Deprecated.class) && key.getType() == String.class && isAuthorized(key)) {
                try {
                    String value = Secure.getString(this.context.getContentResolver(), (String) key.get(null));
                    if (value != null) {
                        result.append(key.getName()).append("=").append(value).append("\n");
                    }
                } catch (IllegalArgumentException e) {
                    ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e);
                } catch (IllegalAccessException e2) {
                    ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e2);
                }
            }
        }
        return result.toString();
    }

    @NonNull
    public String collectGlobalSettings() {
        if (VERSION.SDK_INT < 17) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        try {
            Class<?> globalClass = Class.forName("android.provider.Settings$Global");
            Field[] keys = globalClass.getFields();
            Method getString = globalClass.getMethod("getString", new Class[]{ContentResolver.class, String.class});
            for (Field key : keys) {
                if (!key.isAnnotationPresent(Deprecated.class) && key.getType() == String.class && isAuthorized(key)) {
                    Object value = getString.invoke(null, new Object[]{this.context.getContentResolver(), key.get(null)});
                    if (value != null) {
                        result.append(key.getName()).append("=").append(value).append("\n");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e);
        } catch (InvocationTargetException e2) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e2);
        } catch (NoSuchMethodException e3) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e3);
        } catch (SecurityException e4) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e4);
        } catch (ClassNotFoundException e5) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e5);
        } catch (IllegalAccessException e6) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, ERROR, e6);
        }
        return result.toString();
    }

    private boolean isAuthorized(@Nullable Field key) {
        if (key == null || key.getName().startsWith("WIFI_AP")) {
            return false;
        }
        for (String regex : this.config.excludeMatchingSettingsKeys()) {
            if (key.getName().matches(regex)) {
                return false;
            }
        }
        return true;
    }
}
