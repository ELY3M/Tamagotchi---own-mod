package org.anddev.andengine.engine.handler;

import org.anddev.andengine.util.SmartList;

public class UpdateHandlerList extends SmartList<IUpdateHandler> implements IUpdateHandler {
    private static final long serialVersionUID = -8842562717687229277L;

    public UpdateHandlerList(int pCapacity) {
        super(pCapacity);
    }

    public void onUpdate(float pSecondsElapsed) {
        for (int i = size() - 1; i >= 0; i--) {
            ((IUpdateHandler) get(i)).onUpdate(pSecondsElapsed);
        }
    }

    public void reset() {
        for (int i = size() - 1; i >= 0; i--) {
            ((IUpdateHandler) get(i)).reset();
        }
    }
}
