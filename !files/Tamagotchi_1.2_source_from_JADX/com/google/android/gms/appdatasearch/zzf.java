package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<Request> {
    static void zza(Request request, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, request.zzTT, i, false);
        zzb.zzc(parcel, 1000, request.mVersionCode);
        zzb.zza(parcel, 2, request.zzTU);
        zzb.zza(parcel, 3, request.zzTV);
        zzb.zza(parcel, 4, request.zzTW);
        zzb.zza(parcel, 5, request.zzTX, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzam(i);
    }

    public Request[] zzam(int i) {
        return new Request[i];
    }

    public Request zzv(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
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
            return new Request(i, account, z3, z2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
