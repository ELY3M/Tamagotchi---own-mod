package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzo implements Creator<OfferWalletObject> {
    static void zza(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, offerWalletObject.getVersionCode());
        zzb.zza(parcel, 2, offerWalletObject.zzio, false);
        zzb.zza(parcel, 3, offerWalletObject.zzbpB, false);
        zzb.zza(parcel, 4, offerWalletObject.zzboB, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzla(i);
    }

    public OfferWalletObject zzhC(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzat, CommonWalletObject.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OfferWalletObject[] zzla(int i) {
        return new OfferWalletObject[i];
    }
}
