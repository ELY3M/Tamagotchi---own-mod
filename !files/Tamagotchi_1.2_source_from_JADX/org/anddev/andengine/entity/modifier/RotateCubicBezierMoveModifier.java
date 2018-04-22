package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class RotateCubicBezierMoveModifier extends CubicBezierMoveModifier {
    public RotateCubicBezierMoveModifier(float pDuration, float pX1, float pY1, float pX2, float pY2, float pX3, float pY3, float pX4, float pY4, IEaseFunction pEaseFunction) {
        super(pDuration, pX1, pY1, pX2, pY2, pX3, pY3, pX4, pY4, pEaseFunction);
    }

    protected void onManagedUpdate(float pSecondsElapsed, IEntity pEntity) {
        float startX = pEntity.getX();
        float startY = pEntity.getY();
        super.onManagedUpdate(pSecondsElapsed, pEntity);
        pEntity.setRotation(MathUtils.radToDeg(MathUtils.atan2(pEntity.getY() - startY, pEntity.getX() - startX)) + 90.0f);
    }
}
