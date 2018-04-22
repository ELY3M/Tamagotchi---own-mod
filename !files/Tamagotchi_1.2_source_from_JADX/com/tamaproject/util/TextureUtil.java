package com.tamaproject.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.opengl.texture.ITexture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.util.MathUtils;

public class TextureUtil {
    public static Hashtable<String, TextureRegion> loadTextures(Context context, Engine pEngine, String[] folderNameArray) {
        Hashtable<String, TextureRegion> listTR = new Hashtable();
        List<BitmapTextureAtlas> texturelist = new ArrayList();
        Options opt = new Options();
        opt.inJustDecodeBounds = true;
        int i = 0;
        while (i < folderNameArray.length) {
            BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(folderNameArray[i]);
            try {
                String[] fileNames = context.getResources().getAssets().list(folderNameArray[i].substring(0, folderNameArray[i].lastIndexOf("/")));
                Arrays.sort(fileNames);
                for (int j = 0; j < fileNames.length; j++) {
                    BitmapFactory.decodeStream(context.getResources().getAssets().open(folderNameArray[i].concat(fileNames[j])), null, opt);
                    int width = opt.outWidth;
                    int height = opt.outHeight;
                    if (!MathUtils.isPowerOfTwo(width)) {
                        width = MathUtils.nextPowerOfTwo(opt.outWidth);
                    }
                    if (!MathUtils.isPowerOfTwo(height)) {
                        height = MathUtils.nextPowerOfTwo(opt.outHeight);
                    }
                    texturelist.add(new BitmapTextureAtlas(width, height, TextureOptions.BILINEAR_PREMULTIPLYALPHA));
                    listTR.put(fileNames[j], BitmapTextureAtlasTextureRegionFactory.createFromAsset((BitmapTextureAtlas) texturelist.get(j), context, fileNames[j], 0, 0));
                    pEngine.getTextureManager().loadTexture((ITexture) texturelist.get(j));
                }
                i++;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return listTR;
    }
}
