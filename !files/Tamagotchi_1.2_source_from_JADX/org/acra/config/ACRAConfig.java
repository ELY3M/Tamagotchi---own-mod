package org.acra.config;

import android.support.annotation.NonNull;
import java.io.Serializable;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;

public interface ACRAConfig extends ReportsCrashes, Serializable {
    @NonNull
    Map<String, String> getHttpHeaders();

    @NonNull
    List<ReportField> getReportFields();

    @NonNull
    KeyStore keyStore();
}
