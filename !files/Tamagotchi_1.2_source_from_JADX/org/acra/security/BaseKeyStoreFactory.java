package org.acra.security;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.InputStream;

public abstract class BaseKeyStoreFactory implements KeyStoreFactory {
    private final String certificateType;

    public abstract InputStream getInputStream(@NonNull Context context);

    public BaseKeyStoreFactory() {
        this("X.509");
    }

    public BaseKeyStoreFactory(String certificateType) {
        this.certificateType = certificateType;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    public final java.security.KeyStore create(@android.support.annotation.NonNull android.content.Context r11) {
        /*
        r10 = this;
        r6 = 0;
        r4 = r10.getInputStream(r11);
        if (r4 == 0) goto L_0x0044;
    L_0x0007:
        r0 = new java.io.BufferedInputStream;
        r0.<init>(r4);
        r7 = r10.certificateType;	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r2 = java.security.cert.CertificateFactory.getInstance(r7);	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r1 = r2.generateCertificate(r0);	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r7 = java.security.KeyStore.getDefaultType();	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r5 = java.security.KeyStore.getInstance(r7);	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r7 = 0;
        r8 = 0;
        r5.load(r7, r8);	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r7 = "ca";
        r5.setCertificateEntry(r7, r1);	 Catch:{ CertificateException -> 0x0037, KeyStoreException -> 0x0051, NoSuchAlgorithmException -> 0x006a, IOException -> 0x0083 }
        r0.close();	 Catch:{ IOException -> 0x002c }
    L_0x002b:
        return r5;
    L_0x002c:
        r3 = move-exception;
        r6 = org.acra.ACRA.log;
        r7 = org.acra.ACRA.LOG_TAG;
        r8 = "";
        r6.mo4044e(r7, r8, r3);
        goto L_0x002b;
    L_0x0037:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;	 Catch:{ all -> 0x009c }
        r8 = org.acra.ACRA.LOG_TAG;	 Catch:{ all -> 0x009c }
        r9 = "";
        r7.mo4044e(r8, r9, r3);	 Catch:{ all -> 0x009c }
        r0.close();	 Catch:{ IOException -> 0x0046 }
    L_0x0044:
        r5 = r6;
        goto L_0x002b;
    L_0x0046:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;
        r8 = org.acra.ACRA.LOG_TAG;
        r9 = "";
        r7.mo4044e(r8, r9, r3);
        goto L_0x0044;
    L_0x0051:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;	 Catch:{ all -> 0x009c }
        r8 = org.acra.ACRA.LOG_TAG;	 Catch:{ all -> 0x009c }
        r9 = "";
        r7.mo4044e(r8, r9, r3);	 Catch:{ all -> 0x009c }
        r0.close();	 Catch:{ IOException -> 0x005f }
        goto L_0x0044;
    L_0x005f:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;
        r8 = org.acra.ACRA.LOG_TAG;
        r9 = "";
        r7.mo4044e(r8, r9, r3);
        goto L_0x0044;
    L_0x006a:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;	 Catch:{ all -> 0x009c }
        r8 = org.acra.ACRA.LOG_TAG;	 Catch:{ all -> 0x009c }
        r9 = "";
        r7.mo4044e(r8, r9, r3);	 Catch:{ all -> 0x009c }
        r0.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x0044;
    L_0x0078:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;
        r8 = org.acra.ACRA.LOG_TAG;
        r9 = "";
        r7.mo4044e(r8, r9, r3);
        goto L_0x0044;
    L_0x0083:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;	 Catch:{ all -> 0x009c }
        r8 = org.acra.ACRA.LOG_TAG;	 Catch:{ all -> 0x009c }
        r9 = "";
        r7.mo4044e(r8, r9, r3);	 Catch:{ all -> 0x009c }
        r0.close();	 Catch:{ IOException -> 0x0091 }
        goto L_0x0044;
    L_0x0091:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;
        r8 = org.acra.ACRA.LOG_TAG;
        r9 = "";
        r7.mo4044e(r8, r9, r3);
        goto L_0x0044;
    L_0x009c:
        r6 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x00a1 }
    L_0x00a0:
        throw r6;
    L_0x00a1:
        r3 = move-exception;
        r7 = org.acra.ACRA.log;
        r8 = org.acra.ACRA.LOG_TAG;
        r9 = "";
        r7.mo4044e(r8, r9, r3);
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.security.BaseKeyStoreFactory.create(android.content.Context):java.security.KeyStore");
    }
}
