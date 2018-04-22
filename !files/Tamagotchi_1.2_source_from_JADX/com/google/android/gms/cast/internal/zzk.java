package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api.zzc;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public final class zzk {
    public static final zzc<zze> zzUI = new zzc();
    public static final Charset zzaec;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        zzaec = charset;
    }
}
