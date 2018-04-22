package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<RegisterStatusCallbackRequest> {
    static void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, registerStatusCallbackRequest.versionCode);
        zzb.zza(parcel, 2, registerStatusCallbackRequest.zzED(), false);
        zzb.zza(parcel, 3, registerStatusCallbackRequest.zzEG(), false);
        zzb.zza(parcel, 4, registerStatusCallbackRequest.zzbcX);
        zzb.zza(parcel, 5, registerStatusCallbackRequest.zzbbF, false);
        zzb.zza(parcel, 6, registerStatusCallbackRequest.zzbcs, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjs(i);
    }

    public RegisterStatusCallbackRequest zzgm(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzau = zza.zzau(parcel);
        String str = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RegisterStatusCallbackRequest(i, iBinder2, iBinder, z, str, clientAppContext);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RegisterStatusCallbackRequest[] zzjs(int i) {
        return new RegisterStatusCallbackRequest[i];
    }
}
