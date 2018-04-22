package org.acra.log;

import android.util.Log;

public final class AndroidLogDelegate implements ACRALog {
    public int mo4048v(String tag, String msg) {
        return Log.v(tag, msg);
    }

    public int mo4049v(String tag, String msg, Throwable tr) {
        return Log.v(tag, msg, tr);
    }

    public int mo4041d(String tag, String msg) {
        return Log.d(tag, msg);
    }

    public int mo4042d(String tag, String msg, Throwable tr) {
        return Log.d(tag, msg, tr);
    }

    public int mo4046i(String tag, String msg) {
        return Log.i(tag, msg);
    }

    public int mo4047i(String tag, String msg, Throwable tr) {
        return Log.i(tag, msg, tr);
    }

    public int mo4050w(String tag, String msg) {
        return Log.w(tag, msg);
    }

    public int mo4051w(String tag, String msg, Throwable tr) {
        return Log.w(tag, msg, tr);
    }

    public int mo4052w(String tag, Throwable tr) {
        return Log.w(tag, tr);
    }

    public int mo4043e(String tag, String msg) {
        return Log.e(tag, msg);
    }

    public int mo4044e(String tag, String msg, Throwable tr) {
        return Log.e(tag, msg, tr);
    }

    public String getStackTraceString(Throwable tr) {
        return Log.getStackTraceString(tr);
    }
}
