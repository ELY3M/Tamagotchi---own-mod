package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs implements Creator<Subscription> {
    static void zza(Subscription subscription, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, subscription.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, subscription.getVersionCode());
        zzb.zza(parcel, 2, subscription.getDataType(), i, false);
        zzb.zza(parcel, 3, subscription.zzux());
        zzb.zzc(parcel, 4, subscription.getAccuracyMode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfd(i);
    }

    public Subscription zzdd(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Subscription[] zzfd(int i) {
        return new Subscription[i];
    }
}
