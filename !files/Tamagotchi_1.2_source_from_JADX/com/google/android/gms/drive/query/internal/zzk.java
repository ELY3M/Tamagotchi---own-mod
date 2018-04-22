package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, logicalFilter.mVersionCode);
        zzb.zza(parcel, 1, logicalFilter.zzaug, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzauv, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzen(i);
    }

    public LogicalFilter zzcs(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            Operator operator2;
            ArrayList zzc;
            int zzat = zza.zzat(parcel);
            List list2;
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) zza.zza(parcel, zzat, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzat, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = zza.zzg(parcel, zzat);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzc = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzau) {
            return new LogicalFilter(i, operator, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LogicalFilter[] zzen(int i) {
        return new LogicalFilter[i];
    }
}
