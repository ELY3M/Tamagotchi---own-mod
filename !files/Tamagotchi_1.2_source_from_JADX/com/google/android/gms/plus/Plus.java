package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api("Plus.API", zzUJ, zzUI);
    @Deprecated
    public static final Account AccountApi = new zzqv();
    public static final Moments MomentsApi = new zzqy();
    public static final People PeopleApi = new zzqz();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final zzc<zze> zzUI = new zzc();
    static final com.google.android.gms.common.api.Api.zza<zze, PlusOptions> zzUJ = new C08481();
    public static final zzb zzbdW = new zzqx();
    public static final zza zzbdX = new zzqw();

    static class C08481 extends com.google.android.gms.common.api.Api.zza<zze, PlusOptions> {
        C08481() {
        }

        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, new PlusSession(com_google_android_gms_common_internal_zzf.zzqq().name, zznh.zzc(com_google_android_gms_common_internal_zzf.zzqt()), (String[]) plusOptions.zzbdZ.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class PlusOptions implements Optional {
        final String zzbdY;
        final Set<String> zzbdZ;

        public static final class Builder {
            String zzbdY;
            final Set<String> zzbdZ = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                zzx.zzb((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.zzbdZ.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.zzbdY = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.zzbdY = null;
            this.zzbdZ = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzbdY = builder.zzbdY;
            this.zzbdZ = builder.zzbdZ;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzUI, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zze) googleApiClient.zza(zzUI) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
