package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class MoveModifier extends DoubleValueSpanEntityModifier {
    public MoveModifier(float pDuration, float pFromX, float pToX, float pFromY, float pToY) {
        this(pDuration, pFromX, pToX, pFromY, pToY, null, IEaseFunction.DEFAULT);
    }

    public MoveModifier(float pDuration, float pFromX, float pToX, float pFromY, float pToY, IEaseFunction pEaseFunction) {
        this(pDuration, pFromX, pToX, pFromY, pToY, null, pEaseFunction);
    }

    public MoveModifier(float pDuration, float pFromX, float pToX, float pFromY, float pToY, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromX, pToX, pFromY, pToY, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public MoveModifier(float pDuration, float pFromX, float pToX, float pFromY, float pToY, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromX, pToX, pFromY, pToY, pEntityModifierListener, pEaseFunction);
    }

    protected MoveModifier(MoveModifier pMoveModifier) {
        super(pMoveModifier);
    }

    public MoveModifier deepCopy() {
        return new MoveModifier(this);
    }

    protected void onSetInitialValues(IEntity pEntity, float pX, float pY) {
        pEntity.setPosition(pX, pY);
    }

    protected void onSetValues(IEntity pEntity, float pPercentageDone, float pX, float pY) {
        pEntity.setPosition(pX, pY);
    }
}
