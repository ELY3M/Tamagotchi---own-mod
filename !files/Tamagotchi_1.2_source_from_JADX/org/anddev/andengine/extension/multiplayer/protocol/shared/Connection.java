package org.anddev.andengine.extension.multiplayer.protocol.shared;

import android.os.Process;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.anddev.andengine.util.Debug;

public abstract class Connection extends Thread {
    protected IConnectionListener mConnectionListener;
    protected final DataInputStream mDataInputStream;
    protected final DataOutputStream mDataOutputStream;
    protected AtomicBoolean mRunning = new AtomicBoolean(false);
    protected AtomicBoolean mTerminated = new AtomicBoolean(false);

    public interface IConnectionListener {
        void onStarted(Connection connection);

        void onTerminated(Connection connection);

        void read(DataInputStream dataInputStream) throws IOException;
    }

    public Connection(DataInputStream pDataInputStream, DataOutputStream pDataOutputStream) throws IOException {
        this.mDataInputStream = pDataInputStream;
        this.mDataOutputStream = pDataOutputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return this.mDataOutputStream;
    }

    public DataInputStream getDataInputStream() {
        return this.mDataInputStream;
    }

    public boolean hasConnectionListener() {
        return this.mConnectionListener != null;
    }

    public IConnectionListener getConnectionListener() {
        return this.mConnectionListener;
    }

    public void setConnectionListener(IConnectionListener pConnectionListener) {
        this.mConnectionListener = pConnectionListener;
    }

    public void run() {
        onStart();
        this.mRunning.set(true);
        Process.setThreadPriority(-1);
        while (!Thread.interrupted() && this.mRunning.get() && !this.mTerminated.get()) {
            try {
                this.mConnectionListener.read(this.mDataInputStream);
            } catch (SocketException e) {
                terminate();
            } catch (EOFException e2) {
                terminate();
            } catch (Throwable pThrowable) {
                try {
                    Debug.m63e(pThrowable);
                    return;
                } finally {
                    terminate();
                }
            }
        }
        terminate();
    }

    protected void finalize() throws Throwable {
        terminate();
        super.finalize();
    }

    public void terminate() {
        if (!this.mTerminated.getAndSet(true)) {
            this.mRunning.set(false);
            interrupt();
            onTerminate();
        }
    }

    protected void onStart() {
        if (this.mConnectionListener != null) {
            this.mConnectionListener.onStarted(this);
        }
    }

    protected void onTerminate() {
        if (this.mConnectionListener != null) {
            this.mConnectionListener.onTerminated(this);
        }
    }
}
