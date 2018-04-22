package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc extends zzd {
    protected final Handler mHandler;
    protected final long zzadq;
    protected final Runnable zzadr;
    protected boolean zzads;

    private class zza implements Runnable {
        final /* synthetic */ zzc zzadt;

        private zza(zzc com_google_android_gms_cast_internal_zzc) {
            this.zzadt = com_google_android_gms_cast_internal_zzc;
        }

        public void run() {
            this.zzadt.zzads = false;
            this.zzadt.zzW(this.zzadt.zzz(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3) {
        this(str, str2, str3, 1000);
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzadr = new zza();
        this.zzadq = j;
        zzW(false);
    }

    protected final void zzW(boolean z) {
        if (this.zzads != z) {
            this.zzads = z;
            if (z) {
                this.mHandler.postDelayed(this.zzadr, this.zzadq);
            } else {
                this.mHandler.removeCallbacks(this.zzadr);
            }
        }
    }

    public void zzof() {
        zzW(false);
    }

    protected abstract boolean zzz(long j);
}
