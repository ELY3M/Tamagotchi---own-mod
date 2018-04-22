package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzd;
import com.google.android.gms.auth.api.credentials.internal.zzf;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import java.util.Collections;
import java.util.List;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzVA, zzVu);
    public static final CredentialsApi CredentialsApi = new zzd();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzVE, zzVx);
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final Api<zza> PROXY_API = new Api("Auth.PROXY_API", zzVz, zzVt);
    public static final ProxyApi ProxyApi = new zzld();
    private static final com.google.android.gms.common.api.Api.zza<zzf, AuthCredentialsOptions> zzVA = new C06802();
    private static final com.google.android.gms.common.api.Api.zza<zzks, NoOptions> zzVB = new C06813();
    private static final com.google.android.gms.common.api.Api.zza<zzkw, NoOptions> zzVC = new C06824();
    private static final com.google.android.gms.common.api.Api.zza<zzo, zzg> zzVD = new C06835();
    private static final com.google.android.gms.common.api.Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> zzVE = new C06846();
    public static final Api<zzg> zzVF = new Api("Auth.SIGN_IN_API", zzVD, zzVw);
    public static final Api<NoOptions> zzVG = new Api("Auth.ACCOUNT_STATUS_API", zzVB, zzVv);
    public static final Api<NoOptions> zzVH = new Api("Auth.CONSENT_API", zzVC, zzVy);
    public static final zzkq zzVI = new zzkr();
    public static final com.google.android.gms.auth.api.signin.zzf zzVJ = new zzn();
    public static final com.google.android.gms.auth.api.consent.zza zzVK = new zzkv();
    public static final Api.zzc<zzkz> zzVt = new Api.zzc();
    public static final Api.zzc<zzf> zzVu = new Api.zzc();
    public static final Api.zzc<zzks> zzVv = new Api.zzc();
    public static final Api.zzc<zzo> zzVw = new Api.zzc();
    public static final Api.zzc<com.google.android.gms.auth.api.signin.internal.zzd> zzVx = new Api.zzc();
    public static final Api.zzc<zzkw> zzVy = new Api.zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzkz, zza> zzVz = new C06791();

    static class C06791 extends com.google.android.gms.common.api.Api.zza<zzkz, zza> {
        C06791() {
        }

        public zzkz zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_auth_api_Auth_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkz(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_Auth_zza, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06802 extends com.google.android.gms.common.api.Api.zza<zzf, AuthCredentialsOptions> {
        C06802() {
        }

        public zzf zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzf(context, looper, com_google_android_gms_common_internal_zzf, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06813 extends com.google.android.gms.common.api.Api.zza<zzks, NoOptions> {
        C06813() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzks zzc(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzks(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06824 extends com.google.android.gms.common.api.Api.zza<zzkw, NoOptions> {
        C06824() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzd(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzkw zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkw(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06835 extends com.google.android.gms.common.api.Api.zza<zzo, zzg> {
        C06835() {
        }

        public zzo zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_auth_api_signin_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzo(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_signin_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06846 extends com.google.android.gms.common.api.Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> {
        C06846() {
        }

        public com.google.android.gms.auth.api.signin.internal.zzd zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, @Nullable GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.auth.api.signin.internal.zzd(context, looper, com_google_android_gms_common_internal_zzf, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public List<Scope> zza(@Nullable GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzmN();
        }

        public /* synthetic */ List zzo(@Nullable Object obj) {
            return zza((GoogleSignInOptions) obj);
        }
    }

    public static final class AuthCredentialsOptions implements Optional {
        private final String zzVL;
        private final PasswordSpecification zzVM;

        public static class Builder {
            @NonNull
            private PasswordSpecification zzVM = PasswordSpecification.zzWl;
        }

        public Bundle zzml() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzVL);
            bundle.putParcelable("password_specification", this.zzVM);
            return bundle;
        }

        public PasswordSpecification zzmr() {
            return this.zzVM;
        }
    }

    public static final class zza implements Optional {
        private final Bundle zzVN;

        public Bundle zzms() {
            return new Bundle(this.zzVN);
        }
    }

    private Auth() {
    }
}
