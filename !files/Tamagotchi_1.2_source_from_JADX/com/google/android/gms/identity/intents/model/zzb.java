package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<UserAddress> {
    static void zza(UserAddress userAddress, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, userAddress.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, userAddress.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, userAddress.zzaMD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, userAddress.zzaME, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, userAddress.zzaMF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, userAddress.zzaMG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, userAddress.zzaMH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, userAddress.zzaMI, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, userAddress.zzaMJ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, userAddress.zzJU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, userAddress.zzaMK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, userAddress.zzaML, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, userAddress.phoneNumber, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, userAddress.zzaMM);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, userAddress.zzaMN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, userAddress.zzaMO, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhk(i);
    }

    public UserAddress zzeN(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str8 = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    str9 = zza.zzp(parcel, zzat);
                    break;
                case 11:
                    str10 = zza.zzp(parcel, zzat);
                    break;
                case 12:
                    str11 = zza.zzp(parcel, zzat);
                    break;
                case 13:
                    str12 = zza.zzp(parcel, zzat);
                    break;
                case 14:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 15:
                    str13 = zza.zzp(parcel, zzat);
                    break;
                case 16:
                    str14 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UserAddress[] zzhk(int i) {
        return new UserAddress[i];
    }
}
