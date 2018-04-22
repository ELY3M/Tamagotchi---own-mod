package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.internal.zzj.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public final class zzf extends zzj<zzj> {
    @Nullable
    private final AuthCredentialsOptions zzWA;

    public zzf(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzWA = authCredentialsOptions;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzav(iBinder);
    }

    protected zzj zzav(IBinder iBinder) {
        return zza.zzax(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    AuthCredentialsOptions zzmD() {
        return this.zzWA;
    }

    protected Bundle zzml() {
        return this.zzWA == null ? new Bundle() : this.zzWA.zzml();
    }
}
