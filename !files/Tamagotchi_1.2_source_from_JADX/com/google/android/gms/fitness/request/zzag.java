package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Creator<UnclaimBleDeviceRequest> {
    static void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, unclaimBleDeviceRequest.getVersionCode());
        zzb.zza(parcel, 2, unclaimBleDeviceRequest.getDeviceAddress(), false);
        zzb.zza(parcel, 3, unclaimBleDeviceRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfM(i);
    }

    public UnclaimBleDeviceRequest zzdL(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 2:
                    str = zza.zzp(parcel, zzat);
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
            return new UnclaimBleDeviceRequest(i, str, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UnclaimBleDeviceRequest[] zzfM(int i) {
        return new UnclaimBleDeviceRequest[i];
    }
}
