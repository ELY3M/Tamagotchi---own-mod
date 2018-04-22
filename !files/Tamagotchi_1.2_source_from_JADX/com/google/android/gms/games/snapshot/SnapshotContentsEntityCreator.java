package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    static void zza(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, snapshotContentsEntity.zzsx(), i, false);
        zzb.zzc(parcel, 1000, snapshotContentsEntity.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgR(i);
    }

    public SnapshotContentsEntity zzeA(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    contents = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
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
            return new SnapshotContentsEntity(i, contents);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SnapshotContentsEntity[] zzgR(int i) {
        return new SnapshotContentsEntity[i];
    }
}
