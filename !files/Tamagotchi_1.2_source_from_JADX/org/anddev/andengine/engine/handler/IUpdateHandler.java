package org.anddev.andengine.engine.handler;

import org.anddev.andengine.util.IMatcher;

public interface IUpdateHandler {

    public interface IUpdateHandlerMatcher extends IMatcher<IUpdateHandler> {
    }

    void onUpdate(float f);

    void reset();
}
