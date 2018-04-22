package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

public class zze implements Creator<DataSourcesResult> {
    static void zza(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, dataSourcesResult.getDataSources(), false);
        zzb.zzc(parcel, 1000, dataSourcesResult.getVersionCode());
        zzb.zza(parcel, 2, dataSourcesResult.getStatus(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfS(i);
    }

    public DataSourcesResult zzdR(Parcel parcel) {
        Status status = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    list = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
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
            return new DataSourcesResult(i, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSourcesResult[] zzfS(int i) {
        return new DataSourcesResult[i];
    }
}
