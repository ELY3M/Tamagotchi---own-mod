package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class VideoConfigurationCreator implements Creator<VideoConfiguration> {
    static void zza(VideoConfiguration videoConfiguration, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, videoConfiguration.zzyd());
        zzb.zzc(parcel, 1000, videoConfiguration.getVersionCode());
        zzb.zzc(parcel, 2, videoConfiguration.zzye());
        zzb.zza(parcel, 3, videoConfiguration.getStreamUrl(), false);
        zzb.zza(parcel, 4, videoConfiguration.zzyf(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhb(i);
    }

    public VideoConfiguration zzeG(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
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
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
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
            return new VideoConfiguration(i3, i2, i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public VideoConfiguration[] zzhb(int i) {
        return new VideoConfiguration[i];
    }
}
