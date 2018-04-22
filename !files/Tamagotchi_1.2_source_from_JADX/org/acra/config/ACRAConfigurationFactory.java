package org.acra.config;

import android.app.Application;
import android.support.annotation.NonNull;

public final class ACRAConfigurationFactory {
    @NonNull
    public ACRAConfiguration create(@NonNull Application app) {
        return new ConfigurationBuilder(app).build();
    }
}
