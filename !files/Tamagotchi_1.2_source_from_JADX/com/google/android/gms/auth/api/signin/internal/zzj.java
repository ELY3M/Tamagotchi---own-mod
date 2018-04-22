package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<IdpTokenType> {
    static void zza(IdpTokenType idpTokenType, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, idpTokenType.versionCode);
        zzb.zza(parcel, 2, idpTokenType.zzng(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaP(i);
    }

    public IdpTokenType zzU(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new IdpTokenType(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public IdpTokenType[] zzaP(int i) {
        return new IdpTokenType[i];
    }
}
