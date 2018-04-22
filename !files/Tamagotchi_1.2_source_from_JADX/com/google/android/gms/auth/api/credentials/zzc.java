package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<CredentialRequest> {
    static void zza(CredentialRequest credentialRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, credentialRequest.isPasswordLoginSupported());
        zzb.zzc(parcel, 1000, credentialRequest.mVersionCode);
        zzb.zza(parcel, 2, credentialRequest.getAccountTypes(), false);
        zzb.zza(parcel, 3, credentialRequest.getCredentialPickerConfig(), i, false);
        zzb.zza(parcel, 4, credentialRequest.getCredentialHintPickerConfig(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaB(i);
    }

    public CredentialRequest zzG(Parcel parcel) {
        boolean z = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int zzau = zza.zzau(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 2:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 3:
                    credentialPickerConfig2 = (CredentialPickerConfig) zza.zza(parcel, zzat, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig = (CredentialPickerConfig) zza.zza(parcel, zzat, CredentialPickerConfig.CREATOR);
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
            return new CredentialRequest(i, z, strArr, credentialPickerConfig2, credentialPickerConfig);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CredentialRequest[] zzaB(int i) {
        return new CredentialRequest[i];
    }
}
