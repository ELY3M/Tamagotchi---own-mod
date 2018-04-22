package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzh.zza;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzo extends zzj<zzh> {
    private final zzg zzXK;

    public zzo(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_auth_api_signin_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzXK = (zzg) zzx.zzz(com_google_android_gms_auth_api_signin_zzg);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaB(iBinder);
    }

    protected zzh zzaB(IBinder iBinder) {
        return zza.zzaD(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
