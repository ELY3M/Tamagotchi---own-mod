package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<GetInstrumentsRequest> {
    static void zza(GetInstrumentsRequest getInstrumentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getInstrumentsRequest.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsRequest.zzbpS, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlg(i);
    }

    public GetInstrumentsRequest zzhI(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iArr = zza.zzv(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetInstrumentsRequest(i, iArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetInstrumentsRequest[] zzlg(int i) {
        return new GetInstrumentsRequest[i];
    }
}
