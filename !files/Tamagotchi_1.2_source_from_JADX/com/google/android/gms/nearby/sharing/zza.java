package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AppContentReceivedResult> {
    static void zza(AppContentReceivedResult appContentReceivedResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appContentReceivedResult.getVersionCode());
        zzb.zza(parcel, 2, appContentReceivedResult.zzEJ(), i, false);
        zzb.zzc(parcel, 3, appContentReceivedResult.getStatusCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjw(i);
    }

    public AppContentReceivedResult zzgq(Parcel parcel) {
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Uri uri = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            Uri uri2;
            int zzg;
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    int i3 = i;
                    uri2 = uri;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    Uri uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    zzat = i;
                    uri2 = uri3;
                    break;
                case 3:
                    zzat = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    uri2 = uri;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    zzat = i;
                    uri2 = uri;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            uri = uri2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new AppContentReceivedResult(i2, uri, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppContentReceivedResult[] zzjw(int i) {
        return new AppContentReceivedResult[i];
    }
}
