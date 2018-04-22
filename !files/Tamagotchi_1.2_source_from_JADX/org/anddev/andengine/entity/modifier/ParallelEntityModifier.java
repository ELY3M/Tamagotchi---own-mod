package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.ParallelModifier;

public class ParallelEntityModifier extends ParallelModifier<IEntity> implements IEntityModifier {
    public ParallelEntityModifier(IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
        super((IModifier[]) pEntityModifiers);
    }

    public ParallelEntityModifier(IEntityModifierListener pEntityModifierListener, IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
        super(pEntityModifierListener, pEntityModifiers);
    }

    protected ParallelEntityModifier(ParallelEntityModifier pParallelShapeModifier) throws DeepCopyNotSupportedException {
        super((ParallelModifier) pParallelShapeModifier);
    }

    public ParallelEntityModifier deepCopy() throws DeepCopyNotSupportedException {
        return new ParallelEntityModifier(this);
    }
}
