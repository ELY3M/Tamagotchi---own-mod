package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverInfoEntity;
import java.util.HashSet;
import java.util.Set;

public class zzd implements Creator<CoverInfoEntity> {
    static void zza(CoverInfoEntity coverInfoEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = coverInfoEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverInfoEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverInfoEntity.zzbgj);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, coverInfoEntity.zzbgk);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjO(i);
    }

    public CoverInfoEntity zzgH(Parcel parcel) {
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
            return new CoverInfoEntity(hashSet, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CoverInfoEntity[] zzjO(int i) {
        return new CoverInfoEntity[i];
    }
}
