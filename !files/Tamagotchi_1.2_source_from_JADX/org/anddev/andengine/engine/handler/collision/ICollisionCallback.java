package org.anddev.andengine.engine.handler.collision;

import org.anddev.andengine.entity.shape.IShape;

public interface ICollisionCallback {
    boolean onCollision(IShape iShape, IShape iShape2);
}
