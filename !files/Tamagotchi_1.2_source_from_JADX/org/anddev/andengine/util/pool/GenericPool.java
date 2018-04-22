package org.anddev.andengine.util.pool;

import java.util.Collections;
import java.util.Stack;
import org.anddev.andengine.util.Debug;

public abstract class GenericPool<T> {
    private final Stack<T> mAvailableItems;
    private final int mGrowth;
    private int mUnrecycledCount;

    protected abstract T onAllocatePoolItem();

    public GenericPool() {
        this(0);
    }

    public GenericPool(int pInitialSize) {
        this(pInitialSize, 1);
    }

    public GenericPool(int pInitialSize, int pGrowth) {
        this.mAvailableItems = new Stack();
        if (pGrowth < 0) {
            throw new IllegalArgumentException("pGrowth must be at least 0!");
        }
        this.mGrowth = pGrowth;
        if (pInitialSize > 0) {
            batchAllocatePoolItems(pInitialSize);
        }
    }

    public synchronized int getUnrecycledCount() {
        return this.mUnrecycledCount;
    }

    protected void onHandleRecycleItem(T t) {
    }

    protected T onHandleAllocatePoolItem() {
        return onAllocatePoolItem();
    }

    protected void onHandleObtainItem(T t) {
    }

    public synchronized void batchAllocatePoolItems(int pCount) {
        Stack<T> availableItems = this.mAvailableItems;
        for (int i = pCount - 1; i >= 0; i--) {
            availableItems.push(onHandleAllocatePoolItem());
        }
    }

    public synchronized T obtainPoolItem() {
        T item;
        if (this.mAvailableItems.size() > 0) {
            item = this.mAvailableItems.pop();
        } else {
            if (this.mGrowth == 1) {
                item = onHandleAllocatePoolItem();
            } else {
                batchAllocatePoolItems(this.mGrowth);
                item = this.mAvailableItems.pop();
            }
            Debug.m64i(new StringBuilder(String.valueOf(getClass().getName())).append("<").append(item.getClass().getSimpleName()).append("> was exhausted, with ").append(this.mUnrecycledCount).append(" item not yet recycled. Allocated ").append(this.mGrowth).append(" more.").toString());
        }
        onHandleObtainItem(item);
        this.mUnrecycledCount++;
        return item;
    }

    public synchronized void recyclePoolItem(T pItem) {
        if (pItem == null) {
            throw new IllegalArgumentException("Cannot recycle null item!");
        }
        onHandleRecycleItem(pItem);
        this.mAvailableItems.push(pItem);
        this.mUnrecycledCount--;
        if (this.mUnrecycledCount < 0) {
            Debug.m61e("More items recycled than obtained!");
        }
    }

    public synchronized void shufflePoolItems() {
        Collections.shuffle(this.mAvailableItems);
    }
}
