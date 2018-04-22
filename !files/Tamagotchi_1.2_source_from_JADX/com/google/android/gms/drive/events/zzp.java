package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.internal.TransferProgressData;
import java.util.List;

public class zzp implements Creator<TransferStateEvent> {
    static void zza(TransferStateEvent transferStateEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferStateEvent.mVersionCode);
        zzb.zza(parcel, 2, transferStateEvent.zzVa, false);
        zzb.zzc(parcel, 3, transferStateEvent.zzapU, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcM(i);
    }

    public TransferStateEvent zzaW(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, TransferProgressData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferStateEvent(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TransferStateEvent[] zzcM(int i) {
        return new TransferStateEvent[i];
    }
}
