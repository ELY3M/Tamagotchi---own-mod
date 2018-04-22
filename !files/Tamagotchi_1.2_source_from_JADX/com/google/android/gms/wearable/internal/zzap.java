package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzap implements Creator<GetConfigsResponse> {
    static void zza(GetConfigsResponse getConfigsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getConfigsResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigsResponse.statusCode);
        zzb.zza(parcel, 3, getConfigsResponse.zzbsH, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlZ(i);
    }

    public GetConfigsResponse zziv(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ConnectionConfiguration[] connectionConfigurationArr = null;
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
                    connectionConfigurationArr = (ConnectionConfiguration[]) zza.zzb(parcel, zzat, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetConfigsResponse(i2, i, connectionConfigurationArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetConfigsResponse[] zzlZ(int i) {
        return new GetConfigsResponse[i];
    }
}
