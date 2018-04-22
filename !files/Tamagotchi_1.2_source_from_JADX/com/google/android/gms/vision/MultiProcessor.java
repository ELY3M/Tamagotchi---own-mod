package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import java.util.HashSet;
import java.util.Set;

public class MultiProcessor<T> implements Processor<T> {
    private int zzbne;
    private Factory<T> zzbnq;
    private SparseArray<zza> zzbnr;

    public static class Builder<T> {
        private MultiProcessor<T> zzbns = new MultiProcessor();

        public Builder(Factory<T> factory) {
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            this.zzbns.zzbnq = factory;
        }

        public MultiProcessor<T> build() {
            return this.zzbns;
        }

        public Builder<T> setMaxGapFrames(int maxGapFrames) {
            if (maxGapFrames < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + maxGapFrames);
            }
            this.zzbns.zzbne = maxGapFrames;
            return this;
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza {
        private Tracker<T> zzbnd;
        private int zzbnh;
        final /* synthetic */ MultiProcessor zzbnt;

        private zza(MultiProcessor multiProcessor) {
            this.zzbnt = multiProcessor;
            this.zzbnh = 0;
        }
    }

    private MultiProcessor() {
        this.zzbnr = new SparseArray();
        this.zzbne = 3;
    }

    private void zza(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            if (this.zzbnr.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = new zza();
                com_google_android_gms_vision_MultiProcessor_zza.zzbnd = this.zzbnq.create(valueAt);
                com_google_android_gms_vision_MultiProcessor_zza.zzbnd.onNewItem(keyAt, valueAt);
                this.zzbnr.append(keyAt, com_google_android_gms_vision_MultiProcessor_zza);
            }
        }
    }

    private void zzb(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        Set<Integer> hashSet = new HashSet();
        for (int i = 0; i < this.zzbnr.size(); i++) {
            int keyAt = this.zzbnr.keyAt(i);
            if (detectedItems.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = (zza) this.zzbnr.valueAt(i);
                com_google_android_gms_vision_MultiProcessor_zza.zzbnh = com_google_android_gms_vision_MultiProcessor_zza.zzbnh + 1;
                if (com_google_android_gms_vision_MultiProcessor_zza.zzbnh >= this.zzbne) {
                    com_google_android_gms_vision_MultiProcessor_zza.zzbnd.onDone();
                    hashSet.add(Integer.valueOf(keyAt));
                } else {
                    com_google_android_gms_vision_MultiProcessor_zza.zzbnd.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzbnr.delete(intValue.intValue());
        }
    }

    private void zzc(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            zza com_google_android_gms_vision_MultiProcessor_zza = (zza) this.zzbnr.get(keyAt);
            com_google_android_gms_vision_MultiProcessor_zza.zzbnh = 0;
            com_google_android_gms_vision_MultiProcessor_zza.zzbnd.onUpdate(detections, valueAt);
        }
    }

    public void receiveDetections(Detections<T> detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    public void release() {
        for (int i = 0; i < this.zzbnr.size(); i++) {
            ((zza) this.zzbnr.valueAt(i)).zzbnd.onDone();
        }
        this.zzbnr.clear();
    }
}
