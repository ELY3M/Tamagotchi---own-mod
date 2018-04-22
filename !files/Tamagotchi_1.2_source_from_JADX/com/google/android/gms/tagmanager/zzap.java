package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzap extends zzak {
    private static final String ID = zzad.HASH.toString();
    private static final String zzbiQ = zzae.ARG0.toString();
    private static final String zzbiS = zzae.INPUT_FORMAT.toString();
    private static final String zzbiW = zzae.ALGORITHM.toString();

    public zzap() {
        super(ID, zzbiQ);
    }

    private byte[] zzg(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean zzFW() {
        return true;
    }

    public zza zzP(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbiQ);
        if (com_google_android_gms_internal_zzag_zza == null || com_google_android_gms_internal_zzag_zza == zzdf.zzHF()) {
            return zzdf.zzHF();
        }
        byte[] bytes;
        String zzg = zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbiW);
        String zzg2 = com_google_android_gms_internal_zzag_zza == null ? "MD5" : zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbiS);
        String zzg3 = com_google_android_gms_internal_zzag_zza == null ? "text" : zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        if ("text".equals(zzg3)) {
            bytes = zzg.getBytes();
        } else if ("base16".equals(zzg3)) {
            bytes = zzk.zzfO(zzg);
        } else {
            zzbg.m11e("Hash: unknown input format: " + zzg3);
            return zzdf.zzHF();
        }
        try {
            return zzdf.zzR(zzk.zzj(zzg(zzg2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            zzbg.m11e("Hash: unknown algorithm: " + zzg2);
            return zzdf.zzHF();
        }
    }
}
