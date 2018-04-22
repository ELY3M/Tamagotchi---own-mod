package org.anddev.andengine.extension.multiplayer.protocol.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.IMessage;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.pool.GenericPool;
import org.anddev.andengine.util.pool.MultiPool;

public class MessagePool<M extends IMessage> {
    private final MultiPool<M> mMessageMultiPool = new MultiPool();

    public void registerMessage(short pFlag, final Class<? extends M> pMessageClass) {
        this.mMessageMultiPool.registerPool(pFlag, new GenericPool<M>() {
            protected M onAllocatePoolItem() {
                try {
                    return (IMessage) pMessageClass.newInstance();
                } catch (Throwable t) {
                    Debug.m63e(t);
                    return null;
                }
            }
        });
    }

    public M obtainMessage(short pFlag) {
        return (IMessage) this.mMessageMultiPool.obtainPoolItem(pFlag);
    }

    public M obtainMessage(short pFlag, DataInputStream pDataInputStream) throws IOException {
        IMessage message = (IMessage) this.mMessageMultiPool.obtainPoolItem(pFlag);
        if (message != null) {
            message.read(pDataInputStream);
            return message;
        }
        throw new IllegalArgumentException("No message found for pFlag='" + pFlag + "'.");
    }

    public void recycleMessage(M pMessage) {
        this.mMessageMultiPool.recyclePoolItem(pMessage.getFlag(), pMessage);
    }

    public void recycleMessages(List<? extends M> pMessages) {
        MultiPool<M> messageMultiPool = this.mMessageMultiPool;
        for (int i = pMessages.size() - 1; i >= 0; i--) {
            IMessage message = (IMessage) pMessages.get(i);
            messageMultiPool.recyclePoolItem(message.getFlag(), message);
        }
    }
}
