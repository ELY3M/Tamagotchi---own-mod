package com.github.anrwatchdog;

import android.os.Looper;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ANRError extends Error {
    private static final long serialVersionUID = 1;

    private ANRError(_Thread st) {
        super("Application Not Responding", st);
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    static ANRError New(String prefix, boolean logThreadsWithoutStackTrace) {
        final Thread mainThread = Looper.getMainLooper().getThread();
        Map<Thread, StackTraceElement[]> stackTraces = new TreeMap(new Comparator<Thread>() {
            public int compare(Thread lhs, Thread rhs) {
                if (lhs == rhs) {
                    return 0;
                }
                if (lhs == mainThread) {
                    return 1;
                }
                if (rhs == mainThread) {
                    return -1;
                }
                return rhs.getName().compareTo(lhs.getName());
            }
        });
        for (Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == mainThread || (((Thread) entry.getKey()).getName().startsWith(prefix) && (logThreadsWithoutStackTrace || ((StackTraceElement[]) entry.getValue()).length > 0))) {
                stackTraces.put(entry.getKey(), entry.getValue());
            }
        }
        _Thread tst = null;
        for (Entry<Thread, StackTraceElement[]> entry2 : stackTraces.entrySet()) {
            ANRError$$ aNRError$$ = new ANRError$$(((Thread) entry2.getKey()).getName(), (StackTraceElement[]) entry2.getValue());
            aNRError$$.getClass();
            tst = new _Thread(tst);
        }
        return new ANRError(tst);
    }

    static ANRError NewMainOnly() {
        Thread mainThread = Looper.getMainLooper().getThread();
        ANRError$$ aNRError$$ = new ANRError$$(mainThread.getName(), mainThread.getStackTrace());
        aNRError$$.getClass();
        return new ANRError(new _Thread(null));
    }
}
