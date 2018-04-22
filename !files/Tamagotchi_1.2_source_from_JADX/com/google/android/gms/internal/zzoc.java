package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public class zzoc extends zzny<zzon> {

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzoc, NoOptions> {
        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzj(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzoc zzj(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzoc(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzoc(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 61, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbx(iBinder);
    }

    protected zzon zzbx(IBinder iBinder) {
        return com.google.android.gms.internal.zzon.zza.zzbI(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    protected String zzgv() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }
}
