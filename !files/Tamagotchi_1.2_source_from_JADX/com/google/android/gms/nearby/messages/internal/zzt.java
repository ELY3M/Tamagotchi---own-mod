package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Creator<UnpublishRequest> {
    static void zza(UnpublishRequest unpublishRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, unpublishRequest.mVersionCode);
        zzb.zza(parcel, 2, unpublishRequest.zzbcT, i, false);
        zzb.zza(parcel, 3, unpublishRequest.zzED(), false);
        zzb.zza(parcel, 4, unpublishRequest.zzbbF, false);
        zzb.zza(parcel, 5, unpublishRequest.zzbco, false);
        zzb.zza(parcel, 6, unpublishRequest.zzbbH);
        zzb.zza(parcel, 7, unpublishRequest.zzbcs, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzju(i);
    }

    public UnpublishRequest zzgo(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        MessageWrapper messageWrapper = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) zza.zza(parcel, zzat, MessageWrapper.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UnpublishRequest(i, messageWrapper, iBinder, str2, str, z, clientAppContext);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UnpublishRequest[] zzju(int i) {
        return new UnpublishRequest[i];
    }
}
