package org.acra.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import org.acra.ACRA;
import org.acra.ACRAConstants;

public final class ReportUtils {
    private ReportUtils() {
    }

    public static long getAvailableInternalMemorySize() {
        long blockSize;
        long availableBlocks;
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            blockSize = stat.getBlockSizeLong();
            availableBlocks = stat.getAvailableBlocksLong();
        } else {
            blockSize = (long) stat.getBlockSize();
            availableBlocks = (long) stat.getAvailableBlocks();
        }
        return availableBlocks * blockSize;
    }

    public static long getTotalInternalMemorySize() {
        long blockSize;
        long totalBlocks;
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            blockSize = stat.getBlockSizeLong();
            totalBlocks = stat.getBlockCountLong();
        } else {
            blockSize = (long) stat.getBlockSize();
            totalBlocks = (long) stat.getBlockCount();
        }
        return totalBlocks * blockSize;
    }

    @Nullable
    public static String getDeviceId(@NonNull Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (RuntimeException e) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, "Couldn't retrieve DeviceId for : " + context.getPackageName(), e);
            return null;
        }
    }

    @NonNull
    public static String getApplicationFilePath(@NonNull Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        ACRA.log.mo4050w(ACRA.LOG_TAG, "Couldn't retrieve ApplicationFilePath for : " + context.getPackageName());
        return "Couldn't retrieve ApplicationFilePath";
    }

    @NonNull
    public static String getLocalIpAddress() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                Enumeration<InetAddress> enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        if (!first) {
                            result.append('\n');
                        }
                        result.append(inetAddress.getHostAddress());
                        first = false;
                    }
                }
            }
        } catch (SocketException ex) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, ex.toString());
        }
        return result.toString();
    }

    @NonNull
    public static String getTimeString(@NonNull Calendar time) {
        return new SimpleDateFormat(ACRAConstants.DATE_TIME_FORMAT_STRING, Locale.ENGLISH).format(Long.valueOf(time.getTimeInMillis()));
    }
}
