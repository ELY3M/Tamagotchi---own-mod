package org.anddev.andengine.entity.scene.background.modifier;

import org.anddev.andengine.entity.scene.background.IBackground;
import org.anddev.andengine.entity.scene.background.modifier.IBackgroundModifier.IBackgroundModifierListener;
import org.anddev.andengine.util.modifier.BaseTripleValueSpanModifier;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class ColorModifier extends BaseTripleValueSpanModifier<IBackground> implements IBackgroundModifier {
    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue) {
        this(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, null, IEaseFunction.DEFAULT);
    }

    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, IEaseFunction pEaseFunction) {
        this(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, null, pEaseFunction);
    }

    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, IBackgroundModifierListener pBackgroundModifierListener) {
        super(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, pBackgroundModifierListener, IEaseFunction.DEFAULT);
    }

    public ColorModifier(float pDuration, float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, IBackgroundModifierListener pBackgroundModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, pBackgroundModifierListener, pEaseFunction);
    }

    protected ColorModifier(ColorModifier pColorModifier) {
        super(pColorModifier);
    }

    public ColorModifier deepCopy() {
        return new ColorModifier(this);
    }

    protected void onSetInitialValues(IBackground pBackground, float pRed, float pGreen, float pBlue) {
        pBackground.setColor(pRed, pGreen, pBlue);
    }

    protected void onSetValues(IBackground pBackground, float pPerctentageDone, float pRed, float pGreen, float pBlue) {
        pBackground.setColor(pRed, pGreen, pBlue);
    }
}
