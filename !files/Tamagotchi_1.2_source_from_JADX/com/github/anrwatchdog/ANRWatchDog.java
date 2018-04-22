package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ANRWatchDog extends Thread {
    private static final ANRListener DEFAULT_ANR_LISTENER = new C06501();
    private static final int DEFAULT_ANR_TIMEOUT = 5000;
    private static final InterruptionListener DEFAULT_INTERRUPTION_LISTENER = new C06512();
    private ANRListener _anrListener;
    private boolean _ignoreDebugger;
    private InterruptionListener _interruptionListener;
    private boolean _logThreadsWithoutStackTrace;
    private String _namePrefix;
    private volatile int _tick;
    private final Runnable _ticker;
    private final int _timeoutInterval;
    private final Handler _uiHandler;

    class C01953 implements Runnable {
        C01953() {
        }

        public void run() {
            ANRWatchDog.this._tick = (ANRWatchDog.this._tick + 1) % Integer.MAX_VALUE;
        }
    }

    public interface ANRListener {
        void onAppNotResponding(ANRError aNRError);
    }

    public interface InterruptionListener {
        void onInterrupted(InterruptedException interruptedException);
    }

    static class C06501 implements ANRListener {
        C06501() {
        }

        public void onAppNotResponding(ANRError error) {
            throw error;
        }
    }

    static class C06512 implements InterruptionListener {
        C06512() {
        }

        public void onInterrupted(InterruptedException exception) {
            Log.w("ANRWatchdog", "Interrupted: " + exception.getMessage());
        }
    }

    public ANRWatchDog() {
        this(5000);
    }

    public ANRWatchDog(int timeoutInterval) {
        this._anrListener = DEFAULT_ANR_LISTENER;
        this._interruptionListener = DEFAULT_INTERRUPTION_LISTENER;
        this._uiHandler = new Handler(Looper.getMainLooper());
        this._namePrefix = "";
        this._logThreadsWithoutStackTrace = false;
        this._ignoreDebugger = false;
        this._tick = 0;
        this._ticker = new C01953();
        this._timeoutInterval = timeoutInterval;
    }

    public ANRWatchDog setANRListener(ANRListener listener) {
        if (listener == null) {
            this._anrListener = DEFAULT_ANR_LISTENER;
        } else {
            this._anrListener = listener;
        }
        return this;
    }

    public ANRWatchDog setInterruptionListener(InterruptionListener listener) {
        if (listener == null) {
            this._interruptionListener = DEFAULT_INTERRUPTION_LISTENER;
        } else {
            this._interruptionListener = listener;
        }
        return this;
    }

    public ANRWatchDog setReportThreadNamePrefix(String prefix) {
        if (prefix == null) {
            prefix = "";
        }
        this._namePrefix = prefix;
        return this;
    }

    public ANRWatchDog setReportMainThreadOnly() {
        this._namePrefix = null;
        return this;
    }

    public ANRWatchDog setLogThreadsWithoutStackTrace(boolean logThreadsWithoutStackTrace) {
        this._logThreadsWithoutStackTrace = logThreadsWithoutStackTrace;
        return this;
    }

    public ANRWatchDog setIgnoreDebugger(boolean ignoreDebugger) {
        this._ignoreDebugger = ignoreDebugger;
        return this;
    }

    public void run() {
        setName("|ANR-WatchDog|");
        int lastIgnored = -1;
        while (!isInterrupted()) {
            int lastTick = this._tick;
            this._uiHandler.post(this._ticker);
            try {
                Thread.sleep((long) this._timeoutInterval);
                if (this._tick == lastTick) {
                    if (this._ignoreDebugger || !Debug.isDebuggerConnected()) {
                        ANRError error;
                        if (this._namePrefix != null) {
                            error = ANRError.New(this._namePrefix, this._logThreadsWithoutStackTrace);
                        } else {
                            error = ANRError.NewMainOnly();
                        }
                        this._anrListener.onAppNotResponding(error);
                        return;
                    }
                    if (this._tick != lastIgnored) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    lastIgnored = this._tick;
                }
            } catch (InterruptedException e) {
                this._interruptionListener.onInterrupted(e);
                return;
            }
        }
    }
}
