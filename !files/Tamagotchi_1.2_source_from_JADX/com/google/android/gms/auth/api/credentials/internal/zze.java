package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.zza;

abstract class zze<R extends Result> extends zza<R, zzf> {
    zze(GoogleApiClient googleApiClient) {
        super(Auth.zzVu, googleApiClient);
    }

    protected abstract void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws DeadObjectException, RemoteException;

    protected final void zza(zzf com_google_android_gms_auth_api_credentials_internal_zzf) throws DeadObjectException, RemoteException {
        zza(com_google_android_gms_auth_api_credentials_internal_zzf.getContext(), (zzj) com_google_android_gms_auth_api_credentials_internal_zzf.zzqJ());
    }
}
