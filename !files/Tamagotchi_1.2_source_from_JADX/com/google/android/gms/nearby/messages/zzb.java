package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.List;

public class zzb implements Creator<MessageFilter> {
    static void zza(MessageFilter messageFilter, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, messageFilter.zzEo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, messageFilter.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, messageFilter.zzEq(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, messageFilter.zzEp());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjc(i);
    }

    public MessageFilter zzgb(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    list2 = zza.zzc(parcel, zzat, MessageType.CREATOR);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, NearbyDeviceFilter.CREATOR);
                    break;
                case 3:
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
            return new MessageFilter(i, list2, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MessageFilter[] zzjc(int i) {
        return new MessageFilter[i];
    }
}
