package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzp implements Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzaxg);
        zzb.zzc(parcel, 1000, rawDataSet.mVersionCode);
        zzb.zzc(parcel, 2, rawDataSet.zzaxi);
        zzb.zzc(parcel, 3, rawDataSet.zzaxj, false);
        zzb.zza(parcel, 4, rawDataSet.zzawi);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzda(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeZ(i);
    }

    public RawDataSet zzda(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RawDataSet[] zzeZ(int i) {
        return new RawDataSet[i];
    }
}
