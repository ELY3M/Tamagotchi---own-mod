package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR = new zzb();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final MetadataField<?> zzaui;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzauh = value;
        this.zzaui = zze.zza(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.zzb(field, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> com_google_android_gms_drive_query_internal_zzf_T) {
        return com_google_android_gms_drive_query_internal_zzf_T.zze(this.zzaui);
    }
}
