package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbk implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, openContentsRequest.zzaqj, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzaoy);
        zzb.zzc(parcel, 4, openContentsRequest.zzasx);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdI(i);
    }

    public OpenContentsRequest zzbN(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            int zzat = zza.zzat(parcel);
            int i4;
            switch (zza.zzca(zzat)) {
                case 1:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    zzat = i4;
                    break;
                case 2:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    zzat = i;
                    i = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzat);
                    zzat = i4;
                    break;
                case 4:
                    zzat = zza.zzg(parcel, zzat);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzat = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OpenContentsRequest[] zzdI(int i) {
        return new OpenContentsRequest[i];
    }
}
