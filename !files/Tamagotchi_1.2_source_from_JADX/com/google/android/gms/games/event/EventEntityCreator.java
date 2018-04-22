package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(EventEntity eventEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, eventEntity.getEventId(), false);
        zzb.zzc(parcel, 1000, eventEntity.getVersionCode());
        zzb.zza(parcel, 2, eventEntity.getName(), false);
        zzb.zza(parcel, 3, eventEntity.getDescription(), false);
        zzb.zza(parcel, 4, eventEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 5, eventEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 6, eventEntity.getPlayer(), i, false);
        zzb.zza(parcel, 7, eventEntity.getValue());
        zzb.zza(parcel, 8, eventEntity.getFormattedValue(), false);
        zzb.zza(parcel, 9, eventEntity.isVisible());
        zzb.zzI(parcel, zzav);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    player = (PlayerEntity) zza.zza(parcel, zzat, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
