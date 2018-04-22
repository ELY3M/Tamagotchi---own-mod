package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.zzau.zza;

public final class zzt extends zza {
    private zzm zzbsk;
    private zzu zzbso;
    private final Object zzpV = new Object();

    public void zza(zzu com_google_android_gms_wearable_internal_zzu) {
        synchronized (this.zzpV) {
            this.zzbso = (zzu) zzx.zzz(com_google_android_gms_wearable_internal_zzu);
            zzm com_google_android_gms_wearable_internal_zzm = this.zzbsk;
        }
        if (com_google_android_gms_wearable_internal_zzm != null) {
            com_google_android_gms_wearable_internal_zzu.zzb(com_google_android_gms_wearable_internal_zzm);
        }
    }

    public void zzy(int i, int i2) {
        synchronized (this.zzpV) {
            zzu com_google_android_gms_wearable_internal_zzu = this.zzbso;
            zzm com_google_android_gms_wearable_internal_zzm = new zzm(i, i2);
            this.zzbsk = com_google_android_gms_wearable_internal_zzm;
        }
        if (com_google_android_gms_wearable_internal_zzu != null) {
            com_google_android_gms_wearable_internal_zzu.zzb(com_google_android_gms_wearable_internal_zzm);
        }
    }
}
