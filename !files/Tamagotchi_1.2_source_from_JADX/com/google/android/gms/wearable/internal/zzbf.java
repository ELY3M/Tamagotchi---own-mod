package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbf implements Creator<PutDataResponse> {
    static void zza(PutDataResponse putDataResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, putDataResponse.versionCode);
        zzb.zzc(parcel, 2, putDataResponse.statusCode);
        zzb.zza(parcel, 3, putDataResponse.zzbsJ, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmi(i);
    }

    public PutDataResponse zziE(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        DataItemParcelable dataItemParcelable = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    dataItemParcelable = (DataItemParcelable) zza.zza(parcel, zzat, DataItemParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PutDataResponse(i2, i, dataItemParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PutDataResponse[] zzmi(int i) {
        return new PutDataResponse[i];
    }
}
