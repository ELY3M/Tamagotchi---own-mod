package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public class zzf implements Creator<ProvideContentRequest> {
    static void zza(ProvideContentRequest provideContentRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, provideContentRequest.versionCode);
        zzb.zza(parcel, 2, provideContentRequest.zzbdk, false);
        zzb.zza(parcel, 3, provideContentRequest.zzEP(), false);
        zzb.zzc(parcel, 4, provideContentRequest.zzbdm, false);
        zzb.zza(parcel, 5, provideContentRequest.zzbdn);
        zzb.zza(parcel, 6, provideContentRequest.zzED(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjA(i);
    }

    public ProvideContentRequest zzgu(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder3 = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, SharedContent.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 6:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ProvideContentRequest(i, iBinder3, iBinder2, list, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ProvideContentRequest[] zzjA(int i) {
        return new ProvideContentRequest[i];
    }
}
