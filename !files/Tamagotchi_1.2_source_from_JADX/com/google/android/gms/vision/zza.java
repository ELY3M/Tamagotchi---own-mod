package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza {
    private static int zzbnl = 0;
    private static final Object zzqy = new Object();
    private SparseArray<Integer> zzbnm = new SparseArray();
    private SparseArray<Integer> zzbnn = new SparseArray();

    public int zzkr(int i) {
        int intValue;
        synchronized (zzqy) {
            Integer num = (Integer) this.zzbnm.get(i);
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = zzbnl;
                zzbnl++;
                this.zzbnm.append(i, Integer.valueOf(intValue));
                this.zzbnn.append(intValue, Integer.valueOf(i));
            }
        }
        return intValue;
    }

    public int zzks(int i) {
        int intValue;
        synchronized (zzqy) {
            intValue = ((Integer) this.zzbnn.get(i)).intValue();
        }
        return intValue;
    }
}
