package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<EnableTargetRequest> {
    static void zza(EnableTargetRequest enableTargetRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, enableTargetRequest.getName(), false);
        zzb.zzc(parcel, 1000, enableTargetRequest.versionCode);
        zzb.zza(parcel, 2, enableTargetRequest.getDescription(), false);
        zzb.zza(parcel, 3, enableTargetRequest.zzEg(), false);
        zzb.zza(parcel, 4, enableTargetRequest.zzEh(), false);
        zzb.zza(parcel, 5, enableTargetRequest.getCallbackBinder(), false);
        zzb.zza(parcel, 6, enableTargetRequest.zzEb());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziQ(i);
    }

    public EnableTargetRequest zzfU(Parcel parcel) {
        byte b = (byte) 0;
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    iBinder3 = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 5:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 6:
                    b = zza.zze(parcel, zzat);
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
            return new EnableTargetRequest(i, str2, str, b, iBinder3, iBinder2, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public EnableTargetRequest[] zziQ(int i) {
        return new EnableTargetRequest[i];
    }
}
