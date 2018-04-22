package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<StopProvidingContentRequest> {
    static void zza(StopProvidingContentRequest stopProvidingContentRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, stopProvidingContentRequest.versionCode);
        zzb.zza(parcel, 2, stopProvidingContentRequest.zzbdn);
        zzb.zza(parcel, 3, stopProvidingContentRequest.zzED(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjC(i);
    }

    public StopProvidingContentRequest zzgw(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StopProvidingContentRequest(i, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StopProvidingContentRequest[] zzjC(int i) {
        return new StopProvidingContentRequest[i];
    }
}
