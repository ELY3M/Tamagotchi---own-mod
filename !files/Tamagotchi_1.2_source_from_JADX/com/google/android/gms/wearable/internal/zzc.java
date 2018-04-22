package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<AddListenerRequest> {
    static void zza(AddListenerRequest addListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, addListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, addListenerRequest.zzIy(), false);
        zzb.zza(parcel, 3, addListenerRequest.zzbrC, i, false);
        zzb.zza(parcel, 4, addListenerRequest.zzbrD, false);
        zzb.zza(parcel, 5, addListenerRequest.zzbrE, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzia(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlB(i);
    }

    public AddListenerRequest zzia(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) zza.zzb(parcel, zzat, IntentFilter.CREATOR);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AddListenerRequest(i, iBinder, intentFilterArr, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AddListenerRequest[] zzlB(int i) {
        return new AddListenerRequest[i];
    }
}
