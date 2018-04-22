package org.anddev.andengine.util.pool;

import java.util.ArrayList;
import org.anddev.andengine.engine.handler.IUpdateHandler;

public abstract class PoolUpdateHandler<T extends PoolItem> implements IUpdateHandler {
    private final Pool<T> mPool;
    private final ArrayList<T> mScheduledPoolItems;

    class C10511 extends Pool<T> {
        C10511() {
        }

        protected T onAllocatePoolItem() {
            return PoolUpdateHandler.this.onAllocatePoolItem();
        }
    }

    protected abstract T onAllocatePoolItem();

    protected abstract void onHandlePoolItem(T t);

    public PoolUpdateHandler() {
        this.mScheduledPoolItems = new ArrayList();
        this.mPool = new C10511();
    }

    public PoolUpdateHandler(int pInitialPoolSize) {
        this.mScheduledPoolItems = new ArrayList();
        this.mPool = new Pool<T>(pInitialPoolSize) {
            protected T onAllocatePoolItem() {
                return PoolUpdateHandler.this.onAllocatePoolItem();
            }
        };
    }

    public PoolUpdateHandler(int pInitialPoolSize, int pGrowth) {
        this.mScheduledPoolItems = new ArrayList();
        this.mPool = new Pool<T>(pInitialPoolSize, pGrowth) {
            protected T onAllocatePoolItem() {
                return PoolUpdateHandler.this.onAllocatePoolItem();
            }
        };
    }

    public void onUpdate(float pSecondsElapsed) {
        ArrayList<T> scheduledPoolItems = this.mScheduledPoolItems;
        synchronized (scheduledPoolItems) {
            int count = scheduledPoolItems.size();
            if (count > 0) {
                Pool<T> pool = this.mPool;
                for (int i = 0; i < count; i++) {
                    PoolItem item = (PoolItem) scheduledPoolItems.get(i);
                    onHandlePoolItem(item);
                    pool.recyclePoolItem(item);
                }
                scheduledPoolItems.clear();
            }
        }
    }

    public void reset() {
        ArrayList<T> scheduledPoolItems = this.mScheduledPoolItems;
        synchronized (scheduledPoolItems) {
            int count = scheduledPoolItems.size();
            Pool<T> pool = this.mPool;
            for (int i = count - 1; i >= 0; i--) {
                pool.recyclePoolItem((PoolItem) scheduledPoolItems.get(i));
            }
            scheduledPoolItems.clear();
        }
    }

    public T obtainPoolItem() {
        return (PoolItem) this.mPool.obtainPoolItem();
    }

    public void postPoolItem(T pPoolItem) {
        synchronized (this.mScheduledPoolItems) {
            if (pPoolItem == null) {
                throw new IllegalArgumentException("PoolItem already recycled!");
            } else if (this.mPool.ownsPoolItem(pPoolItem)) {
                this.mScheduledPoolItems.add(pPoolItem);
            } else {
                throw new IllegalArgumentException("PoolItem from another pool!");
            }
        }
    }
}
