package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    static void zza(QuestEntity questEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, questEntity.getGame(), i, false);
        zzb.zza(parcel, 2, questEntity.getQuestId(), false);
        zzb.zza(parcel, 3, questEntity.getAcceptedTimestamp());
        zzb.zza(parcel, 4, questEntity.getBannerImageUri(), i, false);
        zzb.zza(parcel, 5, questEntity.getBannerImageUrl(), false);
        zzb.zza(parcel, 6, questEntity.getDescription(), false);
        zzb.zza(parcel, 7, questEntity.getEndTimestamp());
        zzb.zza(parcel, 8, questEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 9, questEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 10, questEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, questEntity.getName(), false);
        zzb.zza(parcel, 13, questEntity.zzxS());
        zzb.zza(parcel, 14, questEntity.getStartTimestamp());
        zzb.zzc(parcel, 15, questEntity.getState());
        zzb.zzc(parcel, 17, questEntity.zzxR(), false);
        zzb.zzc(parcel, 16, questEntity.getType());
        zzb.zzc(parcel, 1000, questEntity.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzey(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgO(i);
    }

    public QuestEntity zzey(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, zzat, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 9:
                    uri2 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 10:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 12:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 13:
                    j4 = zza.zzi(parcel, zzat);
                    break;
                case 14:
                    j5 = zza.zzi(parcel, zzat);
                    break;
                case 15:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 16:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 17:
                    arrayList = zza.zzc(parcel, zzat, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public QuestEntity[] zzgO(int i) {
        return new QuestEntity[i];
    }
}
