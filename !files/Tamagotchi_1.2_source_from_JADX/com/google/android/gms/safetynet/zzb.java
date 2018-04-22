package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<SafeBrowsingData> {
    static void zza(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, safeBrowsingData.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, safeBrowsingData.getMetadata(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjW(i);
    }

    public SafeBrowsingData zzgP(Parcel parcel) {
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SafeBrowsingData(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SafeBrowsingData[] zzjW(int i) {
        return new SafeBrowsingData[i];
    }
}
