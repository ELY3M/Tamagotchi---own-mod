package org.anddev.andengine.opengl;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;

public interface IDrawable {
    void onDraw(GL10 gl10, Camera camera);
}
