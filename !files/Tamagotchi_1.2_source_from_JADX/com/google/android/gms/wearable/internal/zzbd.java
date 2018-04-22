package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Creator<OpenChannelResponse> {
    static void zza(OpenChannelResponse openChannelResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, openChannelResponse.versionCode);
        zzb.zzc(parcel, 2, openChannelResponse.statusCode);
        zzb.zza(parcel, 3, openChannelResponse.zzbsc, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmg(i);
    }

    public OpenChannelResponse zziC(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzat, ChannelImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OpenChannelResponse(i2, i, channelImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OpenChannelResponse[] zzmg(int i) {
        return new OpenChannelResponse[i];
    }
}
