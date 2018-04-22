package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzba implements Creator<MessageEventParcelable> {
    static void zza(MessageEventParcelable messageEventParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, messageEventParcelable.mVersionCode);
        zzb.zzc(parcel, 2, messageEventParcelable.getRequestId());
        zzb.zza(parcel, 3, messageEventParcelable.getPath(), false);
        zzb.zza(parcel, 4, messageEventParcelable.getData(), false);
        zzb.zza(parcel, 5, messageEventParcelable.getSourceNodeId(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzme(i);
    }

    public MessageEventParcelable zziA(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MessageEventParcelable(i2, i, str2, bArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MessageEventParcelable[] zzme(int i) {
        return new MessageEventParcelable[i];
    }
}
