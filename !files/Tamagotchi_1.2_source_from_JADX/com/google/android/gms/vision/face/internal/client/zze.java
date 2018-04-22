package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LandmarkParcel> {
    static void zza(LandmarkParcel landmarkParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, landmarkParcel.versionCode);
        zzb.zza(parcel, 2, landmarkParcel.f19x);
        zzb.zza(parcel, 3, landmarkParcel.f20y);
        zzb.zzc(parcel, 4, landmarkParcel.type);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkK(i);
    }

    public LandmarkParcel zzhm(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    f2 = zza.zzl(parcel, zzat);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LandmarkParcel(i2, f2, f, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LandmarkParcel[] zzkK(int i) {
        return new LandmarkParcel[i];
    }
}
