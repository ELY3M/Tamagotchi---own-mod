package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class zzd implements Creator<DataDeleteRequest> {
    static void zza(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataDeleteRequest.zzlO());
        zzb.zzc(parcel, 1000, dataDeleteRequest.getVersionCode());
        zzb.zza(parcel, 2, dataDeleteRequest.zzud());
        zzb.zzc(parcel, 3, dataDeleteRequest.getDataSources(), false);
        zzb.zzc(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        zzb.zzc(parcel, 5, dataDeleteRequest.getSessions(), false);
        zzb.zza(parcel, 6, dataDeleteRequest.zzuL());
        zzb.zza(parcel, 7, dataDeleteRequest.zzuM());
        zzb.zza(parcel, 8, dataDeleteRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfj(i);
    }

    public DataDeleteRequest zzdj(Parcel parcel) {
        long j = 0;
        boolean z = false;
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        List list = null;
        List list2 = null;
        List list3 = null;
        long j2 = 0;
        int i = 0;
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
                    list3 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 4:
                    list2 = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzat, Session.CREATOR);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
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
            return new DataDeleteRequest(i, j2, j, list3, list2, list, z2, z, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataDeleteRequest[] zzfj(int i) {
        return new DataDeleteRequest[i];
    }
}
