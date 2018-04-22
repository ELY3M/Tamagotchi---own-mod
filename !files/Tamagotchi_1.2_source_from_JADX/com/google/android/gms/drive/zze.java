package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveId.mVersionCode);
        zzb.zza(parcel, 2, driveId.zzaoL, false);
        zzb.zza(parcel, 3, driveId.zzaoM);
        zzb.zza(parcel, 4, driveId.zzaou);
        zzb.zzc(parcel, 5, driveId.zzaoN);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzct(i);
    }

    public DriveId zzaK(Parcel parcel) {
        long j = 0;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
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
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DriveId[] zzct(int i) {
        return new DriveId[i];
    }
}
