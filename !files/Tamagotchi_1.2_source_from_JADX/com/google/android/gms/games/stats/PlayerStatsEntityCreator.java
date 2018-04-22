package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerStatsEntityCreator implements Creator<PlayerStatsEntity> {
    static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, playerStatsEntity.getAverageSessionLength());
        zzb.zzc(parcel, 1000, playerStatsEntity.getVersionCode());
        zzb.zza(parcel, 2, playerStatsEntity.getChurnProbability());
        zzb.zzc(parcel, 3, playerStatsEntity.getDaysSinceLastPlayed());
        zzb.zzc(parcel, 4, playerStatsEntity.getNumberOfPurchases());
        zzb.zzc(parcel, 5, playerStatsEntity.getNumberOfSessions());
        zzb.zza(parcel, 6, playerStatsEntity.getSessionPercentile());
        zzb.zza(parcel, 7, playerStatsEntity.getSpendPercentile());
        zzb.zza(parcel, 8, playerStatsEntity.zzxV(), false);
        zzb.zza(parcel, 9, playerStatsEntity.getSpendProbability());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgW(i);
    }

    public PlayerStatsEntity zzeE(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    f5 = zza.zzl(parcel, zzat);
                    break;
                case 2:
                    f4 = zza.zzl(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    f3 = zza.zzl(parcel, zzat);
                    break;
                case 7:
                    f2 = zza.zzl(parcel, zzat);
                    break;
                case 8:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 9:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlayerStatsEntity(i4, f5, f4, i3, i2, i, f3, f2, bundle, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayerStatsEntity[] zzgW(int i) {
        return new PlayerStatsEntity[i];
    }
}
