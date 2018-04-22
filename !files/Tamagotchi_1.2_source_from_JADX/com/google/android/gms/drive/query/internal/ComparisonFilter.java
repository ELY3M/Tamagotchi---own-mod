package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    final Operator zzaug;
    final MetadataBundle zzauh;
    final MetadataField<T> zzaui;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzaug = operator;
        this.zzauh = value;
        this.zzaui = zze.zza(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.zzb(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzauh.zza(this.zzaui);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzb(this.zzaug, this.zzaui, getValue());
    }
}
