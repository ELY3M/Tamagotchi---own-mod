package net.e175.klaus.solarpositioning;

import java.util.GregorianCalendar;

public final class DeltaT {
    private DeltaT() {
    }

    public static double estimate(GregorianCalendar forDate) {
        double year = decimalYear(forDate);
        if (year < -500.0d) {
            return -20.0d + (32.0d * Math.pow((year - 1820.0d) / 100.0d, 2.0d));
        }
        double u;
        if (year < 500.0d) {
            u = year / 100.0d;
            return (((((10583.6d - (1014.41d * u)) + (33.78311d * Math.pow(u, 2.0d))) - (5.952053d * Math.pow(u, 3.0d))) - (0.1798452d * Math.pow(u, 4.0d))) + (0.022174192d * Math.pow(u, 5.0d))) + (0.0090316521d * Math.pow(u, 6.0d));
        } else if (year < 1600.0d) {
            u = (year - 1000.0d) / 100.0d;
            return (((((1574.2d - (556.01d * u)) + (71.23472d * Math.pow(u, 2.0d))) + (0.319781d * Math.pow(u, 3.0d))) - (0.8503463d * Math.pow(u, 4.0d))) - (0.005050998d * Math.pow(u, 5.0d))) + (0.0083572073d * Math.pow(u, 6.0d));
        } else if (year < 1700.0d) {
            t = year - 1600.0d;
            return ((120.0d - (0.9808d * t)) - (0.01532d * Math.pow(t, 2.0d))) + (Math.pow(t, 3.0d) / 7129.0d);
        } else if (year < 1800.0d) {
            t = year - 1700.0d;
            return (((8.83d + (0.1603d * t)) - (0.0059285d * Math.pow(t, 2.0d))) + (1.3336E-4d * Math.pow(t, 3.0d))) - (Math.pow(t, 4.0d) / 1174000.0d);
        } else if (year < 1860.0d) {
            t = year - 1800.0d;
            return ((((((13.72d - (0.332447d * t)) + (0.0068612d * Math.pow(t, 2.0d))) + (0.0041116d * Math.pow(t, 3.0d))) - (3.7436E-4d * Math.pow(t, 4.0d))) + (1.21272E-5d * Math.pow(t, 5.0d))) - (1.699E-7d * Math.pow(t, 6.0d))) + (8.75E-10d * Math.pow(t, 7.0d));
        } else if (year < 1900.0d) {
            t = year - 1860.0d;
            return ((((7.62d + (0.5737d * t)) - (0.251754d * Math.pow(t, 2.0d))) + (0.01680668d * Math.pow(t, 3.0d))) - (4.473624E-4d * Math.pow(t, 4.0d))) + (Math.pow(t, 5.0d) / 233174.0d);
        } else if (year < 1920.0d) {
            t = year - 1900.0d;
            return (((-2.79d + (1.494119d * t)) - (0.0598939d * Math.pow(t, 2.0d))) + (0.0061966d * Math.pow(t, 3.0d))) - (1.97E-4d * Math.pow(t, 4.0d));
        } else if (year < 1941.0d) {
            t = year - 1920.0d;
            return ((21.2d + (0.84493d * t)) - (0.0761d * Math.pow(t, 2.0d))) + (0.0020936d * Math.pow(t, 3.0d));
        } else if (year < 1961.0d) {
            t = year - 1950.0d;
            return ((29.07d + (0.407d * t)) - (Math.pow(t, 2.0d) / 233.0d)) + (Math.pow(t, 3.0d) / 2547.0d);
        } else if (year < 1986.0d) {
            t = year - 1975.0d;
            return ((45.45d + (1.067d * t)) - (Math.pow(t, 2.0d) / 260.0d)) - (Math.pow(t, 3.0d) / 718.0d);
        } else if (year < 2005.0d) {
            t = year - 2000.0d;
            return ((((63.86d + (0.3345d * t)) - (0.060374d * Math.pow(t, 2.0d))) + (0.0017275d * Math.pow(t, 3.0d))) + (6.51814E-4d * Math.pow(t, 4.0d))) + (2.373599E-5d * Math.pow(t, 5.0d));
        } else if (year < 2050.0d) {
            t = year - 2000.0d;
            return (62.92d + (0.32217d * t)) + (0.005589d * Math.pow(t, 2.0d));
        } else if (year < 2150.0d) {
            return (-20.0d + (32.0d * Math.pow((year - 1820.0d) / 100.0d, 2.0d))) - (0.5628d * (2150.0d - year));
        } else {
            return -20.0d + (32.0d * Math.pow((year - 1820.0d) / 100.0d, 2.0d));
        }
    }

    private static double decimalYear(GregorianCalendar forDate) {
        double rawYear = (double) forDate.get(1);
        if (forDate.get(0) == 0) {
            rawYear = -rawYear;
        }
        return ((((double) (forDate.get(2) + 1)) - 0.5d) / 12.0d) + rawYear;
    }
}
