package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.BaseTripleValueSpanModifier;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public abstract class TripleValueSpanEntityModifier extends BaseTripleValueSpanModifier<IEntity> implements IEntityModifier {
    public TripleValueSpanEntityModifier(float pDuration, float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, float pFromValueC, float pToValueC, IEaseFunction pEaseFunction) {
        super(pDuration, pFromValueA, pToValueA, pFromValueB, pToValueB, pFromValueC, pToValueC, pEaseFunction);
    }

    public TripleValueSpanEntityModifier(float pDuration, float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, float pFromValueC, float pToValueC, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromValueA, pToValueA, pFromValueB, pToValueB, pFromValueC, pToValueC, pEntityModifierListener, pEaseFunction);
    }

    protected TripleValueSpanEntityModifier(TripleValueSpanEntityModifier pTripleValueSpanEntityModifier) {
        super(pTripleValueSpanEntityModifier);
    }
}
