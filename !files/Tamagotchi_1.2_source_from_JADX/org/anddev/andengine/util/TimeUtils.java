package org.anddev.andengine.util;

import org.anddev.andengine.util.constants.TimeConstants;

public class TimeUtils implements TimeConstants {
    public static String formatSeconds(int pSecondsTotal) {
        return formatSeconds(pSecondsTotal, new StringBuilder());
    }

    public static String formatSeconds(int pSecondsTotal, StringBuilder pStringBuilder) {
        int seconds = pSecondsTotal % 60;
        pStringBuilder.append(pSecondsTotal / 60);
        pStringBuilder.append(':');
        if (seconds < 10) {
            pStringBuilder.append('0');
        }
        pStringBuilder.append(seconds);
        return pStringBuilder.toString();
    }
}
