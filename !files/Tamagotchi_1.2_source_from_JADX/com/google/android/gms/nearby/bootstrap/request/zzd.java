package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, disconnectRequest.zzEd(), i, false);
        zzb.zzc(parcel, 1000, disconnectRequest.versionCode);
        zzb.zza(parcel, 2, disconnectRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziP(i);
    }

    public DisconnectRequest zzfT(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Device device = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            IBinder iBinder2;
            Device device2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    Device device3 = (Device) zza.zza(parcel, zzat, Device.CREATOR);
                    iBinder2 = iBinder;
                    device2 = device3;
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    device2 = device;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    device2 = device;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    device2 = device;
                    i2 = i;
                    break;
            }
            i = i2;
            device = device2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new DisconnectRequest(i, device, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DisconnectRequest[] zziP(int i) {
        return new DisconnectRequest[i];
    }
}
