package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzri.zza;

public class zzrj extends zzj<zzri> {
    public zzrj(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, context.getMainLooper(), 73, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdZ(iBinder);
    }

    protected zzri zzdZ(IBinder iBinder) {
        return zza.zzdY(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzgv() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
