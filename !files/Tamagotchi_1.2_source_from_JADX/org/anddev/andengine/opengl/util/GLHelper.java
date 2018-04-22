package org.anddev.andengine.opengl.util;

import android.graphics.Bitmap;
import android.opengl.GLException;
import android.os.Build;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import org.anddev.andengine.engine.options.RenderOptions;
import org.anddev.andengine.extension.svg.util.constants.ColorUtils;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.util.Debug;

public class GLHelper {
    private static /* synthetic */ int[] f9xc82e07aa = null;
    public static final int BYTES_PER_FLOAT = 4;
    public static final int BYTES_PER_PIXEL_RGBA = 4;
    public static boolean EXTENSIONS_DRAWTEXTURE = false;
    public static boolean EXTENSIONS_TEXTURE_NON_POWER_OF_TWO = false;
    public static boolean EXTENSIONS_VERTEXBUFFEROBJECTS = false;
    private static final int[] HARDWAREBUFFERID_CONTAINER = new int[1];
    private static final int[] HARDWARETEXTUREID_CONTAINER = new int[1];
    private static final boolean IS_LITTLE_ENDIAN;
    private static float sAlpha = -1.0f;
    private static float sBlue = -1.0f;
    private static int sCurrentDestinationBlendMode = -1;
    private static int sCurrentHardwareBufferID = -1;
    private static int sCurrentHardwareTextureID = -1;
    private static int sCurrentMatrix = -1;
    private static int sCurrentSourceBlendMode = -1;
    private static FastFloatBuffer sCurrentTextureFloatBuffer = null;
    private static FastFloatBuffer sCurrentVertexFloatBuffer = null;
    private static boolean sEnableBlend = false;
    private static boolean sEnableCulling = false;
    private static boolean sEnableDepthTest = true;
    private static boolean sEnableDither = true;
    private static boolean sEnableLightning = true;
    private static boolean sEnableMultisample = true;
    private static boolean sEnableScissorTest = false;
    private static boolean sEnableTexCoordArray = false;
    private static boolean sEnableTextures = false;
    private static boolean sEnableVertexArray = false;
    private static float sGreen = -1.0f;
    private static float sLineWidth = 1.0f;
    private static float sRed = -1.0f;

    static /* synthetic */ int[] m29xc82e07aa() {
        int[] iArr = f9xc82e07aa;
        if (iArr == null) {
            iArr = new int[PixelFormat.values().length];
            try {
                iArr[PixelFormat.AI_88.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PixelFormat.A_8.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PixelFormat.I_8.ordinal()] = 7;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PixelFormat.RGBA_4444.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PixelFormat.RGBA_5551.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PixelFormat.RGBA_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PixelFormat.RGB_565.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[PixelFormat.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            f9xc82e07aa = iArr;
        }
        return iArr;
    }

    static {
        boolean z;
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            z = true;
        } else {
            z = false;
        }
        IS_LITTLE_ENDIAN = z;
    }

    public static void reset(GL10 pGL) {
        sCurrentHardwareBufferID = -1;
        sCurrentHardwareTextureID = -1;
        sCurrentMatrix = -1;
        sCurrentSourceBlendMode = -1;
        sCurrentDestinationBlendMode = -1;
        sCurrentVertexFloatBuffer = null;
        sCurrentTextureFloatBuffer = null;
        enableDither(pGL);
        enableLightning(pGL);
        enableDepthTest(pGL);
        enableMultisample(pGL);
        disableBlend(pGL);
        disableCulling(pGL);
        disableTextures(pGL);
        disableTexCoordArray(pGL);
        disableVertexArray(pGL);
        sLineWidth = 1.0f;
        sRed = -1.0f;
        sGreen = -1.0f;
        sBlue = -1.0f;
        sAlpha = -1.0f;
        EXTENSIONS_VERTEXBUFFEROBJECTS = false;
        EXTENSIONS_DRAWTEXTURE = false;
        EXTENSIONS_TEXTURE_NON_POWER_OF_TWO = false;
    }

    public static void enableExtensions(GL10 pGL, RenderOptions pRenderOptions) {
        boolean z = false;
        String version = pGL.glGetString(7938);
        String renderer = pGL.glGetString(7937);
        String extensions = pGL.glGetString(7939);
        Debug.m59d("RENDERER: " + renderer);
        Debug.m59d("VERSION: " + version);
        Debug.m59d("EXTENSIONS: " + extensions);
        boolean isOpenGL10 = version.contains("1.0");
        boolean isOpenGL2X = version.contains("2.");
        boolean isSoftwareRenderer = renderer.contains("PixelFlinger");
        boolean isVBOCapable = extensions.contains("_vertex_buffer_object");
        boolean isDrawTextureCapable = extensions.contains("draw_texture");
        boolean isTextureNonPowerOfTwoCapable = extensions.contains("texture_npot");
        boolean z2 = (pRenderOptions.isDisableExtensionVertexBufferObjects() || isSoftwareRenderer || (!isVBOCapable && isOpenGL10)) ? false : true;
        EXTENSIONS_VERTEXBUFFEROBJECTS = z2;
        if (pRenderOptions.isDisableExtensionVertexBufferObjects() || (!isDrawTextureCapable && isOpenGL10)) {
            z2 = false;
        } else {
            z2 = true;
        }
        EXTENSIONS_DRAWTEXTURE = z2;
        if (isTextureNonPowerOfTwoCapable || isOpenGL2X) {
            z = true;
        }
        EXTENSIONS_TEXTURE_NON_POWER_OF_TWO = z;
        hackBrokenDevices();
        Debug.m59d("EXTENSIONS_VERXTEXBUFFEROBJECTS = " + EXTENSIONS_VERTEXBUFFEROBJECTS);
        Debug.m59d("EXTENSIONS_DRAWTEXTURE = " + EXTENSIONS_DRAWTEXTURE);
    }

    private static void hackBrokenDevices() {
        if (Build.PRODUCT.contains("morrison")) {
            EXTENSIONS_VERTEXBUFFEROBJECTS = false;
        }
    }

    public static void setColor(GL10 pGL, float pRed, float pGreen, float pBlue, float pAlpha) {
        if (pAlpha != sAlpha || pRed != sRed || pGreen != sGreen || pBlue != sBlue) {
            sAlpha = pAlpha;
            sRed = pRed;
            sGreen = pGreen;
            sBlue = pBlue;
            pGL.glColor4f(pRed, pGreen, pBlue, pAlpha);
        }
    }

    public static void enableVertexArray(GL10 pGL) {
        if (!sEnableVertexArray) {
            sEnableVertexArray = true;
            pGL.glEnableClientState(32884);
        }
    }

    public static void disableVertexArray(GL10 pGL) {
        if (sEnableVertexArray) {
            sEnableVertexArray = false;
            pGL.glDisableClientState(32884);
        }
    }

    public static void enableTexCoordArray(GL10 pGL) {
        if (!sEnableTexCoordArray) {
            sEnableTexCoordArray = true;
            pGL.glEnableClientState(32888);
        }
    }

    public static void disableTexCoordArray(GL10 pGL) {
        if (sEnableTexCoordArray) {
            sEnableTexCoordArray = false;
            pGL.glDisableClientState(32888);
        }
    }

    public static void enableScissorTest(GL10 pGL) {
        if (!sEnableScissorTest) {
            sEnableScissorTest = true;
            pGL.glEnable(3089);
        }
    }

    public static void disableScissorTest(GL10 pGL) {
        if (sEnableScissorTest) {
            sEnableScissorTest = false;
            pGL.glDisable(3089);
        }
    }

    public static void enableBlend(GL10 pGL) {
        if (!sEnableBlend) {
            sEnableBlend = true;
            pGL.glEnable(3042);
        }
    }

    public static void disableBlend(GL10 pGL) {
        if (sEnableBlend) {
            sEnableBlend = false;
            pGL.glDisable(3042);
        }
    }

    public static void enableCulling(GL10 pGL) {
        if (!sEnableCulling) {
            sEnableCulling = true;
            pGL.glEnable(2884);
        }
    }

    public static void disableCulling(GL10 pGL) {
        if (sEnableCulling) {
            sEnableCulling = false;
            pGL.glDisable(2884);
        }
    }

    public static void enableTextures(GL10 pGL) {
        if (!sEnableTextures) {
            sEnableTextures = true;
            pGL.glEnable(3553);
        }
    }

    public static void disableTextures(GL10 pGL) {
        if (sEnableTextures) {
            sEnableTextures = false;
            pGL.glDisable(3553);
        }
    }

    public static void enableLightning(GL10 pGL) {
        if (!sEnableLightning) {
            sEnableLightning = true;
            pGL.glEnable(2896);
        }
    }

    public static void disableLightning(GL10 pGL) {
        if (sEnableLightning) {
            sEnableLightning = false;
            pGL.glDisable(2896);
        }
    }

    public static void enableDither(GL10 pGL) {
        if (!sEnableDither) {
            sEnableDither = true;
            pGL.glEnable(3024);
        }
    }

    public static void disableDither(GL10 pGL) {
        if (sEnableDither) {
            sEnableDither = false;
            pGL.glDisable(3024);
        }
    }

    public static void enableDepthTest(GL10 pGL) {
        if (!sEnableDepthTest) {
            sEnableDepthTest = true;
            pGL.glEnable(2929);
        }
    }

    public static void disableDepthTest(GL10 pGL) {
        if (sEnableDepthTest) {
            sEnableDepthTest = false;
            pGL.glDisable(2929);
        }
    }

    public static void enableMultisample(GL10 pGL) {
        if (!sEnableMultisample) {
            sEnableMultisample = true;
            pGL.glEnable(32925);
        }
    }

    public static void disableMultisample(GL10 pGL) {
        if (sEnableMultisample) {
            sEnableMultisample = false;
            pGL.glDisable(32925);
        }
    }

    public static void bindBuffer(GL11 pGL11, int pHardwareBufferID) {
        if (sCurrentHardwareBufferID != pHardwareBufferID) {
            sCurrentHardwareBufferID = pHardwareBufferID;
            pGL11.glBindBuffer(34962, pHardwareBufferID);
        }
    }

    public static void deleteBuffer(GL11 pGL11, int pHardwareBufferID) {
        HARDWAREBUFFERID_CONTAINER[0] = pHardwareBufferID;
        pGL11.glDeleteBuffers(1, HARDWAREBUFFERID_CONTAINER, 0);
    }

    public static void bindTexture(GL10 pGL, int pHardwareTextureID) {
        if (sCurrentHardwareTextureID != pHardwareTextureID) {
            sCurrentHardwareTextureID = pHardwareTextureID;
            pGL.glBindTexture(3553, pHardwareTextureID);
        }
    }

    public static void forceBindTexture(GL10 pGL, int pHardwareTextureID) {
        sCurrentHardwareTextureID = pHardwareTextureID;
        pGL.glBindTexture(3553, pHardwareTextureID);
    }

    public static void deleteTexture(GL10 pGL, int pHardwareTextureID) {
        HARDWARETEXTUREID_CONTAINER[0] = pHardwareTextureID;
        pGL.glDeleteTextures(1, HARDWARETEXTUREID_CONTAINER, 0);
    }

    public static void texCoordPointer(GL10 pGL, FastFloatBuffer pTextureFloatBuffer) {
        if (sCurrentTextureFloatBuffer != pTextureFloatBuffer) {
            sCurrentTextureFloatBuffer = pTextureFloatBuffer;
            pGL.glTexCoordPointer(2, 5126, 0, pTextureFloatBuffer.mByteBuffer);
        }
    }

    public static void texCoordZeroPointer(GL11 pGL11) {
        pGL11.glTexCoordPointer(2, 5126, 0, 0);
    }

    public static void vertexPointer(GL10 pGL, FastFloatBuffer pVertexFloatBuffer) {
        if (sCurrentVertexFloatBuffer != pVertexFloatBuffer) {
            sCurrentVertexFloatBuffer = pVertexFloatBuffer;
            pGL.glVertexPointer(2, 5126, 0, pVertexFloatBuffer.mByteBuffer);
        }
    }

    public static void vertexZeroPointer(GL11 pGL11) {
        pGL11.glVertexPointer(2, 5126, 0, 0);
    }

    public static void blendFunction(GL10 pGL, int pSourceBlendMode, int pDestinationBlendMode) {
        if (sCurrentSourceBlendMode != pSourceBlendMode || sCurrentDestinationBlendMode != pDestinationBlendMode) {
            sCurrentSourceBlendMode = pSourceBlendMode;
            sCurrentDestinationBlendMode = pDestinationBlendMode;
            pGL.glBlendFunc(pSourceBlendMode, pDestinationBlendMode);
        }
    }

    public static void lineWidth(GL10 pGL, float pLineWidth) {
        if (sLineWidth != pLineWidth) {
            sLineWidth = pLineWidth;
            pGL.glLineWidth(pLineWidth);
        }
    }

    public static void switchToModelViewMatrix(GL10 pGL) {
        if (sCurrentMatrix != 5888) {
            sCurrentMatrix = 5888;
            pGL.glMatrixMode(5888);
        }
    }

    public static void switchToProjectionMatrix(GL10 pGL) {
        if (sCurrentMatrix != 5889) {
            sCurrentMatrix = 5889;
            pGL.glMatrixMode(5889);
        }
    }

    public static void setProjectionIdentityMatrix(GL10 pGL) {
        switchToProjectionMatrix(pGL);
        pGL.glLoadIdentity();
    }

    public static void setModelViewIdentityMatrix(GL10 pGL) {
        switchToModelViewMatrix(pGL);
        pGL.glLoadIdentity();
    }

    public static void setShadeModelFlat(GL10 pGL) {
        pGL.glShadeModel(7424);
    }

    public static void setPerspectiveCorrectionHintFastest(GL10 pGL) {
        pGL.glHint(3152, 4353);
    }

    public static void bufferData(GL11 pGL11, ByteBuffer pByteBuffer, int pUsage) {
        pGL11.glBufferData(34962, pByteBuffer.capacity(), pByteBuffer, pUsage);
    }

    public static void glTexImage2D(GL10 pGL, int pTarget, int pLevel, Bitmap pBitmap, int pBorder, PixelFormat pPixelFormat) {
        GL10 gl10 = pGL;
        int i = pTarget;
        int i2 = pLevel;
        int i3 = pBorder;
        gl10.glTexImage2D(i, i2, pPixelFormat.getGLFormat(), pBitmap.getWidth(), pBitmap.getHeight(), i3, pPixelFormat.getGLFormat(), pPixelFormat.getGLType(), getPixels(pBitmap, pPixelFormat));
    }

    public static void glTexSubImage2D(GL10 pGL, int pTarget, int pLevel, int pXOffset, int pYOffset, Bitmap pBitmap, PixelFormat pPixelFormat) {
        GL10 gl10 = pGL;
        int i = pTarget;
        int i2 = pLevel;
        int i3 = pXOffset;
        int i4 = pYOffset;
        gl10.glTexSubImage2D(i, i2, i3, i4, pBitmap.getWidth(), pBitmap.getHeight(), pPixelFormat.getGLFormat(), pPixelFormat.getGLType(), getPixels(pBitmap, pPixelFormat));
    }

    private static Buffer getPixels(Bitmap pBitmap, PixelFormat pPixelFormat) {
        int[] pixelsARGB_8888 = getPixelsARGB_8888(pBitmap);
        switch (m29xc82e07aa()[pPixelFormat.ordinal()]) {
            case 2:
                return ByteBuffer.wrap(convertARGB_8888toARGB_4444(pixelsARGB_8888));
            case 4:
                return IntBuffer.wrap(convertARGB_8888toRGBA_8888(pixelsARGB_8888));
            case 5:
                return ByteBuffer.wrap(convertARGB_8888toRGB_565(pixelsARGB_8888));
            case 6:
                return ByteBuffer.wrap(convertARGB_8888toA_8(pixelsARGB_8888));
            default:
                throw new IllegalArgumentException("Unexpected " + PixelFormat.class.getSimpleName() + ": '" + pPixelFormat + "'.");
        }
    }

    private static int[] convertARGB_8888toRGBA_8888(int[] pPixelsARGB_8888) {
        int i;
        int pixel;
        if (IS_LITTLE_ENDIAN) {
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixel = pPixelsARGB_8888[i];
                pPixelsARGB_8888[i] = ((-16711936 & pixel) | ((pixel & 255) << 16)) | ((ColorUtils.COLOR_MASK_32BIT_ARGB_R & pixel) >> 16);
            }
        } else {
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixel = pPixelsARGB_8888[i];
                pPixelsARGB_8888[i] = ((16777215 & pixel) << 8) | ((-16777216 & pixel) >> 24);
            }
        }
        return pPixelsARGB_8888;
    }

    private static byte[] convertARGB_8888toRGB_565(int[] pPixelsARGB_8888) {
        byte[] pixelsRGB_565 = new byte[(pPixelsARGB_8888.length * 2)];
        int j;
        int i;
        int pixel;
        int green;
        int i2;
        if (IS_LITTLE_ENDIAN) {
            j = pixelsRGB_565.length - 1;
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixel = pPixelsARGB_8888[i];
                green = (pixel >> 8) & 255;
                int blue = pixel & 255;
                i2 = j - 1;
                pixelsRGB_565[j] = (byte) ((((pixel >> 16) & 255) & 248) | (green >> 5));
                j = i2 - 1;
                pixelsRGB_565[i2] = (byte) (((green << 3) & 224) | (blue >> 3));
            }
            i2 = j;
        } else {
            j = pixelsRGB_565.length - 1;
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixel = pPixelsARGB_8888[i];
                int red = (pixel >> 16) & 255;
                green = (pixel >> 8) & 255;
                i2 = j - 1;
                pixelsRGB_565[j] = (byte) (((green << 3) & 224) | ((pixel & 255) >> 3));
                j = i2 - 1;
                pixelsRGB_565[i2] = (byte) ((red & 248) | (green >> 5));
            }
            i2 = j;
        }
        return pixelsRGB_565;
    }

    private static byte[] convertARGB_8888toARGB_4444(int[] pPixelsARGB_8888) {
        byte[] pixelsARGB_4444 = new byte[(pPixelsARGB_8888.length * 2)];
        int j;
        int i;
        int pixel;
        int i2;
        if (IS_LITTLE_ENDIAN) {
            j = pixelsARGB_4444.length - 1;
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixel = pPixelsARGB_8888[i];
                int green = (pixel >> 8) & ColorUtils.COLOR_MASK_12BIT_RGB_G;
                int blue = pixel & 15;
                i2 = j - 1;
                pixelsARGB_4444[j] = (byte) (((pixel >> 28) & 15) | ((pixel >> 16) & ColorUtils.COLOR_MASK_12BIT_RGB_G));
                j = i2 - 1;
                pixelsARGB_4444[i2] = (byte) (green | blue);
            }
            i2 = j;
        } else {
            j = pixelsARGB_4444.length - 1;
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixel = pPixelsARGB_8888[i];
                int alpha = (pixel >> 28) & 15;
                int red = (pixel >> 16) & ColorUtils.COLOR_MASK_12BIT_RGB_G;
                i2 = j - 1;
                pixelsARGB_4444[j] = (byte) (((pixel >> 8) & ColorUtils.COLOR_MASK_12BIT_RGB_G) | (pixel & 15));
                j = i2 - 1;
                pixelsARGB_4444[i2] = (byte) (alpha | red);
            }
            i2 = j;
        }
        return pixelsARGB_4444;
    }

    private static byte[] convertARGB_8888toA_8(int[] pPixelsARGB_8888) {
        byte[] pixelsA_8 = new byte[pPixelsARGB_8888.length];
        int i;
        if (IS_LITTLE_ENDIAN) {
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixelsA_8[i] = (byte) (pPixelsARGB_8888[i] >> 24);
            }
        } else {
            for (i = pPixelsARGB_8888.length - 1; i >= 0; i--) {
                pixelsA_8[i] = (byte) (pPixelsARGB_8888[i] & 255);
            }
        }
        return pixelsA_8;
    }

    public static int[] getPixelsARGB_8888(Bitmap pBitmap) {
        int w = pBitmap.getWidth();
        int h = pBitmap.getHeight();
        int[] pixelsARGB_8888 = new int[(w * h)];
        pBitmap.getPixels(pixelsARGB_8888, 0, w, 0, 0, w, h);
        return pixelsARGB_8888;
    }

    public static void checkGLError(GL10 pGL) throws GLException {
        int err = pGL.glGetError();
        if (err != 0) {
            throw new GLException(err);
        }
    }
}
