package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zza implements Creator<ApplicationMetadata> {
    static void zza(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, applicationMetadata.getVersionCode());
        zzb.zza(parcel, 2, applicationMetadata.getApplicationId(), false);
        zzb.zza(parcel, 3, applicationMetadata.getName(), false);
        zzb.zzc(parcel, 4, applicationMetadata.getImages(), false);
        zzb.zzb(parcel, 5, applicationMetadata.getSupportedNamespaces(), false);
        zzb.zza(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        zzb.zza(parcel, 7, applicationMetadata.zznx(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaW(i);
    }

    public ApplicationMetadata zzZ(Parcel parcel) {
        Uri uri = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, WebImage.CREATOR);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, zzat);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ApplicationMetadata[] zzaW(int i) {
        return new ApplicationMetadata[i];
    }
}
