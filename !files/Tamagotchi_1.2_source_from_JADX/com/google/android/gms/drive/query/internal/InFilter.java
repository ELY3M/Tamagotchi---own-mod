package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final zzb<T> zzauu;

    InFilter(int versionCode, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzauh = value;
        this.zzauu = (zzb) zze.zza(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.zzb(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.zzauh.zza(this.zzauu)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzb(this.zzauu, getValue());
    }
}
