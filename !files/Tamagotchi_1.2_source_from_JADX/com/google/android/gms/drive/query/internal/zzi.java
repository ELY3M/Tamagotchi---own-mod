package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzi implements Creator<HasFilter> {
    static void zza(HasFilter hasFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, hasFilter.mVersionCode);
        zzb.zza(parcel, 1, hasFilter.zzauh, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzel(i);
    }

    public HasFilter zzcq(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
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
            return new HasFilter(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public HasFilter[] zzel(int i) {
        return new HasFilter[i];
    }
}
