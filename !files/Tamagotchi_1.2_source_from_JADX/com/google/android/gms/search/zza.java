package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GoogleNowAuthState> {
    static void zza(GoogleNowAuthState googleNowAuthState, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, googleNowAuthState.getAuthCode(), false);
        zzb.zzc(parcel, 1000, googleNowAuthState.mVersionCode);
        zzb.zza(parcel, 2, googleNowAuthState.getAccessToken(), false);
        zzb.zza(parcel, 3, googleNowAuthState.getNextAllowedTimeMillis());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjX(i);
    }

    public GoogleNowAuthState zzgQ(Parcel parcel) {
        String str = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleNowAuthState(i, str2, str, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GoogleNowAuthState[] zzjX(int i) {
        return new GoogleNowAuthState[i];
    }
}
