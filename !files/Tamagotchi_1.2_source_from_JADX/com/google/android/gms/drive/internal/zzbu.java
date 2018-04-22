package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;

public class zzbu extends zzd {
    private final zzb<Status> zzamC;

    public zzbu(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
        this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
    }

    public void onError(Status status) throws RemoteException {
        this.zzamC.zzs(status);
    }

    public void onSuccess() throws RemoteException {
        this.zzamC.zzs(Status.zzagC);
    }
}
