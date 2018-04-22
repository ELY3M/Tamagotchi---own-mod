package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<Feature> {
    static void zza(Feature feature, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, feature.id);
        zzb.zzc(parcel, 1000, feature.mVersionCode);
        zzb.zza(parcel, 2, feature.zzTS, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzal(i);
    }

    public Feature[] zzal(int i) {
        return new Feature[i];
    }

    public Feature zzu(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzat);
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
            return new Feature(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
