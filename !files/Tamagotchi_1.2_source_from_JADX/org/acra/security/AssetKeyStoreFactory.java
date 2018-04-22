package org.acra.security;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import org.acra.ACRA;

public class AssetKeyStoreFactory extends BaseKeyStoreFactory {
    private final String assetName;

    public AssetKeyStoreFactory(String assetName) {
        this.assetName = assetName;
    }

    public AssetKeyStoreFactory(String certificateType, String assetName) {
        super(certificateType);
        this.assetName = assetName;
    }

    public InputStream getInputStream(@NonNull Context context) {
        try {
            return context.getAssets().open(this.assetName);
        } catch (IOException e) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "", e);
            return null;
        }
    }
}
