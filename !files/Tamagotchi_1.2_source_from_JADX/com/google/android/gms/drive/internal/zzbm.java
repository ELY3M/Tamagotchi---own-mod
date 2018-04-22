package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbm implements Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzapg, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzaph, false);
        zzb.zza(parcel, 4, openFileIntentSenderRequest.zzapj, i, false);
        zzb.zza(parcel, 5, openFileIntentSenderRequest.zzasz, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdJ(i);
    }

    public OpenFileIntentSenderRequest zzbO(Parcel parcel) {
        FilterHolder filterHolder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 5:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzat, FilterHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OpenFileIntentSenderRequest[] zzdJ(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
