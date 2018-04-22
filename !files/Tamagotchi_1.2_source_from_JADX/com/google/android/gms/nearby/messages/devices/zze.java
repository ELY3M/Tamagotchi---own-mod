package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;
import java.nio.ByteBuffer;
import java.util.UUID;

class zze extends zza {
    public zze(byte[] bArr) {
        super(zzu(bArr));
    }

    private static byte[] zzu(byte[] bArr) {
        boolean z = bArr.length == 16 || bArr.length == 18 || bArr.length == 20;
        zzx.zzb(z, (Object) "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        return bArr;
    }

    public String toString() {
        return "IBeaconIdPrefix{proximityUuid=" + zzEu() + ", major=" + zzEx() + ", minor=" + zzEy() + '}';
    }

    public UUID zzEu() {
        ByteBuffer wrap = ByteBuffer.wrap(getBytes());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public Short zzEx() {
        byte[] bytes = getBytes();
        return bytes.length >= 18 ? Short.valueOf(ByteBuffer.wrap(bytes).getShort(16)) : null;
    }

    public Short zzEy() {
        byte[] bytes = getBytes();
        return bytes.length == 20 ? Short.valueOf(ByteBuffer.wrap(bytes).getShort(18)) : null;
    }
}
