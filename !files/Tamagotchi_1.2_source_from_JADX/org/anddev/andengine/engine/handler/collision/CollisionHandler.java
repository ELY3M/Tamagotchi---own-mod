package org.anddev.andengine.engine.handler.collision;

import java.util.ArrayList;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.util.ListUtils;

public class CollisionHandler implements IUpdateHandler {
    private final IShape mCheckShape;
    private final ICollisionCallback mCollisionCallback;
    private final ArrayList<? extends IShape> mTargetStaticEntities;

    public CollisionHandler(ICollisionCallback pCollisionCallback, IShape pCheckShape, IShape pTargetShape) throws IllegalArgumentException {
        this(pCollisionCallback, pCheckShape, ListUtils.toList((Object) pTargetShape));
    }

    public CollisionHandler(ICollisionCallback pCollisionCallback, IShape pCheckShape, ArrayList<? extends IShape> pTargetStaticEntities) throws IllegalArgumentException {
        if (pCollisionCallback == null) {
            throw new IllegalArgumentException("pCollisionCallback must not be null!");
        } else if (pCheckShape == null) {
            throw new IllegalArgumentException("pCheckShape must not be null!");
        } else if (pTargetStaticEntities == null) {
            throw new IllegalArgumentException("pTargetStaticEntities must not be null!");
        } else {
            this.mCollisionCallback = pCollisionCallback;
            this.mCheckShape = pCheckShape;
            this.mTargetStaticEntities = pTargetStaticEntities;
        }
    }

    public void onUpdate(float pSecondsElapsed) {
        IShape checkShape = this.mCheckShape;
        ArrayList<? extends IShape> staticEntities = this.mTargetStaticEntities;
        int staticEntityCount = staticEntities.size();
        int i = 0;
        while (i < staticEntityCount) {
            if (!checkShape.collidesWith((IShape) staticEntities.get(i)) || this.mCollisionCallback.onCollision(checkShape, (IShape) staticEntities.get(i))) {
                i++;
            } else {
                return;
            }
        }
    }

    public void reset() {
    }
}
