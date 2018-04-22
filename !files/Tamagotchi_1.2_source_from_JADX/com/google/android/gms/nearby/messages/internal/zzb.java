package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<GetPermissionStatusRequest> {
    static void zza(GetPermissionStatusRequest getPermissionStatusRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getPermissionStatusRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getPermissionStatusRequest.zzED(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getPermissionStatusRequest.zzbbF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, getPermissionStatusRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjm(i);
    }

    public GetPermissionStatusRequest zzgh(Parcel parcel) {
        ClientAppContext clientAppContext = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetPermissionStatusRequest(i, iBinder, str, clientAppContext);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetPermissionStatusRequest[] zzjm(int i) {
        return new GetPermissionStatusRequest[i];
    }
}
