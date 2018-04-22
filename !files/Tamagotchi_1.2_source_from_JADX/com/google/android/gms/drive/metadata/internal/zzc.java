package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, customProperty.mVersionCode);
        zzb.zza(parcel, 2, customProperty.zzasN, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzea(i);
    }

    public CustomProperty zzcf(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < zzau) {
            CustomPropertyKey customPropertyKey2;
            int zzg;
            String str2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = zza.zzg(parcel, zzat);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzat, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
            }
            i = zzg;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == zzau) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CustomProperty[] zzea(int i) {
        return new CustomProperty[i];
    }
}
