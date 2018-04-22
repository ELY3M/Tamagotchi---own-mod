package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<CountrySpecification> {
    static void zza(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, countrySpecification.getVersionCode());
        zzb.zza(parcel, 2, countrySpecification.zzJU, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkO(i);
    }

    public CountrySpecification zzhq(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CountrySpecification(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CountrySpecification[] zzkO(int i) {
        return new CountrySpecification[i];
    }
}
