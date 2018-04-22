package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import java.util.HashSet;
import java.util.Set;

public class zzg implements Creator<NameEntity> {
    static void zza(NameEntity nameEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = nameEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, nameEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, nameEntity.zzbfl, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, nameEntity.zzbgl, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, nameEntity.zzbfo, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, nameEntity.zzbgm, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, nameEntity.zzbgn, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, nameEntity.zzbgo, true);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjR(i);
    }

    public NameEntity zzgK(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NameEntity(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NameEntity[] zzjR(int i) {
        return new NameEntity[i];
    }
}
