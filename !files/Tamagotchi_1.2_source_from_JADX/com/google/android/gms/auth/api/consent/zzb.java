package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<GetConsentIntentRequest> {
    static void zza(GetConsentIntentRequest getConsentIntentRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getConsentIntentRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getConsentIntentRequest.getCallingPackage(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, getConsentIntentRequest.getCallingUid());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, getConsentIntentRequest.zzmt(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, getConsentIntentRequest.getAccount(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, getConsentIntentRequest.zzVR, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, getConsentIntentRequest.zzmu());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, getConsentIntentRequest.zzmv());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, getConsentIntentRequest.zzmw(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzay(i);
    }

    public GetConsentIntentRequest zzD(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        boolean z = false;
        ScopeDetail[] scopeDetailArr = null;
        Account account = null;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    break;
                case 6:
                    scopeDetailArr = (ScopeDetail[]) zza.zzb(parcel, zzat, ScopeDetail.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetConsentIntentRequest(i3, str3, i2, str2, account, scopeDetailArr, z, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetConsentIntentRequest[] zzay(int i) {
        return new GetConsentIntentRequest[i];
    }
}
