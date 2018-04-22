package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.List;

public class zza implements Creator<BleDevicesResult> {
    static void zza(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        zzb.zzc(parcel, 1000, bleDevicesResult.getVersionCode());
        zzb.zza(parcel, 2, bleDevicesResult.getStatus(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfO(i);
    }

    public BleDevicesResult zzdN(Parcel parcel) {
        Status status = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Status.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new BleDevicesResult(i, list, status);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public BleDevicesResult[] zzfO(int i) {
        return new BleDevicesResult[i];
    }
}
