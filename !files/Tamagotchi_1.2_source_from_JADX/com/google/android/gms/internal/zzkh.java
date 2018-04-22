package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.internal.zzkg.zza;

public abstract class zzkh<T> extends zza {
    protected zzb<T> zzUz;

    public zzkh(zzb<T> com_google_android_gms_common_api_internal_zza_zzb_T) {
        this.zzUz = com_google_android_gms_common_api_internal_zza_zzb_T;
    }

    public void zza(Response response) {
    }

    public void zza(Status status) {
    }

    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    public void zza(Status status, boolean z) {
    }
}
