package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable<String> {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    private final Bundle zzaVS;

    class C04621 implements Iterator<String> {
        Iterator<String> zzaVT = this.zzaVU.zzaVS.keySet().iterator();
        final /* synthetic */ EventParams zzaVU;

        C04621(EventParams eventParams) {
            this.zzaVU = eventParams;
        }

        public boolean hasNext() {
            return this.zzaVT.hasNext();
        }

        public String next() {
            return (String) this.zzaVT.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    EventParams(int versionCode, Bundle bundle) {
        this.versionCode = versionCode;
        this.zzaVS = bundle;
    }

    EventParams(Bundle bundle) {
        zzx.zzz(bundle);
        this.zzaVS = bundle;
        this.versionCode = 1;
    }

    public int describeContents() {
        return 0;
    }

    Object get(String key) {
        return this.zzaVS.get(key);
    }

    public Iterator<String> iterator() {
        return new C04621(this);
    }

    public int size() {
        return this.zzaVS.size();
    }

    public String toString() {
        return this.zzaVS.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    public Bundle zzCC() {
        return new Bundle(this.zzaVS);
    }
}
