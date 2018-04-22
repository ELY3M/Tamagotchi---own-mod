package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzar implements Creator<GetDataItemResponse> {
    static void zza(GetDataItemResponse getDataItemResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getDataItemResponse.versionCode);
        zzb.zzc(parcel, 2, getDataItemResponse.statusCode);
        zzb.zza(parcel, 3, getDataItemResponse.zzbsJ, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzix(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmb(i);
    }

    public GetDataItemResponse zzix(Parcel parcel) {
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
            return new GetDataItemResponse(i2, i, dataItemParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetDataItemResponse[] zzmb(int i) {
        return new GetDataItemResponse[i];
    }
}
