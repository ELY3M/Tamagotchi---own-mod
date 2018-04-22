package com.tamaproject.adt.messages.server;

public interface ServerMessageFlags {
    public static final short FLAG_MESSAGE_SERVER_CONNECTION_CLOSE = Short.MIN_VALUE;
    public static final short FLAG_MESSAGE_SERVER_CONNECTION_ESTABLISHED = (short) -32767;
    public static final short FLAG_MESSAGE_SERVER_CONNECTION_PONG = (short) -32765;
    public static final short FLAG_MESSAGE_SERVER_CONNECTION_REJECTED_PROTOCOL_MISSMATCH = (short) -32766;
}
