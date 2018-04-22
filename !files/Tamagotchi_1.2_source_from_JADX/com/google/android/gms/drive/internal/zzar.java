package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzar implements Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.mVersionCode);
        zzb.zza(parcel, 2, loadRealtimeRequest.zzaoz, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzarQ);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzarR, false);
        zzb.zza(parcel, 5, loadRealtimeRequest.zzarS);
        zzb.zza(parcel, 6, loadRealtimeRequest.zzarT, i, false);
        zzb.zza(parcel, 7, loadRealtimeRequest.zzarU, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzds(i);
    }

    public LoadRealtimeRequest zzbx(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        DataHolder dataHolder = null;
        List list = null;
        boolean z2 = false;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzD(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoadRealtimeRequest(i, driveId, z2, list, z, dataHolder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LoadRealtimeRequest[] zzds(int i) {
        return new LoadRealtimeRequest[i];
    }
}
