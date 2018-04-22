package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<HandleClientLifecycleEventRequest> {
    static void zza(HandleClientLifecycleEventRequest handleClientLifecycleEventRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, handleClientLifecycleEventRequest.versionCode);
        zzb.zza(parcel, 2, handleClientLifecycleEventRequest.zzbcs, i, false);
        zzb.zzc(parcel, 3, handleClientLifecycleEventRequest.zzbct);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjn(i);
    }

    public HandleClientLifecycleEventRequest zzgi(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ClientAppContext clientAppContext = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            ClientAppContext clientAppContext2;
            int zzg;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    int i3 = i;
                    clientAppContext2 = clientAppContext;
                    zzg = zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    ClientAppContext clientAppContext3 = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    zzat = i;
                    clientAppContext2 = clientAppContext3;
                    break;
                case 3:
                    zzat = zza.zzg(parcel, zzat);
                    clientAppContext2 = clientAppContext;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzat = i;
                    clientAppContext2 = clientAppContext;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            clientAppContext = clientAppContext2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new HandleClientLifecycleEventRequest(i2, clientAppContext, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public HandleClientLifecycleEventRequest[] zzjn(int i) {
        return new HandleClientLifecycleEventRequest[i];
    }
}
