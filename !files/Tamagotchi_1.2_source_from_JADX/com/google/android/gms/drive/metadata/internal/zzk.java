package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzk<T extends Parcelable> extends zza<T> {
    public zzk(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void zza(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object zzn(Bundle bundle) {
        return zzt(bundle);
    }

    protected T zzt(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
