package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;

public final class Drive {
    public static final Api<NoOptions> API = new Api("Drive.API", new C09471(), zzUI);
    public static final DriveApi DriveApi = new zzs();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzaa();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final zzc<zzu> zzUI = new zzc();
    public static final Scope zzaoE = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzaoF = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzaoG = new Api("Drive.INTERNAL_API", new C09482(), zzUI);
    public static final zzd zzaoH = new zzx();
    public static final zzf zzaoI = new zzac();

    public static abstract class zza<O extends ApiOptions> extends com.google.android.gms.common.api.Api.zza<zzu, O> {
        protected abstract Bundle zza(O o);

        public zzu zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzu(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    static class C09471 extends zza<NoOptions> {
        C09471() {
        }

        protected Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }

    static class C09482 extends zza<zzb> {
        C09482() {
        }

        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzsw();
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzUH;

        public Bundle zzsw() {
            return this.zzUH;
        }
    }

    private Drive() {
    }
}
