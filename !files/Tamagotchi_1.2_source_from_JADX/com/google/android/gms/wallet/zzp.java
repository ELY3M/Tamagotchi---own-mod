package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<PaymentMethodToken> {
    static void zza(PaymentMethodToken paymentMethodToken, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, paymentMethodToken.getVersionCode());
        zzb.zzc(parcel, 2, paymentMethodToken.zzbpC);
        zzb.zza(parcel, 3, paymentMethodToken.zzbaW, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlb(i);
    }

    public PaymentMethodToken zzhD(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PaymentMethodToken(i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PaymentMethodToken[] zzlb(int i) {
        return new PaymentMethodToken[i];
    }
}
