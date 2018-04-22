package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity;
import java.util.HashSet;
import java.util.Set;

public class zzh implements Creator<OrganizationsEntity> {
    static void zza(OrganizationsEntity organizationsEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = organizationsEntity.zzbeN;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, organizationsEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, organizationsEntity.zzbgp, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, organizationsEntity.zzaxl, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, organizationsEntity.zzbfk, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, organizationsEntity.zzbgq, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, organizationsEntity.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, organizationsEntity.zzbgr);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, organizationsEntity.zzbfA, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, organizationsEntity.zzapg, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, organizationsEntity.zzabB);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjS(i);
    }

    public OrganizationsEntity zzgL(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OrganizationsEntity(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OrganizationsEntity[] zzjS(int i) {
        return new OrganizationsEntity[i];
    }
}
