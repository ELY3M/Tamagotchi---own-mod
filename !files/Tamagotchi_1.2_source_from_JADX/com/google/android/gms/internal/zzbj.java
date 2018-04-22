package com.google.android.gms.internal;

import java.security.MessageDigest;
import org.anddev.andengine.extension.svg.util.constants.ColorUtils;

@zzhb
public class zzbj extends zzbg {
    private MessageDigest zztw;

    byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzk(zzbi.zzx(strArr[i]));
        }
        return bArr;
    }

    byte zzk(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((ColorUtils.COLOR_MASK_32BIT_ARGB_R & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] zzu(String str) {
        byte[] zza = zza(str.split(" "));
        this.zztw = zzcL();
        synchronized (this.zzpV) {
            if (this.zztw == null) {
                zza = new byte[0];
            } else {
                this.zztw.reset();
                this.zztw.update(zza);
                Object digest = this.zztw.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                zza = new byte[i];
                System.arraycopy(digest, 0, zza, 0, zza.length);
            }
        }
        return zza;
    }
}
