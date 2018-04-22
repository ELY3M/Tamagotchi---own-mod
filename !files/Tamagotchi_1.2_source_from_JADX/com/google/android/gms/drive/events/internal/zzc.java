package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Creator<TransferProgressData> {
    static void zza(TransferProgressData transferProgressData, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferProgressData.mVersionCode);
        zzb.zzc(parcel, 2, transferProgressData.zzapT);
        zzb.zza(parcel, 3, transferProgressData.zzaoz, i, false);
        zzb.zzc(parcel, 4, transferProgressData.zzBc);
        zzb.zza(parcel, 5, transferProgressData.zzapW);
        zzb.zza(parcel, 6, transferProgressData.zzapX);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcO(i);
    }

    public TransferProgressData zzaY(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        long j2 = 0;
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
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferProgressData(i3, i2, driveId, i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TransferProgressData[] zzcO(int i) {
        return new TransferProgressData[i];
    }
}
