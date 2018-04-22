package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzb implements Creator<Cart> {
    static void zza(Cart cart, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, cart.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, cart.zzboh, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, cart.zzboi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, cart.zzboj, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhp(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkN(i);
    }

    public Cart zzhp(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = zza.zzc(parcel, zzat, LineItem.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Cart[] zzkN(int i) {
        return new Cart[i];
    }
}
