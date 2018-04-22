package org.anddev.andengine.util;

import android.util.Log;
import org.anddev.andengine.util.constants.Constants;

public class Debug implements Constants {
    private static DebugLevel sDebugLevel = DebugLevel.VERBOSE;
    private static String sDebugTag = Constants.DEBUGTAG;

    public enum DebugLevel implements Comparable<DebugLevel> {
        NONE,
        ERROR,
        WARNING,
        INFO,
        DEBUG,
        VERBOSE;
        
        public static DebugLevel ALL;

        static {
            ALL = VERBOSE;
        }

        private boolean isSameOrLessThan(DebugLevel pDebugLevel) {
            return compareTo(pDebugLevel) >= 0;
        }
    }

    public static String getDebugTag() {
        return sDebugTag;
    }

    public static void setDebugTag(String pDebugTag) {
        sDebugTag = pDebugTag;
    }

    public static DebugLevel getDebugLevel() {
        return sDebugLevel;
    }

    public static void setDebugLevel(DebugLevel pDebugLevel) {
        if (pDebugLevel == null) {
            throw new IllegalArgumentException("pDebugLevel must not be null!");
        }
        sDebugLevel = pDebugLevel;
    }

    public static void m66v(String pMessage) {
        m67v(pMessage, null);
    }

    public static void m67v(String pMessage, Throwable pThrowable) {
        if (sDebugLevel.isSameOrLessThan(DebugLevel.VERBOSE)) {
            Log.v(sDebugTag, pMessage, pThrowable);
        }
    }

    public static void m59d(String pMessage) {
        m60d(pMessage, null);
    }

    public static void m60d(String pMessage, Throwable pThrowable) {
        if (sDebugLevel.isSameOrLessThan(DebugLevel.DEBUG)) {
            Log.d(sDebugTag, pMessage, pThrowable);
        }
    }

    public static void m64i(String pMessage) {
        m65i(pMessage, null);
    }

    public static void m65i(String pMessage, Throwable pThrowable) {
        if (sDebugLevel.isSameOrLessThan(DebugLevel.INFO)) {
            Log.i(sDebugTag, pMessage, pThrowable);
        }
    }

    public static void m68w(String pMessage) {
        m69w(pMessage, null);
    }

    public static void m70w(Throwable pThrowable) {
        m69w("", pThrowable);
    }

    public static void m69w(String pMessage, Throwable pThrowable) {
        if (!sDebugLevel.isSameOrLessThan(DebugLevel.WARNING)) {
            return;
        }
        if (pThrowable == null) {
            Log.w(sDebugTag, pMessage, new Exception());
        } else {
            Log.w(sDebugTag, pMessage, pThrowable);
        }
    }

    public static void m61e(String pMessage) {
        m62e(pMessage, null);
    }

    public static void m63e(Throwable pThrowable) {
        m62e(sDebugTag, pThrowable);
    }

    public static void m62e(String pMessage, Throwable pThrowable) {
        if (!sDebugLevel.isSameOrLessThan(DebugLevel.ERROR)) {
            return;
        }
        if (pThrowable == null) {
            Log.e(sDebugTag, pMessage, new Exception());
        } else {
            Log.e(sDebugTag, pMessage, pThrowable);
        }
    }
}
