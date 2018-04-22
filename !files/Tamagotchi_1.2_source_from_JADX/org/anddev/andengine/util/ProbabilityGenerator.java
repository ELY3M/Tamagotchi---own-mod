package org.anddev.andengine.util;

import java.util.ArrayList;

public class ProbabilityGenerator<T> {
    private final ArrayList<Entry<T>> mEntries = new ArrayList();
    private float mProbabilitySum;

    private static class Entry<T> {
        public final T[] mData;
        public final float mFactor;

        public Entry(float pFactor, T[] pData) {
            this.mFactor = pFactor;
            this.mData = pData;
        }

        public T getReturnValue() {
            if (this.mData.length == 1) {
                return this.mData[0];
            }
            return ArrayUtils.random(this.mData);
        }
    }

    public void add(float pFactor, T... pElements) {
        this.mProbabilitySum += pFactor;
        this.mEntries.add(new Entry(pFactor, pElements));
    }

    public T next() {
        float random = MathUtils.random(0.0f, this.mProbabilitySum);
        ArrayList<Entry<T>> factors = this.mEntries;
        for (int i = factors.size() - 1; i >= 0; i--) {
            Entry<T> entry = (Entry) factors.get(i);
            random -= entry.mFactor;
            if (random <= 0.0f) {
                return entry.getReturnValue();
            }
        }
        return ((Entry) factors.get(factors.size() - 1)).getReturnValue();
    }

    public void clear() {
        this.mProbabilitySum = 0.0f;
        this.mEntries.clear();
    }
}
