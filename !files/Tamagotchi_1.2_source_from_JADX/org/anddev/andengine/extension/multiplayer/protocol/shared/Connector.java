package org.anddev.andengine.extension.multiplayer.protocol.shared;

import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection.IConnectionListener;
import org.anddev.andengine.util.SmartList;

public abstract class Connector<C extends Connection> implements IConnectionListener {
    protected final C mConnection;
    protected SmartList<IConnectorListener<? extends Connector<C>>> mConnectorListeners = new SmartList();

    public interface IConnectorListener<C extends Connector<?>> {
        void onStarted(C c);

        void onTerminated(C c);
    }

    public Connector(C pConnection) {
        this.mConnection = pConnection;
        this.mConnection.setConnectionListener(this);
    }

    public C getConnection() {
        return this.mConnection;
    }

    public boolean hasConnectorListener() {
        return this.mConnectorListeners != null;
    }

    public SmartList<? extends IConnectorListener<? extends Connector<C>>> getConnectorListeners() {
        return this.mConnectorListeners;
    }

    protected void addConnectorListener(IConnectorListener<? extends Connector<C>> pConnectorListener) {
        if (pConnectorListener != null) {
            this.mConnectorListeners.add(pConnectorListener);
        }
    }

    protected boolean removeConnectorListener(IConnectorListener<? extends Connector<C>> pConnectorListener) {
        if (pConnectorListener == null) {
            return false;
        }
        return this.mConnectorListeners.remove(pConnectorListener);
    }

    public void start() {
        getConnection().start();
    }

    public void terminate() {
        getConnection().terminate();
    }
}
