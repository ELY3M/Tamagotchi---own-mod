package com.github.anrwatchdog;

import java.io.Serializable;

/* compiled from: ANRError */
class ANRError$$ implements Serializable {
    private final String _name;
    private final StackTraceElement[] _stackTrace;

    /* compiled from: ANRError */
    private class _Thread extends Throwable {
        private _Thread(_Thread other) {
            super(ANRError$$.this._name, other);
        }

        public Throwable fillInStackTrace() {
            setStackTrace(ANRError$$.this._stackTrace);
            return this;
        }
    }

    private ANRError$$(String name, StackTraceElement[] stackTrace) {
        this._name = name;
        this._stackTrace = stackTrace;
    }
}
