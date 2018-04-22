package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbo implements Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, queryRequest.mVersionCode);
        zzb.zza(parcel, 2, queryRequest.zzasB, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdL(i);
    }

    public QueryRequest zzbQ(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    query = (Query) zza.zza(parcel, zzat, Query.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new QueryRequest(i, query);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public QueryRequest[] zzdL(int i) {
        return new QueryRequest[i];
    }
}
