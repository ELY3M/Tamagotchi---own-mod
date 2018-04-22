package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<CreateWalletObjectsRequest> {
    static void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createWalletObjectsRequest.getVersionCode());
        zzb.zza(parcel, 2, createWalletObjectsRequest.zzbol, i, false);
        zzb.zza(parcel, 3, createWalletObjectsRequest.zzbom, i, false);
        zzb.zza(parcel, 4, createWalletObjectsRequest.zzbon, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkP(i);
    }

    public CreateWalletObjectsRequest zzhr(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        OfferWalletObject offerWalletObject = null;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < zzau) {
            OfferWalletObject offerWalletObject2;
            LoyaltyWalletObject loyaltyWalletObject2;
            int zzg;
            GiftCardWalletObject giftCardWalletObject2;
            int zzat = zza.zzat(parcel);
            GiftCardWalletObject giftCardWalletObject3;
            switch (zza.zzca(zzat)) {
                case 1:
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = zza.zzg(parcel, zzat);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case 2:
                    zzg = i;
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = (LoyaltyWalletObject) zza.zza(parcel, zzat, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 3:
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = (OfferWalletObject) zza.zza(parcel, zzat, OfferWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case 4:
                    giftCardWalletObject2 = (GiftCardWalletObject) zza.zza(parcel, zzat, GiftCardWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
            }
            i = zzg;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
            giftCardWalletObject = giftCardWalletObject2;
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateWalletObjectsRequest(i, loyaltyWalletObject, offerWalletObject, giftCardWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CreateWalletObjectsRequest[] zzkP(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
