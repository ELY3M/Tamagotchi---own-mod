package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbs implements Creator<SetPinnedDownloadPreferencesRequest> {
    static void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, setPinnedDownloadPreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, setPinnedDownloadPreferencesRequest.zzasu, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdP(i);
    }

    public SetPinnedDownloadPreferencesRequest zzbU(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelableTransferPreferences parcelableTransferPreferences = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcelableTransferPreferences = (ParcelableTransferPreferences) zza.zza(parcel, zzat, ParcelableTransferPreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SetPinnedDownloadPreferencesRequest(i, parcelableTransferPreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SetPinnedDownloadPreferencesRequest[] zzdP(int i) {
        return new SetPinnedDownloadPreferencesRequest[i];
    }
}
