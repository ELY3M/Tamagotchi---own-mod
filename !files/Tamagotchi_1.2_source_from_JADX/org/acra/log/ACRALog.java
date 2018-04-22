package org.acra.log;

import android.support.annotation.Nullable;

public interface ACRALog {
    int mo4041d(String str, String str2);

    int mo4042d(String str, String str2, Throwable th);

    int mo4043e(String str, String str2);

    int mo4044e(String str, String str2, Throwable th);

    @Nullable
    String getStackTraceString(Throwable th);

    int mo4046i(String str, String str2);

    int mo4047i(String str, String str2, Throwable th);

    int mo4048v(String str, String str2);

    int mo4049v(String str, String str2, Throwable th);

    int mo4050w(String str, String str2);

    int mo4051w(String str, String str2, Throwable th);

    int mo4052w(String str, Throwable th);
}
