package com.google.android.gms.tagmanager;

import org.anddev.andengine.extension.svg.util.constants.ColorUtils;

public class zzk {
    public static byte[] zzfO(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("purported base16 string has odd number of characters");
        }
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            int digit = Character.digit(str.charAt(i), 16);
            int digit2 = Character.digit(str.charAt(i + 1), 16);
            if (digit == -1 || digit2 == -1) {
                throw new IllegalArgumentException("purported base16 string has illegal char");
            }
            bArr[i / 2] = (byte) ((digit << 4) + digit2);
        }
        return bArr;
    }

    public static String zzj(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            if ((b & ColorUtils.COLOR_MASK_12BIT_RGB_G) == 0) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(b & 255));
        }
        return stringBuilder.toString().toUpperCase();
    }
}
