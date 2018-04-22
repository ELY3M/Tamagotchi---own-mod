package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzav implements Creator<OnChangesResponse> {
    static void zza(OnChangesResponse onChangesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onChangesResponse.mVersionCode);
        zzb.zza(parcel, 2, onChangesResponse.zzasb, i, false);
        zzb.zzc(parcel, 3, onChangesResponse.zzasc, false);
        zzb.zza(parcel, 4, onChangesResponse.zzasd, i, false);
        zzb.zza(parcel, 5, onChangesResponse.zzase);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzby(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdt(i);
    }

    public OnChangesResponse zzby(Parcel parcel) {
        boolean z = false;
        ChangeSequenceNumber changeSequenceNumber = null;
        int zzau = zza.zzau(parcel);
        List list = null;
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, DriveId.CREATOR);
                    break;
                case 4:
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzat, ChangeSequenceNumber.CREATOR);
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
            return new OnChangesResponse(i, dataHolder, list, changeSequenceNumber, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnChangesResponse[] zzdt(int i) {
        return new OnChangesResponse[i];
    }
}
