package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<ValuesAddedDetails> {
    static void zza(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, valuesAddedDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesAddedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesAddedDetails.zzauP);
        zzb.zzc(parcel, 4, valuesAddedDetails.zzauQ);
        zzb.zza(parcel, 5, valuesAddedDetails.zzavo, false);
        zzb.zzc(parcel, 6, valuesAddedDetails.zzavp);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeG(i);
    }

    public ValuesAddedDetails zzcK(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ValuesAddedDetails[] zzeG(int i) {
        return new ValuesAddedDetails[i];
    }
}
