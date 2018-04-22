package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.BleDevice;

public class zzb implements Creator<ClaimBleDeviceRequest> {
    static void zza(ClaimBleDeviceRequest claimBleDeviceRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, claimBleDeviceRequest.getDeviceAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, claimBleDeviceRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, claimBleDeviceRequest.zzuK(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, claimBleDeviceRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfh(i);
    }

    public ClaimBleDeviceRequest zzdh(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        BleDevice bleDevice = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            String zzp;
            IBinder iBinder2;
            BleDevice bleDevice2;
            int zzat = zza.zzat(parcel);
            IBinder iBinder3;
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    BleDevice bleDevice3 = bleDevice;
                    zzp = zza.zzp(parcel, zzat);
                    iBinder2 = iBinder;
                    bleDevice2 = bleDevice3;
                    break;
                case 2:
                    zzp = str;
                    i2 = i;
                    iBinder3 = iBinder;
                    bleDevice2 = (BleDevice) zza.zza(parcel, zzat, BleDevice.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = zza.zzq(parcel, zzat);
                    bleDevice2 = bleDevice;
                    zzp = str;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    bleDevice2 = bleDevice;
                    zzp = str;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    bleDevice2 = bleDevice;
                    zzp = str;
                    i2 = i;
                    break;
            }
            i = i2;
            str = zzp;
            bleDevice = bleDevice2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new ClaimBleDeviceRequest(i, str, bleDevice, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ClaimBleDeviceRequest[] zzfh(int i) {
        return new ClaimBleDeviceRequest[i];
    }
}
