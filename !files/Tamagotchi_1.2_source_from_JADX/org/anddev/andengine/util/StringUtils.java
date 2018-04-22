package org.anddev.andengine.util;

public class StringUtils {
    public static String padFront(String pString, char pPadChar, int pLength) {
        int padCount = pLength - pString.length();
        if (padCount <= 0) {
            return pString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = padCount - 1; i >= 0; i--) {
            sb.append(pPadChar);
        }
        sb.append(pString);
        return sb.toString();
    }

    public static int countOccurrences(String pString, char pCharacter) {
        int count = 0;
        int lastOccurrence = pString.indexOf(pCharacter, 0);
        while (lastOccurrence != -1) {
            count++;
            lastOccurrence = pString.indexOf(pCharacter, lastOccurrence + 1);
        }
        return count;
    }

    public static String[] split(String pString, char pCharacter) {
        return split(pString, pCharacter, null);
    }

    public static String[] split(String pString, char pCharacter, String[] pReuse) {
        boolean reuseable;
        int partCount = countOccurrences(pString, pCharacter) + 1;
        if (pReuse == null || pReuse.length != partCount) {
            reuseable = false;
        } else {
            reuseable = true;
        }
        String[] out = reuseable ? pReuse : new String[partCount];
        if (partCount == 0) {
            out[0] = pString;
        } else {
            int from = 0;
            for (int i = 0; i < partCount - 1; i++) {
                int to = pString.indexOf(pCharacter, from);
                out[i] = pString.substring(from, to);
                from = to + 1;
            }
            out[partCount - 1] = pString.substring(from, pString.length());
        }
        return out;
    }
}
