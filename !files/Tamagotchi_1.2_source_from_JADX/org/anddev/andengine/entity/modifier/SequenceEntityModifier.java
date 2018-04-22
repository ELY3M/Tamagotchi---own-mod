package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;
import org.anddev.andengine.util.modifier.SequenceModifier;
import org.anddev.andengine.util.modifier.SequenceModifier.ISubSequenceModifierListener;

public class SequenceEntityModifier extends SequenceModifier<IEntity> implements IEntityModifier {

    public interface ISubSequenceShapeModifierListener extends ISubSequenceModifierListener<IEntity> {
    }

    public SequenceEntityModifier(IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
        super((IModifier[]) pEntityModifiers);
    }

    public SequenceEntityModifier(ISubSequenceShapeModifierListener pSubSequenceShapeModifierListener, IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
        super((ISubSequenceModifierListener) pSubSequenceShapeModifierListener, (IModifier[]) pEntityModifiers);
    }

    public SequenceEntityModifier(IEntityModifierListener pEntityModifierListener, IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
        super((IModifierListener) pEntityModifierListener, (IModifier[]) pEntityModifiers);
    }

    public SequenceEntityModifier(ISubSequenceShapeModifierListener pSubSequenceShapeModifierListener, IEntityModifierListener pEntityModifierListener, IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
        super(pSubSequenceShapeModifierListener, pEntityModifierListener, pEntityModifiers);
    }

    protected SequenceEntityModifier(SequenceEntityModifier pSequenceShapeModifier) throws DeepCopyNotSupportedException {
        super((SequenceModifier) pSequenceShapeModifier);
    }

    public SequenceEntityModifier deepCopy() throws DeepCopyNotSupportedException {
        return new SequenceEntityModifier(this);
    }
}
