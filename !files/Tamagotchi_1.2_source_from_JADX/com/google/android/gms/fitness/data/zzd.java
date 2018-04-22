package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DataPoint> {
    static void zza(DataPoint dataPoint, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataPoint.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataPoint.getVersionCode());
        zzb.zza(parcel, 3, dataPoint.getTimestampNanos());
        zzb.zza(parcel, 4, dataPoint.zzuj());
        zzb.zza(parcel, 5, dataPoint.zzuf(), i, false);
        zzb.zza(parcel, 6, dataPoint.getOriginalDataSource(), i, false);
        zzb.zza(parcel, 7, dataPoint.zzug());
        zzb.zza(parcel, 8, dataPoint.zzuh());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeP(i);
    }

    public DataPoint zzcQ(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    valueArr = (Value[]) zza.zzb(parcel, zzat, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    j4 = zza.zzi(parcel, zzat);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataPoint[] zzeP(int i) {
        return new DataPoint[i];
    }
}
