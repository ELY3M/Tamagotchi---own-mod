package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import java.util.List;

public interface zzf<F> {
    F zzB(F f);

    <T> F zzb(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t);

    <T> F zzb(Operator operator, MetadataField<T> metadataField, T t);

    F zzb(Operator operator, List<F> list);

    F zzdj(String str);

    F zze(MetadataField<?> metadataField);

    <T> F zze(MetadataField<T> metadataField, T t);

    F zztP();

    F zztQ();
}
