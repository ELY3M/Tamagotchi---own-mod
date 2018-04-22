package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

public class zzu implements Creator<ReadStatsRequest> {
    static void zza(ReadStatsRequest readStatsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, readStatsRequest.getCallbackBinder(), false);
        zzb.zzc(parcel, 1000, readStatsRequest.getVersionCode());
        zzb.zzc(parcel, 3, readStatsRequest.getDataSources(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfz(i);
    }

    public ReadStatsRequest zzdz(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, DataSource.CREATOR);
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
            return new ReadStatsRequest(i, iBinder, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ReadStatsRequest[] zzfz(int i) {
        return new ReadStatsRequest[i];
    }
}
