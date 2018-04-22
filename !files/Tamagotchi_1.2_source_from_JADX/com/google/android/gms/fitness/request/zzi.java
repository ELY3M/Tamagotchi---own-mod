package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Field;
import java.util.List;

public class zzi implements Creator<DataTypeCreateRequest> {
    static void zza(DataTypeCreateRequest dataTypeCreateRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataTypeCreateRequest.getName(), false);
        zzb.zzc(parcel, 1000, dataTypeCreateRequest.getVersionCode());
        zzb.zzc(parcel, 2, dataTypeCreateRequest.getFields(), false);
        zzb.zza(parcel, 3, dataTypeCreateRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfo(i);
    }

    public DataTypeCreateRequest zzdo(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, Field.CREATOR);
                    break;
                case 3:
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
            return new DataTypeCreateRequest(i, str, list, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataTypeCreateRequest[] zzfo(int i) {
        return new DataTypeCreateRequest[i];
    }
}
