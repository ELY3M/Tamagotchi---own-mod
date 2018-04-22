package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class ScaleModifier extends DoubleValueSpanEntityModifier {
    public ScaleModifier(float pDuration, float pFromScale, float pToScale) {
        this(pDuration, pFromScale, pToScale, null, IEaseFunction.DEFAULT);
    }

    public ScaleModifier(float pDuration, float pFromScale, float pToScale, IEaseFunction pEaseFunction) {
        this(pDuration, pFromScale, pToScale, null, pEaseFunction);
    }

    public ScaleModifier(float pDuration, float pFromScale, float pToScale, IEntityModifierListener pEntityModifierListener) {
        this(pDuration, pFromScale, pToScale, pFromScale, pToScale, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public ScaleModifier(float pDuration, float pFromScale, float pToScale, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        this(pDuration, pFromScale, pToScale, pFromScale, pToScale, pEntityModifierListener, pEaseFunction);
    }

    public ScaleModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY) {
        this(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, null, IEaseFunction.DEFAULT);
    }

    public ScaleModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, IEaseFunction pEaseFunction) {
        this(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, null, pEaseFunction);
    }

    public ScaleModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public ScaleModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pEntityModifierListener, pEaseFunction);
    }

    protected ScaleModifier(ScaleModifier pScaleModifier) {
        super(pScaleModifier);
    }

    public ScaleModifier deepCopy() {
        return new ScaleModifier(this);
    }

    protected void onSetInitialValues(IEntity pEntity, float pScaleA, float pScaleB) {
        pEntity.setScale(pScaleA, pScaleB);
    }

    protected void onSetValues(IEntity pEntity, float pPercentageDone, float pScaleA, float pScaleB) {
        pEntity.setScale(pScaleA, pScaleB);
    }
}
