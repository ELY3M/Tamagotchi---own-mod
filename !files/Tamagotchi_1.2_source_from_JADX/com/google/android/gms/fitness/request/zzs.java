package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzs implements Creator<ListSubscriptionsRequest> {
    static void zza(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, listSubscriptionsRequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, listSubscriptionsRequest.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfx(i);
    }

    public ListSubscriptionsRequest zzdx(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            IBinder iBinder2;
            DataType dataType2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    DataType dataType3 = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    iBinder2 = iBinder;
                    dataType2 = dataType3;
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    dataType2 = dataType;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new ListSubscriptionsRequest(i, dataType, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ListSubscriptionsRequest[] zzfx(int i) {
        return new ListSubscriptionsRequest[i];
    }
}
