package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzaa implements Creator<SessionStartRequest> {
    static void zza(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sessionStartRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionStartRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStartRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfG(i);
    }

    public SessionStartRequest zzdF(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            IBinder iBinder2;
            Session session2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    iBinder2 = iBinder;
                    session2 = session3;
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new SessionStartRequest(i, session, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SessionStartRequest[] zzfG(int i) {
        return new SessionStartRequest[i];
    }
}
