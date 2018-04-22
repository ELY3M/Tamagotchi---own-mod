package org.anddev.andengine.extension.svg.util.constants;

public class MathUtils {
    public static final double[] POWERS_OF_10 = new double[128];

    static {
        for (int i = 0; i < POWERS_OF_10.length; i++) {
            POWERS_OF_10[i] = Math.pow(10.0d, (double) i);
        }
    }
}
