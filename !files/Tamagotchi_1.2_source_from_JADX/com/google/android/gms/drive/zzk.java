package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzk implements Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.mVersionCode);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzapq, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzapr, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcC(i);
    }

    public RealtimeDocumentSyncRequest zzaN(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list2 = zza.zzD(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzD(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RealtimeDocumentSyncRequest[] zzcC(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
