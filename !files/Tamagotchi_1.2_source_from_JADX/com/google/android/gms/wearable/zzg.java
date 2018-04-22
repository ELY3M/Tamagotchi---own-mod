package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<ConnectionConfiguration> {
    static void zza(ConnectionConfiguration connectionConfiguration, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, connectionConfiguration.mVersionCode);
        zzb.zza(parcel, 2, connectionConfiguration.getName(), false);
        zzb.zza(parcel, 3, connectionConfiguration.getAddress(), false);
        zzb.zzc(parcel, 4, connectionConfiguration.getType());
        zzb.zzc(parcel, 5, connectionConfiguration.getRole());
        zzb.zza(parcel, 6, connectionConfiguration.isEnabled());
        zzb.zza(parcel, 7, connectionConfiguration.isConnected());
        zzb.zza(parcel, 8, connectionConfiguration.zzIt(), false);
        zzb.zza(parcel, 9, connectionConfiguration.zzIu());
        zzb.zza(parcel, 10, connectionConfiguration.getNodeId(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlz(i);
    }

    public ConnectionConfiguration zzhY(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ConnectionConfiguration(i3, str4, str3, i2, i, z3, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ConnectionConfiguration[] zzlz(int i) {
        return new ConnectionConfiguration[i];
    }
}
