package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzao implements Creator<GetConfigResponse> {
    static void zza(GetConfigResponse getConfigResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getConfigResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigResponse.statusCode);
        zzb.zza(parcel, 3, getConfigResponse.zzbsG, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlY(i);
    }

    public GetConfigResponse zziu(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ConnectionConfiguration connectionConfiguration = null;
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
                    connectionConfiguration = (ConnectionConfiguration) zza.zza(parcel, zzat, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetConfigResponse(i2, i, connectionConfiguration);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetConfigResponse[] zzlY(int i) {
        return new GetConfigResponse[i];
    }
}
