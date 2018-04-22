package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity;
import java.util.HashSet;
import java.util.Set;

public class zzi implements Creator<PlacesLivedEntity> {
    static void zza(PlacesLivedEntity placesLivedEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = placesLivedEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, placesLivedEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, placesLivedEntity.zzbgr);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, placesLivedEntity.mValue, true);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjT(i);
    }

    public PlacesLivedEntity zzgM(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlacesLivedEntity(hashSet, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlacesLivedEntity[] zzjT(int i) {
        return new PlacesLivedEntity[i];
    }
}
