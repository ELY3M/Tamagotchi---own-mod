package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class zzx implements Creator<SessionInsertRequest> {
    static void zza(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sessionInsertRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionInsertRequest.getVersionCode());
        zzb.zzc(parcel, 2, sessionInsertRequest.getDataSets(), false);
        zzb.zzc(parcel, 3, sessionInsertRequest.getAggregateDataPoints(), false);
        zzb.zza(parcel, 4, sessionInsertRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfD(i);
    }

    public SessionInsertRequest zzdC(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        Session session = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    session = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzat, DataSet.CREATOR);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, DataPoint.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzq(parcel, zzat);
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
            return new SessionInsertRequest(i, session, list2, list, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SessionInsertRequest[] zzfD(int i) {
        return new SessionInsertRequest[i];
    }
}
