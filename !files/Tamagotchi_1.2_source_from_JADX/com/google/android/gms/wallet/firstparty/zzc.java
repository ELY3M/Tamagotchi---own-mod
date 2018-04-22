package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<GetBuyFlowInitializationTokenResponse> {
    static void zza(GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getBuyFlowInitializationTokenResponse.getVersionCode());
        zzb.zza(parcel, 2, getBuyFlowInitializationTokenResponse.zzbpR, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlf(i);
    }

    public GetBuyFlowInitializationTokenResponse zzhH(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetBuyFlowInitializationTokenResponse(i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetBuyFlowInitializationTokenResponse[] zzlf(int i) {
        return new GetBuyFlowInitializationTokenResponse[i];
    }
}
