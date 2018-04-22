package org.anddev.andengine.util.modifier;

import org.anddev.andengine.util.SmartList;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public abstract class BaseModifier<T> implements IModifier<T> {
    protected boolean mFinished;
    private final SmartList<IModifierListener<T>> mModifierListeners = new SmartList(2);
    private boolean mRemoveWhenFinished = true;

    public abstract IModifier<T> deepCopy() throws DeepCopyNotSupportedException;

    public BaseModifier(IModifierListener<T> pModifierListener) {
        addModifierListener(pModifierListener);
    }

    public boolean isFinished() {
        return this.mFinished;
    }

    public final boolean isRemoveWhenFinished() {
        return this.mRemoveWhenFinished;
    }

    public final void setRemoveWhenFinished(boolean pRemoveWhenFinished) {
        this.mRemoveWhenFinished = pRemoveWhenFinished;
    }

    public void addModifierListener(IModifierListener<T> pModifierListener) {
        if (pModifierListener != null) {
            this.mModifierListeners.add(pModifierListener);
        }
    }

    public boolean removeModifierListener(IModifierListener<T> pModifierListener) {
        if (pModifierListener == null) {
            return false;
        }
        return this.mModifierListeners.remove(pModifierListener);
    }

    protected void onModifierStarted(T pItem) {
        SmartList<IModifierListener<T>> modifierListeners = this.mModifierListeners;
        for (int i = modifierListeners.size() - 1; i >= 0; i--) {
            ((IModifierListener) modifierListeners.get(i)).onModifierStarted(this, pItem);
        }
    }

    protected void onModifierFinished(T pItem) {
        SmartList<IModifierListener<T>> modifierListeners = this.mModifierListeners;
        for (int i = modifierListeners.size() - 1; i >= 0; i--) {
            ((IModifierListener) modifierListeners.get(i)).onModifierFinished(this, pItem);
        }
    }
}
