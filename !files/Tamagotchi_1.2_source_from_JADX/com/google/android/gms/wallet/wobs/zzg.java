package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<TimeInterval> {
    static void zza(TimeInterval timeInterval, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, timeInterval.getVersionCode());
        zzb.zza(parcel, 2, timeInterval.zzbqP);
        zzb.zza(parcel, 3, timeInterval.zzbqQ);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlv(i);
    }

    public TimeInterval zzhU(Parcel parcel) {
        long j = 0;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TimeInterval(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TimeInterval[] zzlv(int i) {
        return new TimeInterval[i];
    }
}
