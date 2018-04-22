package org.anddev.andengine.util.pool;

import android.util.SparseArray;

public class MultiPool<T> {
    private final SparseArray<GenericPool<T>> mPools = new SparseArray();

    public void registerPool(int pID, GenericPool<T> pPool) {
        this.mPools.put(pID, pPool);
    }

    public T obtainPoolItem(int pID) {
        GenericPool<T> pool = (GenericPool) this.mPools.get(pID);
        if (pool == null) {
            return null;
        }
        return pool.obtainPoolItem();
    }

    public void recyclePoolItem(int pID, T pItem) {
        GenericPool<T> pool = (GenericPool) this.mPools.get(pID);
        if (pool != null) {
            pool.recyclePoolItem(pItem);
        }
    }
}
