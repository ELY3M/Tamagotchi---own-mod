package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<DataItemParcelable> {
    static void zza(DataItemParcelable dataItemParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, dataItemParcelable.mVersionCode);
        zzb.zza(parcel, 2, dataItemParcelable.getUri(), i, false);
        zzb.zza(parcel, 4, dataItemParcelable.zzIv(), false);
        zzb.zza(parcel, 5, dataItemParcelable.getData(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzil(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlP(i);
    }

    public DataItemParcelable zzil(Parcel parcel) {
        byte[] bArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzau) {
            Bundle bundle2;
            Uri uri2;
            int zzg;
            byte[] bArr2;
            int zzat = zza.zzat(parcel);
            byte[] bArr3;
            switch (zza.zzca(zzat)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = zza.zzg(parcel, zzat);
                    bArr2 = bArr3;
                    break;
                case 2:
                    zzg = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    zzg = i;
                    bArr3 = bArr;
                    bundle2 = zza.zzr(parcel, zzat);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = zza.zzs(parcel, zzat);
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == zzau) {
            return new DataItemParcelable(i, uri, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataItemParcelable[] zzlP(int i) {
        return new DataItemParcelable[i];
    }
}
