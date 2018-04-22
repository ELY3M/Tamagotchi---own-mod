package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public class zzk implements Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        zzb.zza(parcel, 2, loyaltyWalletObject.zzio, false);
        zzb.zza(parcel, 3, loyaltyWalletObject.zzboP, false);
        zzb.zza(parcel, 4, loyaltyWalletObject.zzboQ, false);
        zzb.zza(parcel, 5, loyaltyWalletObject.zzboR, false);
        zzb.zza(parcel, 6, loyaltyWalletObject.zzaQZ, false);
        zzb.zza(parcel, 7, loyaltyWalletObject.zzboS, false);
        zzb.zza(parcel, 8, loyaltyWalletObject.zzboT, false);
        zzb.zza(parcel, 9, loyaltyWalletObject.zzboU, false);
        zzb.zza(parcel, 10, loyaltyWalletObject.zzboV, false);
        zzb.zza(parcel, 11, loyaltyWalletObject.zzboW, false);
        zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        zzb.zzc(parcel, 13, loyaltyWalletObject.zzboX, false);
        zzb.zza(parcel, 14, loyaltyWalletObject.zzboY, i, false);
        zzb.zzc(parcel, 15, loyaltyWalletObject.zzboZ, false);
        zzb.zza(parcel, 17, loyaltyWalletObject.zzbpb, false);
        zzb.zza(parcel, 16, loyaltyWalletObject.zzbpa, false);
        zzb.zza(parcel, 19, loyaltyWalletObject.zzbpd);
        zzb.zzc(parcel, 18, loyaltyWalletObject.zzbpc, false);
        zzb.zzc(parcel, 21, loyaltyWalletObject.zzbpf, false);
        zzb.zzc(parcel, 20, loyaltyWalletObject.zzbpe, false);
        zzb.zza(parcel, 23, loyaltyWalletObject.zzbph, i, false);
        zzb.zzc(parcel, 22, loyaltyWalletObject.zzbpg, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkW(i);
    }

    public LoyaltyWalletObject zzhy(Parcel parcel) {
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
        int i2 = 0;
        ArrayList zzsa = zzmn.zzsa();
        TimeInterval timeInterval = null;
        ArrayList zzsa2 = zzmn.zzsa();
        String str11 = null;
        String str12 = null;
        ArrayList zzsa3 = zzmn.zzsa();
        boolean z = false;
        ArrayList zzsa4 = zzmn.zzsa();
        ArrayList zzsa5 = zzmn.zzsa();
        ArrayList zzsa6 = zzmn.zzsa();
        LoyaltyPoints loyaltyPoints = null;
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
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 13:
                    zzsa = zza.zzc(parcel, zzat, WalletObjectMessage.CREATOR);
                    break;
                case 14:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzat, TimeInterval.CREATOR);
                    break;
                case 15:
                    zzsa2 = zza.zzc(parcel, zzat, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = zza.zzp(parcel, zzat);
                    break;
                case 17:
                    str12 = zza.zzp(parcel, zzat);
                    break;
                case 18:
                    zzsa3 = zza.zzc(parcel, zzat, LabelValueRow.CREATOR);
                    break;
                case 19:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 20:
                    zzsa4 = zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                case 21:
                    zzsa5 = zza.zzc(parcel, zzat, TextModuleData.CREATOR);
                    break;
                case 22:
                    zzsa6 = zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                case 23:
                    loyaltyPoints = (LoyaltyPoints) zza.zza(parcel, zzat, LoyaltyPoints.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzsa, timeInterval, zzsa2, str11, str12, zzsa3, z, zzsa4, zzsa5, zzsa6, loyaltyPoints);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LoyaltyWalletObject[] zzkW(int i) {
        return new LoyaltyWalletObject[i];
    }
}
