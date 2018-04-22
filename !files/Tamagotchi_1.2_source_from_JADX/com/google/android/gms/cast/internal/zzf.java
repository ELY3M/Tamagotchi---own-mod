package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

public final class zzf {
    private static final Pattern zzaeb = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");

    public static double zzA(long j) {
        return ((double) j) / 1000.0d;
    }

    public static <T> boolean zza(T t, T t2) {
        return (t == null && t2 == null) || !(t == null || t2 == null || !t.equals(t2));
    }

    public static String zzb(Locale locale) {
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(locale.getLanguage());
        Object country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            stringBuilder.append('-').append(country);
        }
        country = locale.getVariant();
        if (!TextUtils.isEmpty(country)) {
            stringBuilder.append('-').append(country);
        }
        return stringBuilder.toString();
    }

    private static boolean zzb(char c) {
        return (c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '_' || c == '-'));
    }

    public static void zzch(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static String zzci(String str) {
        return "urn:x-cast:" + str;
    }

    public static String zzcj(String str) {
        if (zzaeb.matcher(str).matches()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (zzb(charAt) || charAt == '.' || charAt == ':') {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append(String.format("%%%04x", new Object[]{Integer.valueOf(charAt & 65535)}));
            }
        }
        return stringBuilder.toString();
    }

    public static long zzg(double d) {
        return (long) (1000.0d * d);
    }
}
