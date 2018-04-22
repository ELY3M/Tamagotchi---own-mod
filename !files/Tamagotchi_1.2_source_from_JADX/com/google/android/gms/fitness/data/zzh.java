package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<DataUpdateNotification> {
    static void zza(DataUpdateNotification dataUpdateNotification, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataUpdateNotification.zzup());
        zzb.zzc(parcel, 1000, dataUpdateNotification.mVersionCode);
        zzb.zza(parcel, 2, dataUpdateNotification.zzuq());
        zzb.zzc(parcel, 3, dataUpdateNotification.getOperationType());
        zzb.zza(parcel, 4, dataUpdateNotification.getDataSource(), i, false);
        zzb.zza(parcel, 5, dataUpdateNotification.getDataType(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeT(i);
    }

    public DataUpdateNotification zzcU(Parcel parcel) {
        long j = 0;
        DataType dataType = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 5:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DataUpdateNotification(i2, j2, j, i, dataSource, dataType);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataUpdateNotification[] zzeT(int i) {
        return new DataUpdateNotification[i];
    }
}
