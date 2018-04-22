package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzal implements Creator<GetCloudSyncOptInOutDoneResponse> {
    static void zza(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInOutDoneResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInOutDoneResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInOutDoneResponse.zzbsD);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzir(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlV(i);
    }

    public GetCloudSyncOptInOutDoneResponse zzir(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
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
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetCloudSyncOptInOutDoneResponse(i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetCloudSyncOptInOutDoneResponse[] zzlV(int i) {
        return new GetCloudSyncOptInOutDoneResponse[i];
    }
}
