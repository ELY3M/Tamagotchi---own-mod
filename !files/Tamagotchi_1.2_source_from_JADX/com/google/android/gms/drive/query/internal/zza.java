package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zza implements Creator<ComparisonFilter> {
    static void zza(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, comparisonFilter.mVersionCode);
        zzb.zza(parcel, 1, comparisonFilter.zzaug, i, false);
        zzb.zza(parcel, 2, comparisonFilter.zzauh, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeg(i);
    }

    public ComparisonFilter zzcl(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case 2:
                    metadataBundle2 = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzau) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ComparisonFilter[] zzeg(int i) {
        return new ComparisonFilter[i];
    }
}
