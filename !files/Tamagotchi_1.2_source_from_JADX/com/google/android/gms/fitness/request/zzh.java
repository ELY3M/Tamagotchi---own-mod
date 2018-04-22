package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzh implements Creator<DataSourcesRequest> {
    static void zza(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, dataSourcesRequest.getVersionCode());
        zzb.zza(parcel, 2, dataSourcesRequest.zzuT(), false);
        zzb.zza(parcel, 3, dataSourcesRequest.zzuU());
        zzb.zza(parcel, 4, dataSourcesRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfn(i);
    }

    public DataSourcesRequest zzdn(Parcel parcel) {
        boolean z = false;
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        List list = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    list2 = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case 2:
                    list = zza.zzC(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    iBinder = zza.zzq(parcel, zzat);
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
            return new DataSourcesRequest(i, list2, list, z, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSourcesRequest[] zzfn(int i) {
        return new DataSourcesRequest[i];
    }
}
