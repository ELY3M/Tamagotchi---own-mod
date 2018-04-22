package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zza;

abstract class zzlc extends zza<ProxyResult, zzkz> {
    public zzlc(GoogleApiClient googleApiClient) {
        super(Auth.zzVt, googleApiClient);
    }

    protected abstract void zza(Context context, zzlb com_google_android_gms_internal_zzlb) throws RemoteException;

    protected final void zza(zzkz com_google_android_gms_internal_zzkz) throws RemoteException {
        zza(com_google_android_gms_internal_zzkz.getContext(), (zzlb) com_google_android_gms_internal_zzkz.zzqJ());
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzj(status);
    }

    protected ProxyResult zzj(Status status) {
        return new zzle(status);
    }
}
