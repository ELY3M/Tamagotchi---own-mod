package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<GetInstrumentsResponse> {
    static void zza(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getInstrumentsResponse.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsResponse.zzbpT, false);
        zzb.zza(parcel, 3, getInstrumentsResponse.zzbpU, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlh(i);
    }

    public GetInstrumentsResponse zzhJ(Parcel parcel) {
        String[] strArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 3:
                    bArr = zza.zzt(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetInstrumentsResponse(i, strArr, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetInstrumentsResponse[] zzlh(int i) {
        return new GetInstrumentsResponse[i];
    }
}
