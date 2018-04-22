package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzp extends zza<String> {
    public zzp(String str, int i) {
        super(str, i);
    }

    protected /* synthetic */ void zza(Bundle bundle, Object obj) {
        zzd(bundle, (String) obj);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzi(dataHolder, i, i2);
    }

    protected void zzd(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected String zzi(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzd(getName(), i, i2);
    }

    protected /* synthetic */ Object zzn(Bundle bundle) {
        return zzu(bundle);
    }

    protected String zzu(Bundle bundle) {
        return bundle.getString(getName());
    }
}
