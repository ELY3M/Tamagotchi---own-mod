package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzb implements Creator<CastDevice> {
    static void zza(CastDevice castDevice, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, castDevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, castDevice.zzny(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, castDevice.zzZU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, castDevice.getFriendlyName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, castDevice.getModelName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, castDevice.getDeviceVersion(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, castDevice.getServicePort());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, castDevice.getIcons(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, castDevice.getCapabilities());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, castDevice.getStatus());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, castDevice.zznz(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaa(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaX(i);
    }

    public CastDevice[] zzaX(int i) {
        return new CastDevice[i];
    }

    public CastDevice zzaa(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i2 = -1;
        List list = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    list = zza.zzc(parcel, zzat, WebImage.CREATOR);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 10:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 11:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CastDevice(i4, str6, str5, str4, str3, str2, i3, list, i, i2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
