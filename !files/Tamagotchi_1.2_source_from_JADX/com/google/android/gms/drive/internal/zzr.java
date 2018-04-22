package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, disconnectRequest.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzde(i);
    }

    public DisconnectRequest zzbn(Parcel parcel) {
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
            return new DisconnectRequest(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DisconnectRequest[] zzde(int i) {
        return new DisconnectRequest[i];
    }
}
