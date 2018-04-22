package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkf.zza;

public class zzki extends zzj<zzkf> {
    public zzki(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzai(iBinder);
    }

    protected zzkf zzai(IBinder iBinder) {
        return zza.zzag(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzgv() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public zzkf zzmj() throws DeadObjectException {
        return (zzkf) zzqJ();
    }
}
