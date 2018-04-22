package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<ReferenceShiftedDetails> {
    static void zza(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, referenceShiftedDetails.mVersionCode);
        zzb.zza(parcel, 2, referenceShiftedDetails.zzavj, false);
        zzb.zza(parcel, 3, referenceShiftedDetails.zzavk, false);
        zzb.zzc(parcel, 4, referenceShiftedDetails.zzavl);
        zzb.zzc(parcel, 5, referenceShiftedDetails.zzavm);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeC(i);
    }

    public ReferenceShiftedDetails zzcG(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ReferenceShiftedDetails[] zzeC(int i) {
        return new ReferenceShiftedDetails[i];
    }
}
