package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

public class zze implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, completionEvent.mVersionCode);
        zzb.zza(parcel, 2, completionEvent.zzaoz, i, false);
        zzb.zza(parcel, 3, completionEvent.zzVa, false);
        zzb.zza(parcel, 4, completionEvent.zzapD, i, false);
        zzb.zza(parcel, 5, completionEvent.zzapE, i, false);
        zzb.zza(parcel, 6, completionEvent.zzapF, i, false);
        zzb.zzb(parcel, 7, completionEvent.zzapG, false);
        zzb.zzc(parcel, 8, completionEvent.zzBc);
        zzb.zza(parcel, 9, completionEvent.zzapH, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcH(i);
    }

    public CompletionEvent zzaS(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 7:
                    list = zza.zzD(parcel, zzat);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CompletionEvent[] zzcH(int i) {
        return new CompletionEvent[i];
    }
}
