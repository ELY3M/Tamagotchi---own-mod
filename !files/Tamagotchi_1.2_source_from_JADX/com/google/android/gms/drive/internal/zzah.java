package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzah implements Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.mVersionCode);
        zzb.zza(parcel, 2, getChangesRequest.zzarJ, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzarK);
        zzb.zzc(parcel, 4, getChangesRequest.zzapB, false);
        zzb.zza(parcel, 5, getChangesRequest.zzarL);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdm(i);
    }

    public GetChangesRequest zzbr(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ChangeSequenceNumber changeSequenceNumber = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzat, ChangeSequenceNumber.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetChangesRequest(i2, changeSequenceNumber, i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetChangesRequest[] zzdm(int i) {
        return new GetChangesRequest[i];
    }
}
