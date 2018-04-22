package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class VideoCapabilitiesCreator implements Creator<VideoCapabilities> {
    static void zza(VideoCapabilities videoCapabilities, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, videoCapabilities.zzxZ());
        zzb.zzc(parcel, 1000, videoCapabilities.getVersionCode());
        zzb.zza(parcel, 2, videoCapabilities.zzxY());
        zzb.zza(parcel, 3, videoCapabilities.zzya());
        zzb.zza(parcel, 4, videoCapabilities.zzyb(), false);
        zzb.zza(parcel, 5, videoCapabilities.zzyc(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgY(i);
    }

    public VideoCapabilities zzeF(Parcel parcel) {
        boolean[] zArr = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean[] zArr2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    zArr2 = zza.zzu(parcel, zzat);
                    break;
                case 5:
                    zArr = zza.zzu(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new VideoCapabilities(i, z3, z2, z, zArr2, zArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public VideoCapabilities[] zzgY(int i) {
        return new VideoCapabilities[i];
    }
}
