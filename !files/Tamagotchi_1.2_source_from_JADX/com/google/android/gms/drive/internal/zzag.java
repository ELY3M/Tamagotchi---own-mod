package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Creator<FileUploadPreferencesImpl> {
    static void zza(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fileUploadPreferencesImpl.mVersionCode);
        zzb.zzc(parcel, 2, fileUploadPreferencesImpl.zzarG);
        zzb.zzc(parcel, 3, fileUploadPreferencesImpl.zzarH);
        zzb.zza(parcel, 4, fileUploadPreferencesImpl.zzarI);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdl(i);
    }

    public FileUploadPreferencesImpl zzbq(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FileUploadPreferencesImpl[] zzdl(int i) {
        return new FileUploadPreferencesImpl[i];
    }
}
