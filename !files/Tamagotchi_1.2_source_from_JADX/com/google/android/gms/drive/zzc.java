package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<DriveFileRange> {
    static void zza(DriveFileRange driveFileRange, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveFileRange.mVersionCode);
        zzb.zza(parcel, 2, driveFileRange.zzaoJ);
        zzb.zza(parcel, 3, driveFileRange.zzaoK);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcs(i);
    }

    public DriveFileRange zzaJ(Parcel parcel) {
        long j = 0;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveFileRange(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DriveFileRange[] zzcs(int i) {
        return new DriveFileRange[i];
    }
}
