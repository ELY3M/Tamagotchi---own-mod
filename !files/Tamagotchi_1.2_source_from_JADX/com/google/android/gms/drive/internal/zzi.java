package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzi implements Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, closeContentsRequest.zzaql, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzaqp, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzaqn);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcW(i);
    }

    public CloseContentsRequest zzbg(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        Contents contents = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            Boolean bool2;
            Contents contents2;
            int zzg;
            int zzat = zza.zzat(parcel);
            int i3;
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    Boolean bool3 = bool;
                    contents2 = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
                    zzat = i;
                    bool2 = bool3;
                    break;
                case 3:
                    contents2 = contents;
                    zzg = i2;
                    i3 = i;
                    bool2 = zza.zzd(parcel, zzat);
                    zzat = i3;
                    break;
                case 4:
                    zzat = zza.zzg(parcel, zzat);
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzat = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            contents = contents2;
            bool = bool2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new CloseContentsRequest(i2, contents, bool, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CloseContentsRequest[] zzcW(int i) {
        return new CloseContentsRequest[i];
    }
}
