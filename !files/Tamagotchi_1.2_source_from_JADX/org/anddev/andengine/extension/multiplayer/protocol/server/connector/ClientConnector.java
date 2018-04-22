package org.anddev.andengine.extension.multiplayer.protocol.server.connector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.anddev.andengine.extension.multiplayer.protocol.server.IClientMessageHandler;
import org.anddev.andengine.extension.multiplayer.protocol.server.IClientMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.server.IClientMessageReader.ClientMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connector.IConnectorListener;
import org.anddev.andengine.util.ParameterCallable;
import org.anddev.andengine.util.SmartList;

public class ClientConnector<C extends Connection> extends Connector<C> {
    private final IClientMessageReader<C> mClientMessageReader;
    private final ParameterCallable<IClientConnectorListener<C>> mOnStartedParameterCallable;
    private final ParameterCallable<IClientConnectorListener<C>> mOnTerminatedParameterCallable;

    class C09181 implements ParameterCallable<IClientConnectorListener<C>> {
        C09181() {
        }

        public void call(IClientConnectorListener<C> pClientConnectorListener) {
            pClientConnectorListener.onStarted(ClientConnector.this);
        }
    }

    class C09192 implements ParameterCallable<IClientConnectorListener<C>> {
        C09192() {
        }

        public void call(IClientConnectorListener<C> pClientConnectorListener) {
            pClientConnectorListener.onTerminated(ClientConnector.this);
        }
    }

    public interface IClientConnectorListener<T extends Connection> extends IConnectorListener<ClientConnector<T>> {
        void onStarted(ClientConnector<T> clientConnector);

        void onTerminated(ClientConnector<T> clientConnector);
    }

    public ClientConnector(C pConnection) throws IOException {
        this(pConnection, new ClientMessageReader());
    }

    public ClientConnector(C pConnection, IClientMessageReader<C> pClientMessageReader) throws IOException {
        super(pConnection);
        this.mOnStartedParameterCallable = new C09181();
        this.mOnTerminatedParameterCallable = new C09192();
        this.mClientMessageReader = pClientMessageReader;
    }

    public IClientMessageReader<C> getClientMessageReader() {
        return this.mClientMessageReader;
    }

    public SmartList<IClientConnectorListener<C>> getConnectorListeners() {
        return super.getConnectorListeners();
    }

    public void addClientConnectorListener(IClientConnectorListener<C> pClientConnectorListener) {
        super.addConnectorListener(pClientConnectorListener);
    }

    public void removeClientConnectorListener(IClientConnectorListener<C> pClientConnectorListener) {
        super.removeConnectorListener(pClientConnectorListener);
    }

    public void onStarted(Connection pConnection) {
        getConnectorListeners().call(this.mOnStartedParameterCallable);
    }

    public void onTerminated(Connection pConnection) {
        getConnectorListeners().call(this.mOnTerminatedParameterCallable);
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        IClientMessage clientMessage = this.mClientMessageReader.readMessage(pDataInputStream);
        this.mClientMessageReader.handleMessage(this, clientMessage);
        this.mClientMessageReader.recycleMessage(clientMessage);
    }

    public void registerClientMessage(short pFlag, Class<? extends IClientMessage> pClientMessageClass) {
        this.mClientMessageReader.registerMessage(pFlag, pClientMessageClass);
    }

    public void registerClientMessage(short pFlag, Class<? extends IClientMessage> pClientMessageClass, IClientMessageHandler<C> pClientMessageHandler) {
        this.mClientMessageReader.registerMessage(pFlag, pClientMessageClass, pClientMessageHandler);
    }

    public void registerClientMessageHandler(short pFlag, IClientMessageHandler<C> pClientMessageHandler) {
        this.mClientMessageReader.registerMessageHandler(pFlag, pClientMessageHandler);
    }

    public synchronized void sendServerMessage(IServerMessage pServerMessage) throws IOException {
        DataOutputStream dataOutputStream = this.mConnection.getDataOutputStream();
        pServerMessage.write(dataOutputStream);
        dataOutputStream.flush();
    }
}
