package com.tamaproject.adt.messages.client;

public interface ClientMessageFlags {
    public static final short FLAG_MESSAGE_CLIENT_CONNECTION_CLOSE = Short.MIN_VALUE;
    public static final short FLAG_MESSAGE_CLIENT_CONNECTION_ESTABLISH = (short) -32767;
    public static final short FLAG_MESSAGE_CLIENT_CONNECTION_PING = (short) -32766;
}
