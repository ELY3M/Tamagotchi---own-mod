package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.GeoPoint;

public class zzh implements Creator<GeoPoint> {
    static void zza(GeoPoint geoPoint, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, geoPoint.versionCode);
        zzb.zza(parcel, 2, geoPoint.lat);
        zzb.zza(parcel, 3, geoPoint.lng);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkA(i);
    }

    public GeoPoint zzhd(Parcel parcel) {
        double d = 0.0d;
        int zzau = zza.zzau(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    d2 = zza.zzn(parcel, zzat);
                    break;
                case 3:
                    d = zza.zzn(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GeoPoint(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GeoPoint[] zzkA(int i) {
        return new GeoPoint[i];
    }
}
