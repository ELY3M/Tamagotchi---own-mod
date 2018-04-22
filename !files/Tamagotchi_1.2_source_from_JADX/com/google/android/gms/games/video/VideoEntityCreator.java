package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class VideoEntityCreator implements Creator<VideoEntity> {
    static void zza(VideoEntity videoEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, videoEntity.getDuration());
        zzb.zzc(parcel, 1000, videoEntity.getVersionCode());
        zzb.zza(parcel, 2, videoEntity.zzxX(), false);
        zzb.zza(parcel, 3, videoEntity.getFileSize());
        zzb.zza(parcel, 4, videoEntity.getStartTime());
        zzb.zza(parcel, 5, videoEntity.getPackageName(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhc(i);
    }

    public VideoEntity zzeH(Parcel parcel) {
        long j = 0;
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new VideoEntity(i2, i, str2, j2, j, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public VideoEntity[] zzhc(int i) {
        return new VideoEntity[i];
    }
}
