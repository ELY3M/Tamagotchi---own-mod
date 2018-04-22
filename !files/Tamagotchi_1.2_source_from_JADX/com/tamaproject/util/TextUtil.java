package com.tamaproject.util;

import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.opengl.font.Font;

public class TextUtil {
    public static String getNormalizedText(Font font, String ptext, float textWidth) {
        if (!ptext.contains(" ")) {
            return ptext;
        }
        String[] lines = ptext.split("\n");
        StringBuilder normalizedText = new StringBuilder();
        StringBuilder line = new StringBuilder();
        for (int j = 0; j < lines.length; j++) {
            if (lines[j].contains(" ")) {
                String[] words = lines[j].split(" ");
                CharSequence line2 = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    if (((float) font.getStringWidth(line2 + words[i])) > textWidth) {
                        normalizedText.append(line2).append('\n');
                        line2 = new StringBuilder();
                    }
                    if (line2.length() == 0) {
                        line2.append(words[i]);
                    } else {
                        line2.append(' ').append(words[i]);
                    }
                    if (i == words.length - 1) {
                        normalizedText.append(line2);
                    }
                }
            } else {
                normalizedText.append(lines[j]);
            }
            normalizedText.append('\n');
        }
        return normalizedText.toString();
    }

    public static String getIpAndPort(ClientConnector<SocketConnection> pConnector) {
        return ((SocketConnection) pConnector.getConnection()).getSocket().getInetAddress().getHostAddress() + ":" + ((SocketConnection) pConnector.getConnection()).getSocket().getPort();
    }
}
