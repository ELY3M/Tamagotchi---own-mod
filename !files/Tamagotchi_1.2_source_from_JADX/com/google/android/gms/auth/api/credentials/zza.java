package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zza implements Creator<Credential> {
    static void zza(Credential credential, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, credential.getId(), false);
        zzb.zzc(parcel, 1000, credential.mVersionCode);
        zzb.zza(parcel, 2, credential.getName(), false);
        zzb.zza(parcel, 3, credential.getProfilePictureUri(), i, false);
        zzb.zzc(parcel, 4, credential.getIdTokens(), false);
        zzb.zza(parcel, 5, credential.getPassword(), false);
        zzb.zza(parcel, 6, credential.getAccountType(), false);
        zzb.zza(parcel, 7, credential.getGeneratedPassword(), false);
        zzb.zza(parcel, 8, credential.zzmx(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaz(i);
    }

    public Credential zzE(Parcel parcel) {
        String str = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 4:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, IdToken.CREATOR);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Credential(i, str6, str5, uri, list, str4, str3, str2, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Credential[] zzaz(int i) {
        return new Credential[i];
    }
}
