package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

public abstract class zzt<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzu> {

    public static abstract class zza extends zzt<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zzt(GoogleApiClient googleApiClient) {
        super(Drive.zzUI, googleApiClient);
    }
}
