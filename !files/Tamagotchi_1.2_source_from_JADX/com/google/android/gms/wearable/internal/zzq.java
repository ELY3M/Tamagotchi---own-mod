package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzq extends OutputStream {
    private volatile zzm zzbsk;
    private final OutputStream zzbsm;

    class C08841 implements zzu {
        final /* synthetic */ zzq zzbsn;

        C08841(zzq com_google_android_gms_wearable_internal_zzq) {
            this.zzbsn = com_google_android_gms_wearable_internal_zzq;
        }

        public void zzb(zzm com_google_android_gms_wearable_internal_zzm) {
            this.zzbsn.zzc(com_google_android_gms_wearable_internal_zzm);
        }
    }

    public zzq(OutputStream outputStream) {
        this.zzbsm = (OutputStream) zzx.zzz(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzm com_google_android_gms_wearable_internal_zzm = this.zzbsk;
        if (com_google_android_gms_wearable_internal_zzm == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzm.zzbsa, com_google_android_gms_wearable_internal_zzm.zzbsb);
    }

    public void close() throws IOException {
        try {
            this.zzbsm.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzbsm.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzbsm.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer) throws IOException {
        try {
            this.zzbsm.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzbsm.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzu zzIJ() {
        return new C08841(this);
    }

    void zzc(zzm com_google_android_gms_wearable_internal_zzm) {
        this.zzbsk = com_google_android_gms_wearable_internal_zzm;
    }
}
