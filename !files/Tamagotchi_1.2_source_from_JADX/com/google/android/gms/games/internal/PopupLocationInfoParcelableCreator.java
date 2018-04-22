package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PopupLocationInfoParcelableCreator implements Creator<PopupLocationInfoParcelable> {
    static void zza(PopupLocationInfoParcelable popupLocationInfoParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, popupLocationInfoParcelable.zzxg(), false);
        zzb.zzc(parcel, 1000, popupLocationInfoParcelable.getVersionCode());
        zzb.zza(parcel, 2, popupLocationInfoParcelable.getWindowToken(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzem(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgu(i);
    }

    public PopupLocationInfoParcelable zzem(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PopupLocationInfoParcelable(i, bundle, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PopupLocationInfoParcelable[] zzgu(int i) {
        return new PopupLocationInfoParcelable[i];
    }
}
