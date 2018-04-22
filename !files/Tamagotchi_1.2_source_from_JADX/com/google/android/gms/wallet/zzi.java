package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<IsReadyToPayRequest> {
    static void zza(IsReadyToPayRequest isReadyToPayRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, isReadyToPayRequest.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkU(i);
    }

    public IsReadyToPayRequest zzhw(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new IsReadyToPayRequest(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public IsReadyToPayRequest[] zzkU(int i) {
        return new IsReadyToPayRequest[i];
    }
}
