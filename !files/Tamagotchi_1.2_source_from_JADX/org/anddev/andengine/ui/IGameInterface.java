package org.anddev.andengine.ui;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;

public interface IGameInterface {
    void onLoadComplete();

    Engine onLoadEngine();

    void onLoadResources();

    Scene onLoadScene();

    void onPauseGame();

    void onResumeGame();

    void onUnloadResources();
}
