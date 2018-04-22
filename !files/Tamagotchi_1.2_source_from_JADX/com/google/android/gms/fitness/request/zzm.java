package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zzm implements Creator<DataUpdateRequest> {
    static void zza(DataUpdateRequest dataUpdateRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataUpdateRequest.zzlO());
        zzb.zzc(parcel, 1000, dataUpdateRequest.getVersionCode());
        zzb.zza(parcel, 2, dataUpdateRequest.zzud());
        zzb.zza(parcel, 3, dataUpdateRequest.getDataSet(), i, false);
        zzb.zza(parcel, 4, dataUpdateRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzds(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfs(i);
    }

    public DataUpdateRequest zzds(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataSet dataSet = null;
        long j2 = 0;
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
                    dataSet = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
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
            return new DataUpdateRequest(i, j2, j, dataSet, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataUpdateRequest[] zzfs(int i) {
        return new DataUpdateRequest[i];
    }
}
