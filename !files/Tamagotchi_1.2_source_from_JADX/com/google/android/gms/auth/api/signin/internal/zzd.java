package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.internal.zzh.zza;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzd extends zzj<zzh> {
    private final GoogleSignInOptions zzXx;

    public zzd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        if (googleSignInOptions == null) {
            googleSignInOptions = new Builder().build();
        }
        if (!com_google_android_gms_common_internal_zzf.zzqt().isEmpty()) {
            Builder builder = new Builder(googleSignInOptions);
            for (Scope requestScopes : com_google_android_gms_common_internal_zzf.zzqt()) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzXx = googleSignInOptions;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaB(iBinder);
    }

    protected zzh zzaB(IBinder iBinder) {
        return zza.zzaD(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public boolean zznb() {
        return true;
    }

    public Intent zznc() {
        Parcelable zzmX = new zzg.zza(getContext().getPackageName()).zzi(this.zzXx).zzmY().zzmX();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(getContext(), SignInHubActivity.class);
        intent.putExtra("config", zzmX);
        return intent;
    }

    public GoogleSignInOptions zznd() {
        return this.zzXx;
    }
}
