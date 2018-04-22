package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbp;
import com.google.android.gms.wearable.internal.zzbr;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable {
    public static final Api<WearableOptions> API = new Api("Wearable.API", zzUJ, zzUI);
    public static final CapabilityApi CapabilityApi = new zzj();
    public static final ChannelApi ChannelApi = new zzl();
    public static final DataApi DataApi = new zzx();
    public static final MessageApi MessageApi = new zzaz();
    public static final NodeApi NodeApi = new zzbb();
    public static final zzc<zzbp> zzUI = new zzc();
    private static final zza<zzbp, WearableOptions> zzUJ = new C08691();
    public static final zzc zzbrj = new zzg();
    public static final zza zzbrk = new zze();
    public static final zzf zzbrl = new zzw();
    public static final zzi zzbrm = new zzbm();
    public static final zzk zzbrn = new zzbr();

    static class C08691 extends zza<zzbp, WearableOptions> {
        C08691() {
        }

        public zzbp zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new zzbp(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
