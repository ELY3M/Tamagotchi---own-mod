package org.anddev.andengine.audio.sound;

import org.anddev.andengine.audio.BaseAudioEntity;

public class Sound extends BaseAudioEntity {
    private int mLoopCount = 0;
    private float mRate = 1.0f;
    private final int mSoundID;
    private int mStreamID = 0;

    Sound(SoundManager pSoundManager, int pSoundID) {
        super(pSoundManager);
        this.mSoundID = pSoundID;
    }

    public void setLoopCount(int pLoopCount) {
        this.mLoopCount = pLoopCount;
        if (this.mStreamID != 0) {
            getAudioManager().getSoundPool().setLoop(this.mStreamID, pLoopCount);
        }
    }

    public void setRate(float pRate) {
        this.mRate = pRate;
        if (this.mStreamID != 0) {
            getAudioManager().getSoundPool().setRate(this.mStreamID, pRate);
        }
    }

    protected SoundManager getAudioManager() {
        return (SoundManager) super.getAudioManager();
    }

    public void play() {
        float masterVolume = getMasterVolume();
        this.mStreamID = getAudioManager().getSoundPool().play(this.mSoundID, this.mLeftVolume * masterVolume, this.mRightVolume * masterVolume, 1, this.mLoopCount, this.mRate);
    }

    public void stop() {
        if (this.mStreamID != 0) {
            getAudioManager().getSoundPool().stop(this.mStreamID);
        }
    }

    public void resume() {
        if (this.mStreamID != 0) {
            getAudioManager().getSoundPool().resume(this.mStreamID);
        }
    }

    public void pause() {
        if (this.mStreamID != 0) {
            getAudioManager().getSoundPool().pause(this.mStreamID);
        }
    }

    public void release() {
    }

    public void setLooping(boolean pLooping) {
        setLoopCount(pLooping ? -1 : 0);
    }

    public void setVolume(float pLeftVolume, float pRightVolume) {
        super.setVolume(pLeftVolume, pRightVolume);
        if (this.mStreamID != 0) {
            float masterVolume = getMasterVolume();
            getAudioManager().getSoundPool().setVolume(this.mStreamID, this.mLeftVolume * masterVolume, this.mRightVolume * masterVolume);
        }
    }

    public void onMasterVolumeChanged(float pMasterVolume) {
        setVolume(this.mLeftVolume, this.mRightVolume);
    }
}
