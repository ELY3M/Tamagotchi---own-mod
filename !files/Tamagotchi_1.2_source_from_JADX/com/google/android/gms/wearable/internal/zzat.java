package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzat implements Creator<GetLocalNodeResponse> {
    static void zza(GetLocalNodeResponse getLocalNodeResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getLocalNodeResponse.versionCode);
        zzb.zzc(parcel, 2, getLocalNodeResponse.statusCode);
        zzb.zza(parcel, 3, getLocalNodeResponse.zzbsL, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmd(i);
    }

    public GetLocalNodeResponse zziz(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        NodeParcelable nodeParcelable = null;
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
                    nodeParcelable = (NodeParcelable) zza.zza(parcel, zzat, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetLocalNodeResponse(i2, i, nodeParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetLocalNodeResponse[] zzmd(int i) {
        return new GetLocalNodeResponse[i];
    }
}
