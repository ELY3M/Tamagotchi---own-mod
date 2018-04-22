package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class zzm implements Creator<MaskedWalletRequest> {
    static void zza(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, maskedWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, maskedWalletRequest.zzbop, false);
        zzb.zza(parcel, 3, maskedWalletRequest.zzbpl);
        zzb.zza(parcel, 4, maskedWalletRequest.zzbpm);
        zzb.zza(parcel, 5, maskedWalletRequest.zzbpn);
        zzb.zza(parcel, 6, maskedWalletRequest.zzbpo, false);
        zzb.zza(parcel, 7, maskedWalletRequest.zzboi, false);
        zzb.zza(parcel, 8, maskedWalletRequest.zzbpp, false);
        zzb.zza(parcel, 9, maskedWalletRequest.zzboz, i, false);
        zzb.zza(parcel, 10, maskedWalletRequest.zzbpq);
        zzb.zza(parcel, 11, maskedWalletRequest.zzbpr);
        zzb.zza(parcel, 12, maskedWalletRequest.zzbps, i, false);
        zzb.zza(parcel, 13, maskedWalletRequest.zzbpt);
        zzb.zza(parcel, 14, maskedWalletRequest.zzbpu);
        zzb.zzc(parcel, 15, maskedWalletRequest.zzbpv, false);
        zzb.zza(parcel, 17, maskedWalletRequest.zzbpx, false);
        zzb.zza(parcel, 16, maskedWalletRequest.zzbpw, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkY(i);
    }

    public MaskedWalletRequest zzhA(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = null;
        ArrayList arrayList2 = null;
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
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    cart = (Cart) zza.zza(parcel, zzat, Cart.CREATOR);
                    break;
                case 10:
                    z4 = zza.zzc(parcel, zzat);
                    break;
                case 11:
                    z5 = zza.zzc(parcel, zzat);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) zza.zzb(parcel, zzat, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = zza.zzc(parcel, zzat);
                    break;
                case 14:
                    z7 = zza.zzc(parcel, zzat);
                    break;
                case 15:
                    arrayList = zza.zzc(parcel, zzat, CountrySpecification.CREATOR);
                    break;
                case 16:
                    paymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters) zza.zza(parcel, zzat, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                case 17:
                    arrayList2 = zza.zzC(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList, paymentMethodTokenizationParameters, arrayList2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MaskedWalletRequest[] zzkY(int i) {
        return new MaskedWalletRequest[i];
    }
}
