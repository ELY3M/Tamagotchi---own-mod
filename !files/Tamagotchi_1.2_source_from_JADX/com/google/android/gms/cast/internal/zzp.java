package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzaaf = new zzl("RequestTracker");
    public static final Object zzaeB = new Object();
    private long zzacY = -1;
    private zzo zzaeA;
    private long zzaey;
    private long zzaez = 0;

    public zzp(long j) {
        this.zzaey = j;
    }

    private void zzoz() {
        this.zzacY = -1;
        this.zzaeA = null;
        this.zzaez = 0;
    }

    public void clear() {
        synchronized (zzaeB) {
            if (this.zzacY != -1) {
                zzoz();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzaeB) {
            z = this.zzacY != -1 && this.zzacY == j;
        }
        return z;
    }

    public void zza(long j, zzo com_google_android_gms_cast_internal_zzo) {
        synchronized (zzaeB) {
            zzo com_google_android_gms_cast_internal_zzo2 = this.zzaeA;
            long j2 = this.zzacY;
            this.zzacY = j;
            this.zzaeA = com_google_android_gms_cast_internal_zzo;
            this.zzaez = SystemClock.elapsedRealtime();
        }
        if (com_google_android_gms_cast_internal_zzo2 != null) {
            com_google_android_gms_cast_internal_zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo com_google_android_gms_cast_internal_zzo = null;
        synchronized (zzaeB) {
            if (this.zzacY == -1 || this.zzacY != j) {
                z = false;
            } else {
                zzaaf.zzb("request %d completed", Long.valueOf(this.zzacY));
                com_google_android_gms_cast_internal_zzo = this.zzaeA;
                zzoz();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo com_google_android_gms_cast_internal_zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzaeB) {
            if (this.zzacY == -1 || j - this.zzaez < this.zzaey) {
                z = false;
                com_google_android_gms_cast_internal_zzo = null;
            } else {
                zzaaf.zzb("request %d timed out", Long.valueOf(this.zzacY));
                j2 = this.zzacY;
                com_google_android_gms_cast_internal_zzo = this.zzaeA;
                zzoz();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzoA() {
        boolean z;
        synchronized (zzaeB) {
            z = this.zzacY != -1;
        }
        return z;
    }
}
