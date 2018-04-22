package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzat extends Thread implements zzas {
    private static zzat zzbjb;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean zzRE = false;
    private final LinkedBlockingQueue<Runnable> zzbja = new LinkedBlockingQueue();
    private volatile zzau zzbjc;

    private zzat(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzat zzaZ(Context context) {
        if (zzbjb == null) {
            zzbjb = new zzat(context);
        }
        return zzbjb;
    }

    private String zzd(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zzbja.take();
                if (!this.zzRE) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzbg.zzaJ(e.toString());
            } catch (Throwable th) {
                zzbg.m11e("Error on Google TagManager Thread: " + zzd(th));
                zzbg.m11e("Google TagManager is shutting down.");
                this.zzRE = true;
            }
        }
    }

    public void zzgg(String str) {
        zzk(str, System.currentTimeMillis());
    }

    public void zzj(Runnable runnable) {
        this.zzbja.add(runnable);
    }

    void zzk(String str, long j) {
        final zzat com_google_android_gms_tagmanager_zzat = this;
        final long j2 = j;
        final String str2 = str;
        zzj(new Runnable(this) {
            final /* synthetic */ zzat zzbjf;

            public void run() {
                if (this.zzbjf.zzbjc == null) {
                    zzcu zzHo = zzcu.zzHo();
                    zzHo.zza(this.zzbjf.mContext, com_google_android_gms_tagmanager_zzat);
                    this.zzbjf.zzbjc = zzHo.zzHr();
                }
                this.zzbjf.zzbjc.zzg(j2, str2);
            }
        });
    }
}
