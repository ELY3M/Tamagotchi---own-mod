package org.acra.collector;

import android.os.Process;
import android.support.annotation.NonNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.acra.ACRA;

final class DumpSysCollector {
    private DumpSysCollector() {
    }

    @NonNull
    public static String collectMemInfo() {
        IOException e;
        StringBuilder meminfo = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            List<String> commandLine = new ArrayList();
            commandLine.add("dumpsys");
            commandLine.add("meminfo");
            commandLine.add(Integer.toString(Process.myPid()));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[]) commandLine.toArray(new String[commandLine.size()])).getInputStream()), 8192);
            while (true) {
                String line = bufferedReader2.readLine();
                if (line == null) {
                    break;
                }
                try {
                    meminfo.append(line);
                    meminfo.append("\n");
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                }
            }
            bufferedReader = bufferedReader2;
        } catch (IOException e3) {
            e = e3;
            ACRA.log.mo4044e(ACRA.LOG_TAG, "DumpSysCollector.meminfo could not retrieve data", e);
            CollectorUtil.safeClose(bufferedReader);
            return meminfo.toString();
        }
        CollectorUtil.safeClose(bufferedReader);
        return meminfo.toString();
    }
}
