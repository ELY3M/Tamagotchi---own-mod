package org.anddev.andengine.extension.multiplayer.protocol.shared;

import android.util.SparseArray;
import java.io.DataInputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.IMessage;
import org.anddev.andengine.extension.multiplayer.protocol.util.MessagePool;

public abstract class MessageReader<C extends Connection, CC extends Connector<C>, M extends IMessage> implements IMessageReader<C, CC, M> {
    private final SparseArray<IMessageHandler<C, CC, M>> mMessageHandlers = new SparseArray();
    private final MessagePool<M> mMessagePool = new MessagePool();

    public void registerMessage(short pFlag, Class<? extends M> pMessageClass) {
        this.mMessagePool.registerMessage(pFlag, pMessageClass);
    }

    public void registerMessageHandler(short pFlag, IMessageHandler<C, CC, M> pMessageHandler) {
        this.mMessageHandlers.put(pFlag, pMessageHandler);
    }

    public void registerMessage(short pFlag, Class<? extends M> pMessageClass, IMessageHandler<C, CC, M> pMessageHandler) {
        registerMessage(pFlag, pMessageClass);
        registerMessageHandler(pFlag, pMessageHandler);
    }

    public M readMessage(DataInputStream pDataInputStream) throws IOException {
        return this.mMessagePool.obtainMessage(pDataInputStream.readShort(), pDataInputStream);
    }

    public void handleMessage(CC pConnector, M pMessage) throws IOException {
        IMessageHandler<C, CC, M> messageHandler = (IMessageHandler) this.mMessageHandlers.get(pMessage.getFlag());
        if (messageHandler != null) {
            messageHandler.onHandleMessage(pConnector, pMessage);
        }
    }

    public void recycleMessage(M pMessage) {
        this.mMessagePool.recycleMessage(pMessage);
    }
}
