package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzi implements Creator<ReadRawResult> {
    static void zza(ReadRawResult readRawResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, readRawResult.zzsX(), i, false);
        zzb.zzc(parcel, 1000, readRawResult.getVersionCode());
        zzb.zzc(parcel, 2, readRawResult.zzvo(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfW(i);
    }

    public ReadRawResult zzdV(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            DataHolder dataHolder2;
            ArrayList zzc;
            int zzat = zza.zzat(parcel);
            List list2;
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    list2 = list;
                    dataHolder2 = dataHolder3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzat, DataHolder.CREATOR);
                    dataHolder2 = dataHolder;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    dataHolder2 = dataHolder;
                    i2 = zza.zzg(parcel, zzat);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzc = list;
                    dataHolder2 = dataHolder;
                    i2 = i;
                    break;
            }
            i = i2;
            dataHolder = dataHolder2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzau) {
            return new ReadRawResult(i, dataHolder, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ReadRawResult[] zzfW(int i) {
        return new ReadRawResult[i];
    }
}
