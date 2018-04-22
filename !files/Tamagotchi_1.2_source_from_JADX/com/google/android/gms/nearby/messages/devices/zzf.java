package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<NearbyDevice> {
    static void zza(NearbyDevice nearbyDevice, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, nearbyDevice.zzEz(), i, false);
        zzb.zzc(parcel, 1000, nearbyDevice.mVersionCode);
        zzb.zza(parcel, 2, nearbyDevice.getUrl(), false);
        zzb.zza(parcel, 3, nearbyDevice.zzEC(), false);
        zzb.zza(parcel, 4, nearbyDevice.zzEA(), i, false);
        zzb.zza(parcel, 5, nearbyDevice.zzEB(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzji(i);
    }

    public NearbyDevice zzgd(Parcel parcel) {
        String[] strArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        NearbyDeviceId[] nearbyDeviceIdArr = null;
        String str = null;
        String str2 = null;
        NearbyDeviceId nearbyDeviceId = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    nearbyDeviceId = (NearbyDeviceId) zza.zza(parcel, zzat, NearbyDeviceId.CREATOR);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    nearbyDeviceIdArr = (NearbyDeviceId[]) zza.zzb(parcel, zzat, NearbyDeviceId.CREATOR);
                    break;
                case 5:
                    strArr = zza.zzB(parcel, zzat);
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
            return new NearbyDevice(i, nearbyDeviceId, str2, str, nearbyDeviceIdArr, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyDevice[] zzji(int i) {
        return new NearbyDevice[i];
    }
}
