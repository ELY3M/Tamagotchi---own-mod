package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;

public class zzj<T extends Parcelable> extends zzb<T> {
    public zzj(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void zza(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), collection instanceof ArrayList ? (ArrayList) collection : new ArrayList(collection));
    }

    protected /* synthetic */ Object zzn(Bundle bundle) {
        return zzs(bundle);
    }

    protected Collection<T> zzs(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
