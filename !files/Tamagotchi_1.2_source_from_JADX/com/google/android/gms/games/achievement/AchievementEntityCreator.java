package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
    static void zza(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, achievementEntity.getAchievementId(), false);
        zzb.zzc(parcel, 2, achievementEntity.getType());
        zzb.zza(parcel, 3, achievementEntity.getName(), false);
        zzb.zza(parcel, 4, achievementEntity.getDescription(), false);
        zzb.zza(parcel, 5, achievementEntity.getUnlockedImageUri(), i, false);
        zzb.zza(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        zzb.zza(parcel, 7, achievementEntity.getRevealedImageUri(), i, false);
        zzb.zza(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        zzb.zzc(parcel, 9, achievementEntity.zzvK());
        zzb.zza(parcel, 10, achievementEntity.zzvL(), false);
        zzb.zza(parcel, 11, achievementEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 12, achievementEntity.getState());
        zzb.zzc(parcel, 13, achievementEntity.zzvM());
        zzb.zza(parcel, 14, achievementEntity.zzvN(), false);
        zzb.zza(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 16, achievementEntity.getXpValue());
        zzb.zzc(parcel, 1000, achievementEntity.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzee(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgg(i);
    }

    public AchievementEntity zzee(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 6:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    uri2 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 8:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 10:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzat, PlayerEntity.CREATOR);
                    break;
                case 12:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 13:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 14:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 15:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 16:
                    j2 = zza.zzi(parcel, zzat);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AchievementEntity[] zzgg(int i) {
        return new AchievementEntity[i];
    }
}
