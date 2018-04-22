package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzaw implements Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        zzb.zza(parcel, 2, onContentsResponse.zzara, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzasf);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdu(i);
    }

    public OnContentsResponse zzbz(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            Contents contents2;
            int zzg;
            boolean z2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    boolean z3 = z;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzat);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    Contents contents3 = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    contents2 = contents;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    z2 = z;
                    contents2 = contents;
                    zzg = i;
                    break;
            }
            i = zzg;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == zzau) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnContentsResponse[] zzdu(int i) {
        return new OnContentsResponse[i];
    }
}
