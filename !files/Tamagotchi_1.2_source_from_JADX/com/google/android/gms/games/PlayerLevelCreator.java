package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    static void zza(PlayerLevel playerLevel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, playerLevel.getLevelNumber());
        zzb.zzc(parcel, 1000, playerLevel.getVersionCode());
        zzb.zza(parcel, 2, playerLevel.getMinXp());
        zzb.zza(parcel, 3, playerLevel.getMaxXp());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzec(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzge(i);
    }

    public PlayerLevel zzec(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayerLevel[] zzge(int i) {
        return new PlayerLevel[i];
    }
}
