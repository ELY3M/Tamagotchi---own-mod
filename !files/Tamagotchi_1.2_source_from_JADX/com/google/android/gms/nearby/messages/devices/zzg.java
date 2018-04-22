package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<NearbyDeviceFilter> {
    static void zza(NearbyDeviceFilter nearbyDeviceFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyDeviceFilter.zzbci);
        zzb.zzc(parcel, 1000, nearbyDeviceFilter.mVersionCode);
        zzb.zza(parcel, 2, nearbyDeviceFilter.zzbcj, false);
        zzb.zza(parcel, 3, nearbyDeviceFilter.zzbck);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzge(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjj(i);
    }

    public NearbyDeviceFilter zzge(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NearbyDeviceFilter(i2, i, bArr, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyDeviceFilter[] zzjj(int i) {
        return new NearbyDeviceFilter[i];
    }
}
