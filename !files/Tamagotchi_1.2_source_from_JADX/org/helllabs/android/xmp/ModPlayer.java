package org.helllabs.android.xmp;

import android.media.AudioTrack;

public class ModPlayer {
    private static ModPlayer instance = null;
    private AudioTrack audio;
    private int minSize = AudioTrack.getMinBufferSize(44100, 3, 2);
    protected boolean paused;
    private Thread playThread;
    private Xmp xmp = new Xmp();

    private class PlayRunnable implements Runnable {
        private PlayRunnable() {
        }

        public void run() {
            short[] buffer = new short[ModPlayer.this.minSize];
            while (ModPlayer.this.xmp.playFrame() == 0) {
                int size = ModPlayer.this.xmp.softmixer();
                buffer = ModPlayer.this.xmp.getBuffer(size, buffer);
                ModPlayer.this.audio.write(buffer, 0, size / 2);
                while (ModPlayer.this.paused) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
            ModPlayer.this.audio.stop();
            ModPlayer.this.xmp.endPlayer();
            ModPlayer.this.xmp.releaseModule();
        }
    }

    protected ModPlayer() {
        int i = 4096;
        if (this.minSize >= 4096) {
            i = this.minSize;
        }
        this.audio = new AudioTrack(3, 44100, 3, 2, i, 1);
    }

    public static ModPlayer getInstance() {
        if (instance == null) {
            instance = new ModPlayer();
            instance.xmp.init();
            instance.paused = false;
        }
        return instance;
    }

    protected void finalize() {
        this.xmp.stopModule();
        this.paused = false;
        try {
            this.playThread.join();
        } catch (InterruptedException e) {
        }
        this.xmp.deinit();
    }

    public void play(String file) {
        if (this.xmp.loadModule(file) >= 0) {
            this.audio.play();
            this.xmp.startPlayer();
            this.playThread = new Thread(new PlayRunnable());
            this.playThread.start();
        }
    }

    public void stop() {
        this.xmp.stopModule();
        this.paused = false;
    }

    public void pause() {
        this.paused = !this.paused;
    }

    public int time() {
        return this.xmp.time();
    }

    public void seek(int seconds) {
        this.xmp.seek(seconds);
    }

    public int getPlayTempo() {
        return this.xmp.getPlayTempo();
    }

    public int getPlayBpm() {
        return this.xmp.getPlayBpm();
    }

    public int getPlayPos() {
        return this.xmp.getPlayPos();
    }

    public int getPlayPat() {
        return this.xmp.getPlayPat();
    }

    public boolean isPaused() {
        return this.paused;
    }
}
