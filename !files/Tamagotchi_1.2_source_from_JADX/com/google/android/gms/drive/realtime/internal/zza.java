package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BeginCompoundOperationRequest> {
    static void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, beginCompoundOperationRequest.mVersionCode);
        zzb.zza(parcel, 2, beginCompoundOperationRequest.zzauG);
        zzb.zza(parcel, 3, beginCompoundOperationRequest.mName, false);
        zzb.zza(parcel, 4, beginCompoundOperationRequest.zzauH);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzes(i);
    }

    public BeginCompoundOperationRequest zzcx(Parcel parcel) {
        boolean z = false;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public BeginCompoundOperationRequest[] zzes(int i) {
        return new BeginCompoundOperationRequest[i];
    }
}
