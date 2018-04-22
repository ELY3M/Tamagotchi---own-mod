package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LoyaltyPoints> {
    static void zza(LoyaltyPoints loyaltyPoints, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loyaltyPoints.getVersionCode());
        zzb.zza(parcel, 2, loyaltyPoints.label, false);
        zzb.zza(parcel, 3, loyaltyPoints.zzbqI, i, false);
        zzb.zza(parcel, 4, loyaltyPoints.type, false);
        zzb.zza(parcel, 5, loyaltyPoints.zzboY, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlt(i);
    }

    public LoyaltyPoints zzhS(Parcel parcel) {
        TimeInterval timeInterval = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        LoyaltyPointsBalance loyaltyPointsBalance = null;
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
                    loyaltyPointsBalance = (LoyaltyPointsBalance) zza.zza(parcel, zzat, LoyaltyPointsBalance.CREATOR);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzat, TimeInterval.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoyaltyPoints(i, str2, loyaltyPointsBalance, str, timeInterval);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LoyaltyPoints[] zzlt(int i) {
        return new LoyaltyPoints[i];
    }
}
