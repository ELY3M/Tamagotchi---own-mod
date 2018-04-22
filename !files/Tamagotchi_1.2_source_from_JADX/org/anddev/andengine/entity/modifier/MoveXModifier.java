package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class MoveXModifier extends SingleValueSpanEntityModifier {
    public MoveXModifier(float pDuration, float pFromX, float pToX) {
        this(pDuration, pFromX, pToX, null, IEaseFunction.DEFAULT);
    }

    public MoveXModifier(float pDuration, float pFromX, float pToX, IEaseFunction pEaseFunction) {
        this(pDuration, pFromX, pToX, null, pEaseFunction);
    }

    public MoveXModifier(float pDuration, float pFromX, float pToX, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromX, pToX, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public MoveXModifier(float pDuration, float pFromX, float pToX, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromX, pToX, pEntityModifierListener, pEaseFunction);
    }

    protected MoveXModifier(MoveXModifier pMoveXModifier) {
        super(pMoveXModifier);
    }

    public MoveXModifier deepCopy() {
        return new MoveXModifier(this);
    }

    protected void onSetInitialValue(IEntity pEntity, float pX) {
        pEntity.setPosition(pX, pEntity.getY());
    }

    protected void onSetValue(IEntity pEntity, float pPercentageDone, float pX) {
        pEntity.setPosition(pX, pEntity.getY());
    }
}
