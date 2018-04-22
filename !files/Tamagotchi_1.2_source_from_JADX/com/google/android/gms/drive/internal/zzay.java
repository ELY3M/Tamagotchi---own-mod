package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFileRange;
import java.util.List;

public class zzay implements Creator<OnDownloadProgressResponse> {
    static void zza(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onDownloadProgressResponse.mVersionCode);
        zzb.zza(parcel, 2, onDownloadProgressResponse.zzasi);
        zzb.zza(parcel, 3, onDownloadProgressResponse.zzasj);
        zzb.zzc(parcel, 4, onDownloadProgressResponse.zzBc);
        zzb.zzc(parcel, 5, onDownloadProgressResponse.zzask, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdw(i);
    }

    public OnDownloadProgressResponse zzbB(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzau = zza.zzau(parcel);
        List list = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzat, DriveFileRange.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnDownloadProgressResponse(i2, j2, j, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnDownloadProgressResponse[] zzdw(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
