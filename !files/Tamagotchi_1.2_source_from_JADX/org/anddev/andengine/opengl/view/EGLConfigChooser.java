package org.anddev.andengine.opengl.view;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public interface EGLConfigChooser {
    EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
}
