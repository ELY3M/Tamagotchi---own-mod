package org.anddev.andengine.extension.multiplayer.protocol.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class IPUtils {
    public static final int IPV4_LENGTH = 4;
    public static final int IPV6_LENGTH = 16;
    private static final Pattern IPv4_PATTERN = Pattern.compile(REGEXP_IPv4);
    public static final String LOCALHOST_IP = "127.0.0.1";
    private static final String REGEXP_255 = "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
    public static final String REGEXP_IPv4 = "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";

    public static byte[] ipv4AddressToIPAddress(int pIPv4Address) {
        return new byte[]{(byte) ((pIPv4Address >> 0) & 255), (byte) ((pIPv4Address >> 8) & 255), (byte) ((pIPv4Address >> 16) & 255), (byte) ((pIPv4Address >> 24) & 255)};
    }

    public static String ipAddressToString(byte[] pIPAddress) throws UnknownHostException {
        return InetAddress.getByAddress(pIPAddress).getHostAddress();
    }

    public static byte[] stringToIPAddress(String pString) throws UnknownHostException {
        return InetAddress.getByName(pString).getAddress();
    }

    public static boolean isValidIPv4(String pIPv4Address) {
        return IPv4_PATTERN.matcher(pIPv4Address).matches();
    }
}
