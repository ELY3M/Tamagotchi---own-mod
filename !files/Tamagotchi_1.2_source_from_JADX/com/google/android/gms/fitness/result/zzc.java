package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzd(parcel, 1, dataReadResult.zzvl(), false);
        zzb.zzc(parcel, 1000, dataReadResult.getVersionCode());
        zzb.zza(parcel, 2, dataReadResult.getStatus(), i, false);
        zzb.zzd(parcel, 3, dataReadResult.zzvk(), false);
        zzb.zzc(parcel, 5, dataReadResult.zzvj());
        zzb.zzc(parcel, 6, dataReadResult.zzul(), false);
        zzb.zzc(parcel, 7, dataReadResult.zzvm(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfQ(i);
    }

    public DataReadResult zzdP(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzau = zza.zzau(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    zza.zza(parcel, zzat, arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzat, arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    list2 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 7:
                    list = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataReadResult[] zzfQ(int i) {
        return new DataReadResult[i];
    }
}
