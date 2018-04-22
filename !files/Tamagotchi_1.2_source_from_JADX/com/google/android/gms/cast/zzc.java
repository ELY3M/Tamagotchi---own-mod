package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<JoinOptions> {
    static void zza(JoinOptions joinOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, joinOptions.getVersionCode());
        zzb.zzc(parcel, 2, joinOptions.getConnectionType());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzab(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaY(i);
    }

    public JoinOptions[] zzaY(int i) {
        return new JoinOptions[i];
    }

    public JoinOptions zzab(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new JoinOptions(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
