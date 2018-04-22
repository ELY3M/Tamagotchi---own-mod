package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzt implements Creator<ReadRawRequest> {
    static void zza(ReadRawRequest readRawRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, readRawRequest.getCallbackBinder(), false);
        zzb.zzc(parcel, 1000, readRawRequest.getVersionCode());
        zzb.zzc(parcel, 3, readRawRequest.zzuW(), false);
        zzb.zza(parcel, 4, readRawRequest.zzuQ());
        zzb.zza(parcel, 5, readRawRequest.zzuP());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfy(i);
    }

    public ReadRawRequest zzdy(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, DataSourceQueryParams.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzat);
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
            return new ReadRawRequest(i, iBinder, list, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ReadRawRequest[] zzfy(int i) {
        return new ReadRawRequest[i];
    }
}
