package org.anddev.andengine.audio.music;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import org.anddev.andengine.audio.BaseAudioEntity;

public class Music extends BaseAudioEntity {
    private final MediaPlayer mMediaPlayer;

    Music(MusicManager pMusicManager, MediaPlayer pMediaPlayer) {
        super(pMusicManager);
        this.mMediaPlayer = pMediaPlayer;
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    protected MusicManager getAudioManager() {
        return (MusicManager) super.getAudioManager();
    }

    public void play() {
        this.mMediaPlayer.start();
    }

    public void stop() {
        this.mMediaPlayer.stop();
    }

    public void resume() {
        this.mMediaPlayer.start();
    }

    public void pause() {
        this.mMediaPlayer.pause();
    }

    public void release() {
        this.mMediaPlayer.release();
    }

    public void setLooping(boolean pLooping) {
        this.mMediaPlayer.setLooping(pLooping);
    }

    public void setVolume(float pLeftVolume, float pRightVolume) {
        super.setVolume(pLeftVolume, pRightVolume);
        float masterVolume = getAudioManager().getMasterVolume();
        this.mMediaPlayer.setVolume(pLeftVolume * masterVolume, pRightVolume * masterVolume);
    }

    public void onMasterVolumeChanged(float pMasterVolume) {
        setVolume(this.mLeftVolume, this.mRightVolume);
    }

    public void seekTo(int pMilliseconds) {
        this.mMediaPlayer.seekTo(pMilliseconds);
    }

    public void setOnCompletionListener(OnCompletionListener pOnCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(pOnCompletionListener);
    }
}
