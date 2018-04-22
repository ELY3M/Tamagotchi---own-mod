package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Creator<DataItemAssetParcelable> {
    static void zza(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, dataItemAssetParcelable.mVersionCode);
        zzb.zza(parcel, 2, dataItemAssetParcelable.getId(), false);
        zzb.zza(parcel, 3, dataItemAssetParcelable.getDataItemKey(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzik(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlO(i);
    }

    public DataItemAssetParcelable zzik(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DataItemAssetParcelable(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataItemAssetParcelable[] zzlO(int i) {
        return new DataItemAssetParcelable[i];
    }
}
