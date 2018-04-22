package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;

public class zzoe extends zzny<zzop> {

    public static class zzb extends com.google.android.gms.common.api.Api.zza<zzoe, NoOptions> {
        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzl(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzoe zzl(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzoe(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzoe> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzavP, googleApiClient);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            zzx.zzac(!status.isSuccess());
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zzoe(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 55, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbz(iBinder);
    }

    protected zzop zzbz(IBinder iBinder) {
        return com.google.android.gms.internal.zzop.zza.zzbK(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.fitness.SensorsApi";
    }

    protected String zzgv() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi";
    }
}
