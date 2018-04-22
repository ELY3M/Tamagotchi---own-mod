package org.anddev.andengine.opengl.view;

import android.util.Log;
import java.io.Writer;

class LogWriter extends Writer {
    private final StringBuilder mBuilder = new StringBuilder();

    LogWriter() {
    }

    public void close() {
        flushBuilder();
    }

    public void flush() {
        flushBuilder();
    }

    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            Log.v("GLSurfaceView", this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}
