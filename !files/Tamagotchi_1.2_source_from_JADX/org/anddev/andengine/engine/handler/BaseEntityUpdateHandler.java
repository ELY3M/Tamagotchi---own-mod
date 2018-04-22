package org.anddev.andengine.engine.handler;

import org.anddev.andengine.entity.IEntity;

public abstract class BaseEntityUpdateHandler implements IUpdateHandler {
    private final IEntity mEntity;

    protected abstract void onUpdate(float f, IEntity iEntity);

    public BaseEntityUpdateHandler(IEntity pEntity) {
        this.mEntity = pEntity;
    }

    public final void onUpdate(float pSecondsElapsed) {
        onUpdate(pSecondsElapsed, this.mEntity);
    }

    public void reset() {
    }
}
