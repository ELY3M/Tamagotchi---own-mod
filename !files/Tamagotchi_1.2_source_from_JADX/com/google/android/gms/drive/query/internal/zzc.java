package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<FieldWithSortOrder> {
    static void zza(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, fieldWithSortOrder.mVersionCode);
        zzb.zza(parcel, 1, fieldWithSortOrder.zzasF, false);
        zzb.zza(parcel, 2, fieldWithSortOrder.zzauj);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzei(i);
    }

    public FieldWithSortOrder zzcn(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FieldWithSortOrder[] zzei(int i) {
        return new FieldWithSortOrder[i];
    }
}
