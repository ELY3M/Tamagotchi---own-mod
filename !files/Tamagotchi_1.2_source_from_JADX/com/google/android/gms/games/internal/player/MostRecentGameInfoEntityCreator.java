package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, mostRecentGameInfoEntity.zzxy(), false);
        zzb.zzc(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        zzb.zza(parcel, 2, mostRecentGameInfoEntity.zzxz(), false);
        zzb.zza(parcel, 3, mostRecentGameInfoEntity.zzxA());
        zzb.zza(parcel, 4, mostRecentGameInfoEntity.zzxB(), i, false);
        zzb.zza(parcel, 5, mostRecentGameInfoEntity.zzxC(), i, false);
        zzb.zza(parcel, 6, mostRecentGameInfoEntity.zzxD(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzep(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgE(i);
    }

    public MostRecentGameInfoEntity zzep(Parcel parcel) {
        Uri uri = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    uri3 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MostRecentGameInfoEntity[] zzgE(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
