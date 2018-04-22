package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<DeleteRequest> {
    static void zza(DeleteRequest deleteRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, deleteRequest.getCredential(), i, false);
        zzb.zzc(parcel, 1000, deleteRequest.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaF(i);
    }

    public DeleteRequest zzK(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Credential credential = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    credential = (Credential) zza.zza(parcel, zzat, Credential.CREATOR);
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
            return new DeleteRequest(i, credential);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DeleteRequest[] zzaF(int i) {
        return new DeleteRequest[i];
    }
}
