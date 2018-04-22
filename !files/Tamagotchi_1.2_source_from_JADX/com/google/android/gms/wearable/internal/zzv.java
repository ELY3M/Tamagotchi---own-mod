package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzv implements Creator<CloseChannelResponse> {
    static void zza(CloseChannelResponse closeChannelResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, closeChannelResponse.versionCode);
        zzb.zzc(parcel, 2, closeChannelResponse.statusCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzij(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlN(i);
    }

    public CloseChannelResponse zzij(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CloseChannelResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CloseChannelResponse[] zzlN(int i) {
        return new CloseChannelResponse[i];
    }
}
