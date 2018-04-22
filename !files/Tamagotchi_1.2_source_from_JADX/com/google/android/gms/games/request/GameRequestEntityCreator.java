package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    static void zza(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, gameRequestEntity.getGame(), i, false);
        zzb.zzc(parcel, 1000, gameRequestEntity.getVersionCode());
        zzb.zza(parcel, 2, gameRequestEntity.getSender(), i, false);
        zzb.zza(parcel, 3, gameRequestEntity.getData(), false);
        zzb.zza(parcel, 4, gameRequestEntity.getRequestId(), false);
        zzb.zzc(parcel, 5, gameRequestEntity.getRecipients(), false);
        zzb.zzc(parcel, 7, gameRequestEntity.getType());
        zzb.zza(parcel, 9, gameRequestEntity.getCreationTimestamp());
        zzb.zza(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        zzb.zza(parcel, 11, gameRequestEntity.zzxT(), false);
        zzb.zzc(parcel, 12, gameRequestEntity.getStatus());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzez(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgP(i);
    }

    public GameRequestEntity zzez(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, zzat, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzat, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzat, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 10:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 11:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzat);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GameRequestEntity[] zzgP(int i) {
        return new GameRequestEntity[i];
    }
}
