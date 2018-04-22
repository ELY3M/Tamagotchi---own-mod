package org.anddev.andengine.util.pool;

public abstract class Pool<T extends PoolItem> extends GenericPool<T> {
    public Pool(int pInitialSize) {
        super(pInitialSize);
    }

    public Pool(int pInitialSize, int pGrowth) {
        super(pInitialSize, pGrowth);
    }

    protected T onHandleAllocatePoolItem() {
        PoolItem poolItem = (PoolItem) super.onHandleAllocatePoolItem();
        poolItem.mParent = this;
        return poolItem;
    }

    protected void onHandleObtainItem(T pPoolItem) {
        pPoolItem.mRecycled = false;
        pPoolItem.onObtain();
    }

    protected void onHandleRecycleItem(T pPoolItem) {
        pPoolItem.onRecycle();
        pPoolItem.mRecycled = true;
    }

    public synchronized void recyclePoolItem(T pPoolItem) {
        if (pPoolItem.mParent == null) {
            throw new IllegalArgumentException("PoolItem not assigned to a pool!");
        } else if (!pPoolItem.isFromPool(this)) {
            throw new IllegalArgumentException("PoolItem from another pool!");
        } else if (pPoolItem.isRecycled()) {
            throw new IllegalArgumentException("PoolItem already recycled!");
        } else {
            super.recyclePoolItem(pPoolItem);
        }
    }

    public synchronized boolean ownsPoolItem(T pPoolItem) {
        return pPoolItem.mParent == this;
    }

    void recycle(PoolItem pPoolItem) {
        recyclePoolItem(pPoolItem);
    }
}
