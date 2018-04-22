package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzas implements Creator<GetFdForAssetResponse> {
    static void zza(GetFdForAssetResponse getFdForAssetResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getFdForAssetResponse.versionCode);
        zzb.zzc(parcel, 2, getFdForAssetResponse.statusCode);
        zzb.zza(parcel, 3, getFdForAssetResponse.zzbsK, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmc(i);
    }

    public GetFdForAssetResponse zziy(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetFdForAssetResponse(i2, i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetFdForAssetResponse[] zzmc(int i) {
        return new GetFdForAssetResponse[i];
    }
}
