package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.internal.zznx.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class zznw {
    private static final Set<String> zzazD = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{zznt.zzaxI.name, zznt.zzaxW.name})));

    public static String zzd(DataPoint dataPoint) {
        DataType dataType = dataPoint.getDataType();
        if (!zznu.zzdD(dataType.getName())) {
            return null;
        }
        for (Field field : dataType.getFields()) {
            Value value = dataPoint.getValue(field);
            if (value.isSet()) {
                double asInt;
                if (field.getFormat() == 1) {
                    asInt = (double) value.asInt();
                } else if (field.getFormat() == 2) {
                    asInt = (double) value.asFloat();
                } else {
                    continue;
                }
                zza zzdE = zznx.zzuG().zzdE(field.getName());
                if (zzdE != null && !zzdE.zzh(asInt)) {
                    return "Field out of range";
                }
                zza zzC = zznx.zzuG().zzC(dataType.getName(), field.getName());
                if (zzC != null) {
                    long timestampNanos = dataPoint.getTimestampNanos() - dataPoint.zzuj();
                    if (timestampNanos == 0) {
                        return asInt == 0.0d ? null : "DataPoint out of range";
                    } else {
                        if (!zzC.zzh(asInt / ((double) timestampNanos))) {
                            return "DataPoint out of range";
                        }
                    }
                } else {
                    continue;
                }
            } else if (!zzazD.contains(field.getName())) {
                return field.getName() + " not set";
            }
        }
        return null;
    }

    public static void zze(DataPoint dataPoint) throws IllegalArgumentException {
        String zzd = zzd(dataPoint);
        if (zzd != null) {
            Log.w("Fitness", "Invalid data point: " + dataPoint);
            throw new IllegalArgumentException(zzd);
        }
    }
}
