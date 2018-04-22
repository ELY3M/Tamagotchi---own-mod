package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkp.zza;

public class zzkm extends zzj<zzkp> {
    private final String zzUW;

    public zzkm(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 77, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzUW = com_google_android_gms_common_internal_zzf.zzqv();
    }

    private Bundle zzmm() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzUW);
        return bundle;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaj(iBinder);
    }

    public void zza(zzko com_google_android_gms_internal_zzko) {
        try {
            ((zzkp) zzqJ()).zza(com_google_android_gms_internal_zzko);
        } catch (RemoteException e) {
        }
    }

    public void zza(zzko com_google_android_gms_internal_zzko, String str) {
        try {
            ((zzkp) zzqJ()).zza(com_google_android_gms_internal_zzko, str);
        } catch (RemoteException e) {
        }
    }

    protected zzkp zzaj(IBinder iBinder) {
        return zza.zzal(iBinder);
    }

    public void zzb(zzko com_google_android_gms_internal_zzko, String str) {
        try {
            ((zzkp) zzqJ()).zzb(com_google_android_gms_internal_zzko, str);
        } catch (RemoteException e) {
        }
    }

    protected String zzgu() {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected Bundle zzml() {
        return zzmm();
    }
}
