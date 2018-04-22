package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public final class zzkz extends zzj<zzlb> {
    private final Bundle zzVN;

    public zzkz(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_auth_api_Auth_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzVN = com_google_android_gms_auth_api_Auth_zza == null ? new Bundle() : com_google_android_gms_auth_api_Auth_zza.zzms();
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzay(iBinder);
    }

    protected zzlb zzay(IBinder iBinder) {
        return zzlb.zza.zzaA(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.auth.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public boolean zzmE() {
        zzf zzqH = zzqH();
        return (TextUtils.isEmpty(zzqH.getAccountName()) || zzqH.zzb(Auth.PROXY_API).isEmpty()) ? false : true;
    }

    protected Bundle zzml() {
        return this.zzVN;
    }
}
