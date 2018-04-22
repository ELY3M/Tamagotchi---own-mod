package org.acra.collector;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.Reader;

public final class CollectorUtil {
    private CollectorUtil() {
    }

    public static void safeClose(@Nullable Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }
}
