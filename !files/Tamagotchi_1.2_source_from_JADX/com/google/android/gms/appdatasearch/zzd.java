package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DocumentSection> {
    static void zza(DocumentSection documentSection, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, documentSection.zzTO, false);
        zzb.zzc(parcel, 1000, documentSection.mVersionCode);
        zzb.zza(parcel, 3, documentSection.zzTP, i, false);
        zzb.zzc(parcel, 4, documentSection.zzTQ);
        zzb.zza(parcel, 5, documentSection.zzTR, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzt(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzak(i);
    }

    public DocumentSection[] zzak(int i) {
        return new DocumentSection[i];
    }

    public DocumentSection zzt(Parcel parcel) {
        byte[] bArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) zza.zza(parcel, zzat, RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    bArr = zza.zzs(parcel, zzat);
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
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
