package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<MomentEntity> {
    static void zza(MomentEntity momentEntity, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        Set set = momentEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, momentEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, momentEntity.zzyv, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, momentEntity.zzbfI, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, momentEntity.zzbfA, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, momentEntity.zzbfJ, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, momentEntity.zzJN, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjK(i);
    }

    public MomentEntity zzgD(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        String str2 = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            ItemScopeEntity itemScopeEntity3;
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity3;
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    itemScopeEntity = itemScopeEntity3;
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
            return new MomentEntity(hashSet, i, str3, itemScopeEntity2, str2, itemScopeEntity, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MomentEntity[] zzjK(int i) {
        return new MomentEntity[i];
    }
}
