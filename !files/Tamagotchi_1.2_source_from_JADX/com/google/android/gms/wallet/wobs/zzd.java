package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<LoyaltyPointsBalance> {
    static void zza(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loyaltyPointsBalance.getVersionCode());
        zzb.zzc(parcel, 2, loyaltyPointsBalance.zzbqJ);
        zzb.zza(parcel, 3, loyaltyPointsBalance.zzbqK, false);
        zzb.zza(parcel, 4, loyaltyPointsBalance.zzbqL);
        zzb.zza(parcel, 5, loyaltyPointsBalance.zzboF, false);
        zzb.zza(parcel, 6, loyaltyPointsBalance.zzbqM);
        zzb.zzc(parcel, 7, loyaltyPointsBalance.zzbqN);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzls(i);
    }

    public LoyaltyPointsBalance zzhR(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    d = zza.zzn(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoyaltyPointsBalance(i3, i, str2, d, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LoyaltyPointsBalance[] zzls(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
