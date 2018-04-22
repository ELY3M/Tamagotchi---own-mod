package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.internal.TransferProgressData;

public class zzn implements Creator<TransferProgressEvent> {
    static void zza(TransferProgressEvent transferProgressEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferProgressEvent.mVersionCode);
        zzb.zza(parcel, 2, transferProgressEvent.zzapS, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcK(i);
    }

    public TransferProgressEvent zzaU(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        TransferProgressData transferProgressData = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    transferProgressData = (TransferProgressData) zza.zza(parcel, zzat, TransferProgressData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferProgressEvent(i, transferProgressData);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TransferProgressEvent[] zzcK(int i) {
        return new TransferProgressEvent[i];
    }
}
