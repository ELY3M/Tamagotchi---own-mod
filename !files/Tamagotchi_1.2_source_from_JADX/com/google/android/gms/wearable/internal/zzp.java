package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzp extends InputStream {
    private final InputStream zzbsj;
    private volatile zzm zzbsk;

    class C08831 implements zzu {
        final /* synthetic */ zzp zzbsl;

        C08831(zzp com_google_android_gms_wearable_internal_zzp) {
            this.zzbsl = com_google_android_gms_wearable_internal_zzp;
        }

        public void zzb(zzm com_google_android_gms_wearable_internal_zzm) {
            this.zzbsl.zza(com_google_android_gms_wearable_internal_zzm);
        }
    }

    public zzp(InputStream inputStream) {
        this.zzbsj = (InputStream) zzx.zzz(inputStream);
    }

    private int zzlK(int i) throws ChannelIOException {
        if (i == -1) {
            zzm com_google_android_gms_wearable_internal_zzm = this.zzbsk;
            if (com_google_android_gms_wearable_internal_zzm != null) {
                throw new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzm.zzbsa, com_google_android_gms_wearable_internal_zzm.zzbsb);
            }
        }
        return i;
    }

    public int available() throws IOException {
        return this.zzbsj.available();
    }

    public void close() throws IOException {
        this.zzbsj.close();
    }

    public void mark(int readlimit) {
        this.zzbsj.mark(readlimit);
    }

    public boolean markSupported() {
        return this.zzbsj.markSupported();
    }

    public int read() throws IOException {
        return zzlK(this.zzbsj.read());
    }

    public int read(byte[] buffer) throws IOException {
        return zzlK(this.zzbsj.read(buffer));
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzlK(this.zzbsj.read(buffer, byteOffset, byteCount));
    }

    public void reset() throws IOException {
        this.zzbsj.reset();
    }

    public long skip(long byteCount) throws IOException {
        return this.zzbsj.skip(byteCount);
    }

    zzu zzIJ() {
        return new C08831(this);
    }

    void zza(zzm com_google_android_gms_wearable_internal_zzm) {
        this.zzbsk = (zzm) zzx.zzz(com_google_android_gms_wearable_internal_zzm);
    }
}
