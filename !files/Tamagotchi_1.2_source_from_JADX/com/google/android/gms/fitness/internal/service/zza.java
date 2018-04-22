package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zza implements Creator<FitnessDataSourcesRequest> {
    static void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fitnessDataSourcesRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, fitnessDataSourcesRequest.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzff(i);
    }

    public FitnessDataSourcesRequest zzdf(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FitnessDataSourcesRequest(i, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FitnessDataSourcesRequest[] zzff(int i) {
        return new FitnessDataSourcesRequest[i];
    }
}
