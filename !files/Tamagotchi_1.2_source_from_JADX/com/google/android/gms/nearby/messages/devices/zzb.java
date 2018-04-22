package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class zzb {
    private final zzc zzbbZ;

    public zzb(byte[] bArr) {
        this.zzbbZ = new zzc(zzu(bArr));
    }

    private static byte[] zzu(byte[] bArr) {
        zzx.zzb(bArr.length == 16, (Object) "Bytes must be a namespace plus instance (16 bytes).");
        return bArr;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzb)) {
            return false;
        }
        return zzw.equal(this.zzbbZ, ((zzb) o).zzbbZ);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbbZ);
    }

    public String toString() {
        return "EddystoneUid{id=" + zzEt() + '}';
    }

    public String zzEt() {
        return this.zzbbZ.zzEt();
    }
}
