package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;
import java.util.List;

public class zzh implements Creator<ListSubscriptionsResult> {
    static void zza(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        zzb.zzc(parcel, 1000, listSubscriptionsResult.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsResult.getStatus(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfV(i);
    }

    public ListSubscriptionsResult zzdU(Parcel parcel) {
        Status status = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    list = zza.zzc(parcel, zzat, Subscription.CREATOR);
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ListSubscriptionsResult[] zzfV(int i) {
        return new ListSubscriptionsResult[i];
    }
}
