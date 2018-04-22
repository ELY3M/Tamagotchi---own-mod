package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzd implements Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.mVersionCode);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzapz);
        zzb.zza(parcel, 3, changesAvailableOptions.zzapA);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzapB, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcG(i);
    }

    public ChangesAvailableOptions zzaR(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i = 0;
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
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangesAvailableOptions(i2, i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChangesAvailableOptions[] zzcG(int i) {
        return new ChangesAvailableOptions[i];
    }
}
