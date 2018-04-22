package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzbh implements Creator<OnResourceIdSetResponse> {
    static void zza(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onResourceIdSetResponse.getVersionCode());
        zzb.zzb(parcel, 2, onResourceIdSetResponse.zztc(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdF(i);
    }

    public OnResourceIdSetResponse zzbK(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzD(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnResourceIdSetResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnResourceIdSetResponse[] zzdF(int i) {
        return new OnResourceIdSetResponse[i];
    }
}
