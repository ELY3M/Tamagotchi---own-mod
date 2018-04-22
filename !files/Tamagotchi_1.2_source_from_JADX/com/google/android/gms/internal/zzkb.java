package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzkb extends zze<zzkb> {
    private Map<Integer, String> zzPL = new HashMap(4);

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzPL.entrySet()) {
            hashMap.put("dimension" + entry.getKey(), entry.getValue());
        }
        return zze.zzF(hashMap);
    }

    public void zza(zzkb com_google_android_gms_internal_zzkb) {
        com_google_android_gms_internal_zzkb.zzPL.putAll(this.zzPL);
    }

    public Map<Integer, String> zziP() {
        return Collections.unmodifiableMap(this.zzPL);
    }
}
