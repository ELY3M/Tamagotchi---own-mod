package com.tamaproject.util;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderUtil {
    public static String[] readFile(Context context, String filename) {
        try {
            return readFileToString(context.getAssets().open(filename)).split("\n");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String readFileToString(InputStream is) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        try {
            is.read(buffer);
            bo.write(buffer);
            bo.close();
            is.close();
        } catch (IOException e) {
        }
        return bo.toString();
    }
}
