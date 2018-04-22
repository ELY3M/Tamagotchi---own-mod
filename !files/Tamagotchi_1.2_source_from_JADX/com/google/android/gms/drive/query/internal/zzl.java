package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<MatchAllFilter> {
    static void zza(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, matchAllFilter.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzct(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeo(i);
    }

    public MatchAllFilter zzct(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MatchAllFilter(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MatchAllFilter[] zzeo(int i) {
        return new MatchAllFilter[i];
    }
}
