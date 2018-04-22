package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Creator<ImageEntity> {
    static void zza(ImageEntity imageEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = imageEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, imageEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, imageEntity.zzF, true);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjQ(i);
    }

    public ImageEntity zzgJ(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ImageEntity(hashSet, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ImageEntity[] zzjQ(int i) {
        return new ImageEntity[i];
    }
}
