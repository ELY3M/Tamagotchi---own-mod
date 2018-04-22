package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzcb implements Creator<UpdatePermissionRequest> {
    static void zza(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, updatePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, updatePermissionRequest.zzaoz, i, false);
        zzb.zza(parcel, 3, updatePermissionRequest.zzapk, false);
        zzb.zzc(parcel, 4, updatePermissionRequest.zzasE);
        zzb.zza(parcel, 5, updatePermissionRequest.zzaqd);
        zzb.zza(parcel, 6, updatePermissionRequest.zzaoV, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdX(i);
    }

    public UpdatePermissionRequest zzcc(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UpdatePermissionRequest(i2, driveId, str2, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UpdatePermissionRequest[] zzdX(int i) {
        return new UpdatePermissionRequest[i];
    }
}
