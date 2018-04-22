package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzj implements Creator<ControlProgressRequest> {
    static void zza(ControlProgressRequest controlProgressRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, controlProgressRequest.mVersionCode);
        zzb.zzc(parcel, 2, controlProgressRequest.zzaqq);
        zzb.zzc(parcel, 3, controlProgressRequest.zzaqr);
        zzb.zza(parcel, 4, controlProgressRequest.zzaoz, i, false);
        zzb.zza(parcel, 5, controlProgressRequest.zzaqs, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcX(i);
    }

    public ControlProgressRequest zzbh(Parcel parcel) {
        ParcelableTransferPreferences parcelableTransferPreferences = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
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
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 5:
                    parcelableTransferPreferences = (ParcelableTransferPreferences) zza.zza(parcel, zzat, ParcelableTransferPreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ControlProgressRequest(i3, i2, i, driveId, parcelableTransferPreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ControlProgressRequest[] zzcX(int i) {
        return new ControlProgressRequest[i];
    }
}
