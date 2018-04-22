package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<GetBuyFlowInitializationTokenRequest> {
    static void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getBuyFlowInitializationTokenRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getBuyFlowInitializationTokenRequest.zzbpP, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getBuyFlowInitializationTokenRequest.zzbpQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzle(i);
    }

    public GetBuyFlowInitializationTokenRequest zzhG(Parcel parcel) {
        byte[] bArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[] bArr2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr2 = zza.zzs(parcel, zzat);
                    break;
                case 3:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetBuyFlowInitializationTokenRequest(i, bArr2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetBuyFlowInitializationTokenRequest[] zzle(int i) {
        return new GetBuyFlowInitializationTokenRequest[i];
    }
}
