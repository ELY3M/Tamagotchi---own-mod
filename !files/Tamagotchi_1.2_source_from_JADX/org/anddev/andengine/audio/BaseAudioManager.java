package org.anddev.andengine.audio;

import java.util.ArrayList;

public abstract class BaseAudioManager<T extends IAudioEntity> implements IAudioManager<T> {
    protected final ArrayList<T> mAudioEntities = new ArrayList();
    protected float mMasterVolume = 1.0f;

    public float getMasterVolume() {
        return this.mMasterVolume;
    }

    public void setMasterVolume(float pMasterVolume) {
        this.mMasterVolume = pMasterVolume;
        ArrayList<T> audioEntities = this.mAudioEntities;
        for (int i = audioEntities.size() - 1; i >= 0; i--) {
            ((IAudioEntity) audioEntities.get(i)).onMasterVolumeChanged(pMasterVolume);
        }
    }

    public void add(T pAudioEntity) {
        this.mAudioEntities.add(pAudioEntity);
    }

    public void releaseAll() {
        ArrayList<T> audioEntities = this.mAudioEntities;
        for (int i = audioEntities.size() - 1; i >= 0; i--) {
            IAudioEntity audioEntity = (IAudioEntity) audioEntities.get(i);
            audioEntity.stop();
            audioEntity.release();
        }
    }
}
