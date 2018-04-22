package org.acra.util;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;
import org.acra.ACRA;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public final class Installation {
    private static final String INSTALLATION = "ACRA-INSTALLATION";
    private static String sID;

    private Installation() {
    }

    @NonNull
    public static synchronized String id(@NonNull Context context) {
        String str;
        synchronized (Installation.class) {
            if (sID == null) {
                File installation = new File(context.getFilesDir(), INSTALLATION);
                try {
                    if (!installation.exists()) {
                        writeInstallationFile(installation);
                    }
                    sID = readInstallationFile(installation);
                } catch (IOException e) {
                    ACRA.log.mo4051w(ACRA.LOG_TAG, "Couldn't retrieve InstallationId for " + context.getPackageName(), e);
                    str = "Couldn't retrieve InstallationId";
                } catch (RuntimeException e2) {
                    ACRA.log.mo4051w(ACRA.LOG_TAG, "Couldn't retrieve InstallationId for " + context.getPackageName(), e2);
                    str = "Couldn't retrieve InstallationId";
                }
            }
            str = sID;
        }
        return str;
    }

    @NonNull
    private static String readInstallationFile(@NonNull File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, ISVGConstants.ATTRIBUTE_RADIUS);
        byte[] bytes = new byte[((int) f.length())];
        try {
            f.readFully(bytes);
            return new String(bytes);
        } finally {
            f.close();
        }
    }

    private static void writeInstallationFile(@NonNull File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        try {
            out.write(UUID.randomUUID().toString().getBytes());
        } finally {
            out.close();
        }
    }
}
