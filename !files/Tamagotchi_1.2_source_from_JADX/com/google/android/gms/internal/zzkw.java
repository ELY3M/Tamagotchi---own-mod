package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkx.zza;

public class zzkw extends zzj<zzkx> {
    public zzkw(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 92, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzat(iBinder);
    }

    protected zzkx zzat(IBinder iBinder) {
        return zza.zzau(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.auth.api.consent.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.auth.api.consent.internal.IConsentService";
    }
}
