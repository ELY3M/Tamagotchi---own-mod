package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<CheckResourceIdsExistRequest> {
    static void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        zzb.zzb(parcel, 2, checkResourceIdsExistRequest.zztc(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbe(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcU(i);
    }

    public CheckResourceIdsExistRequest zzbe(Parcel parcel) {
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
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CheckResourceIdsExistRequest[] zzcU(int i) {
        return new CheckResourceIdsExistRequest[i];
    }
}
