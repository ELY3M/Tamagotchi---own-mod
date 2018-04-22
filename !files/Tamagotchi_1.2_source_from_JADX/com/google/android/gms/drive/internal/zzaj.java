package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaj implements Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, getMetadataRequest.zzaqj, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzarN);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbt(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdo(i);
    }

    public GetMetadataRequest zzbt(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            boolean z2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    boolean z3 = z;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == zzau) {
            return new GetMetadataRequest(i, driveId, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetMetadataRequest[] zzdo(int i) {
        return new GetMetadataRequest[i];
    }
}
