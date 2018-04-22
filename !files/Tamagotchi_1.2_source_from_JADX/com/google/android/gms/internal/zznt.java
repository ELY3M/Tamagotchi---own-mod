package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzsy.zzb;
import com.google.android.gms.plus.PlusShare;

public class zznt {
    public static final zzb zzaxA = zzdt("duration");
    public static final zzb zzaxB = zzdz("activity_duration");
    public static final zzb zzaxC = zzdz("activity_duration.ascending");
    public static final zzb zzaxD = zzdz("activity_duration.descending");
    public static final zzb zzaxE = zzdv("bpm");
    public static final zzb zzaxF = zzdv("latitude");
    public static final zzb zzaxG = zzdv("longitude");
    public static final zzb zzaxH = zzdv("accuracy");
    public static final zzb zzaxI = zzdw("altitude");
    public static final zzb zzaxJ = zzdv("distance");
    public static final zzb zzaxK = zzdC("google.android.fitness.GoalV2");
    public static final zzb zzaxL = zzdv("progress");
    public static final zzb zzaxM = zzdv("height");
    public static final zzb zzaxN = zzdv("weight");
    public static final zzb zzaxO = zzdv("circumference");
    public static final zzb zzaxP = zzdv("percentage");
    public static final zzb zzaxQ = zzdv("speed");
    public static final zzb zzaxR = zzdv("rpm");
    public static final zzb zzaxS = zzdt("revolutions");
    public static final zzb zzaxT = zzdv(Field.NUTRIENT_CALORIES);
    public static final zzb zzaxU = zzdv("watts");
    public static final zzb zzaxV = zzdt("meal_type");
    public static final zzb zzaxW = zzdx("food_item");
    public static final zzb zzaxX = zzdz("nutrients");
    public static final zzb zzaxY = zzdv("elevation.change");
    public static final zzb zzaxZ = zzdz("elevation.gain");
    public static final zzb zzaxw = zzdt("activity");
    public static final zzb zzaxx = zzdv("confidence");
    public static final zzb zzaxy = zzdz("activity_confidence");
    public static final zzb zzaxz = zzdt("steps");
    public static final zzb zzaya = zzdz("elevation.loss");
    public static final zzb zzayb = zzdv("floors");
    public static final zzb zzayc = zzdz("floor.gain");
    public static final zzb zzayd = zzdz("floor.loss");
    public static final zzb zzaye = zzdx("exercise");
    public static final zzb zzayf = zzdt("repetitions");
    public static final zzb zzayg = zzdv("resistance");
    public static final zzb zzayh = zzdt("resistance_type");
    public static final zzb zzayi = zzdt("num_segments");
    public static final zzb zzayj = zzdv("average");
    public static final zzb zzayk = zzdv("max");
    public static final zzb zzayl = zzdv("min");
    public static final zzb zzaym = zzdv("low_latitude");
    public static final zzb zzayn = zzdv("low_longitude");
    public static final zzb zzayo = zzdv("high_latitude");
    public static final zzb zzayp = zzdv("high_longitude");
    public static final zzb zzayq = zzdv("x");
    public static final zzb zzayr = zzdv("y");
    public static final zzb zzays = zzdv("z");
    public static final zzb zzayt = zzdA("timestamps");
    public static final zzb zzayu = zzdB("sensor_values");
    public static final zzb zzayv = zzdt("sensor_type");
    public static final zzb zzayw = zzdx("identifier");
    public static final zzb zzayx = zzdy("name");
    public static final zzb zzayy = zzdy(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    public static final zzb zzayz = zzdu("active_time");

    private static zzb zzb(String str, int i, Boolean bool) {
        zzb com_google_android_gms_internal_zzsy_zzb = new zzb();
        com_google_android_gms_internal_zzsy_zzb.name = str;
        com_google_android_gms_internal_zzsy_zzb.zzbuG = Integer.valueOf(i);
        if (bool != null) {
            com_google_android_gms_internal_zzsy_zzb.zzbuH = bool;
        }
        return com_google_android_gms_internal_zzsy_zzb;
    }

    private static zzb zzdA(String str) {
        return zzo(str, 5);
    }

    private static zzb zzdB(String str) {
        return zzo(str, 6);
    }

    private static zzb zzdC(String str) {
        return zzo(str, 7);
    }

    private static zzb zzdt(String str) {
        return zzo(str, 1);
    }

    private static zzb zzdu(String str) {
        return zzb(str, 1, Boolean.valueOf(true));
    }

    private static zzb zzdv(String str) {
        return zzo(str, 2);
    }

    private static zzb zzdw(String str) {
        return zzb(str, 2, Boolean.valueOf(true));
    }

    private static zzb zzdx(String str) {
        return zzo(str, 3);
    }

    private static zzb zzdy(String str) {
        return zzb(str, 3, Boolean.valueOf(true));
    }

    private static zzb zzdz(String str) {
        return zzo(str, 4);
    }

    public static zzb zzo(String str, int i) {
        return zzb(str, i, null);
    }
}
