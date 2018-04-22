package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, queryResultEventParcelable.zzahi, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzapQ);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzapR);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcI(i);
    }

    public QueryResultEventParcelable zzaT(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        DataHolder dataHolder = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            boolean z2;
            DataHolder dataHolder2;
            int zzg;
            int zzat = zza.zzat(parcel);
            int i3;
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    boolean z3 = z;
                    dataHolder2 = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    zzat = i;
                    z2 = z3;
                    break;
                case 3:
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    i3 = i;
                    z2 = zza.zzc(parcel, zzat);
                    zzat = i3;
                    break;
                case 4:
                    zzat = zza.zzg(parcel, zzat);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzat = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            dataHolder = dataHolder2;
            z = z2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new QueryResultEventParcelable(i2, dataHolder, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public QueryResultEventParcelable[] zzcI(int i) {
        return new QueryResultEventParcelable[i];
    }
}
