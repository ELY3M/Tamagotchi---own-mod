package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class zzah implements Creator<UnsubscribeRequest> {
    static void zza(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, unsubscribeRequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, unsubscribeRequest.getVersionCode());
        zzb.zza(parcel, 2, unsubscribeRequest.getDataSource(), i, false);
        zzb.zza(parcel, 3, unsubscribeRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfN(i);
    }

    public UnsubscribeRequest zzdM(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            DataType dataType2;
            IBinder iBinder2;
            DataSource dataSource2;
            int zzat = zza.zzat(parcel);
            IBinder iBinder3;
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    DataSource dataSource3 = dataSource;
                    dataType2 = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    iBinder2 = iBinder;
                    dataSource2 = dataSource3;
                    break;
                case 2:
                    dataType2 = dataType;
                    i2 = i;
                    iBinder3 = iBinder;
                    dataSource2 = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = zza.zzq(parcel, zzat);
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            dataSource = dataSource2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new UnsubscribeRequest(i, dataType, dataSource, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UnsubscribeRequest[] zzfN(int i) {
        return new UnsubscribeRequest[i];
    }
}
