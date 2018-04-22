package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.mVersionCode);
        zzb.zza(parcel, 2, onListEntriesResponse.zzass, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzaqJ);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdA(i);
    }

    public OnListEntriesResponse zzbF(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            DataHolder dataHolder2;
            int zzg;
            boolean z2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzat);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzau) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnListEntriesResponse[] zzdA(int i) {
        return new OnListEntriesResponse[i];
    }
}
