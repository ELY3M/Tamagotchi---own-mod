package org.anddev.andengine.util.pool;

public class EntityDetachRunnablePoolUpdateHandler extends RunnablePoolUpdateHandler<EntityDetachRunnablePoolItem> {
    protected EntityDetachRunnablePoolItem onAllocatePoolItem() {
        return new EntityDetachRunnablePoolItem();
    }
}
