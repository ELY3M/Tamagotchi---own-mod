package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Collection;

public class zza implements Creator<AppVisibleCustomProperties> {
    static void zza(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appVisibleCustomProperties.mVersionCode);
        zzb.zzc(parcel, 2, appVisibleCustomProperties.zzasL, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzce(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdZ(i);
    }

    public AppVisibleCustomProperties zzce(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    collection = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, CustomProperty.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppVisibleCustomProperties[] zzdZ(int i) {
        return new AppVisibleCustomProperties[i];
    }
}
