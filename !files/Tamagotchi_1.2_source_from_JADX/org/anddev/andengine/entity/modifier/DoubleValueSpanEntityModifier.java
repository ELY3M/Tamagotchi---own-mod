package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.BaseDoubleValueSpanModifier;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public abstract class DoubleValueSpanEntityModifier extends BaseDoubleValueSpanModifier<IEntity> implements IEntityModifier {
    public DoubleValueSpanEntityModifier(float pDuration, float pFromValueA, float pToValueA, float pFromValueB, float pToValueB) {
        super(pDuration, pFromValueA, pToValueA, pFromValueB, pToValueB);
    }

    public DoubleValueSpanEntityModifier(float pDuration, float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, IEaseFunction pEaseFunction) {
        super(pDuration, pFromValueA, pToValueA, pFromValueB, pToValueB, pEaseFunction);
    }

    public DoubleValueSpanEntityModifier(float pDuration, float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromValueA, pToValueA, pFromValueB, pToValueB, (IModifierListener) pEntityModifierListener);
    }

    public DoubleValueSpanEntityModifier(float pDuration, float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromValueA, pToValueA, pFromValueB, pToValueB, pEntityModifierListener, pEaseFunction);
    }

    protected DoubleValueSpanEntityModifier(DoubleValueSpanEntityModifier pDoubleValueSpanEntityModifier) {
        super(pDoubleValueSpanEntityModifier);
    }
}
