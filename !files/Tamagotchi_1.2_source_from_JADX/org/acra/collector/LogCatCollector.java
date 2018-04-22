package org.acra.collector;

import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;
import org.acra.util.BoundedLinkedList;

class LogCatCollector {
    private static final int DEFAULT_TAIL_COUNT = 100;

    LogCatCollector() {
    }

    public String collectLogCat(@NonNull ACRAConfiguration config, @Nullable String bufferName) {
        int tailCount;
        IOException e;
        Throwable th;
        int myPid = Process.myPid();
        String myPidStr = null;
        if (config.logcatFilterByPid() && myPid > 0) {
            myPidStr = Integer.toString(myPid) + "):";
        }
        List<String> commandLine = new ArrayList();
        commandLine.add("logcat");
        if (bufferName != null) {
            commandLine.add("-b");
            commandLine.add(bufferName);
        }
        List<String> logcatArgumentsList = new ArrayList(Arrays.asList(config.logcatArguments()));
        int tailIndex = logcatArgumentsList.indexOf("-t");
        if (tailIndex <= -1 || tailIndex >= logcatArgumentsList.size()) {
            tailCount = -1;
        } else {
            tailCount = Integer.parseInt((String) logcatArgumentsList.get(tailIndex + 1));
            if (VERSION.SDK_INT < 8) {
                logcatArgumentsList.remove(tailIndex + 1);
                logcatArgumentsList.remove(tailIndex);
                logcatArgumentsList.add("-d");
            }
        }
        if (tailCount <= 0) {
            tailCount = 100;
        }
        LinkedList<String> logcatBuf = new BoundedLinkedList(tailCount);
        commandLine.addAll(logcatArgumentsList);
        BufferedReader bufferedReader = null;
        try {
            final Process process = Runtime.getRuntime().exec((String[]) commandLine.toArray(new String[commandLine.size()]));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()), 8192);
            try {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            do {
                            } while (process.getErrorStream().read(new byte[8192]) >= 0);
                        } catch (IOException e) {
                        }
                    }
                }).start();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    if (myPidStr != null) {
                        if (!line.contains(myPidStr)) {
                        }
                    }
                    logcatBuf.add(line + "\n");
                }
                CollectorUtil.safeClose(bufferedReader2);
                bufferedReader = bufferedReader2;
            } catch (IOException e2) {
                e = e2;
                bufferedReader = bufferedReader2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (IOException e3) {
            e = e3;
            try {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "LogCatCollector.collectLogCat could not retrieve data.", e);
                CollectorUtil.safeClose(bufferedReader);
                return logcatBuf.toString();
            } catch (Throwable th3) {
                th = th3;
                CollectorUtil.safeClose(bufferedReader);
                throw th;
            }
        }
        return logcatBuf.toString();
    }
}
