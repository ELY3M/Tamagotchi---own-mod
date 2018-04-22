package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<ChannelEventParcelable> {
    static void zza(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, channelEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, channelEventParcelable.zzbsc, i, false);
        zzb.zzc(parcel, 3, channelEventParcelable.type);
        zzb.zzc(parcel, 4, channelEventParcelable.zzbsa);
        zzb.zzc(parcel, 5, channelEventParcelable.zzbsb);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzif(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlI(i);
    }

    public ChannelEventParcelable zzif(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzat, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChannelEventParcelable[] zzlI(int i) {
        return new ChannelEventParcelable[i];
    }
}
