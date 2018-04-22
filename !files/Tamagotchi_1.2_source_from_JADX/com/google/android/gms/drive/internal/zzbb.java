package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.mVersionCode);
        zzb.zza(parcel, 2, onFetchThumbnailResponse.zzasr, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdz(i);
    }

    public OnFetchThumbnailResponse zzbE(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnFetchThumbnailResponse[] zzdz(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
