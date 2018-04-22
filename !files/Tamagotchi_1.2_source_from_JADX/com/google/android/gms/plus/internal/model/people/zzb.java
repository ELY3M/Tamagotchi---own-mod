package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity.AgeRangeEntity;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<AgeRangeEntity> {
    static void zza(AgeRangeEntity ageRangeEntity, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        Set set = ageRangeEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, ageRangeEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, ageRangeEntity.zzbge);
        }
        if (set.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, ageRangeEntity.zzbgf);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjM(i);
    }

    public AgeRangeEntity zzgF(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AgeRangeEntity(hashSet, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AgeRangeEntity[] zzjM(int i) {
        return new AgeRangeEntity[i];
    }
}
