package org.anddev.andengine.entity.shape;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;

public interface IShape extends IEntity, ITouchArea {
    boolean collidesWith(IShape iShape);

    float getBaseHeight();

    float getBaseWidth();

    float getHeight();

    float getHeightScaled();

    float getWidth();

    float getWidthScaled();

    boolean isCullingEnabled();

    void setBlendFunction(int i, int i2);

    void setCullingEnabled(boolean z);
}
