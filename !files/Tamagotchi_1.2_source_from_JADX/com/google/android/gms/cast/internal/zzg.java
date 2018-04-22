package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<DeviceStatus> {
    static void zza(DeviceStatus deviceStatus, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, deviceStatus.getVersionCode());
        zzb.zza(parcel, 2, deviceStatus.zzok());
        zzb.zza(parcel, 3, deviceStatus.zzot());
        zzb.zzc(parcel, 4, deviceStatus.zzol());
        zzb.zza(parcel, 5, deviceStatus.getApplicationMetadata(), i, false);
        zzb.zzc(parcel, 6, deviceStatus.zzom());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzae(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbo(i);
    }

    public DeviceStatus zzae(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    d = zza.zzn(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) zza.zza(parcel, zzat, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DeviceStatus(i3, d, z, i2, applicationMetadata, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DeviceStatus[] zzbo(int i) {
        return new DeviceStatus[i];
    }
}
