package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<Asset> {
    static void zza(Asset asset, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, asset.mVersionCode);
        zzb.zza(parcel, 2, asset.getData(), false);
        zzb.zza(parcel, 3, asset.getDigest(), false);
        zzb.zza(parcel, 4, asset.zzbqV, i, false);
        zzb.zza(parcel, 5, asset.uri, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzly(i);
    }

    public Asset zzhX(Parcel parcel) {
        Uri uri = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Asset[] zzly(int i) {
        return new Asset[i];
    }
}
