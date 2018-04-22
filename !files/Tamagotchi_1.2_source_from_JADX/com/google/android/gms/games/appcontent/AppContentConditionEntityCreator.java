package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void zza(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, appContentConditionEntity.zzwf(), false);
        zzb.zzc(parcel, 1000, appContentConditionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentConditionEntity.zzwg(), false);
        zzb.zza(parcel, 3, appContentConditionEntity.zzwh(), false);
        zzb.zza(parcel, 4, appContentConditionEntity.zzwi(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzei(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgk(i);
    }

    public AppContentConditionEntity zzei(Parcel parcel) {
        Bundle bundle = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppContentConditionEntity[] zzgk(int i) {
        return new AppContentConditionEntity[i];
    }
}
