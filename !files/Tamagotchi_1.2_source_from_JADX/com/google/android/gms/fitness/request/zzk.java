package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class zzk implements Creator<DataUpdateListenerRegistrationRequest> {
    static void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataUpdateListenerRegistrationRequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataUpdateListenerRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, dataUpdateListenerRegistrationRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, dataUpdateListenerRegistrationRequest.getIntent(), i, false);
        zzb.zza(parcel, 4, dataUpdateListenerRegistrationRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfq(i);
    }

    public DataUpdateListenerRegistrationRequest zzdq(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        DataType dataType = null;
        DataSource dataSource = null;
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
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
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
            return new DataUpdateListenerRegistrationRequest(i, dataSource, dataType, pendingIntent, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataUpdateListenerRegistrationRequest[] zzfq(int i) {
        return new DataUpdateListenerRegistrationRequest[i];
    }
}
