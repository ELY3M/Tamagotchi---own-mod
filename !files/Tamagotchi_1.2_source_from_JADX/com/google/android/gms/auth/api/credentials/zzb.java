package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<CredentialPickerConfig> {
    static void zza(CredentialPickerConfig credentialPickerConfig, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, credentialPickerConfig.shouldShowAddAccountButton());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, credentialPickerConfig.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, credentialPickerConfig.shouldShowCancelButton());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, credentialPickerConfig.isForNewAccount());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaA(i);
    }

    public CredentialPickerConfig zzF(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
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
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CredentialPickerConfig(i, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CredentialPickerConfig[] zzaA(int i) {
        return new CredentialPickerConfig[i];
    }
}
