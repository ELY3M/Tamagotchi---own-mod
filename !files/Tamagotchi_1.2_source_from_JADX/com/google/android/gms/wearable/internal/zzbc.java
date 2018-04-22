package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<NodeParcelable> {
    static void zza(NodeParcelable nodeParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nodeParcelable.mVersionCode);
        zzb.zza(parcel, 2, nodeParcelable.getId(), false);
        zzb.zza(parcel, 3, nodeParcelable.getDisplayName(), false);
        zzb.zzc(parcel, 4, nodeParcelable.getHopCount());
        zzb.zza(parcel, 5, nodeParcelable.isNearby());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmf(i);
    }

    public NodeParcelable zziB(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NodeParcelable(i2, str2, str, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NodeParcelable[] zzmf(int i) {
        return new NodeParcelable[i];
    }
}
