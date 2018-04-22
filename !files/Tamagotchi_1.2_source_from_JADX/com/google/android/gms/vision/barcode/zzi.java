package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.PersonName;

public class zzi implements Creator<PersonName> {
    static void zza(PersonName personName, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, personName.versionCode);
        zzb.zza(parcel, 2, personName.formattedName, false);
        zzb.zza(parcel, 3, personName.pronunciation, false);
        zzb.zza(parcel, 4, personName.prefix, false);
        zzb.zza(parcel, 5, personName.first, false);
        zzb.zza(parcel, 6, personName.middle, false);
        zzb.zza(parcel, 7, personName.last, false);
        zzb.zza(parcel, 8, personName.suffix, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhe(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkB(i);
    }

    public PersonName zzhe(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonName(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PersonName[] zzkB(int i) {
        return new PersonName[i];
    }
}
