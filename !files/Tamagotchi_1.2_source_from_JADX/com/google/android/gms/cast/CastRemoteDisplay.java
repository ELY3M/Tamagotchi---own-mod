package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlq;
import com.google.android.gms.internal.zzlr;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API = new Api("CastRemoteDisplay.API", zzUJ, zzUI);
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzlq(zzUI);
    private static final zzc<zzlr> zzUI = new zzc();
    private static final zza<zzlr, CastRemoteDisplayOptions> zzUJ = new C06901();

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    static class C06901 extends zza<zzlr, CastRemoteDisplayOptions> {
        C06901() {
        }

        public zzlr zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastRemoteDisplayOptions castRemoteDisplayOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlr(context, looper, com_google_android_gms_common_internal_zzf, castRemoteDisplayOptions.zzZL, castRemoteDisplayOptions.zzaad, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    public static final class CastRemoteDisplayOptions implements HasOptions {
        final CastDevice zzZL;
        final CastRemoteDisplaySessionCallbacks zzaad;

        public static final class Builder {
            CastDevice zzZO;
            CastRemoteDisplaySessionCallbacks zzaae;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks callbacks) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzZO = castDevice;
                this.zzaae = callbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions();
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzaad = builder.zzaae;
        }
    }

    private CastRemoteDisplay() {
    }
}
