package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class ColorModifier extends TripleValueSpanEntityModifier {
    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue) {
        this(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, null, IEaseFunction.DEFAULT);
    }

    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, IEaseFunction pEaseFunction) {
        this(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, null, pEaseFunction);
    }

    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, pEntityModifierListener, pEaseFunction);
    }

    protected ColorModifier(ColorModifier pColorModifier) {
        super(pColorModifier);
    }

    public ColorModifier deepCopy() {
        return new ColorModifier(this);
    }

    protected void onSetInitialValues(IEntity pEntity, float pRed, float pGreen, float pBlue) {
        pEntity.setColor(pRed, pGreen, pBlue);
    }

    protected void onSetValues(IEntity pEntity, float pPerctentageDone, float pRed, float pGreen, float pBlue) {
        pEntity.setColor(pRed, pGreen, pBlue);
    }
}
