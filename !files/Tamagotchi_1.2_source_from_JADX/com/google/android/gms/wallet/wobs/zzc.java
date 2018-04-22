package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

public class zzc implements Creator<LabelValueRow> {
    static void zza(LabelValueRow labelValueRow, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, labelValueRow.getVersionCode());
        zzb.zza(parcel, 2, labelValueRow.zzbqF, false);
        zzb.zza(parcel, 3, labelValueRow.zzbqG, false);
        zzb.zzc(parcel, 4, labelValueRow.zzbqH, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlr(i);
    }

    public LabelValueRow zzhQ(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList zzsa = zzmn.zzsa();
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    zzsa = zza.zzc(parcel, zzat, LabelValue.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LabelValueRow(i, str2, str, zzsa);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LabelValueRow[] zzlr(int i) {
        return new LabelValueRow[i];
    }
}
