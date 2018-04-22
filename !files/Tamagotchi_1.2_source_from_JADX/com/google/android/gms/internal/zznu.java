package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsy.zzb;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zznu {
    public static final Set<String> AGGREGATE_INPUT_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{zzayD.name, zzayF.name, zzayG.name, zzayQ.name, zzayE.name, zzayN.name, zzayO.name, zzazc.name, zzayS.name, zzayA.name, zzayY.name})));
    private static final Map<String, List<com.google.android.gms.internal.zzsy.zza>> zzawC = zzuF();
    public static final com.google.android.gms.internal.zzsy.zza zzayA = zza("com.google.step_count.delta", zznt.zzaxz);
    public static final com.google.android.gms.internal.zzsy.zza zzayB = zza("com.google.step_count.cumulative", zznt.zzaxz);
    public static final com.google.android.gms.internal.zzsy.zza zzayC = zza("com.google.step_count.cadence", zznt.zzaxR);
    public static final com.google.android.gms.internal.zzsy.zza zzayD = zza("com.google.activity.segment", zznt.zzaxw);
    public static final com.google.android.gms.internal.zzsy.zza zzayE = zza("com.google.floor_change", zznt.zzaxw, zznt.zzaxx, zznt.zzaxY, zznt.zzayb);
    public static final com.google.android.gms.internal.zzsy.zza zzayF = zza("com.google.calories.consumed", zznt.zzaxT);
    public static final com.google.android.gms.internal.zzsy.zza zzayG = zza("com.google.calories.expended", zznt.zzaxT);
    public static final com.google.android.gms.internal.zzsy.zza zzayH = zza("com.google.calories.bmr", zznt.zzaxT);
    public static final com.google.android.gms.internal.zzsy.zza zzayI = zza("com.google.power.sample", zznt.zzaxU);
    public static final com.google.android.gms.internal.zzsy.zza zzayJ = zza("com.google.activity.sample", zznt.zzaxw, zznt.zzaxx);
    public static final com.google.android.gms.internal.zzsy.zza zzayK = zza("com.google.accelerometer", zznt.zzayq, zznt.zzayr, zznt.zzays);
    public static final com.google.android.gms.internal.zzsy.zza zzayL = zza("com.google.sensor.events", zznt.zzayv, zznt.zzayt, zznt.zzayu);
    public static final com.google.android.gms.internal.zzsy.zza zzayM = zza("com.google.internal.goal", zznt.zzaxK);
    public static final com.google.android.gms.internal.zzsy.zza zzayN = zza("com.google.heart_rate.bpm", zznt.zzaxE);
    public static final com.google.android.gms.internal.zzsy.zza zzayO = zza("com.google.location.sample", zznt.zzaxF, zznt.zzaxG, zznt.zzaxH, zznt.zzaxI);
    public static final com.google.android.gms.internal.zzsy.zza zzayP = zza("com.google.location.track", zznt.zzaxF, zznt.zzaxG, zznt.zzaxH, zznt.zzaxI);
    public static final com.google.android.gms.internal.zzsy.zza zzayQ = zza("com.google.distance.delta", zznt.zzaxJ);
    public static final com.google.android.gms.internal.zzsy.zza zzayR = zza("com.google.distance.cumulative", zznt.zzaxJ);
    public static final com.google.android.gms.internal.zzsy.zza zzayS = zza("com.google.speed", zznt.zzaxQ);
    public static final com.google.android.gms.internal.zzsy.zza zzayT = zza("com.google.cycling.wheel_revolution.cumulative", zznt.zzaxS);
    public static final com.google.android.gms.internal.zzsy.zza zzayU = zza("com.google.cycling.wheel_revolution.rpm", zznt.zzaxR);
    public static final com.google.android.gms.internal.zzsy.zza zzayV = zza("com.google.cycling.pedaling.cumulative", zznt.zzaxS);
    public static final com.google.android.gms.internal.zzsy.zza zzayW = zza("com.google.cycling.pedaling.cadence", zznt.zzaxR);
    public static final com.google.android.gms.internal.zzsy.zza zzayX = zza("com.google.height", zznt.zzaxM);
    public static final com.google.android.gms.internal.zzsy.zza zzayY = zza("com.google.weight", zznt.zzaxN);
    public static final com.google.android.gms.internal.zzsy.zza zzayZ = zza("com.google.body.fat.percentage", zznt.zzaxP);
    public static final com.google.android.gms.internal.zzsy.zza zzaza = zza("com.google.body.waist.circumference", zznt.zzaxO);
    public static final com.google.android.gms.internal.zzsy.zza zzazb = zza("com.google.body.hip.circumference", zznt.zzaxO);
    public static final com.google.android.gms.internal.zzsy.zza zzazc = zza("com.google.nutrition", zznt.zzaxX, zznt.zzaxV, zznt.zzaxW);
    public static final com.google.android.gms.internal.zzsy.zza zzazd = zza("com.google.activity.exercise", zznt.zzaye, zznt.zzayf, zznt.zzaxA, zznt.zzayh, zznt.zzayg);
    public static final com.google.android.gms.internal.zzsy.zza zzaze = zza("com.google.activity.summary", zznt.zzaxw, zznt.zzaxA, zznt.zzayi);
    public static final com.google.android.gms.internal.zzsy.zza zzazf = zza("com.google.floor_change.summary", zznt.zzaxC, zznt.zzaxD, zznt.zzaxZ, zznt.zzaya, zznt.zzayc, zznt.zzayd);
    public static final com.google.android.gms.internal.zzsy.zza zzazg = zzayA;
    public static final com.google.android.gms.internal.zzsy.zza zzazh = zzayQ;
    public static final com.google.android.gms.internal.zzsy.zza zzazi = zzayF;
    public static final com.google.android.gms.internal.zzsy.zza zzazj = zzayG;
    public static final com.google.android.gms.internal.zzsy.zza zzazk = zza("com.google.heart_rate.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazl = zza("com.google.location.bounding_box", zznt.zzaym, zznt.zzayn, zznt.zzayo, zznt.zzayp);
    public static final com.google.android.gms.internal.zzsy.zza zzazm = zza("com.google.power.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazn = zza("com.google.speed.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazo = zza("com.google.weight.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazp = zza("com.google.calories.bmr.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazq = zza("com.google.body.fat.percentage.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazr = zza("com.google.body.hip.circumference.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazs = zza("com.google.body.waist.circumference.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final com.google.android.gms.internal.zzsy.zza zzazt = zza("com.google.nutrition.summary", zznt.zzaxX, zznt.zzaxV);
    public static final com.google.android.gms.internal.zzsy.zza zzazu = zza("com.google.internal.session", zznt.zzayw, zznt.zzaxw, zznt.zzayx, zznt.zzayy, zznt.zzayz);
    public static final String[] zzazv = new String[]{"com.google.accelerometer", "com.google.activity.exercise", "com.google.activity.sample", "com.google.activity.segment", "com.google.activity.summary", "com.google.body.fat.percentage", "com.google.body.fat.percentage.summary", "com.google.body.hip.circumference", "com.google.body.hip.circumference.summary", "com.google.body.waist.circumference", "com.google.body.waist.circumference.summary", "com.google.calories.bmr", "com.google.calories.bmr.summary", "com.google.calories.consumed", "com.google.calories.expended", "com.google.cycling.pedaling.cadence", "com.google.cycling.pedaling.cumulative", "com.google.cycling.wheel_revolution.cumulative", "com.google.cycling.wheel_revolution.rpm", "com.google.distance.cumulative", "com.google.distance.delta", "com.google.floor_change", "com.google.floor_change.summary", "com.google.heart_rate.bpm", "com.google.heart_rate.summary", "com.google.height", "com.google.internal.goal", "com.google.internal.session", "com.google.location.bounding_box", "com.google.location.sample", "com.google.location.track", "com.google.nutrition", "com.google.nutrition.summary", "com.google.power.sample", "com.google.power.summary", "com.google.sensor.events", "com.google.speed", "com.google.speed.summary", "com.google.step_count.cadence", "com.google.step_count.cumulative", "com.google.step_count.delta", "com.google.weight", "com.google.weight.summary"};
    private static final Map<com.google.android.gms.internal.zzsy.zza, zza> zzazw;

    public enum zza {
        CUMULATIVE,
        DELTA,
        SAMPLE,
        OTHER
    }

    static {
        Collection hashSet = new HashSet();
        hashSet.add(zzayB);
        hashSet.add(zzayR);
        hashSet.add(zzayV);
        Collection hashSet2 = new HashSet();
        hashSet2.add(zzayQ);
        hashSet2.add(zzayA);
        hashSet2.add(zzayG);
        hashSet2.add(zzayF);
        hashSet2.add(zzayE);
        Collection hashSet3 = new HashSet();
        hashSet3.add(zzayZ);
        hashSet3.add(zzazb);
        hashSet3.add(zzaza);
        hashSet3.add(zzazc);
        hashSet3.add(zzayX);
        hashSet3.add(zzayY);
        hashSet3.add(zzayN);
        Map hashMap = new HashMap();
        zza(hashMap, hashSet, zza.CUMULATIVE);
        zza(hashMap, hashSet2, zza.DELTA);
        zza(hashMap, hashSet3, zza.SAMPLE);
        zzazw = Collections.unmodifiableMap(hashMap);
    }

    public static com.google.android.gms.internal.zzsy.zza zza(String str, zzb... com_google_android_gms_internal_zzsy_zzbArr) {
        com.google.android.gms.internal.zzsy.zza com_google_android_gms_internal_zzsy_zza = new com.google.android.gms.internal.zzsy.zza();
        com_google_android_gms_internal_zzsy_zza.name = str;
        com_google_android_gms_internal_zzsy_zza.zzbuE = com_google_android_gms_internal_zzsy_zzbArr;
        return com_google_android_gms_internal_zzsy_zza;
    }

    private static void zza(Map<com.google.android.gms.internal.zzsy.zza, zza> map, Collection<com.google.android.gms.internal.zzsy.zza> collection, zza com_google_android_gms_internal_zznu_zza) {
        for (com.google.android.gms.internal.zzsy.zza put : collection) {
            map.put(put, com_google_android_gms_internal_zznu_zza);
        }
    }

    public static boolean zzdD(String str) {
        return Arrays.binarySearch(zzazv, str) >= 0;
    }

    private static Map<String, List<com.google.android.gms.internal.zzsy.zza>> zzuF() {
        Map<String, List<com.google.android.gms.internal.zzsy.zza>> hashMap = new HashMap();
        hashMap.put(zzayD.name, Collections.singletonList(zzaze));
        hashMap.put(zzayF.name, Collections.singletonList(zzazi));
        hashMap.put(zzayG.name, Collections.singletonList(zzazj));
        hashMap.put(zzayQ.name, Collections.singletonList(zzazh));
        hashMap.put(zzayE.name, Collections.singletonList(zzazf));
        hashMap.put(zzayO.name, Collections.singletonList(zzazl));
        hashMap.put(zzayI.name, Collections.singletonList(zzazm));
        hashMap.put(zzayN.name, Collections.singletonList(zzazk));
        hashMap.put(zzayS.name, Collections.singletonList(zzazn));
        hashMap.put(zzayA.name, Collections.singletonList(zzazg));
        hashMap.put(zzayY.name, Collections.singletonList(zzazo));
        return hashMap;
    }
}
