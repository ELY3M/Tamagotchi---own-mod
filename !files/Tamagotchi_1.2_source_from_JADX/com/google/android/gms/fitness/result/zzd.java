package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzd implements Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataSourceStatsResult.zzavU, i, false);
        zzb.zzc(parcel, 1000, dataSourceStatsResult.mVersionCode);
        zzb.zza(parcel, 2, dataSourceStatsResult.zzUZ);
        zzb.zza(parcel, 3, dataSourceStatsResult.zzaBI);
        zzb.zza(parcel, 4, dataSourceStatsResult.zzaBJ);
        zzb.zza(parcel, 5, dataSourceStatsResult.zzaBK);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfR(i);
    }

    public DataSourceStatsResult zzdQ(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzau = zza.zzau(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzat);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSourceStatsResult[] zzfR(int i) {
        return new DataSourceStatsResult[i];
    }
}
