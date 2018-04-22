package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<WalletFragmentStyle> {
    static void zza(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, walletFragmentStyle.mVersionCode);
        zzb.zza(parcel, 2, walletFragmentStyle.zzbqu, false);
        zzb.zzc(parcel, 3, walletFragmentStyle.zzbqv);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlm(i);
    }

    public WalletFragmentStyle zzhN(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public WalletFragmentStyle[] zzlm(int i) {
        return new WalletFragmentStyle[i];
    }
}
