package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;

public class zzb implements Creator<DailyTotalResult> {
    static void zza(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, dailyTotalResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dailyTotalResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dailyTotalResult.getTotal(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfP(i);
    }

    public DailyTotalResult zzdO(Parcel parcel) {
        DataSet dataSet = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            DataSet dataSet2;
            Status status2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    dataSet2 = dataSet;
                    status2 = status3;
                    break;
                case 2:
                    dataSet2 = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzat);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    dataSet2 = dataSet;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzau) {
            return new DailyTotalResult(i, status, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DailyTotalResult[] zzfP(int i) {
        return new DailyTotalResult[i];
    }
}
