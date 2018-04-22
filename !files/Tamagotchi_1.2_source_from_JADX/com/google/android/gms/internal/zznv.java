package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zznv {
    private static int zzazC = -1;

    public static boolean zzaD(Context context) {
        return zzaG(context) == 3;
    }

    private static int zzaE(Context context) {
        return ((zzaF(context) % 1000) / 100) + 5;
    }

    private static int zzaF(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzaG(Context context) {
        if (zzazC == -1) {
            switch (zzaE(context)) {
                case 8:
                case 13:
                    zzazC = 0;
                    break;
                case 10:
                    zzazC = 3;
                    break;
                default:
                    zzazC = zzaH(context) ? 1 : 2;
                    break;
            }
        }
        return zzazC;
    }

    private static boolean zzaH(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Throwable e) {
            Log.wtf("Fitness", "Unable to determine type of device, assuming phone.  Version: " + zzaF(context), e);
            return true;
        }
    }
}
