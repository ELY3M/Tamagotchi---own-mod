package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class zza implements Creator<WalletFragmentInitParams> {
    static void zza(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, walletFragmentInitParams.mVersionCode);
        zzb.zza(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        zzb.zza(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        zzb.zzc(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        zzb.zza(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlj(i);
    }

    public WalletFragmentInitParams zzhL(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
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
                    maskedWalletRequest = (MaskedWalletRequest) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, MaskedWallet.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public WalletFragmentInitParams[] zzlj(int i) {
        return new WalletFragmentInitParams[i];
    }
}
