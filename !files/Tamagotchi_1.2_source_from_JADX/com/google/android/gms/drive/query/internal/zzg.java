package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg implements zzf<Boolean> {
    private Boolean zzaut = Boolean.valueOf(false);

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        return filter == null ? false : ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    public /* synthetic */ Object zzB(Object obj) {
        return zzd((Boolean) obj);
    }

    public /* synthetic */ Object zzb(zzb com_google_android_gms_drive_metadata_zzb, Object obj) {
        return zzc(com_google_android_gms_drive_metadata_zzb, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, MetadataField metadataField, Object obj) {
        return zzc(operator, metadataField, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, List list) {
        return zzc(operator, list);
    }

    public <T> Boolean zzc(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t) {
        return this.zzaut;
    }

    public <T> Boolean zzc(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzaut;
    }

    public Boolean zzc(Operator operator, List<Boolean> list) {
        return this.zzaut;
    }

    public Boolean zzd(Boolean bool) {
        return this.zzaut;
    }

    public /* synthetic */ Object zzdj(String str) {
        return zzdk(str);
    }

    public Boolean zzdk(String str) {
        if (!str.isEmpty()) {
            this.zzaut = Boolean.valueOf(true);
        }
        return this.zzaut;
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzf(metadataField);
    }

    public /* synthetic */ Object zze(MetadataField metadataField, Object obj) {
        return zzf(metadataField, obj);
    }

    public Boolean zzf(MetadataField<?> metadataField) {
        return this.zzaut;
    }

    public <T> Boolean zzf(MetadataField<T> metadataField, T t) {
        return this.zzaut;
    }

    public /* synthetic */ Object zztP() {
        return zztS();
    }

    public /* synthetic */ Object zztQ() {
        return zztR();
    }

    public Boolean zztR() {
        return this.zzaut;
    }

    public Boolean zztS() {
        return this.zzaut;
    }
}
