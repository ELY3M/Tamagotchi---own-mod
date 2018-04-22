package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzf implements Creator<PasswordSpecification> {
    static void zza(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, passwordSpecification.zzWn, false);
        zzb.zzc(parcel, 1000, passwordSpecification.mVersionCode);
        zzb.zzb(parcel, 2, passwordSpecification.zzWo, false);
        zzb.zza(parcel, 3, passwordSpecification.zzWp, false);
        zzb.zzc(parcel, 4, passwordSpecification.zzWq);
        zzb.zzc(parcel, 5, passwordSpecification.zzWr);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaE(i);
    }

    public PasswordSpecification zzJ(Parcel parcel) {
        List list = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    list2 = zza.zzD(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzC(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
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
            return new PasswordSpecification(i3, str, list2, list, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PasswordSpecification[] zzaE(int i) {
        return new PasswordSpecification[i];
    }
}
