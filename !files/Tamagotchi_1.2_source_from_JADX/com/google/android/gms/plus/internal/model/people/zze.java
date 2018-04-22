package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity;
import java.util.HashSet;
import java.util.Set;

public class zze implements Creator<CoverPhotoEntity> {
    static void zza(CoverPhotoEntity coverPhotoEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = coverPhotoEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverPhotoEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverPhotoEntity.zzoH);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverPhotoEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzc(parcel, 4, coverPhotoEntity.zzoG);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjP(i);
    }

    public CoverPhotoEntity zzgI(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CoverPhotoEntity(hashSet, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CoverPhotoEntity[] zzjP(int i) {
        return new CoverPhotoEntity[i];
    }
}
