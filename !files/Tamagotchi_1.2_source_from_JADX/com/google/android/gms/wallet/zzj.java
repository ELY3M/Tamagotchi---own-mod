package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<LineItem> {
    static void zza(LineItem lineItem, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, lineItem.getVersionCode());
        zzb.zza(parcel, 2, lineItem.description, false);
        zzb.zza(parcel, 3, lineItem.zzboL, false);
        zzb.zza(parcel, 4, lineItem.zzboM, false);
        zzb.zza(parcel, 5, lineItem.zzboh, false);
        zzb.zzc(parcel, 6, lineItem.zzboN);
        zzb.zza(parcel, 7, lineItem.zzboi, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkV(i);
    }

    public LineItem zzhx(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LineItem[] zzkV(int i) {
        return new LineItem[i];
    }
}
