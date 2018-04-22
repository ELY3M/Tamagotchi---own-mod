package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<ProxyResponse> {
    static void zza(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, proxyResponse.googlePlayServicesStatusCode);
        zzb.zzc(parcel, 1000, proxyResponse.versionCode);
        zzb.zza(parcel, 2, proxyResponse.recoveryAction, i, false);
        zzb.zzc(parcel, 3, proxyResponse.statusCode);
        zzb.zza(parcel, 4, proxyResponse.zzWB, false);
        zzb.zza(parcel, 5, proxyResponse.body, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaK(i);
    }

    public ProxyResponse zzP(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 5:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ProxyResponse[] zzaK(int i) {
        return new ProxyResponse[i];
    }
}
