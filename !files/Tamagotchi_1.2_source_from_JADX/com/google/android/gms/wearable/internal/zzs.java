package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs implements Creator<ChannelSendFileResponse> {
    static void zza(ChannelSendFileResponse channelSendFileResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, channelSendFileResponse.versionCode);
        zzb.zzc(parcel, 2, channelSendFileResponse.statusCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzii(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlM(i);
    }

    public ChannelSendFileResponse zzii(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChannelSendFileResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChannelSendFileResponse[] zzlM(int i) {
        return new ChannelSendFileResponse[i];
    }
}
