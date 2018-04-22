package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzb.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, playerEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzb.zzc(parcel, 6, playerEntity.zzvG());
        zzb.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzb.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 14, playerEntity.getTitle(), false);
        zzb.zza(parcel, 15, playerEntity.zzvI(), i, false);
        zzb.zza(parcel, 16, playerEntity.getLevelInfo(), i, false);
        zzb.zzc(parcel, 1000, playerEntity.getVersionCode());
        zzb.zza(parcel, 19, playerEntity.zzvF());
        zzb.zza(parcel, 18, playerEntity.zzvH());
        zzb.zza(parcel, 21, playerEntity.getName(), false);
        zzb.zza(parcel, 20, playerEntity.zzvE(), false);
        zzb.zza(parcel, 23, playerEntity.getBannerImageLandscapeUrl(), false);
        zzb.zza(parcel, 22, playerEntity.getBannerImageLandscapeUri(), i, false);
        zzb.zza(parcel, 25, playerEntity.getBannerImagePortraitUrl(), false);
        zzb.zza(parcel, 24, playerEntity.getBannerImagePortraitUri(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgd(i);
    }

    public PlayerEntity zzeb(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
        String str6 = null;
        String str7 = null;
        Uri uri3 = null;
        String str8 = null;
        Uri uri4 = null;
        String str9 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 14:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zza.zza(parcel, zzat, (Creator) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) zza.zza(parcel, zzat, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 19:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 20:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 21:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 22:
                    uri3 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 23:
                    str8 = zza.zzp(parcel, zzat);
                    break;
                case 24:
                    uri4 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 25:
                    str9 = zza.zzp(parcel, zzat);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2, str6, str7, uri3, str8, uri4, str9);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayerEntity[] zzgd(int i) {
        return new PlayerEntity[i];
    }
}
