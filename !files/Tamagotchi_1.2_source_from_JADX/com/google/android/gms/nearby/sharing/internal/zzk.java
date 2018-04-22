package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<TrustedDevicesRequest> {
    static void zza(TrustedDevicesRequest trustedDevicesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, trustedDevicesRequest.versionCode);
        zzb.zza(parcel, 2, trustedDevicesRequest.zzbdq, false);
        zzb.zza(parcel, 3, trustedDevicesRequest.zzbdr, false);
        zzb.zza(parcel, 4, trustedDevicesRequest.zzED(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjD(i);
    }

    public TrustedDevicesRequest zzgx(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
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
                case 3:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 4:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TrustedDevicesRequest(i, str, bArr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TrustedDevicesRequest[] zzjD(int i) {
        return new TrustedDevicesRequest[i];
    }
}
