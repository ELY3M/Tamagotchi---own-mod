package org.helllabs.android.xmp;

public class Xmp {
    public native int decGvol();

    public native int deinit();

    public native int endPlayer();

    public native short[] getBuffer(int i, short[] sArr);

    public native int getFormatCount();

    public native String[] getFormats();

    public native ModInfo getModInfo(String str);

    public native int getPlayBpm();

    public native int getPlayPat();

    public native int getPlayPos();

    public native int getPlayTempo();

    public native String getVersion();

    public native int incGvol();

    public native int init();

    public native int loadModule(String str);

    public native int nextOrd();

    public native int playFrame();

    public native int prevOrd();

    public native int releaseModule();

    public native int restartModule();

    public native int restartTimer();

    public native int seek(int i);

    public native int seek(long j);

    public native int setOrd(int i);

    public native int softmixer();

    public native int startPlayer();

    public native int stopModule();

    public native int stopTimer();

    public native int testModule(String str);

    public native int time();

    static {
        System.loadLibrary("xmp");
    }
}
