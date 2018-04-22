package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzl extends com.google.android.gms.fitness.data.zzk.zza {
    private final OnDataPointListener zzaxb;

    public static class zza {
        private static final zza zzaxc = new zza();
        private final Map<OnDataPointListener, zzl> zzaxd = new HashMap();

        private zza() {
        }

        public static zza zzuu() {
            return zzaxc;
        }

        public zzl zza(OnDataPointListener onDataPointListener) {
            zzl com_google_android_gms_fitness_data_zzl;
            synchronized (this.zzaxd) {
                com_google_android_gms_fitness_data_zzl = (zzl) this.zzaxd.get(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzl == null) {
                    com_google_android_gms_fitness_data_zzl = new zzl(onDataPointListener);
                    this.zzaxd.put(onDataPointListener, com_google_android_gms_fitness_data_zzl);
                }
            }
            return com_google_android_gms_fitness_data_zzl;
        }

        public zzl zzb(OnDataPointListener onDataPointListener) {
            zzl com_google_android_gms_fitness_data_zzl;
            synchronized (this.zzaxd) {
                com_google_android_gms_fitness_data_zzl = (zzl) this.zzaxd.get(onDataPointListener);
            }
            return com_google_android_gms_fitness_data_zzl;
        }

        public zzl zzc(OnDataPointListener onDataPointListener) {
            zzl com_google_android_gms_fitness_data_zzl;
            synchronized (this.zzaxd) {
                com_google_android_gms_fitness_data_zzl = (zzl) this.zzaxd.remove(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzl != null) {
                } else {
                    com_google_android_gms_fitness_data_zzl = new zzl(onDataPointListener);
                }
            }
            return com_google_android_gms_fitness_data_zzl;
        }
    }

    private zzl(OnDataPointListener onDataPointListener) {
        this.zzaxb = (OnDataPointListener) zzx.zzz(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzaxb.onDataPoint(dataPoint);
    }
}
