package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzbl implements Creator<StorageInfoResponse> {
    static void zza(StorageInfoResponse storageInfoResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, storageInfoResponse.versionCode);
        zzb.zzc(parcel, 2, storageInfoResponse.statusCode);
        zzb.zza(parcel, 3, storageInfoResponse.zzbta);
        zzb.zzc(parcel, 4, storageInfoResponse.zzbtc, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmm(i);
    }

    public StorageInfoResponse zziI(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, PackageStorageInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StorageInfoResponse(i2, i, j, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StorageInfoResponse[] zzmm(int i) {
        return new StorageInfoResponse[i];
    }
}
