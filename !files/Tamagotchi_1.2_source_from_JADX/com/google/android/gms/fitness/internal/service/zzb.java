package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;

public class zzb implements Creator<FitnessUnregistrationRequest> {
    static void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, fitnessUnregistrationRequest.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, fitnessUnregistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfg(i);
    }

    public FitnessUnregistrationRequest zzdg(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
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
            return new FitnessUnregistrationRequest(i, dataSource);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FitnessUnregistrationRequest[] zzfg(int i) {
        return new FitnessUnregistrationRequest[i];
    }
}
