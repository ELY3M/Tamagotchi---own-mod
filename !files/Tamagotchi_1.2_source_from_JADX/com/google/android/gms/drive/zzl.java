package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, userMetadata.mVersionCode);
        zzb.zza(parcel, 2, userMetadata.zzaps, false);
        zzb.zza(parcel, 3, userMetadata.zzWQ, false);
        zzb.zza(parcel, 4, userMetadata.zzapt, false);
        zzb.zza(parcel, 5, userMetadata.zzapu);
        zzb.zza(parcel, 6, userMetadata.zzapv, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcD(i);
    }

    public UserMetadata zzaO(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UserMetadata[] zzcD(int i) {
        return new UserMetadata[i];
    }
}
