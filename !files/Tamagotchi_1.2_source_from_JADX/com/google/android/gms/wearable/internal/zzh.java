package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<AncsNotificationParcelable> {
    static void zza(AncsNotificationParcelable ancsNotificationParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, ancsNotificationParcelable.mVersionCode);
        zzb.zzc(parcel, 2, ancsNotificationParcelable.getId());
        zzb.zza(parcel, 3, ancsNotificationParcelable.zzwK(), false);
        zzb.zza(parcel, 4, ancsNotificationParcelable.zzIB(), false);
        zzb.zza(parcel, 5, ancsNotificationParcelable.zzIC(), false);
        zzb.zza(parcel, 6, ancsNotificationParcelable.getTitle(), false);
        zzb.zza(parcel, 7, ancsNotificationParcelable.zzwc(), false);
        zzb.zza(parcel, 8, ancsNotificationParcelable.getDisplayName(), false);
        zzb.zza(parcel, 9, ancsNotificationParcelable.zzID());
        zzb.zza(parcel, 10, ancsNotificationParcelable.zzIE());
        zzb.zza(parcel, 11, ancsNotificationParcelable.zzIF());
        zzb.zza(parcel, 12, ancsNotificationParcelable.zzIG());
        zzb.zza(parcel, 13, ancsNotificationParcelable.getPackageName(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzid(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlE(i);
    }

    public AncsNotificationParcelable zzid(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        String str7 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    b = zza.zze(parcel, zzat);
                    break;
                case 10:
                    b2 = zza.zze(parcel, zzat);
                    break;
                case 11:
                    b3 = zza.zze(parcel, zzat);
                    break;
                case 12:
                    b4 = zza.zze(parcel, zzat);
                    break;
                case 13:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AncsNotificationParcelable(i, i2, str, str2, str3, str4, str5, str6, b, b2, b3, b4, str7);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AncsNotificationParcelable[] zzlE(int i) {
        return new AncsNotificationParcelable[i];
    }
}
