package com.google.android.gms.internal;

public class zzoz {
    private static final ThreadLocal<String> zzazL = new ThreadLocal();

    public static String zzD(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        Object obj = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, obj, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, obj, str.length(), str2.length());
        return Integer.toHexString(zznd.zza(obj, 0, obj.length, 0));
    }

    public static String zzdF(String str) {
        return zzuH() ? str : zzD(str, (String) zzazL.get());
    }

    public static boolean zzuH() {
        String str = (String) zzazL.get();
        return str == null || str.startsWith("com.google");
    }
}
