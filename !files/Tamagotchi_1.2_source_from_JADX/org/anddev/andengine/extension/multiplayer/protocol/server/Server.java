package org.anddev.andengine.extension.multiplayer.protocol.server;

import android.os.Process;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector.IClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.SmartList;

public abstract class Server<C extends Connection, CC extends ClientConnector<C>> extends Thread {
    protected IClientConnectorListener<C> mClientConnectorListener;
    protected final SmartList<CC> mClientConnectors = new SmartList();
    private final AtomicBoolean mRunning = new AtomicBoolean(false);
    protected IServerListener<? extends Server<C, CC>> mServerListener;
    private final AtomicBoolean mTerminated = new AtomicBoolean(false);

    public interface IServerListener<S extends Server<?, ?>> {
        void onException(S s, Throwable th);

        void onStarted(S s);

        void onTerminated(S s);
    }

    protected abstract CC acceptClientConnector() throws IOException;

    protected abstract void onException(Throwable th);

    protected abstract void onStart() throws IOException;

    protected abstract void onTerminate();

    public Server(IClientConnectorListener<C> pClientConnectorListener, IServerListener<? extends Server<C, CC>> pServerListener) {
        this.mServerListener = pServerListener;
        this.mClientConnectorListener = pClientConnectorListener;
        initName();
    }

    private void initName() {
        setName(getClass().getName());
    }

    public boolean isRunning() {
        return this.mRunning.get();
    }

    public boolean isTerminated() {
        return this.mTerminated.get();
    }

    public IClientConnectorListener<C> getClientConnectorListener() {
        return this.mClientConnectorListener;
    }

    public void setClientConnectorListener(IClientConnectorListener<C> pClientConnectorListener) {
        this.mClientConnectorListener = pClientConnectorListener;
    }

    public IServerListener<? extends Server<C, CC>> getServerListener() {
        return this.mServerListener;
    }

    protected void setServerListener(IServerListener<? extends Server<C, CC>> pServerListener) {
        this.mServerListener = pServerListener;
    }

    public void run() {
        try {
            onStart();
            this.mRunning.set(true);
            Process.setThreadPriority(0);
            while (!Thread.interrupted() && this.mRunning.get() && !this.mTerminated.get()) {
                final CC clientConnector = acceptClientConnector();
                clientConnector.addClientConnectorListener(new IClientConnectorListener<C>() {
                    public void onStarted(ClientConnector<C> clientConnector) {
                        Server.this.onAddClientConnector(clientConnector);
                    }

                    public void onTerminated(ClientConnector<C> clientConnector) {
                        Server.this.onRemoveClientConnector(clientConnector);
                    }
                });
                clientConnector.addClientConnectorListener(this.mClientConnectorListener);
                clientConnector.start();
            }
            terminate();
        } catch (Throwable pThrowable) {
            try {
                onException(pThrowable);
            } finally {
                terminate();
            }
        }
    }

    protected void finalize() throws Throwable {
        terminate();
        super.finalize();
    }

    private synchronized void onAddClientConnector(CC pClientConnector) {
        this.mClientConnectors.add(pClientConnector);
    }

    private synchronized void onRemoveClientConnector(CC pClientConnector) {
        this.mClientConnectors.remove(pClientConnector);
    }

    public void terminate() {
        if (!this.mTerminated.getAndSet(true)) {
            this.mRunning.set(false);
            try {
                ArrayList<CC> clientConnectors = this.mClientConnectors;
                for (int i = 0; i < clientConnectors.size(); i++) {
                    ((ClientConnector) clientConnectors.get(i)).terminate();
                }
                clientConnectors.clear();
            } catch (Exception e) {
                onException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (Throwable e2) {
                Debug.m63e(e2);
            }
            interrupt();
            onTerminate();
        }
    }

    public synchronized void sendBroadcastServerMessage(IServerMessage pServerMessage) throws IOException {
        if (this.mRunning.get()) {
            ArrayList<CC> clientConnectors = this.mClientConnectors;
            for (int i = 0; i < clientConnectors.size(); i++) {
                try {
                    ((ClientConnector) clientConnectors.get(i)).sendServerMessage(pServerMessage);
                } catch (IOException e) {
                    onException(e);
                }
            }
        }
    }
}
