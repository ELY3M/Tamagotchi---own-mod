package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;

public abstract class FocusingProcessor<T> implements Processor<T> {
    private Detector<T> zzbmN;
    private Tracker<T> zzbnd;
    private int zzbne = 3;
    private boolean zzbnf = false;
    private int zzbng;
    private int zzbnh = 0;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzbmN = detector;
        this.zzbnd = tracker;
    }

    public void receiveDetections(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzbnh == this.zzbne) {
                this.zzbnd.onDone();
                this.zzbnf = false;
            } else {
                this.zzbnd.onMissing(detections);
            }
            this.zzbnh++;
            return;
        }
        this.zzbnh = 0;
        if (this.zzbnf) {
            Object obj = detectedItems.get(this.zzbng);
            if (obj != null) {
                this.zzbnd.onUpdate(detections, obj);
                return;
            } else {
                this.zzbnd.onDone();
                this.zzbnf = false;
            }
        }
        int selectFocus = selectFocus(detections);
        Object obj2 = detectedItems.get(selectFocus);
        if (obj2 == null) {
            Log.w("FocusingProcessor", "Invalid focus selected: " + selectFocus);
            return;
        }
        this.zzbnf = true;
        this.zzbng = selectFocus;
        this.zzbmN.setFocus(this.zzbng);
        this.zzbnd.onNewItem(this.zzbng, obj2);
        this.zzbnd.onUpdate(detections, obj2);
    }

    public void release() {
        this.zzbnd.onDone();
    }

    public abstract int selectFocus(Detections<T> detections);

    protected void zzkq(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid max gap: " + i);
        }
        this.zzbne = i;
    }
}
