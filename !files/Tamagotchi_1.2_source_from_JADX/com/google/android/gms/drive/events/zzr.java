package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzr implements Creator<TransferStateOptions> {
    static void zza(TransferStateOptions transferStateOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferStateOptions.mVersionCode);
        zzb.zzc(parcel, 2, transferStateOptions.zzapB, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcN(i);
    }

    public TransferStateOptions zzaX(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferStateOptions(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TransferStateOptions[] zzcN(int i) {
        return new TransferStateOptions[i];
    }
}
