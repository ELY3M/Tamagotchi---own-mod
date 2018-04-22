package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzh implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, closeContentsAndUpdateMetadataRequest.zzaqj, i, false);
        zzb.zza(parcel, 3, closeContentsAndUpdateMetadataRequest.zzaqk, i, false);
        zzb.zza(parcel, 4, closeContentsAndUpdateMetadataRequest.zzaql, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzaoW);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzaoV, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzaqm);
        zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzaqn);
        zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzaqo);
        zzb.zza(parcel, 10, closeContentsAndUpdateMetadataRequest.zzapa);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcV(i);
    }

    public CloseContentsAndUpdateMetadataRequest zzbf(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = true;
        int i = 0;
        int i2 = 0;
        boolean z3 = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CloseContentsAndUpdateMetadataRequest(i3, driveId, metadataBundle, contents, z3, str, i2, i, z, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] zzcV(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
