package net.e175.klaus.solarpositioning;

import java.util.GregorianCalendar;

public final class Grena3 {
    private Grena3() {
    }

    public static AzimuthZenithAngle calculateSolarPosition(GregorianCalendar date, double latitude, double longitude, double deltaT) {
        return calculateSolarPosition(date, latitude, longitude, deltaT, Double.MIN_VALUE, Double.MIN_VALUE);
    }

    public static AzimuthZenithAngle calculateSolarPosition(GregorianCalendar date, double latitude, double longitude, double deltaT, double pressure, double temperature) {
        double t = calcT(date);
        double tE = t + (1.1574E-5d * deltaT);
        double omegaAtE = 0.0172019715d * tE;
        double lambda = ((-1.388803d + (0.01720279216d * tE)) + (0.033366d * Math.sin(omegaAtE - 0.06172d))) + (3.53E-4d * Math.sin((2.0d * omegaAtE) - 0.1163d));
        double epsilon = 0.4089567d - (6.19E-9d * tE);
        double sLambda = Math.sin(lambda);
        double cLambda = Math.cos(lambda);
        double sEpsilon = Math.sin(epsilon);
        double alpha = Math.atan2(sLambda * Math.sqrt(1.0d - (sEpsilon * sEpsilon)), cLambda);
        if (alpha < 0.0d) {
            alpha += 6.283185307179586d;
        }
        double delta = Math.asin(sLambda * sEpsilon);
        double H = ((3.141592653589793d + (((1.7528311d + (6.300388099d * t)) + Math.toRadians(longitude)) - alpha)) % 6.283185307179586d) - 3.141592653589793d;
        if (H < -3.141592653589793d) {
            H += 6.283185307179586d;
        }
        double sPhi = Math.sin(Math.toRadians(latitude));
        double cPhi = Math.sqrt(1.0d - (sPhi * sPhi));
        double sDelta = Math.sin(delta);
        double cDelta = Math.sqrt(1.0d - (sDelta * sDelta));
        double sH = Math.sin(H);
        double cH = Math.cos(H);
        double sEpsilon0 = (sPhi * sDelta) + ((cPhi * cDelta) * cH);
        double eP = Math.asin(sEpsilon0) - (4.26E-5d * Math.sqrt(1.0d - (sEpsilon0 * sEpsilon0)));
        double gamma = Math.atan2(sH, (cH * sPhi) - ((sDelta * cPhi) / cDelta));
        double deltaRe = (temperature < -273.0d || temperature > 273.0d || pressure < 0.0d || pressure > 3000.0d) ? 0.0d : eP > 0.0d ? (0.08422d * (pressure / 1000.0d)) / ((273.0d + temperature) * Math.tan((0.003138d / (0.08919d + eP)) + eP)) : 0.0d;
        return new AzimuthZenithAngle(Math.toDegrees(3.141592653589793d + gamma) % 360.0d, Math.toDegrees((1.5707963267948966d - eP) - deltaRe));
    }

    private static double calcT(GregorianCalendar date) {
        GregorianCalendar utc = JulianDate.createUtcCalendar(date);
        int m = utc.get(2) + 1;
        int y = utc.get(1);
        int d = utc.get(5);
        double h = (((double) utc.get(11)) + (((double) utc.get(12)) / 60.0d)) + (((double) utc.get(13)) / 3600.0d);
        if (m <= 2) {
            m += 12;
            y--;
        }
        return (((double) (((((int) (365.25d * ((double) (y - 2000)))) + ((int) (30.6001d * ((double) (m + 1))))) - ((int) (0.01d * ((double) y)))) + d)) + (0.0416667d * h)) - 21958.0d;
    }
}
