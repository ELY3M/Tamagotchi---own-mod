package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void zza(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, snapshotMetadataChangeEntity.getVersionCode());
        zzb.zza(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        zzb.zza(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 5, snapshotMetadataChangeEntity.zzxU(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataChangeEntity.getProgressValue(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgT(i);
    }

    public SnapshotMetadataChangeEntity zzeC(Parcel parcel) {
        Long l = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Uri uri = null;
        BitmapTeleporter bitmapTeleporter = null;
        Long l2 = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    l2 = zza.zzj(parcel, zzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 5:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, zzat, BitmapTeleporter.CREATOR);
                    break;
                case 6:
                    l = zza.zzj(parcel, zzat);
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
            return new SnapshotMetadataChangeEntity(i, str, l2, bitmapTeleporter, uri, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SnapshotMetadataChangeEntity[] zzgT(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
