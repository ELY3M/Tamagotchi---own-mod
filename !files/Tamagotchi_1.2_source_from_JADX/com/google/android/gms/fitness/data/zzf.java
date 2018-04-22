package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataSource.getDataType(), i, false);
        zzb.zzc(parcel, 1000, dataSource.getVersionCode());
        zzb.zza(parcel, 2, dataSource.getName(), false);
        zzb.zzc(parcel, 3, dataSource.getType());
        zzb.zza(parcel, 4, dataSource.getDevice(), i, false);
        zzb.zza(parcel, 5, dataSource.zzum(), i, false);
        zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeR(i);
    }

    public DataSource zzcS(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        Application application = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    device = (Device) zza.zza(parcel, zzat, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) zza.zza(parcel, zzat, Application.CREATOR);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
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
            return new DataSource(i2, dataType, str2, i, device, application, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSource[] zzeR(int i) {
        return new DataSource[i];
    }
}
