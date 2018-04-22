package com.tamaproject.util;

public interface TamaBattleConstants {
    public static final int BAR_HEIGHT = 15;
    public static final int BAR_LENGTH = 100;
    public static final int DIALOG_CHOOSE_SERVER_OR_CLIENT_ID = 0;
    public static final int DIALOG_ENTER_SERVER_IP_ID = 1;
    public static final int DIALOG_SHOW_SERVER_IP_ID = 2;
    public static final short FLAG_MESSAGE_CLIENT_ADD_SPRITE = (short) 7;
    public static final short FLAG_MESSAGE_CLIENT_FIRE_BULLET = (short) 9;
    public static final short FLAG_MESSAGE_CLIENT_MOVE_SPRITE = (short) 6;
    public static final short FLAG_MESSAGE_CLIENT_REQUEST_ID = (short) 4;
    public static final short FLAG_MESSAGE_CLIENT_SEND_PLAYER = (short) 12;
    public static final short FLAG_MESSAGE_CLIENT_VOTE_DEATHMATCH = (short) 16;
    public static final short FLAG_MESSAGE_SERVER_ADD_SPRITE = (short) 1;
    public static final short FLAG_MESSAGE_SERVER_DEATHMATCH = (short) 16;
    public static final short FLAG_MESSAGE_SERVER_FIRE_BULLET = (short) 8;
    public static final short FLAG_MESSAGE_SERVER_ID_PLAYER = (short) 3;
    public static final short FLAG_MESSAGE_SERVER_MODIFY_PLAYER = (short) 11;
    public static final short FLAG_MESSAGE_SERVER_MOVE_SPRITE = (short) 2;
    public static final short FLAG_MESSAGE_SERVER_RECEIVED_DAMAGE = (short) 15;
    public static final short FLAG_MESSAGE_SERVER_REMOVE_SPRITE = (short) 10;
    public static final short FLAG_MESSAGE_SERVER_SEND_PLAYER = (short) 13;
    public static final short FLAG_MESSAGE_SERVER_START_GAME = (short) 14;
    public static final int SERVER_PORT = 4444;
}
