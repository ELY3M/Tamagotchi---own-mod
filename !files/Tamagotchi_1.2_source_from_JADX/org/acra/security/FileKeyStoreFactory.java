package org.acra.security;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.acra.ACRA;

public class FileKeyStoreFactory extends BaseKeyStoreFactory {
    private final String filePath;

    public FileKeyStoreFactory(String filePath) {
        this.filePath = filePath;
    }

    public FileKeyStoreFactory(String certificateType, String filePath) {
        super(certificateType);
        this.filePath = filePath;
    }

    public InputStream getInputStream(@NonNull Context context) {
        try {
            return new FileInputStream(this.filePath);
        } catch (FileNotFoundException e) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "", e);
            return null;
        }
    }
}
