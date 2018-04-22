package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<DataStatsResult> {
    static void zza(DataStatsResult dataStatsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataStatsResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, dataStatsResult.getVersionCode());
        zzb.zzc(parcel, 2, dataStatsResult.zzvn(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfT(i);
    }

    public DataStatsResult zzdS(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzat = zza.zzat(parcel);
            List list2;
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzat, DataSourceStatsResult.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzat);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzau) {
            return new DataStatsResult(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataStatsResult[] zzfT(int i) {
        return new DataStatsResult[i];
    }
}
