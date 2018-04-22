package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.mVersionCode);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzaoZ, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzarM);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdn(i);
    }

    public GetDriveIdFromUniqueIdentifierRequest zzbs(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] zzdn(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
