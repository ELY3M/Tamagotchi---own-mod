package org.anddev.andengine.extension.multiplayer.protocol.shared;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.IMessage;

public interface IMessageHandler<C extends Connection, CC extends Connector<C>, M extends IMessage> {
    void onHandleMessage(CC cc, M m) throws IOException;
}
