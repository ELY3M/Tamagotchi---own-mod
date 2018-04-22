package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<DataType> {
    static void zza(DataType dataType, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataType.getName(), false);
        zzb.zzc(parcel, 1000, dataType.getVersionCode());
        zzb.zzc(parcel, 2, dataType.getFields(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeS(i);
    }

    public DataType zzcT(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, Field.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DataType(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataType[] zzeS(int i) {
        return new DataType[i];
    }
}
