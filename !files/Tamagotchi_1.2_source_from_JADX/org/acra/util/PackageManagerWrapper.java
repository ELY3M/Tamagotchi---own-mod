package org.acra.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import org.acra.ACRA;

public final class PackageManagerWrapper {
    private final Context context;

    public PackageManagerWrapper(@NonNull Context context) {
        this.context = context;
    }

    public boolean hasPermission(@NonNull String permission) {
        PackageManager pm = this.context.getPackageManager();
        if (pm == null) {
            return false;
        }
        try {
            if (pm.checkPermission(permission, this.context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Nullable
    public PackageInfo getPackageInfo() {
        PackageInfo packageInfo = null;
        PackageManager pm = this.context.getPackageManager();
        if (pm != null) {
            try {
                packageInfo = pm.getPackageInfo(this.context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                ACRA.log.mo4050w(ACRA.LOG_TAG, "Failed to find PackageInfo for current App : " + this.context.getPackageName());
            } catch (RuntimeException e2) {
            }
        }
        return packageInfo;
    }
}
