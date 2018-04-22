package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<OwnedByMeFilter> {
    static void zza(OwnedByMeFilter ownedByMeFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, ownedByMeFilter.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzer(i);
    }

    public OwnedByMeFilter zzcw(Parcel parcel) {
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
            return new OwnedByMeFilter(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OwnedByMeFilter[] zzer(int i) {
        return new OwnedByMeFilter[i];
    }
}
