package org.anddev.andengine.extension.multiplayer.protocol.client.connector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.anddev.andengine.extension.multiplayer.protocol.client.IServerMessageHandler;
import org.anddev.andengine.extension.multiplayer.protocol.client.IServerMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.client.IServerMessageReader.ServerMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connector.IConnectorListener;
import org.anddev.andengine.util.ParameterCallable;
import org.anddev.andengine.util.SmartList;

public class ServerConnector<C extends Connection> extends Connector<C> {
    private final ParameterCallable<IServerConnectorListener<C>> mOnStartedParameterCallable;
    private final ParameterCallable<IServerConnectorListener<C>> mOnTerminatedParameterCallable;
    private final IServerMessageReader<C> mServerMessageReader;

    class C09161 implements ParameterCallable<IServerConnectorListener<C>> {
        C09161() {
        }

        public void call(IServerConnectorListener<C> pServerConnectorListener) {
            pServerConnectorListener.onStarted(ServerConnector.this);
        }
    }

    class C09172 implements ParameterCallable<IServerConnectorListener<C>> {
        C09172() {
        }

        public void call(IServerConnectorListener<C> pServerConnectorListener) {
            pServerConnectorListener.onTerminated(ServerConnector.this);
        }
    }

    public interface IServerConnectorListener<T extends Connection> extends IConnectorListener<ServerConnector<T>> {
        void onStarted(ServerConnector<T> serverConnector);

        void onTerminated(ServerConnector<T> serverConnector);
    }

    public ServerConnector(C pConnection, IServerConnectorListener<C> pServerConnectorListener) throws IOException {
        this(pConnection, new ServerMessageReader(), pServerConnectorListener);
    }

    public ServerConnector(C pConnection, IServerMessageReader<C> pServerMessageReader, IServerConnectorListener<C> pServerConnectorListener) throws IOException {
        super(pConnection);
        this.mOnStartedParameterCallable = new C09161();
        this.mOnTerminatedParameterCallable = new C09172();
        this.mServerMessageReader = pServerMessageReader;
        addServerConnectorListener(pServerConnectorListener);
    }

    public IServerMessageReader<C> getServerMessageReader() {
        return this.mServerMessageReader;
    }

    public SmartList<IServerConnectorListener<C>> getConnectorListeners() {
        return super.getConnectorListeners();
    }

    public void addServerConnectorListener(IServerConnectorListener<C> pServerConnectorListener) {
        super.addConnectorListener(pServerConnectorListener);
    }

    public boolean removeServerConnectorListener(IServerConnectorListener<C> pServerConnectorListener) {
        return super.removeConnectorListener(pServerConnectorListener);
    }

    public void onStarted(Connection pConnection) {
        getConnectorListeners().call(this.mOnStartedParameterCallable);
    }

    public void onTerminated(Connection pConnection) {
        getConnectorListeners().call(this.mOnTerminatedParameterCallable);
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        IServerMessage serverMessage = this.mServerMessageReader.readMessage(pDataInputStream);
        this.mServerMessageReader.handleMessage(this, serverMessage);
        this.mServerMessageReader.recycleMessage(serverMessage);
    }

    public void registerServerMessage(short pFlag, Class<? extends IServerMessage> pServerMessageClass) {
        this.mServerMessageReader.registerMessage(pFlag, pServerMessageClass);
    }

    public void registerServerMessage(short pFlag, Class<? extends IServerMessage> pServerMessageClass, IServerMessageHandler<C> pServerMessageHandler) {
        this.mServerMessageReader.registerMessage(pFlag, pServerMessageClass, pServerMessageHandler);
    }

    public void registerServerMessageHandler(short pFlag, IServerMessageHandler<C> pServerMessageHandler) {
        this.mServerMessageReader.registerMessageHandler(pFlag, pServerMessageHandler);
    }

    public synchronized void sendClientMessage(IClientMessage pClientMessage) throws IOException {
        DataOutputStream dataOutputStream = this.mConnection.getDataOutputStream();
        pClientMessage.write(dataOutputStream);
        dataOutputStream.flush();
    }
}
