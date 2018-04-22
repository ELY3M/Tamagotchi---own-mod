package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class MapValue implements SafeParcelable {
    public static final Creator<MapValue> CREATOR = new zzm();
    private final int mVersionCode;
    private final int zzawZ;
    private final float zzaxe;

    public MapValue(int format, float value) {
        this(1, format, value);
    }

    MapValue(int versionCode, int format, float value) {
        this.mVersionCode = versionCode;
        this.zzawZ = format;
        this.zzaxe = value;
    }

    private boolean zza(MapValue mapValue) {
        if (this.zzawZ != mapValue.zzawZ) {
            return false;
        }
        switch (this.zzawZ) {
            case 2:
                return asFloat() == mapValue.asFloat();
            default:
                return this.zzaxe == mapValue.zzaxe;
        }
    }

    public static MapValue zzc(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzx.zza(this.zzawZ == 2, (Object) "Value is not in float format");
        return this.zzaxe;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof MapValue) && zza((MapValue) o));
    }

    int getFormat() {
        return this.zzawZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (int) this.zzaxe;
    }

    public String toString() {
        switch (this.zzawZ) {
            case 2:
                return Float.toString(asFloat());
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    float zzuv() {
        return this.zzaxe;
    }
}
