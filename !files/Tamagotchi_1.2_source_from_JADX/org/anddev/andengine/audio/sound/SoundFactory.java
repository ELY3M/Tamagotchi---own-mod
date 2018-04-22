package org.anddev.andengine.audio.sound;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.IOException;

public class SoundFactory {
    private static String sAssetBasePath = "";

    public static void setAssetBasePath(String pAssetBasePath) {
        if (pAssetBasePath.endsWith("/") || pAssetBasePath.length() == 0) {
            sAssetBasePath = pAssetBasePath;
            return;
        }
        throw new IllegalStateException("pAssetBasePath must end with '/' or be lenght zero.");
    }

    public static void reset() {
        setAssetBasePath("");
    }

    public static Sound createSoundFromPath(SoundManager pSoundManager, String pPath) throws IOException {
        Sound sound = new Sound(pSoundManager, pSoundManager.getSoundPool().load(pPath, 1));
        pSoundManager.add(sound);
        return sound;
    }

    public static Sound createSoundFromAsset(SoundManager pSoundManager, Context pContext, String pAssetPath) throws IOException {
        Sound sound = new Sound(pSoundManager, pSoundManager.getSoundPool().load(pContext.getAssets().openFd(sAssetBasePath + pAssetPath), 1));
        pSoundManager.add(sound);
        return sound;
    }

    public static Sound createSoundFromResource(SoundManager pSoundManager, Context pContext, int pSoundResID) {
        Sound sound = new Sound(pSoundManager, pSoundManager.getSoundPool().load(pContext, pSoundResID, 1));
        pSoundManager.add(sound);
        return sound;
    }

    public static Sound createSoundFromFileDescriptor(SoundManager pSoundManager, FileDescriptor pFileDescriptor, long pOffset, long pLength) throws IOException {
        Sound sound = new Sound(pSoundManager, pSoundManager.getSoundPool().load(pFileDescriptor, pOffset, pLength, 1));
        pSoundManager.add(sound);
        return sound;
    }
}
