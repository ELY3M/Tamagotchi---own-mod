package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzn implements Creator<CreateFileRequest> {
    static void zza(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createFileRequest.mVersionCode);
        zzb.zza(parcel, 2, createFileRequest.zzaqy, i, false);
        zzb.zza(parcel, 3, createFileRequest.zzaqw, i, false);
        zzb.zza(parcel, 4, createFileRequest.zzaql, i, false);
        zzb.zza(parcel, 5, createFileRequest.zzaqx, false);
        zzb.zza(parcel, 6, createFileRequest.zzaqd);
        zzb.zza(parcel, 7, createFileRequest.zzaoV, false);
        zzb.zzc(parcel, 8, createFileRequest.zzaqz);
        zzb.zzc(parcel, 9, createFileRequest.zzaqA);
        zzb.zza(parcel, 10, createFileRequest.zzaoY, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdb(i);
    }

    public CreateFileRequest zzbk(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        Integer num = null;
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
                    num = zza.zzh(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 10:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str2, i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CreateFileRequest[] zzdb(int i) {
        return new CreateFileRequest[i];
    }
}
