package org.acra.builder;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.acra.dialog.BaseCrashReportDialog;

public final class LastActivityManager {
    @NonNull
    private WeakReference<Activity> lastActivityCreated = new WeakReference(null);

    class C05851 implements ActivityLifecycleCallbacks {
        C05851() {
        }

        public void onActivityCreated(@NonNull Activity activity, Bundle savedInstanceState) {
            if (!(activity instanceof BaseCrashReportDialog)) {
                LastActivityManager.this.lastActivityCreated = new WeakReference(activity);
            }
        }

        public void onActivityStarted(@NonNull Activity activity) {
        }

        public void onActivityResumed(@NonNull Activity activity) {
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityStopped(@NonNull Activity activity) {
        }

        public void onActivitySaveInstanceState(@NonNull Activity activity, Bundle outState) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
        }
    }

    public LastActivityManager(@NonNull Application application) {
        if (VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new C05851());
        }
    }

    @Nullable
    public Activity getLastActivity() {
        return (Activity) this.lastActivityCreated.get();
    }

    public void clearLastActivity() {
        this.lastActivityCreated.clear();
    }
}
