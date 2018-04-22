package org.anddev.andengine.engine.handler.runnable;

import java.util.ArrayList;
import org.anddev.andengine.engine.handler.IUpdateHandler;

public class RunnableHandler implements IUpdateHandler {
    private final ArrayList<Runnable> mRunnables = new ArrayList();

    public synchronized void onUpdate(float pSecondsElapsed) {
        ArrayList<Runnable> runnables = this.mRunnables;
        for (int i = runnables.size() - 1; i >= 0; i--) {
            ((Runnable) runnables.get(i)).run();
        }
        runnables.clear();
    }

    public void reset() {
        this.mRunnables.clear();
    }

    public synchronized void postRunnable(Runnable pRunnable) {
        this.mRunnables.add(pRunnable);
    }
}
