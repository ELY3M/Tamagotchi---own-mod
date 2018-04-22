package org.anddev.andengine.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class SystemUtils {
    private static final String BOGOMIPS_PATTERN = "BogoMIPS[\\s]*:[\\s]*(\\d+\\.\\d+)[\\s]*\n";
    private static final String MEMFREE_PATTERN = "MemFree[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
    private static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";

    public static class SystemUtilsException extends Exception {
        private static final long serialVersionUID = -7256483361095147596L;

        public SystemUtilsException(Throwable pThrowable) {
            super(pThrowable);
        }
    }

    public static int getPackageVersionCode(Context pContext) {
        return getPackageInfo(pContext).versionCode;
    }

    public static String getPackageVersionName(Context pContext) {
        return getPackageInfo(pContext).versionName;
    }

    private static PackageInfo getPackageInfo(Context pContext) {
        try {
            return pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), 0);
        } catch (Throwable e) {
            Debug.m63e(e);
            return null;
        }
    }

    public static boolean hasSystemFeature(Context pContext, String pFeature) {
        try {
            Method PackageManager_hasSystemFeatures = PackageManager.class.getMethod("hasSystemFeature", new Class[]{String.class});
            if (PackageManager_hasSystemFeatures == null) {
                return false;
            }
            return ((Boolean) PackageManager_hasSystemFeatures.invoke(pContext.getPackageManager(), new Object[]{pFeature})).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isAndroidVersionOrHigher(int pBuildVersionCode) {
        return Integer.parseInt(VERSION.SDK) >= pBuildVersionCode;
    }

    public static float getCPUBogoMips() throws SystemUtilsException {
        MatchResult matchResult = matchSystemFile("/proc/cpuinfo", BOGOMIPS_PATTERN, 1000);
        try {
            if (matchResult.groupCount() > 0) {
                return Float.parseFloat(matchResult.group(1));
            }
            throw new SystemUtilsException();
        } catch (NumberFormatException e) {
            throw new SystemUtilsException(e);
        }
    }

    public static int getMemoryTotal() throws SystemUtilsException {
        MatchResult matchResult = matchSystemFile("/proc/meminfo", MEMTOTAL_PATTERN, 1000);
        try {
            if (matchResult.groupCount() > 0) {
                return Integer.parseInt(matchResult.group(1));
            }
            throw new SystemUtilsException();
        } catch (NumberFormatException e) {
            throw new SystemUtilsException(e);
        }
    }

    public static int getMemoryFree() throws SystemUtilsException {
        MatchResult matchResult = matchSystemFile("/proc/meminfo", MEMFREE_PATTERN, 1000);
        try {
            if (matchResult.groupCount() > 0) {
                return Integer.parseInt(matchResult.group(1));
            }
            throw new SystemUtilsException();
        } catch (NumberFormatException e) {
            throw new SystemUtilsException(e);
        }
    }

    public static int getCPUFrequencyCurrent() throws SystemUtilsException {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
    }

    public static int getCPUFrequencyMin() throws SystemUtilsException {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
    }

    public static int getCPUFrequencyMax() throws SystemUtilsException {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    }

    public static int getCPUFrequencyMinScaling() throws SystemUtilsException {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq");
    }

    public static int getCPUFrequencyMaxScaling() throws SystemUtilsException {
        return readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq");
    }

    private static MatchResult matchSystemFile(String pSystemFile, String pPattern, int pHorizon) throws SystemUtilsException {
        boolean matchFound = true;
        InputStream in = null;
        try {
            in = new ProcessBuilder(new String[]{"/system/bin/cat", pSystemFile}).start().getInputStream();
            Scanner scanner = new Scanner(in);
            if (scanner.findWithinHorizon(pPattern, pHorizon) == null) {
                matchFound = false;
            }
            if (matchFound) {
                MatchResult match = scanner.match();
                StreamUtils.close(in);
                return match;
            }
            throw new SystemUtilsException();
        } catch (IOException e) {
            throw new SystemUtilsException(e);
        } catch (Throwable th) {
            StreamUtils.close(in);
        }
    }

    private static int readSystemFileAsInt(String pSystemFile) throws SystemUtilsException {
        InputStream in = null;
        try {
            in = new ProcessBuilder(new String[]{"/system/bin/cat", pSystemFile}).start().getInputStream();
            int parseInt = Integer.parseInt(StreamUtils.readFully(in));
            StreamUtils.close(in);
            return parseInt;
        } catch (IOException e) {
            throw new SystemUtilsException(e);
        } catch (NumberFormatException e2) {
            throw new SystemUtilsException(e2);
        } catch (Throwable th) {
            StreamUtils.close(in);
        }
    }
}
