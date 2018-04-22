package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ChangeSequenceNumber> {
    static void zza(ChangeSequenceNumber changeSequenceNumber, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeSequenceNumber.mVersionCode);
        zzb.zza(parcel, 2, changeSequenceNumber.zzaot);
        zzb.zza(parcel, 3, changeSequenceNumber.zzaou);
        zzb.zza(parcel, 4, changeSequenceNumber.zzaov);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcq(i);
    }

    public ChangeSequenceNumber zzaH(Parcel parcel) {
        long j = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangeSequenceNumber(i, j3, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChangeSequenceNumber[] zzcq(int i) {
        return new ChangeSequenceNumber[i];
    }
}
