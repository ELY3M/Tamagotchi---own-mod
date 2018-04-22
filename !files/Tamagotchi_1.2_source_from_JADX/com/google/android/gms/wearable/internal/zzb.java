package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;

final class zzb<T> extends zzi<Status> {
    private T mListener;
    private zzq<T> zzbbi;
    private zza<T> zzbrA;

    interface zza<T> {
        void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, T t, zzq<T> com_google_android_gms_common_api_internal_zzq_T) throws RemoteException;
    }

    private zzb(GoogleApiClient googleApiClient, T t, zzq<T> com_google_android_gms_common_api_internal_zzq_T, zza<T> com_google_android_gms_wearable_internal_zzb_zza_T) {
        super(googleApiClient);
        this.mListener = zzx.zzz(t);
        this.zzbbi = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_T);
        this.zzbrA = (zza) zzx.zzz(com_google_android_gms_wearable_internal_zzb_zza_T);
    }

    static <T> PendingResult<Status> zza(GoogleApiClient googleApiClient, zza<T> com_google_android_gms_wearable_internal_zzb_zza_T, T t) {
        return googleApiClient.zza(new zzb(googleApiClient, t, googleApiClient.zzr(t), com_google_android_gms_wearable_internal_zzb_zza_T));
    }

    protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
        this.zzbrA.zza(com_google_android_gms_wearable_internal_zzbp, this, this.mListener, this.zzbbi);
        this.mListener = null;
        this.zzbbi = null;
    }

    protected Status zzb(Status status) {
        this.mListener = null;
        this.zzbbi = null;
        return status;
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzb(status);
    }
}
