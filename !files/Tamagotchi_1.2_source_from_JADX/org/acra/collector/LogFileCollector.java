package org.acra.collector;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.acra.ACRA;
import org.acra.util.BoundedLinkedList;

class LogFileCollector {
    LogFileCollector() {
    }

    @NonNull
    public String collectLogFile(@NonNull Context context, @NonNull String fileName, int numberOfLines) throws IOException {
        BoundedLinkedList<String> resultBuffer = new BoundedLinkedList(numberOfLines);
        BufferedReader reader = getReader(context, fileName);
        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                resultBuffer.add(line + "\n");
            }
            return resultBuffer.toString();
        } finally {
            CollectorUtil.safeClose(reader);
        }
    }

    @NonNull
    private static BufferedReader getReader(@NonNull Context context, @NonNull String fileName) {
        try {
            FileInputStream inputStream;
            if (fileName.startsWith("/")) {
                inputStream = new FileInputStream(fileName);
            } else if (fileName.contains("/")) {
                inputStream = new FileInputStream(new File(context.getFilesDir(), fileName));
            } else {
                inputStream = context.openFileInput(fileName);
            }
            return new BufferedReader(new InputStreamReader(inputStream), 1024);
        } catch (FileNotFoundException e) {
            ACRA.log.mo4043e(ACRA.LOG_TAG, "Cannot find application log file : '" + fileName + "'");
            return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0])));
        }
    }
}
