package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR = new zzj();
    public static final Field FIELD_ACCURACY = zzdp("accuracy");
    public static final Field FIELD_ACTIVITY = zzdo("activity");
    public static final Field FIELD_ALTITUDE = zzdq("altitude");
    public static final Field FIELD_AVERAGE = zzdp("average");
    public static final Field FIELD_BPM = zzdp("bpm");
    public static final Field FIELD_CALORIES = zzdp(NUTRIENT_CALORIES);
    public static final Field FIELD_CIRCUMFERENCE = zzdp("circumference");
    public static final Field FIELD_CONFIDENCE = zzdp("confidence");
    public static final Field FIELD_DISTANCE = zzdp("distance");
    public static final Field FIELD_DURATION = zzdo("duration");
    public static final Field FIELD_EXERCISE = zzdr("exercise");
    public static final Field FIELD_FOOD_ITEM = zzdr("food_item");
    public static final Field FIELD_HEIGHT = zzdp("height");
    public static final Field FIELD_HIGH_LATITUDE = zzdp("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzdp("high_longitude");
    public static final Field FIELD_LATITUDE = zzdp("latitude");
    public static final Field FIELD_LONGITUDE = zzdp("longitude");
    public static final Field FIELD_LOW_LATITUDE = zzdp("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzdp("low_longitude");
    public static final Field FIELD_MAX = zzdp("max");
    public static final Field FIELD_MEAL_TYPE = zzdo("meal_type");
    public static final Field FIELD_MIN = zzdp("min");
    public static final Field FIELD_NUM_SEGMENTS = zzdo("num_segments");
    public static final Field FIELD_NUTRIENTS = zzds("nutrients");
    public static final Field FIELD_PERCENTAGE = zzdp("percentage");
    public static final Field FIELD_REPETITIONS = zzdo("repetitions");
    public static final Field FIELD_RESISTANCE = zzdp("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzdo("resistance_type");
    public static final Field FIELD_REVOLUTIONS = zzdo("revolutions");
    public static final Field FIELD_RPM = zzdp("rpm");
    public static final Field FIELD_SPEED = zzdp("speed");
    public static final Field FIELD_STEPS = zzdo("steps");
    public static final Field FIELD_WATTS = zzdp("watts");
    public static final Field FIELD_WEIGHT = zzdp("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    public static final Field zzawM = zzds("activity_confidence");
    public static final Field zzawN = zzds("activity_duration");
    public static final Field zzawO = zzds("activity_duration.ascending");
    public static final Field zzawP = zzds("activity_duration.descending");
    public static final Field zzawQ = zzdp("elevation.change");
    public static final Field zzawR = zzds("elevation.gain");
    public static final Field zzawS = zzds("elevation.loss");
    public static final Field zzawT = zzdp("floors");
    public static final Field zzawU = zzds("floor.gain");
    public static final Field zzawV = zzds("floor.loss");
    public static final Field zzawW = zzdp("x");
    public static final Field zzawX = zzdp("y");
    public static final Field zzawY = zzdp("z");
    private final String mName;
    private final int mVersionCode;
    private final int zzawZ;
    private final Boolean zzaxa;

    Field(int versionCode, String name, int format, Boolean optional) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzz(name);
        this.zzawZ = format;
        this.zzaxa = optional;
    }

    private Field(String name, int format) {
        this(2, name, format, null);
    }

    private Field(String name, int format, Boolean optional) {
        this(2, name, format, optional);
    }

    public static Field zza(String str, int i, Boolean bool) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2131707655:
                if (str.equals("accuracy")) {
                    obj = null;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    obj = 12;
                    break;
                }
                break;
            case -1655966961:
                if (str.equals("activity")) {
                    obj = 1;
                    break;
                }
                break;
            case -1579612127:
                if (str.equals("floor.gain")) {
                    obj = 17;
                    break;
                }
                break;
            case -1579449403:
                if (str.equals("floor.loss")) {
                    obj = 18;
                    break;
                }
                break;
            case -1569430471:
                if (str.equals("num_segments")) {
                    obj = 31;
                    break;
                }
                break;
            case -1531570079:
                if (str.equals("elevation.change")) {
                    obj = 13;
                    break;
                }
                break;
            case -1439978388:
                if (str.equals("latitude")) {
                    obj = 24;
                    break;
                }
                break;
            case -1271636505:
                if (str.equals("floors")) {
                    obj = 19;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    obj = 21;
                    break;
                }
                break;
            case -1133736764:
                if (str.equals("activity_duration")) {
                    obj = 2;
                    break;
                }
                break;
            case -1110756780:
                if (str.equals("food_item")) {
                    obj = 20;
                    break;
                }
                break;
            case -921832806:
                if (str.equals("percentage")) {
                    obj = 33;
                    break;
                }
                break;
            case -791592328:
                if (str.equals("weight")) {
                    obj = 42;
                    break;
                }
                break;
            case -631448035:
                if (str.equals("average")) {
                    obj = 6;
                    break;
                }
                break;
            case -626344110:
                if (str.equals("high_longitude")) {
                    obj = 23;
                    break;
                }
                break;
            case -619868540:
                if (str.equals("low_longitude")) {
                    obj = 27;
                    break;
                }
                break;
            case -494782871:
                if (str.equals("high_latitude")) {
                    obj = 22;
                    break;
                }
                break;
            case -437053898:
                if (str.equals("meal_type")) {
                    obj = 29;
                    break;
                }
                break;
            case -277306353:
                if (str.equals("circumference")) {
                    obj = 9;
                    break;
                }
                break;
            case -266093204:
                if (str.equals("nutrients")) {
                    obj = 32;
                    break;
                }
                break;
            case -168965370:
                if (str.equals(NUTRIENT_CALORIES)) {
                    obj = 8;
                    break;
                }
                break;
            case -126538880:
                if (str.equals("resistance_type")) {
                    obj = 36;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    obj = 43;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    obj = 44;
                    break;
                }
                break;
            case 122:
                if (str.equals("z")) {
                    obj = 45;
                    break;
                }
                break;
            case 97759:
                if (str.equals("bpm")) {
                    obj = 7;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    obj = 28;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    obj = 30;
                    break;
                }
                break;
            case 113135:
                if (str.equals("rpm")) {
                    obj = 38;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    obj = 39;
                    break;
                }
                break;
            case 109761319:
                if (str.equals("steps")) {
                    obj = 40;
                    break;
                }
                break;
            case 112903913:
                if (str.equals("watts")) {
                    obj = 41;
                    break;
                }
                break;
            case 137365935:
                if (str.equals("longitude")) {
                    obj = 25;
                    break;
                }
                break;
            case 198162679:
                if (str.equals("low_latitude")) {
                    obj = 26;
                    break;
                }
                break;
            case 286612066:
                if (str.equals("activity_duration.descending")) {
                    obj = 4;
                    break;
                }
                break;
            case 288459765:
                if (str.equals("distance")) {
                    obj = 11;
                    break;
                }
                break;
            case 455965230:
                if (str.equals("activity_duration.ascending")) {
                    obj = 3;
                    break;
                }
                break;
            case 811264586:
                if (str.equals("revolutions")) {
                    obj = 37;
                    break;
                }
                break;
            case 829251210:
                if (str.equals("confidence")) {
                    obj = 10;
                    break;
                }
                break;
            case 984367650:
                if (str.equals("repetitions")) {
                    obj = 34;
                    break;
                }
                break;
            case 1857734768:
                if (str.equals("elevation.gain")) {
                    obj = 14;
                    break;
                }
                break;
            case 1857897492:
                if (str.equals("elevation.loss")) {
                    obj = 15;
                    break;
                }
                break;
            case 1863800889:
                if (str.equals("resistance")) {
                    obj = 35;
                    break;
                }
                break;
            case 2036550306:
                if (str.equals("altitude")) {
                    obj = 5;
                    break;
                }
                break;
            case 2056323544:
                if (str.equals("exercise")) {
                    obj = 16;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return FIELD_ACCURACY;
            case 1:
                return FIELD_ACTIVITY;
            case 2:
                return zzawN;
            case 3:
                return zzawO;
            case 4:
                return zzawP;
            case 5:
                return FIELD_ALTITUDE;
            case 6:
                return FIELD_AVERAGE;
            case 7:
                return FIELD_BPM;
            case 8:
                return FIELD_CALORIES;
            case 9:
                return FIELD_CIRCUMFERENCE;
            case 10:
                return FIELD_CONFIDENCE;
            case 11:
                return FIELD_DISTANCE;
            case 12:
                return FIELD_DURATION;
            case 13:
                return zzawQ;
            case 14:
                return zzawR;
            case 15:
                return zzawS;
            case 16:
                return FIELD_EXERCISE;
            case 17:
                return zzawU;
            case 18:
                return zzawV;
            case 19:
                return zzawT;
            case 20:
                return FIELD_FOOD_ITEM;
            case 21:
                return FIELD_HEIGHT;
            case 22:
                return FIELD_HIGH_LATITUDE;
            case 23:
                return FIELD_HIGH_LONGITUDE;
            case 24:
                return FIELD_LATITUDE;
            case 25:
                return FIELD_LONGITUDE;
            case 26:
                return FIELD_LOW_LATITUDE;
            case 27:
                return FIELD_LOW_LONGITUDE;
            case 28:
                return FIELD_MAX;
            case 29:
                return FIELD_MEAL_TYPE;
            case 30:
                return FIELD_MIN;
            case 31:
                return FIELD_NUM_SEGMENTS;
            case 32:
                return FIELD_NUTRIENTS;
            case 33:
                return FIELD_PERCENTAGE;
            case 34:
                return FIELD_REPETITIONS;
            case 35:
                return FIELD_RESISTANCE;
            case 36:
                return FIELD_RESISTANCE_TYPE;
            case 37:
                return FIELD_REVOLUTIONS;
            case 38:
                return FIELD_RPM;
            case 39:
                return FIELD_SPEED;
            case 40:
                return FIELD_STEPS;
            case 41:
                return FIELD_WATTS;
            case 42:
                return FIELD_WEIGHT;
            case 43:
                return zzawW;
            case 44:
                return zzawX;
            case 45:
                return zzawY;
            default:
                return new Field(str, i, bool);
        }
    }

    private boolean zza(Field field) {
        return this.mName.equals(field.mName) && this.zzawZ == field.zzawZ;
    }

    private static Field zzdo(String str) {
        return new Field(str, 1);
    }

    private static Field zzdp(String str) {
        return new Field(str, 2);
    }

    private static Field zzdq(String str) {
        return new Field(str, 2, Boolean.valueOf(true));
    }

    private static Field zzdr(String str) {
        return new Field(str, 3);
    }

    private static Field zzds(String str) {
        return new Field(str, 4);
    }

    public static Field zzn(String str, int i) {
        return zza(str, i, null);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Field) && zza((Field) that));
    }

    public int getFormat() {
        return this.zzawZ;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public Boolean isOptional() {
        return this.zzaxa;
    }

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.zzawZ == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
