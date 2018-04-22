package org.anddev.andengine.audio;

public interface IAudioManager<T extends IAudioEntity> {
    void add(T t);

    float getMasterVolume();

    void releaseAll();

    void setMasterVolume(float f);
}
