package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;

public class zza implements Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, addEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, addEventListenerRequest.zzaoz, i, false);
        zzb.zzc(parcel, 3, addEventListenerRequest.zzanf);
        zzb.zza(parcel, 4, addEventListenerRequest.zzapy, i, false);
        zzb.zza(parcel, 5, addEventListenerRequest.zzapY, i, false);
        zzb.zza(parcel, 6, addEventListenerRequest.zzapZ, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcP(i);
    }

    public AddEventListenerRequest zzaZ(Parcel parcel) {
        int i = 0;
        TransferProgressOptions transferProgressOptions = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        TransferStateOptions transferStateOptions = null;
        ChangesAvailableOptions changesAvailableOptions = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 4:
                    changesAvailableOptions = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ChangesAvailableOptions.CREATOR);
                    break;
                case 5:
                    transferStateOptions = (TransferStateOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, TransferStateOptions.CREATOR);
                    break;
                case 6:
                    transferProgressOptions = (TransferProgressOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, TransferProgressOptions.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AddEventListenerRequest(i2, driveId, i, changesAvailableOptions, transferStateOptions, transferProgressOptions);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AddEventListenerRequest[] zzcP(int i) {
        return new AddEventListenerRequest[i];
    }
}
