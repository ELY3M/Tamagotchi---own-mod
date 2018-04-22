package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;

public class zzbp implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, removeEventListenerRequest.zzaoz, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzanf);
        zzb.zza(parcel, 4, removeEventListenerRequest.zzapZ, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdM(i);
    }

    public RemoveEventListenerRequest zzbR(Parcel parcel) {
        TransferProgressOptions transferProgressOptions = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int i3;
            DriveId driveId2;
            int zzg;
            TransferProgressOptions transferProgressOptions2;
            int zzat = zza.zzat(parcel);
            TransferProgressOptions transferProgressOptions3;
            switch (zza.zzca(zzat)) {
                case 1:
                    transferProgressOptions3 = transferProgressOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    transferProgressOptions2 = transferProgressOptions3;
                    break;
                case 2:
                    zzg = i2;
                    int i4 = i;
                    driveId2 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    transferProgressOptions2 = transferProgressOptions;
                    i3 = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i2;
                    transferProgressOptions3 = transferProgressOptions;
                    i3 = zza.zzg(parcel, zzat);
                    transferProgressOptions2 = transferProgressOptions3;
                    break;
                case 4:
                    transferProgressOptions2 = (TransferProgressOptions) zza.zza(parcel, zzat, TransferProgressOptions.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    transferProgressOptions2 = transferProgressOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = i3;
            transferProgressOptions = transferProgressOptions2;
        }
        if (parcel.dataPosition() == zzau) {
            return new RemoveEventListenerRequest(i2, driveId, i, transferProgressOptions);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RemoveEventListenerRequest[] zzdM(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
