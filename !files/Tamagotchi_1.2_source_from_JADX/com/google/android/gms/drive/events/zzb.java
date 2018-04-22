package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ChangesAvailableEvent> {
    static void zza(ChangesAvailableEvent changesAvailableEvent, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, changesAvailableEvent.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, changesAvailableEvent.zzVa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, changesAvailableEvent.zzapy, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcF(i);
    }

    public ChangesAvailableEvent zzaQ(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
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
                    changesAvailableOptions = (ChangesAvailableOptions) zza.zza(parcel, zzat, ChangesAvailableOptions.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangesAvailableEvent(i, str, changesAvailableOptions);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChangesAvailableEvent[] zzcF(int i) {
        return new ChangesAvailableEvent[i];
    }
}
