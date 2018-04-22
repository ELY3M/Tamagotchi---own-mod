package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbn implements Creator<ParcelableTransferPreferences> {
    static void zza(ParcelableTransferPreferences parcelableTransferPreferences, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableTransferPreferences.mVersionCode);
        zzb.zzc(parcel, 2, parcelableTransferPreferences.zzarG);
        zzb.zzc(parcel, 3, parcelableTransferPreferences.zzarH);
        zzb.zza(parcel, 4, parcelableTransferPreferences.zzasA);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdK(i);
    }

    public ParcelableTransferPreferences zzbP(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableTransferPreferences(i3, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParcelableTransferPreferences[] zzdK(int i) {
        return new ParcelableTransferPreferences[i];
    }
}
