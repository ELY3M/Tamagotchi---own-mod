package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Processor;
import java.util.ArrayList;
import java.util.List;

public class MultiDetector extends Detector<Object> {
    private List<Detector<? extends Object>> zzbno;

    public static class Builder {
        private MultiDetector zzbnp = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzbnp.zzbno.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzbnp.zzbno.size() != 0) {
                return this.zzbnp;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    private MultiDetector() {
        this.zzbno = new ArrayList();
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray();
        for (Detector detect : this.zzbno) {
            SparseArray detect2 = detect.detect(frame);
            for (int i = 0; i < detect2.size(); i++) {
                int keyAt = detect2.keyAt(i);
                if (sparseArray.get(keyAt) != null) {
                    throw new IllegalStateException("Detection ID overlap for id = " + keyAt + ".  " + "This means that one of the detectors is not using global IDs.");
                }
                sparseArray.append(keyAt, detect2.valueAt(i));
            }
        }
        return sparseArray;
    }

    public boolean isOperational() {
        for (Detector isOperational : this.zzbno) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    public void receiveFrame(Frame frame) {
        for (Detector receiveFrame : this.zzbno) {
            receiveFrame.receiveFrame(frame);
        }
    }

    public void release() {
        for (Detector release : this.zzbno) {
            release.release();
        }
        this.zzbno.clear();
    }

    public void setProcessor(Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
