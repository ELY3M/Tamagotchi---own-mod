package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, session.zzlO());
        zzb.zzc(parcel, 1000, session.getVersionCode());
        zzb.zza(parcel, 2, session.zzud());
        zzb.zza(parcel, 3, session.getName(), false);
        zzb.zza(parcel, 4, session.getIdentifier(), false);
        zzb.zza(parcel, 5, session.getDescription(), false);
        zzb.zzc(parcel, 7, session.zzub());
        zzb.zza(parcel, 8, session.zzum(), i, false);
        zzb.zza(parcel, 9, session.zzuw(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfb(i);
    }

    public Session zzdb(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int zzau = zza.zzau(parcel);
        Application application = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    application = (Application) zza.zza(parcel, zzat, Application.CREATOR);
                    break;
                case 9:
                    l = zza.zzj(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Session(i2, j2, j, str3, str2, str, i, application, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Session[] zzfb(int i) {
        return new Session[i];
    }
}
