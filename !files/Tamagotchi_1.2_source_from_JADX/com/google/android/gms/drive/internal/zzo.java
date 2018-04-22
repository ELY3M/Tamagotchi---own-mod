package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzo implements Creator<CreateFolderRequest> {
    static void zza(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createFolderRequest.mVersionCode);
        zzb.zza(parcel, 2, createFolderRequest.zzaqy, i, false);
        zzb.zza(parcel, 3, createFolderRequest.zzaqw, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdc(i);
    }

    public CreateFolderRequest zzbl(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            MetadataBundle metadataBundle2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CreateFolderRequest[] zzdc(int i) {
        return new CreateFolderRequest[i];
    }
}
