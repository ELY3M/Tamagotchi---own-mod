package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zze implements Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataSet.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataSet.getVersionCode());
        zzb.zza(parcel, 2, dataSet.getDataType(), i, false);
        zzb.zzd(parcel, 3, dataSet.zzuk(), false);
        zzb.zzc(parcel, 4, dataSet.zzul(), false);
        zzb.zza(parcel, 5, dataSet.zzuc());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeQ(i);
    }

    public DataSet zzcR(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzau = zza.zzau(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
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
                    zza.zza(parcel, zzat, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSet[] zzeQ(int i) {
        return new DataSet[i];
    }
}
