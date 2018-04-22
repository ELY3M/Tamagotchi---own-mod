package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<NotFilter> {
    static void zza(NotFilter notFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, notFilter.mVersionCode);
        zzb.zza(parcel, 1, notFilter.zzauw, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzep(i);
    }

    public NotFilter zzcu(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzat, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NotFilter[] zzep(int i) {
        return new NotFilter[i];
    }
}
