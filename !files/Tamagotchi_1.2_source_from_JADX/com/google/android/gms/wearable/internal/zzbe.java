package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbe implements Creator<PackageStorageInfo> {
    static void zza(PackageStorageInfo packageStorageInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, packageStorageInfo.versionCode);
        zzb.zza(parcel, 2, packageStorageInfo.packageName, false);
        zzb.zza(parcel, 3, packageStorageInfo.label, false);
        zzb.zza(parcel, 4, packageStorageInfo.zzbta);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmh(i);
    }

    public PackageStorageInfo zziD(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PackageStorageInfo(i, str2, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PackageStorageInfo[] zzmh(int i) {
        return new PackageStorageInfo[i];
    }
}
