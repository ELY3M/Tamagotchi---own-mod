package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] zzUb = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzUc = new HashMap(zzUb.length);

    static {
        int i = 0;
        while (i < zzUb.length) {
            zzUc.put(zzUb[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzao(int i) {
        return (i < 0 || i >= zzUb.length) ? null : zzUb[i];
    }

    public static int zzbA(String str) {
        Integer num = (Integer) zzUc.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzmg() {
        return zzUb.length;
    }
}
