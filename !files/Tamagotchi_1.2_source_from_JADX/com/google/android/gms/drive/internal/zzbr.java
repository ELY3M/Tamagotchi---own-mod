package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbr implements Creator<SetFileUploadPreferencesRequest> {
    static void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, setFileUploadPreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, setFileUploadPreferencesRequest.zzasg, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdO(i);
    }

    public SetFileUploadPreferencesRequest zzbT(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) zza.zza(parcel, zzat, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SetFileUploadPreferencesRequest[] zzdO(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }
}
