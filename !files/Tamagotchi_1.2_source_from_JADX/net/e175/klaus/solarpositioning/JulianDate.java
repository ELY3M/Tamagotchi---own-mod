package net.e175.klaus.solarpositioning;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class JulianDate {
    private final double deltaT;
    private final double julianDate;

    public JulianDate(GregorianCalendar date) {
        this.julianDate = calcJulianDate(createUtcCalendar(date));
        this.deltaT = 0.0d;
    }

    public JulianDate(double fromJulianDate, double deltaT) {
        this.julianDate = fromJulianDate;
        this.deltaT = deltaT;
    }

    public JulianDate(GregorianCalendar date, double deltaT) {
        this.julianDate = calcJulianDate(createUtcCalendar(date));
        this.deltaT = deltaT;
    }

    static GregorianCalendar createUtcCalendar(GregorianCalendar fromCalendar) {
        GregorianCalendar utcCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(fromCalendar.getTimeInMillis());
        utcCalendar.set(0, fromCalendar.get(0));
        return utcCalendar;
    }

    private double calcJulianDate(GregorianCalendar calendar) {
        int y;
        if (calendar.get(0) == 1) {
            y = calendar.get(1);
        } else {
            y = -calendar.get(1);
        }
        int m = calendar.get(2) + 1;
        if (m < 3) {
            y--;
            m += 12;
        }
        double jd = ((Math.floor(365.25d * (((double) y) + 4716.0d)) + Math.floor(30.6001d * ((double) (m + 1)))) + (((double) calendar.get(5)) + ((((double) calendar.get(11)) + ((((double) calendar.get(12)) + (((double) calendar.get(13)) / 60.0d)) / 60.0d)) / 24.0d))) - 1524.5d;
        double a = Math.floor(((double) y) / 100.0d);
        return jd + (jd > 2299160.0d ? (2.0d - a) + Math.floor(a / 4.0d) : 0.0d);
    }

    public double getJulianDate() {
        return this.julianDate;
    }

    public double getJulianEphemerisDay() {
        return this.julianDate + (this.deltaT / 86400.0d);
    }

    public double getJulianCentury() {
        return (this.julianDate - 2451545.0d) / 36525.0d;
    }

    public double getJulianEphemerisCentury() {
        return (getJulianEphemerisDay() - 2451545.0d) / 36525.0d;
    }

    public double getJulianEphemerisMillennium() {
        return getJulianEphemerisCentury() / 10.0d;
    }

    public String toString() {
        return String.format("%.5f", new Object[]{Double.valueOf(this.julianDate)});
    }
}
