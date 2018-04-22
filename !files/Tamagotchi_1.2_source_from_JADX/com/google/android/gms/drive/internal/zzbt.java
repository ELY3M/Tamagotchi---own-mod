package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzbt implements Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, setResourceParentsRequest.zzaqf, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzasC, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdQ(i);
    }

    public SetResourceParentsRequest zzbV(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            ArrayList zzc;
            int zzat = zza.zzat(parcel);
            List list2;
            switch (zza.zzca(zzat)) {
                case 1:
                    List list3 = list;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    list2 = list3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzat, DriveId.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzc = list;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzau) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SetResourceParentsRequest[] zzdQ(int i) {
        return new SetResourceParentsRequest[i];
    }
}
