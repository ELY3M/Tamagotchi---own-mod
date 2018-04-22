package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbj implements Creator<OnSyncMoreResponse> {
    static void zza(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onSyncMoreResponse.mVersionCode);
        zzb.zza(parcel, 2, onSyncMoreResponse.zzaqJ);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdH(i);
    }

    public OnSyncMoreResponse zzbM(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnSyncMoreResponse[] zzdH(int i) {
        return new OnSyncMoreResponse[i];
    }
}
