package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<ChangeResourceParentsRequest> {
    static void zza(ChangeResourceParentsRequest changeResourceParentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, changeResourceParentsRequest.zzaqf, i, false);
        zzb.zzc(parcel, 3, changeResourceParentsRequest.zzaqg, false);
        zzb.zzc(parcel, 4, changeResourceParentsRequest.zzaqh, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcT(i);
    }

    public ChangeResourceParentsRequest zzbd(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list2 = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            Object zzc;
            ArrayList zzc2;
            int zzat = zza.zzat(parcel);
            List list3;
            List list4;
            switch (zza.zzca(zzat)) {
                case 1:
                    list3 = list;
                    list = list2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    list4 = list3;
                    break;
                case 2:
                    zzg = i;
                    list3 = list2;
                    driveId2 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    list4 = list;
                    list = list3;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i;
                    list3 = list;
                    zzc = zza.zzc(parcel, zzat, DriveId.CREATOR);
                    list4 = list3;
                    break;
                case 4:
                    zzc2 = zza.zzc(parcel, zzat, DriveId.CREATOR);
                    list = list2;
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzc2 = list;
                    list = list2;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            list2 = list;
            zzc = zzc2;
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangeResourceParentsRequest(i, driveId, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChangeResourceParentsRequest[] zzcT(int i) {
        return new ChangeResourceParentsRequest[i];
    }
}
