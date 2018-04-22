package org.anddev.andengine.util;

public class ArrayUtils {
    public static <T> T random(T[] pArray) {
        return pArray[MathUtils.random(0, pArray.length - 1)];
    }

    public static void reverse(byte[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                byte tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static void reverse(short[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                short tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static void reverse(int[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                int tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static void reverse(long[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                long tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static void reverse(float[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                float tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static void reverse(double[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                double tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static void reverse(Object[] pArray) {
        if (pArray != null) {
            int j = pArray.length - 1;
            for (int i = 0; j > i; i++) {
                Object tmp = pArray[j];
                pArray[j] = pArray[i];
                pArray[i] = tmp;
                j--;
            }
        }
    }

    public static boolean equals(byte[] pArrayA, int pOffsetA, byte[] pArrayB, int pOffsetB, int pLength) {
        int lastIndexA = pOffsetA + pLength;
        if (lastIndexA > pArrayA.length) {
            throw new ArrayIndexOutOfBoundsException(pArrayA.length);
        } else if (pOffsetB + pLength > pArrayB.length) {
            throw new ArrayIndexOutOfBoundsException(pArrayB.length);
        } else {
            int a = pOffsetA;
            int b = pOffsetB;
            while (a < lastIndexA) {
                if (pArrayA[a] != pArrayB[b]) {
                    return false;
                }
                a++;
                b++;
            }
            return true;
        }
    }
}
