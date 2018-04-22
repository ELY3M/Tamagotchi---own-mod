package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, bucket.zzlO());
        zzb.zzc(parcel, 1000, bucket.getVersionCode());
        zzb.zza(parcel, 2, bucket.zzud());
        zzb.zza(parcel, 3, bucket.getSession(), i, false);
        zzb.zzc(parcel, 4, bucket.zzub());
        zzb.zzc(parcel, 5, bucket.getDataSets(), false);
        zzb.zzc(parcel, 6, bucket.getBucketType());
        zzb.zza(parcel, 7, bucket.zzuc());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeN(i);
    }

    public Bucket zzcP(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
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
                    session = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzat, DataSet.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
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
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Bucket[] zzeN(int i) {
        return new Bucket[i];
    }
}
