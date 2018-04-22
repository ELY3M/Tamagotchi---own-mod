package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<DataUpdateListenerUnregistrationRequest> {
    static void zza(DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataUpdateListenerUnregistrationRequest.getIntent(), i, false);
        zzb.zzc(parcel, 1000, dataUpdateListenerUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, dataUpdateListenerUnregistrationRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfr(i);
    }

    public DataUpdateListenerUnregistrationRequest zzdr(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            IBinder iBinder2;
            PendingIntent pendingIntent2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    PendingIntent pendingIntent3 = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
            }
            i = i2;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new DataUpdateListenerUnregistrationRequest(i, pendingIntent, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataUpdateListenerUnregistrationRequest[] zzfr(int i) {
        return new DataUpdateListenerUnregistrationRequest[i];
    }
}
