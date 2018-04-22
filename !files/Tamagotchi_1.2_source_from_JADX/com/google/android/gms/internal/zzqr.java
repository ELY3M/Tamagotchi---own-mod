package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzqp.zza;

public class zzqr extends zzj<zzqp> {
    public zzqr(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 3, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdM(iBinder);
    }

    public zzqp zzdM(IBinder iBinder) {
        return zza.zzdL(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
