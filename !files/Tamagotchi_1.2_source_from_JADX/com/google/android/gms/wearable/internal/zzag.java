package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Creator<DeleteDataItemsResponse> {
    static void zza(DeleteDataItemsResponse deleteDataItemsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, deleteDataItemsResponse.versionCode);
        zzb.zzc(parcel, 2, deleteDataItemsResponse.statusCode);
        zzb.zzc(parcel, 3, deleteDataItemsResponse.zzbsz);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzim(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlQ(i);
    }

    public DeleteDataItemsResponse zzim(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DeleteDataItemsResponse(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DeleteDataItemsResponse[] zzlQ(int i) {
        return new DeleteDataItemsResponse[i];
    }
}
