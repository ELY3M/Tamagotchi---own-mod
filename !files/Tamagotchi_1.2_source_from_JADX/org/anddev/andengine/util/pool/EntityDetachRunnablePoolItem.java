package org.anddev.andengine.util.pool;

import org.anddev.andengine.entity.IEntity;

public class EntityDetachRunnablePoolItem extends RunnablePoolItem {
    protected IEntity mEntity;

    public void setEntity(IEntity pEntity) {
        this.mEntity = pEntity;
    }

    public void run() {
        this.mEntity.detachSelf();
    }
}
