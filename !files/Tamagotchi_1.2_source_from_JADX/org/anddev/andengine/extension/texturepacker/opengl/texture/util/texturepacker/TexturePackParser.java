package org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.anddev.andengine.opengl.texture.ITexture;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.compressed.pvr.PVRCCZTexture;
import org.anddev.andengine.opengl.texture.compressed.pvr.PVRGZTexture;
import org.anddev.andengine.opengl.texture.compressed.pvr.PVRTexture;
import org.anddev.andengine.opengl.texture.compressed.pvr.PVRTexture.PVRTextureFormat;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TexturePackParser extends DefaultHandler {
    private static final String TAG_TEXTURE = "texture";
    private static final String TAG_TEXTUREREGION = "textureregion";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_HEIGHT = "height";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_ID = "id";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_ROTATED = "rotated";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_SOURCE = "src";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_HEIGHT = "srcheight";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_WIDTH = "srcwidth";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_X = "srcx";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_Y = "srcy";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_TRIMMED = "trimmed";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_WIDTH = "width";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_X = "x";
    private static final String TAG_TEXTUREREGION_ATTRIBUTE_Y = "y";
    private static final String TAG_TEXTURE_ATTRIBUTE_FILE = "file";
    private static final String TAG_TEXTURE_ATTRIBUTE_HEIGHT = "height";
    private static final String TAG_TEXTURE_ATTRIBUTE_MAGFILTER = "magfilter";
    private static final String TAG_TEXTURE_ATTRIBUTE_MAGFILTER_VALUE_LINEAR = "linear";
    private static final String TAG_TEXTURE_ATTRIBUTE_MAGFILTER_VALUE_NEAREST = "nearest";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER = "minfilter";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_LINEAR = "linear";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_LINEAR_MIPMAP_LINEAR = "linear_mipmap_linear";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_LINEAR_MIPMAP_NEAREST = "linear_mipmap_nearest";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_NEAREST = "nearest";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_NEAREST_MIPMAP_LINEAR = "nearest_mipmap_linear";
    private static final String TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_NEAREST_MIPMAP_NEAREST = "nearest_mipmap_nearest";
    private static final String TAG_TEXTURE_ATTRIBUTE_PIXELFORMAT = "pixelformat";
    private static final String TAG_TEXTURE_ATTRIBUTE_PREMULTIPLYALPHA = "premultiplyalpha";
    private static final String TAG_TEXTURE_ATTRIBUTE_TYPE = "type";
    private static final String TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_BITMAP = "bitmap";
    private static final String TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_PVR = "pvr";
    private static final String TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_PVRCCZ = "pvrccz";
    private static final String TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_PVRGZ = "pvrgz";
    private static final String TAG_TEXTURE_ATTRIBUTE_VERSION = "version";
    private static final String TAG_TEXTURE_ATTRIBUTE_WIDTH = "width";
    private static final String TAG_TEXTURE_ATTRIBUTE_WRAPS = "wraps";
    private static final String TAG_TEXTURE_ATTRIBUTE_WRAPT = "wrapt";
    private static final String TAG_TEXTURE_ATTRIBUTE_WRAP_VALUE_CLAMP = "clamp";
    private static final String TAG_TEXTURE_ATTRIBUTE_WRAP_VALUE_CLAMP_TO_EDGE = "clamp_to_edge";
    private static final String TAG_TEXTURE_ATTRIBUTE_WRAP_VALUE_REPEAT = "repeat";
    private final String mAssetBasePath;
    private final Context mContext;
    private ITexture mTexture;
    private TexturePack mTexturePackerResult;
    private TexturePackTextureRegionLibrary mTextureRegionLibrary;
    private int mVersion;

    public TexturePackParser(Context pContext, String pAssetBasePath) {
        this.mContext = pContext;
        this.mAssetBasePath = pAssetBasePath;
    }

    public TexturePack getTexturePackerResult() {
        return this.mTexturePackerResult;
    }

    public void startElement(String pUri, String pLocalName, String pQualifiedName, Attributes pAttributes) throws SAXException {
        if (pLocalName.equals(TAG_TEXTURE)) {
            this.mVersion = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_TEXTURE_ATTRIBUTE_VERSION);
            this.mTexture = parseTexture(pAttributes);
            this.mTextureRegionLibrary = new TexturePackTextureRegionLibrary(10);
            this.mTexturePackerResult = new TexturePack(this.mTexture, this.mTextureRegionLibrary);
            return;
        }
        if (pLocalName.equals(TAG_TEXTUREREGION)) {
            int id = SAXUtils.getIntAttributeOrThrow(pAttributes, "id");
            int x = SAXUtils.getIntAttributeOrThrow(pAttributes, "x");
            int y = SAXUtils.getIntAttributeOrThrow(pAttributes, "y");
            int width = SAXUtils.getIntAttributeOrThrow(pAttributes, "width");
            int height = SAXUtils.getIntAttributeOrThrow(pAttributes, "height");
            String source = SAXUtils.getAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_SOURCE);
            boolean trimmed = SAXUtils.getBooleanAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_TRIMMED);
            boolean rotated = SAXUtils.getBooleanAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_ROTATED);
            int sourceX = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_X);
            int sourceY = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_Y);
            int sourceWidth = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_WIDTH);
            int sourceHeight = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_TEXTUREREGION_ATTRIBUTE_SOURCE_HEIGHT);
            this.mTextureRegionLibrary.add(new TexturePackerTextureRegion(this.mTexture, x, y, width, height, id, source, rotated, trimmed, sourceX, sourceY, sourceWidth, sourceHeight));
            return;
        }
        throw new TexturePackParseException("Unexpected end tag: '" + pLocalName + "'.");
    }

    private ITexture parseTexture(Attributes pAttributes) throws TexturePackParseException {
        final String file = SAXUtils.getAttributeOrThrow(pAttributes, TAG_TEXTURE_ATTRIBUTE_FILE);
        String type = SAXUtils.getAttributeOrThrow(pAttributes, "type");
        PixelFormat pixelFormat = parsePixelFormat(pAttributes);
        TextureOptions textureOptions = parseTextureOptions(pAttributes);
        if (type.equals(TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_BITMAP)) {
            try {
                return new BitmapTexture(BitmapTextureFormat.fromPixelFormat(pixelFormat), textureOptions) {
                    protected InputStream onGetInputStream() throws IOException {
                        return TexturePackParser.this.mContext.getAssets().open(new StringBuilder(String.valueOf(TexturePackParser.this.mAssetBasePath)).append(file).toString());
                    }
                };
            } catch (Exception e) {
                throw new TexturePackParseException(e);
            }
        } else if (type.equals(TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_PVR)) {
            try {
                return new PVRTexture(PVRTextureFormat.fromPixelFormat(pixelFormat), textureOptions) {
                    protected InputStream onGetInputStream() throws IOException {
                        return TexturePackParser.this.mContext.getAssets().open(new StringBuilder(String.valueOf(TexturePackParser.this.mAssetBasePath)).append(file).toString());
                    }
                };
            } catch (Exception e2) {
                throw new TexturePackParseException(e2);
            }
        } else if (type.equals(TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_PVRGZ)) {
            try {
                return new PVRGZTexture(PVRTextureFormat.fromPixelFormat(pixelFormat), textureOptions) {
                    protected InputStream onGetInputStream() throws IOException {
                        return TexturePackParser.this.mContext.getAssets().open(new StringBuilder(String.valueOf(TexturePackParser.this.mAssetBasePath)).append(file).toString());
                    }
                };
            } catch (Exception e22) {
                throw new TexturePackParseException(e22);
            }
        } else if (type.equals(TAG_TEXTURE_ATTRIBUTE_TYPE_VALUE_PVRCCZ)) {
            try {
                return new PVRCCZTexture(PVRTextureFormat.fromPixelFormat(pixelFormat), textureOptions) {
                    protected InputStream onGetInputStream() throws IOException {
                        return TexturePackParser.this.mContext.getAssets().open(new StringBuilder(String.valueOf(TexturePackParser.this.mAssetBasePath)).append(file).toString());
                    }
                };
            } catch (Exception e222) {
                throw new TexturePackParseException(e222);
            }
        } else {
            throw new TexturePackParseException(new IllegalArgumentException("Unsupported pTextureFormat: '" + type + "'."));
        }
    }

    private PixelFormat parsePixelFormat(Attributes pAttributes) {
        return PixelFormat.valueOf(SAXUtils.getAttributeOrThrow(pAttributes, TAG_TEXTURE_ATTRIBUTE_PIXELFORMAT));
    }

    private TextureOptions parseTextureOptions(Attributes pAttributes) {
        return new TextureOptions(parseMinFilter(pAttributes), parseMagFilter(pAttributes), parseWrapT(pAttributes), parseWrapS(pAttributes), parsePremultiplyalpha(pAttributes));
    }

    private int parseMinFilter(Attributes pAttributes) {
        String minFilter = SAXUtils.getAttributeOrThrow(pAttributes, TAG_TEXTURE_ATTRIBUTE_MINFILTER);
        if (minFilter.equals("nearest")) {
            return 9728;
        }
        if (minFilter.equals("linear")) {
            return 9729;
        }
        if (minFilter.equals(TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_LINEAR_MIPMAP_LINEAR)) {
            return 9987;
        }
        if (minFilter.equals(TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_LINEAR_MIPMAP_NEAREST)) {
            return 9985;
        }
        if (minFilter.equals(TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_NEAREST_MIPMAP_LINEAR)) {
            return 9986;
        }
        if (minFilter.equals(TAG_TEXTURE_ATTRIBUTE_MINFILTER_VALUE_NEAREST_MIPMAP_NEAREST)) {
            return 9984;
        }
        throw new IllegalArgumentException("Unexpected minfilter attribute: '" + minFilter + "'.");
    }

    private int parseMagFilter(Attributes pAttributes) {
        String magFilter = SAXUtils.getAttributeOrThrow(pAttributes, TAG_TEXTURE_ATTRIBUTE_MAGFILTER);
        if (magFilter.equals("nearest")) {
            return 9728;
        }
        if (magFilter.equals("linear")) {
            return 9729;
        }
        throw new IllegalArgumentException("Unexpected magfilter attribute: '" + magFilter + "'.");
    }

    private int parseWrapT(Attributes pAttributes) {
        return parseWrap(pAttributes, TAG_TEXTURE_ATTRIBUTE_WRAPT);
    }

    private int parseWrapS(Attributes pAttributes) {
        return parseWrap(pAttributes, TAG_TEXTURE_ATTRIBUTE_WRAPS);
    }

    private int parseWrap(Attributes pAttributes, String pWrapAttributeName) {
        String wrapAttribute = SAXUtils.getAttributeOrThrow(pAttributes, pWrapAttributeName);
        if (this.mVersion == 1 || wrapAttribute.equals(TAG_TEXTURE_ATTRIBUTE_WRAP_VALUE_CLAMP) || wrapAttribute.equals(TAG_TEXTURE_ATTRIBUTE_WRAP_VALUE_CLAMP_TO_EDGE)) {
            return 33071;
        }
        if (wrapAttribute.equals("repeat")) {
            return 10497;
        }
        throw new IllegalArgumentException("Unexpected " + pWrapAttributeName + " attribute: '" + wrapAttribute + "'.");
    }

    private boolean parsePremultiplyalpha(Attributes pAttributes) {
        return SAXUtils.getBooleanAttributeOrThrow(pAttributes, TAG_TEXTURE_ATTRIBUTE_PREMULTIPLYALPHA);
    }
}
