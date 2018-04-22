package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.mVersionCode);
        zzb.zza(parcel, 2, onListParentsResponse.zzast, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdB(i);
    }

    public OnListParentsResponse zzbG(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnListParentsResponse[] zzdB(int i) {
        return new OnListParentsResponse[i];
    }
}
