package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzp extends Metadata {
    private final MetadataBundle zzaqB;

    public zzp(MetadataBundle metadataBundle) {
        this.zzaqB = metadataBundle;
    }

    public /* synthetic */ Object freeze() {
        return zzsK();
    }

    public boolean isDataValid() {
        return this.zzaqB != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzaqB + "]";
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzaqB.zza(metadataField);
    }

    public Metadata zzsK() {
        return new zzp(this.zzaqB.zztF());
    }
}
