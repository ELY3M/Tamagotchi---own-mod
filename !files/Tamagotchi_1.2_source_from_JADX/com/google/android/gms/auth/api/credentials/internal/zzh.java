package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<GeneratePasswordRequest> {
    static void zza(GeneratePasswordRequest generatePasswordRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, generatePasswordRequest.zzmr(), i, false);
        zzb.zzc(parcel, 1000, generatePasswordRequest.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaG(i);
    }

    public GeneratePasswordRequest zzL(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        PasswordSpecification passwordSpecification = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    passwordSpecification = (PasswordSpecification) zza.zza(parcel, zzat, PasswordSpecification.CREATOR);
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
            return new GeneratePasswordRequest(i, passwordSpecification);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GeneratePasswordRequest[] zzaG(int i) {
        return new GeneratePasswordRequest[i];
    }
}
