package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Strategy;

public class zzq implements Creator<PublishRequest> {
    static void zza(PublishRequest publishRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, publishRequest.mVersionCode);
        zzb.zza(parcel, 2, publishRequest.zzbcT, i, false);
        zzb.zza(parcel, 3, publishRequest.zzbcU, i, false);
        zzb.zza(parcel, 4, publishRequest.zzED(), false);
        zzb.zza(parcel, 5, publishRequest.zzbbF, false);
        zzb.zza(parcel, 6, publishRequest.zzbco, false);
        zzb.zza(parcel, 7, publishRequest.zzbbG);
        zzb.zza(parcel, 8, publishRequest.zzEF(), false);
        zzb.zza(parcel, 9, publishRequest.zzbbH);
        zzb.zza(parcel, 10, publishRequest.zzbcs, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjr(i);
    }

    public PublishRequest zzgl(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzau = zza.zzau(parcel);
        IBinder iBinder = null;
        boolean z2 = false;
        String str = null;
        String str2 = null;
        IBinder iBinder2 = null;
        Strategy strategy = null;
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
                    strategy = (Strategy) zza.zza(parcel, zzat, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PublishRequest(i, messageWrapper, strategy, iBinder2, str2, str, z2, iBinder, z, clientAppContext);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PublishRequest[] zzjr(int i) {
        return new PublishRequest[i];
    }
}
