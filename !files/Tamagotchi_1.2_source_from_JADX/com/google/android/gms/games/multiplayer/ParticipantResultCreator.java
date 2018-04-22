package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    static void zza(ParticipantResult participantResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, participantResult.getParticipantId(), false);
        zzb.zzc(parcel, 1000, participantResult.getVersionCode());
        zzb.zzc(parcel, 2, participantResult.getResult());
        zzb.zzc(parcel, 3, participantResult.getPlacing());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzet(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgJ(i);
    }

    public ParticipantResult zzet(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
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
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParticipantResult[] zzgJ(int i) {
        return new ParticipantResult[i];
    }
}
