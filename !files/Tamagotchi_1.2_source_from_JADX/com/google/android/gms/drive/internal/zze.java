package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze implements Creator<CancelPendingActionsRequest> {
    static void zza(CancelPendingActionsRequest cancelPendingActionsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, cancelPendingActionsRequest.mVersionCode);
        zzb.zzb(parcel, 2, cancelPendingActionsRequest.zzapG, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcS(i);
    }

    public CancelPendingActionsRequest zzbc(Parcel parcel) {
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
            return new CancelPendingActionsRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CancelPendingActionsRequest[] zzcS(int i) {
        return new CancelPendingActionsRequest[i];
    }
}
