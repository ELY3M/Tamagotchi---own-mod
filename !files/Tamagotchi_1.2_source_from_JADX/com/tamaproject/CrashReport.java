package com.tamaproject;

import android.app.Application;
import android.content.Context;
import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(reportSenderFactoryClasses = {LogSenderFactory.class})
public class CrashReport extends Application {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ACRA.init(this);
    }
}
