package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zza implements Creator<CommonWalletObject> {
    static void zza(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, commonWalletObject.getVersionCode());
        zzb.zza(parcel, 2, commonWalletObject.zzio, false);
        zzb.zza(parcel, 3, commonWalletObject.zzboW, false);
        zzb.zza(parcel, 4, commonWalletObject.name, false);
        zzb.zza(parcel, 5, commonWalletObject.zzboQ, false);
        zzb.zza(parcel, 6, commonWalletObject.zzboS, false);
        zzb.zza(parcel, 7, commonWalletObject.zzboT, false);
        zzb.zza(parcel, 8, commonWalletObject.zzboU, false);
        zzb.zza(parcel, 9, commonWalletObject.zzboV, false);
        zzb.zzc(parcel, 10, commonWalletObject.state);
        zzb.zzc(parcel, 11, commonWalletObject.zzboX, false);
        zzb.zza(parcel, 12, commonWalletObject.zzboY, i, false);
        zzb.zzc(parcel, 13, commonWalletObject.zzboZ, false);
        zzb.zza(parcel, 14, commonWalletObject.zzbpa, false);
        zzb.zza(parcel, 15, commonWalletObject.zzbpb, false);
        zzb.zza(parcel, 17, commonWalletObject.zzbpd);
        zzb.zzc(parcel, 16, commonWalletObject.zzbpc, false);
        zzb.zzc(parcel, 19, commonWalletObject.zzbpf, false);
        zzb.zzc(parcel, 18, commonWalletObject.zzbpe, false);
        zzb.zzc(parcel, 20, commonWalletObject.zzbpg, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlp(i);
    }

    public CommonWalletObject zzhO(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList zzsa = zzmn.zzsa();
        TimeInterval timeInterval = null;
        ArrayList zzsa2 = zzmn.zzsa();
        String str9 = null;
        String str10 = null;
        ArrayList zzsa3 = zzmn.zzsa();
        boolean z = false;
        ArrayList zzsa4 = zzmn.zzsa();
        ArrayList zzsa5 = zzmn.zzsa();
        ArrayList zzsa6 = zzmn.zzsa();
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 11:
                    zzsa = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, TimeInterval.CREATOR);
                    break;
                case 13:
                    zzsa2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 16:
                    zzsa3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, LabelValueRow.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 18:
                    zzsa4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                case 19:
                    zzsa5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, TextModuleData.CREATOR);
                    break;
                case 20:
                    zzsa6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, zzsa, timeInterval, zzsa2, str9, str10, zzsa3, z, zzsa4, zzsa5, zzsa6);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CommonWalletObject[] zzlp(int i) {
        return new CommonWalletObject[i];
    }
}
