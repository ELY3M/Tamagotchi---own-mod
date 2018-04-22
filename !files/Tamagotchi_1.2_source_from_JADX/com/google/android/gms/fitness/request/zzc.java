package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzc implements Creator<DailyTotalRequest> {
    static void zza(DailyTotalRequest dailyTotalRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dailyTotalRequest.getCallbackBinder(), false);
        zzb.zzc(parcel, 1000, dailyTotalRequest.getVersionCode());
        zzb.zza(parcel, 2, dailyTotalRequest.getDataType(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfi(i);
    }

    public DailyTotalRequest zzdi(Parcel parcel) {
        DataType dataType = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
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
            return new DailyTotalRequest(i, iBinder, dataType);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DailyTotalRequest[] zzfi(int i) {
        return new DailyTotalRequest[i];
    }
}
