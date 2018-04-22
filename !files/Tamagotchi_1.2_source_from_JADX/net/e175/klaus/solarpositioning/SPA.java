package net.e175.klaus.solarpositioning;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class SPA {
    static final /* synthetic */ boolean $assertionsDisabled = (!SPA.class.desiredAssertionStatus());
    private static final double HPRIME_0 = -0.8333d;
    private static final int MS_PER_DAY = 86400000;
    private static final double[][] NUTATION_COEFFS = new double[][]{new double[]{297.85036d, 445267.11148d, -0.0019142d, 5.277768981496142E-6d}, new double[]{357.52772d, 35999.05034d, -1.603E-4d, -3.3333333333333333E-6d}, new double[]{134.96298d, 477198.867398d, 0.0086972d, 1.7777777777777777E-5d}, new double[]{93.27191d, 483202.017538d, -0.0036825d, 3.0555810187307116E-6d}, new double[]{125.04452d, -1934.136261d, 0.0020708d, 2.222222222222222E-6d}};
    private static final double[] OBLIQUITY_COEFFS = new double[]{84381.448d, -4680.93d, -1.55d, 1999.25d, 51.38d, -249.67d, -39.05d, 7.12d, 27.87d, 5.79d, 2.45d};
    private static final double SIN_HPRIME_0 = Math.sin(Math.toRadians(HPRIME_0));
    private static final double[][][] TERMS_B;
    private static final double[][][] TERMS_L;
    private static final double[][] TERMS_PE = new double[][]{new double[]{-171996.0d, -174.2d, 92025.0d, 8.9d}, new double[]{-13187.0d, -1.6d, 5736.0d, -3.1d}, new double[]{-2274.0d, -0.2d, 977.0d, -0.5d}, new double[]{2062.0d, 0.2d, -895.0d, 0.5d}, new double[]{1426.0d, -3.4d, 54.0d, -0.1d}, new double[]{712.0d, 0.1d, -7.0d, 0.0d}, new double[]{-517.0d, 1.2d, 224.0d, -0.6d}, new double[]{-386.0d, -0.4d, 200.0d, 0.0d}, new double[]{-301.0d, 0.0d, 129.0d, -0.1d}, new double[]{217.0d, -0.5d, -95.0d, 0.3d}, new double[]{-158.0d, 0.0d, 0.0d, 0.0d}, new double[]{129.0d, 0.1d, -70.0d, 0.0d}, new double[]{123.0d, 0.0d, -53.0d, 0.0d}, new double[]{63.0d, 0.0d, 0.0d, 0.0d}, new double[]{63.0d, 0.1d, -33.0d, 0.0d}, new double[]{-59.0d, 0.0d, 26.0d, 0.0d}, new double[]{-58.0d, -0.1d, 32.0d, 0.0d}, new double[]{-51.0d, 0.0d, 27.0d, 0.0d}, new double[]{48.0d, 0.0d, 0.0d, 0.0d}, new double[]{46.0d, 0.0d, -24.0d, 0.0d}, new double[]{-38.0d, 0.0d, 16.0d, 0.0d}, new double[]{-31.0d, 0.0d, 13.0d, 0.0d}, new double[]{29.0d, 0.0d, 0.0d, 0.0d}, new double[]{29.0d, 0.0d, -12.0d, 0.0d}, new double[]{26.0d, 0.0d, 0.0d, 0.0d}, new double[]{-22.0d, 0.0d, 0.0d, 0.0d}, new double[]{21.0d, 0.0d, -10.0d, 0.0d}, new double[]{17.0d, -0.1d, 0.0d, 0.0d}, new double[]{16.0d, 0.0d, -8.0d, 0.0d}, new double[]{-16.0d, 0.1d, 7.0d, 0.0d}, new double[]{-15.0d, 0.0d, 9.0d, 0.0d}, new double[]{-13.0d, 0.0d, 7.0d, 0.0d}, new double[]{-12.0d, 0.0d, 6.0d, 0.0d}, new double[]{11.0d, 0.0d, 0.0d, 0.0d}, new double[]{-10.0d, 0.0d, 5.0d, 0.0d}, new double[]{-8.0d, 0.0d, 3.0d, 0.0d}, new double[]{7.0d, 0.0d, -3.0d, 0.0d}, new double[]{-7.0d, 0.0d, 0.0d, 0.0d}, new double[]{-7.0d, 0.0d, 3.0d, 0.0d}, new double[]{-7.0d, 0.0d, 3.0d, 0.0d}, new double[]{6.0d, 0.0d, 0.0d, 0.0d}, new double[]{6.0d, 0.0d, -3.0d, 0.0d}, new double[]{6.0d, 0.0d, -3.0d, 0.0d}, new double[]{-6.0d, 0.0d, 3.0d, 0.0d}, new double[]{-6.0d, 0.0d, 3.0d, 0.0d}, new double[]{5.0d, 0.0d, 0.0d, 0.0d}, new double[]{-5.0d, 0.0d, 3.0d, 0.0d}, new double[]{-5.0d, 0.0d, 3.0d, 0.0d}, new double[]{-5.0d, 0.0d, 3.0d, 0.0d}, new double[]{4.0d, 0.0d, 0.0d, 0.0d}, new double[]{4.0d, 0.0d, 0.0d, 0.0d}, new double[]{4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-4.0d, 0.0d, 0.0d, 0.0d}, new double[]{3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}};
    private static final double[][][] TERMS_R;
    private static final double[][] TERMS_Y = new double[][]{new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d}, new double[]{-2.0d, 0.0d, 0.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 0.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d}, new double[]{0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 0.0d, 0.0d}, new double[]{-2.0d, 1.0d, 0.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 0.0d, 2.0d, 1.0d}, new double[]{0.0d, 0.0d, 1.0d, 2.0d, 2.0d}, new double[]{-2.0d, -1.0d, 0.0d, 2.0d, 2.0d}, new double[]{-2.0d, 0.0d, 1.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 0.0d, 2.0d, 1.0d}, new double[]{0.0d, 0.0d, -1.0d, 2.0d, 2.0d}, new double[]{2.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 0.0d, 1.0d}, new double[]{2.0d, 0.0d, -1.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, -1.0d, 0.0d, 1.0d}, new double[]{0.0d, 0.0d, 1.0d, 2.0d, 1.0d}, new double[]{-2.0d, 0.0d, 2.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, -2.0d, 2.0d, 1.0d}, new double[]{2.0d, 0.0d, 0.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 2.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 2.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 1.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 0.0d, 2.0d, 0.0d}, new double[]{-2.0d, 0.0d, 0.0d, 2.0d, 0.0d}, new double[]{0.0d, 0.0d, -1.0d, 2.0d, 1.0d}, new double[]{0.0d, 2.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, 0.0d, -1.0d, 0.0d, 1.0d}, new double[]{-2.0d, 2.0d, 0.0d, 2.0d, 2.0d}, new double[]{0.0d, 1.0d, 0.0d, 0.0d, 1.0d}, new double[]{-2.0d, 0.0d, 1.0d, 0.0d, 1.0d}, new double[]{0.0d, -1.0d, 0.0d, 0.0d, 1.0d}, new double[]{0.0d, 0.0d, 2.0d, -2.0d, 0.0d}, new double[]{2.0d, 0.0d, -1.0d, 2.0d, 1.0d}, new double[]{2.0d, 0.0d, 1.0d, 2.0d, 2.0d}, new double[]{0.0d, 1.0d, 0.0d, 2.0d, 2.0d}, new double[]{-2.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{0.0d, -1.0d, 0.0d, 2.0d, 2.0d}, new double[]{2.0d, 0.0d, 0.0d, 2.0d, 1.0d}, new double[]{2.0d, 0.0d, 1.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 2.0d, 2.0d, 2.0d}, new double[]{-2.0d, 0.0d, 1.0d, 2.0d, 1.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 1.0d}, new double[]{2.0d, 0.0d, 0.0d, 0.0d, 1.0d}, new double[]{0.0d, -1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-2.0d, -1.0d, 0.0d, 2.0d, 1.0d}, new double[]{-2.0d, 0.0d, 0.0d, 0.0d, 1.0d}, new double[]{0.0d, 0.0d, 2.0d, 2.0d, 1.0d}, new double[]{-2.0d, 0.0d, 2.0d, 0.0d, 1.0d}, new double[]{-2.0d, 1.0d, 0.0d, 2.0d, 1.0d}, new double[]{0.0d, 0.0d, 1.0d, -2.0d, 0.0d}, new double[]{-1.0d, 0.0d, 1.0d, 0.0d, 0.0d}, new double[]{-2.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 2.0d, 0.0d}, new double[]{0.0d, 0.0d, -2.0d, 2.0d, 2.0d}, new double[]{-1.0d, -1.0d, 1.0d, 0.0d, 0.0d}, new double[]{0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{0.0d, -1.0d, 1.0d, 2.0d, 2.0d}, new double[]{2.0d, -1.0d, -1.0d, 2.0d, 2.0d}, new double[]{0.0d, 0.0d, 3.0d, 2.0d, 2.0d}, new double[]{2.0d, -1.0d, 0.0d, 2.0d, 2.0d}};

    private static final class AlphaDelta {
        final double alpha;
        final double delta;

        AlphaDelta(double alpha, double delta) {
            this.alpha = alpha;
            this.delta = delta;
        }
    }

    static {
        r0 = new double[6][][];
        r0[0] = new double[][]{new double[]{1.75347046E8d, 0.0d, 0.0d}, new double[]{3341656.0d, 4.6692568d, 6283.07585d}, new double[]{34894.0d, 4.6261d, 12566.1517d}, new double[]{3497.0d, 2.7441d, 5753.3849d}, new double[]{3418.0d, 2.8289d, 3.5231d}, new double[]{3136.0d, 3.6277d, 77713.7715d}, new double[]{2676.0d, 4.4181d, 7860.4194d}, new double[]{2343.0d, 6.1352d, 3930.2097d}, new double[]{1324.0d, 0.7425d, 11506.7698d}, new double[]{1273.0d, 2.0371d, 529.691d}, new double[]{1199.0d, 1.1096d, 1577.3435d}, new double[]{990.0d, 5.233d, 5884.927d}, new double[]{902.0d, 2.045d, 26.298d}, new double[]{857.0d, 3.508d, 398.149d}, new double[]{780.0d, 1.179d, 5223.694d}, new double[]{753.0d, 2.533d, 5507.553d}, new double[]{505.0d, 4.583d, 18849.228d}, new double[]{492.0d, 4.205d, 775.523d}, new double[]{357.0d, 2.92d, 0.067d}, new double[]{317.0d, 5.849d, 11790.629d}, new double[]{284.0d, 1.899d, 796.298d}, new double[]{271.0d, 0.315d, 10977.079d}, new double[]{243.0d, 0.345d, 5486.778d}, new double[]{206.0d, 4.806d, 2544.314d}, new double[]{205.0d, 1.869d, 5573.143d}, new double[]{202.0d, 2.458d, 6069.777d}, new double[]{156.0d, 0.833d, 213.299d}, new double[]{132.0d, 3.411d, 2942.463d}, new double[]{126.0d, 1.083d, 20.775d}, new double[]{115.0d, 0.645d, 0.98d}, new double[]{103.0d, 0.636d, 4694.003d}, new double[]{102.0d, 0.976d, 15720.839d}, new double[]{102.0d, 4.267d, 7.114d}, new double[]{99.0d, 6.21d, 2146.17d}, new double[]{98.0d, 0.68d, 155.42d}, new double[]{86.0d, 5.98d, 161000.69d}, new double[]{85.0d, 1.3d, 6275.96d}, new double[]{85.0d, 3.67d, 71430.7d}, new double[]{80.0d, 1.81d, 17260.15d}, new double[]{79.0d, 3.04d, 12036.46d}, new double[]{75.0d, 1.76d, 5088.63d}, new double[]{74.0d, 3.5d, 3154.69d}, new double[]{74.0d, 4.68d, 801.82d}, new double[]{70.0d, 0.83d, 9437.76d}, new double[]{62.0d, 3.98d, 8827.39d}, new double[]{61.0d, 1.82d, 7084.9d}, new double[]{57.0d, 2.78d, 6286.6d}, new double[]{56.0d, 4.39d, 14143.5d}, new double[]{56.0d, 3.47d, 6279.55d}, new double[]{52.0d, 0.19d, 12139.55d}, new double[]{52.0d, 1.33d, 1748.02d}, new double[]{51.0d, 0.28d, 5856.48d}, new double[]{49.0d, 0.49d, 1194.45d}, new double[]{41.0d, 5.37d, 8429.24d}, new double[]{41.0d, 2.4d, 19651.05d}, new double[]{39.0d, 6.17d, 10447.39d}, new double[]{37.0d, 6.04d, 10213.29d}, new double[]{37.0d, 2.57d, 1059.38d}, new double[]{36.0d, 1.71d, 2352.87d}, new double[]{36.0d, 1.78d, 6812.77d}, new double[]{33.0d, 0.59d, 17789.85d}, new double[]{30.0d, 0.44d, 83996.85d}, new double[]{30.0d, 2.74d, 1349.87d}, new double[]{25.0d, 3.16d, 4690.48d}};
        r0[1] = new double[][]{new double[]{6.28331966747E11d, 0.0d, 0.0d}, new double[]{206059.0d, 2.678235d, 6283.07585d}, new double[]{4303.0d, 2.6351d, 12566.1517d}, new double[]{425.0d, 1.59d, 3.523d}, new double[]{119.0d, 5.796d, 26.298d}, new double[]{109.0d, 2.966d, 1577.344d}, new double[]{93.0d, 2.59d, 18849.23d}, new double[]{72.0d, 1.14d, 529.69d}, new double[]{68.0d, 1.87d, 398.15d}, new double[]{67.0d, 4.41d, 5507.55d}, new double[]{59.0d, 2.89d, 5223.69d}, new double[]{56.0d, 2.17d, 155.42d}, new double[]{45.0d, 0.4d, 796.3d}, new double[]{36.0d, 0.47d, 775.52d}, new double[]{29.0d, 2.65d, 7.11d}, new double[]{21.0d, 5.34d, 0.98d}, new double[]{19.0d, 1.85d, 5486.78d}, new double[]{19.0d, 4.97d, 213.3d}, new double[]{17.0d, 2.99d, 6275.96d}, new double[]{16.0d, 0.03d, 2544.31d}, new double[]{16.0d, 1.43d, 2146.17d}, new double[]{15.0d, 1.21d, 10977.08d}, new double[]{12.0d, 2.83d, 1748.02d}, new double[]{12.0d, 3.26d, 5088.63d}, new double[]{12.0d, 5.27d, 1194.45d}, new double[]{12.0d, 2.08d, 4694.0d}, new double[]{11.0d, 0.77d, 553.57d}, new double[]{10.0d, 1.3d, 6286.6d}, new double[]{10.0d, 4.24d, 1349.87d}, new double[]{9.0d, 2.7d, 242.73d}, new double[]{9.0d, 5.64d, 951.72d}, new double[]{8.0d, 5.3d, 2352.87d}, new double[]{6.0d, 2.65d, 9437.76d}, new double[]{6.0d, 4.67d, 4690.48d}};
        r0[2] = new double[][]{new double[]{52919.0d, 0.0d, 0.0d}, new double[]{8720.0d, 1.0721d, 6283.0758d}, new double[]{309.0d, 0.867d, 12566.152d}, new double[]{27.0d, 0.05d, 3.52d}, new double[]{16.0d, 5.19d, 26.3d}, new double[]{16.0d, 3.68d, 155.42d}, new double[]{10.0d, 0.76d, 18849.23d}, new double[]{9.0d, 2.06d, 77713.77d}, new double[]{7.0d, 0.83d, 775.52d}, new double[]{5.0d, 4.66d, 1577.34d}, new double[]{4.0d, 1.03d, 7.11d}, new double[]{4.0d, 3.44d, 5573.14d}, new double[]{3.0d, 5.14d, 796.3d}, new double[]{3.0d, 6.05d, 5507.55d}, new double[]{3.0d, 1.19d, 242.73d}, new double[]{3.0d, 6.12d, 529.69d}, new double[]{3.0d, 0.31d, 398.15d}, new double[]{3.0d, 2.28d, 553.57d}, new double[]{2.0d, 4.38d, 5223.69d}, new double[]{2.0d, 3.75d, 0.98d}};
        r0[3] = new double[][]{new double[]{289.0d, 5.844d, 6283.076d}, new double[]{35.0d, 0.0d, 0.0d}, new double[]{17.0d, 5.49d, 12566.15d}, new double[]{3.0d, 5.2d, 155.42d}, new double[]{1.0d, 4.72d, 3.52d}, new double[]{1.0d, 5.3d, 18849.23d}, new double[]{1.0d, 5.97d, 242.73d}};
        r0[4] = new double[][]{new double[]{114.0d, 3.142d, 0.0d}, new double[]{8.0d, 4.13d, 6283.08d}, new double[]{1.0d, 3.84d, 12566.15d}};
        r0[5] = new double[][]{new double[]{1.0d, 3.14d, 0.0d}};
        TERMS_L = r0;
        r0 = new double[2][][];
        r0[0] = new double[][]{new double[]{280.0d, 3.199d, 84334.662d}, new double[]{102.0d, 5.422d, 5507.553d}, new double[]{80.0d, 3.88d, 5223.69d}, new double[]{44.0d, 3.7d, 2352.87d}, new double[]{32.0d, 4.0d, 1577.34d}};
        r0[1] = new double[][]{new double[]{9.0d, 3.9d, 5507.55d}, new double[]{6.0d, 1.73d, 5223.69d}};
        TERMS_B = r0;
        r0 = new double[5][][];
        r0[0] = new double[][]{new double[]{1.00013989E8d, 0.0d, 0.0d}, new double[]{1670700.0d, 3.0984635d, 6283.07585d}, new double[]{13956.0d, 3.05525d, 12566.1517d}, new double[]{3084.0d, 5.1985d, 77713.7715d}, new double[]{1628.0d, 1.1739d, 5753.3849d}, new double[]{1576.0d, 2.8469d, 7860.4194d}, new double[]{925.0d, 5.453d, 11506.77d}, new double[]{542.0d, 4.564d, 3930.21d}, new double[]{472.0d, 3.661d, 5884.927d}, new double[]{346.0d, 0.964d, 5507.553d}, new double[]{329.0d, 5.9d, 5223.694d}, new double[]{307.0d, 0.299d, 5573.143d}, new double[]{243.0d, 4.273d, 11790.629d}, new double[]{212.0d, 5.847d, 1577.344d}, new double[]{186.0d, 5.022d, 10977.079d}, new double[]{175.0d, 3.012d, 18849.228d}, new double[]{110.0d, 5.055d, 5486.778d}, new double[]{98.0d, 0.89d, 6069.78d}, new double[]{86.0d, 5.69d, 15720.84d}, new double[]{86.0d, 1.27d, 161000.69d}, new double[]{65.0d, 0.27d, 17260.15d}, new double[]{63.0d, 0.92d, 529.69d}, new double[]{57.0d, 2.01d, 83996.85d}, new double[]{56.0d, 5.24d, 71430.7d}, new double[]{49.0d, 3.25d, 2544.31d}, new double[]{47.0d, 2.58d, 775.52d}, new double[]{45.0d, 5.54d, 9437.76d}, new double[]{43.0d, 6.01d, 6275.96d}, new double[]{39.0d, 5.36d, 4694.0d}, new double[]{38.0d, 2.39d, 8827.39d}, new double[]{37.0d, 0.83d, 19651.05d}, new double[]{37.0d, 4.9d, 12139.55d}, new double[]{36.0d, 1.67d, 12036.46d}, new double[]{35.0d, 1.84d, 2942.46d}, new double[]{33.0d, 0.24d, 7084.9d}, new double[]{32.0d, 0.18d, 5088.63d}, new double[]{32.0d, 1.78d, 398.15d}, new double[]{28.0d, 1.21d, 6286.6d}, new double[]{28.0d, 1.9d, 6279.55d}, new double[]{26.0d, 4.59d, 10447.39d}};
        r0[1] = new double[][]{new double[]{103019.0d, 1.10749d, 6283.07585d}, new double[]{1721.0d, 1.0644d, 12566.1517d}, new double[]{702.0d, 3.142d, 0.0d}, new double[]{32.0d, 1.02d, 18849.23d}, new double[]{31.0d, 2.84d, 5507.55d}, new double[]{25.0d, 1.32d, 5223.69d}, new double[]{18.0d, 1.42d, 1577.34d}, new double[]{10.0d, 5.91d, 10977.08d}, new double[]{9.0d, 1.42d, 6275.96d}, new double[]{9.0d, 0.27d, 5486.78d}};
        r0[2] = new double[][]{new double[]{4359.0d, 5.7846d, 6283.0758d}, new double[]{124.0d, 5.579d, 12566.152d}, new double[]{12.0d, 3.14d, 0.0d}, new double[]{9.0d, 3.63d, 77713.77d}, new double[]{6.0d, 1.87d, 5573.14d}, new double[]{3.0d, 5.47d, 18849.23d}};
        r0[3] = new double[][]{new double[]{145.0d, 4.273d, 6283.076d}, new double[]{7.0d, 3.92d, 12566.15d}};
        r0[4] = new double[][]{new double[]{4.0d, 2.56d, 6283.08d}};
        TERMS_R = r0;
    }

    private SPA() {
    }

    public static AzimuthZenithAngle calculateSolarPosition(GregorianCalendar date, double latitude, double longitude, double elevation, double deltaT, double pressure, double temperature) {
        JulianDate julianDate = new JulianDate(date, deltaT);
        double jme = julianDate.getJulianEphemerisMillennium();
        double jce = julianDate.getJulianEphemerisCentury();
        double lDegrees = limitDegreesTo360(Math.toDegrees(calculateLBRPolynomial(jme, calculateLBRTerms(jme, TERMS_L))));
        double bDegrees = limitDegreesTo360(Math.toDegrees(calculateLBRPolynomial(jme, calculateLBRTerms(jme, TERMS_B))));
        double r = calculateLBRPolynomial(jme, calculateLBRTerms(jme, TERMS_R));
        double thetaDegrees = limitDegreesTo360(180.0d + lDegrees);
        double beta = Math.toRadians(-bDegrees);
        double[] xTerms = calculateNutationTerms(jce);
        double[] deltaPsiI = calculateDeltaPsiI(jce, xTerms);
        double[] deltaEpsilonI = calculateDeltaEpsilonI(jce, xTerms);
        double deltaPsi = calculateDeltaPsiEpsilon(deltaPsiI);
        double epsilonDegrees = calculateTrueObliquityOfEcliptic(julianDate, calculateDeltaPsiEpsilon(deltaEpsilonI));
        double epsilon = Math.toRadians(epsilonDegrees);
        double lambda = Math.toRadians((thetaDegrees + deltaPsi) + (-20.4898d / (3600.0d * r)));
        double nuDegrees = calculateApparentSiderealTimeAtGreenwich(julianDate, deltaPsi, epsilonDegrees);
        double alphaDegrees = calculateGeocentricSunRightAscension(beta, epsilon, lambda);
        double deltaDegrees = Math.toDegrees(calculateGeocentricSunDeclination(beta, epsilon, lambda));
        double hDegrees = limitDegreesTo360((nuDegrees + longitude) - alphaDegrees);
        double h = Math.toRadians(hDegrees);
        double xi = Math.toRadians(8.794d / (3600.0d * r));
        double phi = Math.toRadians(latitude);
        double delta = Math.toRadians(deltaDegrees);
        double u = Math.atan(0.99664719d * Math.tan(phi));
        double x = Math.cos(u) + ((Math.cos(phi) * elevation) / 6378140.0d);
        double y = (0.99664719d * Math.sin(u)) + ((Math.sin(phi) * elevation) / 6378140.0d);
        double deltaAlphaDegrees = Math.toDegrees(Math.atan2(((-x) * Math.sin(xi)) * Math.sin(h), Math.cos(delta) - ((Math.sin(xi) * x) * Math.cos(h))));
        return calculateTopocentricSolarPosition(pressure, temperature, phi, Math.atan2((Math.sin(delta) - (Math.sin(xi) * y)) * Math.cos(Math.toRadians(deltaAlphaDegrees)), Math.cos(delta) - ((Math.sin(xi) * x) * Math.cos(h))), Math.toRadians(hDegrees - deltaAlphaDegrees));
    }

    public static AzimuthZenithAngle calculateSolarPosition(GregorianCalendar date, double latitude, double longitude, double elevation, double deltaT) {
        return calculateSolarPosition(date, latitude, longitude, elevation, deltaT, Double.MIN_VALUE, Double.MIN_VALUE);
    }

    public static GregorianCalendar[] calculateSunriseTransitSet(GregorianCalendar day, double latitude, double longitude, double deltaT) {
        int i;
        GregorianCalendar gregorianCalendar;
        JulianDate julianDate = new JulianDate(startOfDayUT(day), 0.0d);
        double phi = Math.toRadians(latitude);
        double jce = julianDate.getJulianEphemerisCentury();
        double[] xTerms = calculateNutationTerms(jce);
        double[] deltaPsiI = calculateDeltaPsiI(jce, xTerms);
        double[] deltaEpsilonI = calculateDeltaEpsilonI(jce, xTerms);
        double deltaPsi = calculateDeltaPsiEpsilon(deltaPsiI);
        double epsilonDegrees = calculateTrueObliquityOfEcliptic(julianDate, calculateDeltaPsiEpsilon(deltaEpsilonI));
        double nuDegrees = calculateApparentSiderealTimeAtGreenwich(julianDate, deltaPsi, epsilonDegrees);
        AlphaDelta[] alphaDeltas = new AlphaDelta[3];
        for (i = 0; i < alphaDeltas.length; i++) {
            alphaDeltas[i] = calculateAlphaDelta(new JulianDate((julianDate.getJulianDate() + ((double) i)) - 1.0d, 0.0d).getJulianEphemerisMillennium(), deltaPsi, epsilonDegrees);
        }
        double[] m = new double[3];
        m[0] = ((alphaDeltas[1].alpha - longitude) - nuDegrees) / 360.0d;
        double acosArg = (SIN_HPRIME_0 - Math.sin(Math.sin(Math.toRadians(alphaDeltas[1].delta)) * phi)) / (Math.cos(phi) * Math.cos(Math.toRadians(alphaDeltas[1].delta)));
        boolean noSunriseOrSet = acosArg < -1.0d || acosArg > 1.0d;
        double h0Degrees = limitTo(Math.toDegrees(Math.acos(acosArg)), 180.0d);
        m[1] = limitTo(m[0] - (h0Degrees / 360.0d), 1.0d);
        m[2] = limitTo(m[0] + (h0Degrees / 360.0d), 1.0d);
        m[0] = limitTo(m[0], 1.0d);
        double[] nu = new double[3];
        for (i = 0; i < m.length; i++) {
            nu[i] = (360.985647d * m[i]) + nuDegrees;
        }
        double[] n = new double[3];
        for (i = 0; i < m.length; i++) {
            n[i] = m[i] + (deltaT / 86400.0d);
        }
        double a = limitIfNecessary(alphaDeltas[1].alpha - alphaDeltas[0].alpha);
        double aPrime = limitIfNecessary(alphaDeltas[1].delta - alphaDeltas[0].delta);
        double b = limitIfNecessary(alphaDeltas[2].alpha - alphaDeltas[1].alpha);
        double bPrime = limitIfNecessary(alphaDeltas[2].delta - alphaDeltas[1].delta);
        double c = b - a;
        double cPrime = bPrime - aPrime;
        AlphaDelta[] alphaDeltaPrimes = new AlphaDelta[3];
        for (i = 0; i < alphaDeltaPrimes.length; i++) {
            alphaDeltaPrimes[i] = new AlphaDelta(alphaDeltas[1].alpha + ((n[i] * ((a + b) + (n[i] * c))) / 2.0d), alphaDeltas[1].delta + ((n[i] * ((aPrime + bPrime) + (n[i] * cPrime))) / 2.0d));
        }
        double[] hPrime = new double[3];
        for (i = 0; i < hPrime.length; i++) {
            hPrime[i] = limitHprime((nu[i] + longitude) - alphaDeltaPrimes[i].alpha);
        }
        double[] h = new double[3];
        for (i = 0; i < h.length; i++) {
            double deltaPrimeRad = Math.toRadians(alphaDeltaPrimes[i].delta);
            h[i] = Math.toDegrees(Math.asin((Math.sin(phi) * Math.sin(deltaPrimeRad)) + ((Math.cos(phi) * Math.cos(deltaPrimeRad)) * Math.cos(Math.toRadians(hPrime[i])))));
        }
        double t = m[0] - (hPrime[0] / 360.0d);
        double r = m[1] + ((h[1] - HPRIME_0) / (((360.0d * Math.cos(Math.toRadians(alphaDeltaPrimes[1].delta))) * Math.cos(phi)) * Math.sin(Math.toRadians(hPrime[1]))));
        double s = m[2] + ((h[2] - HPRIME_0) / (((360.0d * Math.cos(Math.toRadians(alphaDeltaPrimes[2].delta))) * Math.cos(phi)) * Math.sin(Math.toRadians(hPrime[2]))));
        GregorianCalendar[] gregorianCalendarArr = new GregorianCalendar[3];
        if (noSunriseOrSet) {
            gregorianCalendar = null;
        } else {
            gregorianCalendar = addFractionOfDay(day, r);
        }
        gregorianCalendarArr[0] = gregorianCalendar;
        gregorianCalendarArr[1] = addFractionOfDay(day, t);
        if (noSunriseOrSet) {
            gregorianCalendar = null;
        } else {
            gregorianCalendar = addFractionOfDay(day, s);
        }
        gregorianCalendarArr[2] = gregorianCalendar;
        return gregorianCalendarArr;
    }

    private static GregorianCalendar addFractionOfDay(GregorianCalendar day, double fraction) {
        GregorianCalendar dayStart = (GregorianCalendar) day.clone();
        dayStart.set(12, 0);
        dayStart.set(13, 0);
        dayStart.set(14, 0);
        dayStart.set(11, 0);
        int offset = day.getTimeZone().getOffset(dayStart.getTimeInMillis());
        dayStart.set(11, 0);
        int addMs = (int) (limitTo(fraction + (((double) offset) / 8.64E7d), 1.0d) * 8.64E7d);
        if ($assertionsDisabled || (addMs >= 0 && addMs <= MS_PER_DAY)) {
            dayStart.setTimeInMillis(dayStart.getTimeInMillis() + ((long) addMs));
            return dayStart;
        }
        throw new AssertionError();
    }

    private static double limitHprime(double hPrime) {
        hPrime /= 360.0d;
        double limited = 360.0d * (hPrime - Math.floor(hPrime));
        if (limited < -180.0d) {
            return limited + 360.0d;
        }
        if (limited > 180.0d) {
            return limited - 360.0d;
        }
        return limited;
    }

    private static double limitIfNecessary(double val) {
        return Math.abs(val) > 2.0d ? limitTo(val, 1.0d) : val;
    }

    private static AlphaDelta calculateAlphaDelta(double jme, double deltaPsi, double epsilonDegrees) {
        double bDegrees = limitDegreesTo360(Math.toDegrees(calculateLBRPolynomial(jme, calculateLBRTerms(jme, TERMS_B))));
        double r = calculateLBRPolynomial(jme, calculateLBRTerms(jme, TERMS_R));
        double thetaDegrees = limitDegreesTo360(180.0d + limitDegreesTo360(Math.toDegrees(calculateLBRPolynomial(jme, calculateLBRTerms(jme, TERMS_L)))));
        double beta = Math.toRadians(-bDegrees);
        double epsilon = Math.toRadians(epsilonDegrees);
        double lambda = Math.toRadians((thetaDegrees + deltaPsi) + (-20.4898d / (3600.0d * r)));
        return new AlphaDelta(calculateGeocentricSunRightAscension(beta, epsilon, lambda), Math.toDegrees(calculateGeocentricSunDeclination(beta, epsilon, lambda)));
    }

    private static GregorianCalendar startOfDayUT(GregorianCalendar day) {
        GregorianCalendar utcCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        utcCalendar.set(day.get(1), day.get(2), day.get(5));
        utcCalendar.set(0, day.get(0));
        utcCalendar.set(11, 0);
        utcCalendar.set(12, 0);
        utcCalendar.set(13, 0);
        utcCalendar.set(14, 0);
        return utcCalendar;
    }

    private static AzimuthZenithAngle calculateTopocentricSolarPosition(double p, double t, double phi, double deltaPrime, double hPrime) {
        double deltaEdegrees;
        double eZeroDegrees = Math.toDegrees(Math.asin((Math.sin(phi) * Math.sin(deltaPrime)) + ((Math.cos(phi) * Math.cos(deltaPrime)) * Math.cos(hPrime))));
        if (p < 0.0d || p > 3000.0d || t < -273.0d || t > 273.0d) {
            deltaEdegrees = 0.0d;
        } else {
            deltaEdegrees = ((p / 1010.0d) * (283.0d / (273.0d + t))) * (1.02d / (60.0d * Math.tan(Math.toRadians((10.3d / (5.11d + eZeroDegrees)) + eZeroDegrees))));
        }
        return new AzimuthZenithAngle(limitDegreesTo360(180.0d + limitDegreesTo360(Math.toDegrees(Math.atan2(Math.sin(hPrime), (Math.cos(hPrime) * Math.sin(phi)) - (Math.tan(deltaPrime) * Math.cos(phi)))))), 90.0d - (eZeroDegrees + deltaEdegrees));
    }

    private static double calculateGeocentricSunDeclination(double betaRad, double epsilonRad, double lambdaRad) {
        return Math.asin((Math.sin(betaRad) * Math.cos(epsilonRad)) + ((Math.cos(betaRad) * Math.sin(epsilonRad)) * Math.sin(lambdaRad)));
    }

    private static double calculateGeocentricSunRightAscension(double betaRad, double epsilonRad, double lambdaRad) {
        return limitDegreesTo360(Math.toDegrees(Math.atan2((Math.sin(lambdaRad) * Math.cos(epsilonRad)) - (Math.tan(betaRad) * Math.sin(epsilonRad)), Math.cos(lambdaRad))));
    }

    private static double calculateTrueObliquityOfEcliptic(JulianDate jd, double deltaEpsilon) {
        return (calculatePolynomial(jd.getJulianEphemerisMillennium() / 10.0d, OBLIQUITY_COEFFS) / 3600.0d) + deltaEpsilon;
    }

    private static double calculateApparentSiderealTimeAtGreenwich(JulianDate jd, double deltaPsi, double epsilonDegrees) {
        return (Math.cos(Math.toRadians(epsilonDegrees)) * deltaPsi) + limitDegreesTo360(((280.46061837d + (360.98564736629d * (jd.getJulianDate() - 2451545.0d))) + (3.87933E-4d * Math.pow(jd.getJulianCentury(), 2.0d))) - (Math.pow(jd.getJulianCentury(), 2.0d) / 3.871E7d));
    }

    private static double calculateDeltaPsiEpsilon(double[] deltaPsiOrEpsilonI) {
        double sum = 0.0d;
        for (double element : deltaPsiOrEpsilonI) {
            sum += element;
        }
        return sum / 3.6E7d;
    }

    private static double[] calculateDeltaPsiI(double jce, double[] x) {
        double[] deltaPsiI = new double[TERMS_PE.length];
        for (int i = 0; i < TERMS_PE.length; i++) {
            deltaPsiI[i] = ((TERMS_PE[i][1] * jce) + TERMS_PE[i][0]) * Math.sin(Math.toRadians(calculateXjYtermSum(i, x)));
        }
        return deltaPsiI;
    }

    private static double[] calculateDeltaEpsilonI(double jce, double[] x) {
        double[] deltaEpsilonI = new double[TERMS_PE.length];
        for (int i = 0; i < TERMS_PE.length; i++) {
            deltaEpsilonI[i] = ((TERMS_PE[i][3] * jce) + TERMS_PE[i][2]) * Math.cos(Math.toRadians(calculateXjYtermSum(i, x)));
        }
        return deltaEpsilonI;
    }

    private static double calculateXjYtermSum(int i, double[] x) {
        double sum = 0.0d;
        for (int j = 0; j < x.length; j++) {
            sum += x[j] * TERMS_Y[i][j];
        }
        return sum;
    }

    private static double[] calculateNutationTerms(double jce) {
        double[] x = new double[NUTATION_COEFFS.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = calculatePolynomial(jce, NUTATION_COEFFS[i]);
        }
        return x;
    }

    private static double limitDegreesTo360(double degrees) {
        return limitTo(degrees, 360.0d);
    }

    private static double limitTo(double degrees, double max) {
        double dividedDegrees = degrees / max;
        double limited = max * (dividedDegrees - Math.floor(dividedDegrees));
        return limited < 0.0d ? limited + max : limited;
    }

    private static double calculateLBRPolynomial(double jme, double[] terms) {
        return calculatePolynomial(jme, terms) / 1.0E8d;
    }

    private static double calculatePolynomial(double x, double[] coeffs) {
        double sum = 0.0d;
        for (int i = 0; i < coeffs.length; i++) {
            sum += coeffs[i] * Math.pow(x, (double) i);
        }
        return sum;
    }

    private static double[] calculateLBRTerms(double jme, double[][][] termCoeffs) {
        double[] lbrTerms = new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
        for (int i = 0; i < termCoeffs.length; i++) {
            double lbrSum = 0.0d;
            for (int v = 0; v < termCoeffs[i].length; v++) {
                lbrSum += Math.cos((termCoeffs[i][v][2] * jme) + termCoeffs[i][v][1]) * termCoeffs[i][v][0];
            }
            lbrTerms[i] = lbrSum;
        }
        return lbrTerms;
    }
}
