package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zza implements Creator<ConnectRequest> {
    static void zza(ConnectRequest connectRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, connectRequest.zzEd(), i, false);
        zzb.zzc(parcel, 1000, connectRequest.versionCode);
        zzb.zza(parcel, 2, connectRequest.getName(), false);
        zzb.zza(parcel, 3, connectRequest.getDescription(), false);
        zzb.zza(parcel, 4, connectRequest.zzEg(), false);
        zzb.zza(parcel, 5, connectRequest.zzEh(), false);
        zzb.zza(parcel, 6, connectRequest.getCallbackBinder(), false);
        zzb.zza(parcel, 7, connectRequest.zzEb());
        zzb.zza(parcel, 8, connectRequest.zzEe());
        zzb.zza(parcel, 9, connectRequest.getToken(), false);
        zzb.zza(parcel, 10, connectRequest.zzEf());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziM(i);
    }

    public ConnectRequest zzfQ(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Device device = null;
        String str = null;
        String str2 = null;
        byte b = (byte) 0;
        long j = 0;
        String str3 = null;
        byte b2 = (byte) 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Device.CREATOR);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 6:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 7:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 10:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
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
            return new ConnectRequest(i, device, str, str2, b, j, str3, b2, iBinder, iBinder2, iBinder3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ConnectRequest[] zziM(int i) {
        return new ConnectRequest[i];
    }
}
