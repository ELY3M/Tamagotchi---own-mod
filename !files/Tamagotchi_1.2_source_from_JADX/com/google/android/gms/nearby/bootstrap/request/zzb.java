package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ContinueConnectRequest> {
    static void zza(ContinueConnectRequest continueConnectRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, continueConnectRequest.getToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, continueConnectRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, continueConnectRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziN(i);
    }

    public ContinueConnectRequest zzfR(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ContinueConnectRequest(i, str, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ContinueConnectRequest[] zziN(int i) {
        return new ContinueConnectRequest[i];
    }
}
