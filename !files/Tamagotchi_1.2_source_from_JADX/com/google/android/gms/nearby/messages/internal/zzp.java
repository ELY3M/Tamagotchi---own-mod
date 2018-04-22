package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.nearby.messages.internal.zze.zza;

final class zzp extends zza {
    private final zzb<Status> zzbcS;

    private zzp(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
        this.zzbcS = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
    }

    static zzp zzn(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
        return new zzp(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
    }

    public void zzbb(Status status) throws RemoteException {
        this.zzbcS.zzs(status);
    }
}
