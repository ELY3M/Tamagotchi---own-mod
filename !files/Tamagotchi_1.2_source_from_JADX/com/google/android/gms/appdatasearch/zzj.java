package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, usageInfo.zzUs, i, false);
        zzb.zzc(parcel, 1000, usageInfo.mVersionCode);
        zzb.zza(parcel, 2, usageInfo.zzUt);
        zzb.zzc(parcel, 3, usageInfo.zzUu);
        zzb.zza(parcel, 4, usageInfo.zzvp, false);
        zzb.zza(parcel, 5, usageInfo.zzUv, i, false);
        zzb.zza(parcel, 6, usageInfo.zzUw);
        zzb.zzc(parcel, 7, usageInfo.zzUx);
        zzb.zzc(parcel, 8, usageInfo.zzUy);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzat(i);
    }

    public UsageInfo[] zzat(int i) {
        return new UsageInfo[i];
    }

    public UsageInfo zzy(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    documentId = (DocumentId) zza.zza(parcel, zzat, DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.zza(parcel, zzat, DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
