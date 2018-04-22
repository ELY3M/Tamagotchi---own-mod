package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<Strategy> {
    static void zza(Strategy strategy, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, strategy.zzbbL);
        zzb.zzc(parcel, 1000, strategy.mVersionCode);
        zzb.zzc(parcel, 2, strategy.zzbbM);
        zzb.zzc(parcel, 3, strategy.zzbbN);
        zzb.zza(parcel, 4, strategy.zzbbO);
        zzb.zzc(parcel, 5, strategy.zzEr());
        zzb.zzc(parcel, 6, strategy.zzEs());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjh(i);
    }

    public Strategy zzgc(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i6 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Strategy(i6, i5, i4, i3, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Strategy[] zzjh(int i) {
        return new Strategy[i];
    }
}
