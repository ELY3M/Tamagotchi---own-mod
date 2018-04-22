package org.anddev.andengine.util.pool;

public abstract class RunnablePoolUpdateHandler<T extends RunnablePoolItem> extends PoolUpdateHandler<T> {
    protected abstract T onAllocatePoolItem();

    public RunnablePoolUpdateHandler(int pInitialPoolSize) {
        super(pInitialPoolSize);
    }

    protected void onHandlePoolItem(T pRunnablePoolItem) {
        pRunnablePoolItem.run();
    }
}
