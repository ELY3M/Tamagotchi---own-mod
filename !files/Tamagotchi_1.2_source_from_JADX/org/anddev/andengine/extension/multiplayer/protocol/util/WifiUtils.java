package org.anddev.andengine.extension.multiplayer.protocol.util;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.anddev.andengine.extension.multiplayer.protocol.exception.WifiException;
import org.anddev.andengine.util.SystemUtils;

public class WifiUtils {
    private static final String HOTSPOT_NETWORKINTERFACE_NAME_DEFAULT = "wl0.1";
    private static final String IP_DEFAULT = "0.0.0.0";
    private static final String MULTICASTLOCK_NAME_DEFAULT = "AndEngineMultiplayerExtensionMulticastLock";

    public static WifiManager getWifiManager(Context pContext) {
        return (WifiManager) pContext.getSystemService("wifi");
    }

    public static boolean isWifiEnabled(Context pContext) {
        return getWifiManager(pContext).isWifiEnabled();
    }

    public static String getWifiSSID(Context pContext) {
        return getWifiManager(pContext).getConnectionInfo().getSSID();
    }

    public static byte[] getWifiIPv4AddressRaw(Context pContext) {
        return IPUtils.ipv4AddressToIPAddress(getWifiManager(pContext).getConnectionInfo().getIpAddress());
    }

    public static String getWifiIPv4Address(Context pContext) throws UnknownHostException {
        return IPUtils.ipAddressToString(getWifiIPv4AddressRaw(pContext));
    }

    public static boolean isWifiIPAddressValid(Context pContext) {
        return getWifiManager(pContext).getConnectionInfo().getIpAddress() != 0;
    }

    public static boolean isHotspotSupported() {
        return SystemUtils.isAndroidVersionOrHigher(8);
    }

    public static boolean isHotspotRunning() throws WifiException {
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                if (((NetworkInterface) networkInterfaceEnumeration.nextElement()).getName().equals(HOTSPOT_NETWORKINTERFACE_NAME_DEFAULT)) {
                    return true;
                }
            }
            return false;
        } catch (SocketException e) {
            throw new WifiException("Unexpected error!", e);
        }
    }

    public static byte[] getHotspotIPAddressRaw() throws WifiException {
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaceEnumeration.nextElement();
                if (networkInterface.getName().equals(HOTSPOT_NETWORKINTERFACE_NAME_DEFAULT)) {
                    byte[] ipv6Address = null;
                    Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
                    while (inetAddressEnumeration.hasMoreElements()) {
                        byte[] ipAddress = ((InetAddress) inetAddressEnumeration.nextElement()).getAddress();
                        if (ipAddress.length == 4) {
                            return ipAddress;
                        }
                        ipv6Address = ipAddress;
                    }
                    if (ipv6Address != null) {
                        return ipv6Address;
                    }
                    throw new WifiException("No IP bound to 'wl0.1'!");
                }
            }
            throw new WifiException("No NetworInterface 'wl0.1' found!");
        } catch (SocketException e) {
            throw new WifiException("Unexpected error!", e);
        }
    }

    public static String getHotspotIPAddress() throws WifiException {
        try {
            return IPUtils.ipAddressToString(getHotspotIPAddressRaw());
        } catch (UnknownHostException e) {
            throw new WifiException("Unexpected error!", e);
        }
    }

    public static boolean isHotspotIPAddressValid() throws WifiException {
        return !IP_DEFAULT.equals(getHotspotIPAddress());
    }

    public static byte[] getBroadcastIPAddressRaw(Context pContext) throws WifiException {
        DhcpInfo dhcp = getWifiManager(pContext).getDhcpInfo();
        int broadcast = (dhcp.ipAddress & dhcp.netmask) | (dhcp.netmask ^ -1);
        byte[] broadcastIP = new byte[4];
        for (int k = 0; k < 4; k++) {
            broadcastIP[k] = (byte) ((broadcast >> (k * 8)) & 255);
        }
        return broadcastIP;
    }

    public static MulticastLock aquireMulticastLock(Context pContext) {
        return aquireMulticastLock(pContext, MULTICASTLOCK_NAME_DEFAULT);
    }

    public static MulticastLock aquireMulticastLock(Context pContext, String pMulticastLockName) {
        MulticastLock multicastLock = getWifiManager(pContext).createMulticastLock(pMulticastLockName);
        multicastLock.setReferenceCounted(true);
        multicastLock.acquire();
        return multicastLock;
    }

    public static void releaseMulticastLock(MulticastLock pMulticastLock) {
        if (pMulticastLock.isHeld()) {
            pMulticastLock.release();
        }
    }
}
