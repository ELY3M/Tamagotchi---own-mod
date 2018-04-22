package org.anddev.andengine.entity.layer.tiled.tmx;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.zip.GZIPInputStream;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import org.anddev.andengine.collision.RectangularShapeCollisionChecker;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.entity.shape.RectangularShape;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.util.Base64InputStream;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.SAXUtils;
import org.anddev.andengine.util.StreamUtils;
import org.xml.sax.Attributes;

public class TMXLayer extends RectangularShape implements TMXConstants {
    private final float[] mCullingVertices = new float[8];
    private final int mGlobalTileIDsExpected;
    private final String mName;
    private final TMXProperties<TMXLayerProperty> mTMXLayerProperties = new TMXProperties();
    private final TMXTiledMap mTMXTiledMap;
    private final TMXTile[][] mTMXTiles;
    private final int mTileColumns;
    private final int mTileRows;
    private int mTilesAdded;

    public TMXLayer(TMXTiledMap pTMXTiledMap, Attributes pAttributes) {
        super(0.0f, 0.0f, 0.0f, 0.0f, null);
        this.mTMXTiledMap = pTMXTiledMap;
        this.mName = pAttributes.getValue("", "name");
        this.mTileColumns = SAXUtils.getIntAttributeOrThrow(pAttributes, "width");
        this.mTileRows = SAXUtils.getIntAttributeOrThrow(pAttributes, "height");
        this.mTMXTiles = (TMXTile[][]) Array.newInstance(TMXTile.class, new int[]{this.mTileRows, this.mTileColumns});
        this.mWidth = (float) (pTMXTiledMap.getTileWidth() * this.mTileColumns);
        float width = this.mWidth;
        this.mBaseWidth = width;
        this.mHeight = (float) (pTMXTiledMap.getTileHeight() * this.mTileRows);
        float height = this.mHeight;
        this.mBaseHeight = height;
        this.mRotationCenterX = width * 0.5f;
        this.mRotationCenterY = height * 0.5f;
        this.mScaleCenterX = this.mRotationCenterX;
        this.mScaleCenterY = this.mRotationCenterY;
        this.mGlobalTileIDsExpected = this.mTileColumns * this.mTileRows;
        setVisible(SAXUtils.getIntAttribute(pAttributes, TMXConstants.TAG_LAYER_ATTRIBUTE_VISIBLE, 1) == 1);
        setAlpha(SAXUtils.getFloatAttribute(pAttributes, "opacity", 1.0f));
    }

    public String getName() {
        return this.mName;
    }

    public int getTileColumns() {
        return this.mTileColumns;
    }

    public int getTileRows() {
        return this.mTileRows;
    }

    public TMXTile[][] getTMXTiles() {
        return this.mTMXTiles;
    }

    public TMXTile getTMXTile(int pTileColumn, int pTileRow) throws ArrayIndexOutOfBoundsException {
        return this.mTMXTiles[pTileRow][pTileColumn];
    }

    public TMXTile getTMXTileAt(float pX, float pY) {
        float[] localCoords = convertSceneToLocalCoordinates(pX, pY);
        TMXTiledMap tmxTiledMap = this.mTMXTiledMap;
        int tileColumn = (int) (localCoords[0] / ((float) tmxTiledMap.getTileWidth()));
        if (tileColumn < 0 || tileColumn > this.mTileColumns - 1) {
            return null;
        }
        int tileRow = (int) (localCoords[1] / ((float) tmxTiledMap.getTileWidth()));
        if (tileRow < 0 || tileRow > this.mTileRows - 1) {
            return null;
        }
        return this.mTMXTiles[tileRow][tileColumn];
    }

    public void addTMXLayerProperty(TMXLayerProperty pTMXLayerProperty) {
        this.mTMXLayerProperties.add(pTMXLayerProperty);
    }

    public TMXProperties<TMXLayerProperty> getTMXLayerProperties() {
        return this.mTMXLayerProperties;
    }

    @Deprecated
    public void setRotation(float pRotation) {
    }

    protected void onUpdateVertexBuffer() {
    }

    protected void onInitDraw(GL10 pGL) {
        super.onInitDraw(pGL);
        GLHelper.enableTextures(pGL);
        GLHelper.enableTexCoordArray(pGL);
    }

    protected void onApplyVertices(GL10 pGL) {
        if (GLHelper.EXTENSIONS_VERTEXBUFFEROBJECTS) {
            GL11 gl11 = (GL11) pGL;
            this.mTMXTiledMap.getSharedVertexBuffer().selectOnHardware(gl11);
            GLHelper.vertexZeroPointer(gl11);
            return;
        }
        GLHelper.vertexPointer(pGL, this.mTMXTiledMap.getSharedVertexBuffer().getFloatBuffer());
    }

    protected void drawVertices(GL10 pGL, Camera pCamera) {
        TMXTile[][] tmxTiles = this.mTMXTiles;
        int tileColumns = this.mTileColumns;
        int tileRows = this.mTileRows;
        int tileWidth = this.mTMXTiledMap.getTileWidth();
        int tileHeight = this.mTMXTiledMap.getTileHeight();
        float scaledTileWidth = ((float) tileWidth) * this.mScaleX;
        float scaledTileHeight = ((float) tileHeight) * this.mScaleY;
        float[] cullingVertices = this.mCullingVertices;
        RectangularShapeCollisionChecker.fillVertices((RectangularShape) this, cullingVertices);
        float layerMinX = cullingVertices[0];
        float layerMinY = cullingVertices[1];
        float cameraMinX = pCamera.getMinX();
        float cameraMinY = pCamera.getMinY();
        float cameraWidth = pCamera.getWidth();
        float cameraHeight = pCamera.getHeight();
        float firstColumnRaw = (cameraMinX - layerMinX) / scaledTileWidth;
        int firstColumn = MathUtils.bringToBounds(0, tileColumns - 1, (int) Math.floor((double) firstColumnRaw));
        int lastColumn = MathUtils.bringToBounds(0, tileColumns - 1, (int) Math.ceil((double) ((cameraWidth / scaledTileWidth) + firstColumnRaw)));
        float firstRowRaw = (cameraMinY - layerMinY) / scaledTileHeight;
        int firstRow = MathUtils.bringToBounds(0, tileRows - 1, (int) Math.floor((double) firstRowRaw));
        int lastRow = MathUtils.bringToBounds(0, tileRows - 1, (int) Math.floor((double) ((cameraHeight / scaledTileHeight) + firstRowRaw)));
        int visibleTilesTotalWidth = ((lastColumn - firstColumn) + 1) * tileWidth;
        pGL.glTranslatef((float) (firstColumn * tileWidth), (float) (firstRow * tileHeight), 0.0f);
        for (int row = firstRow; row <= lastRow; row++) {
            TMXTile[] tmxTileRow = tmxTiles[row];
            for (int column = firstColumn; column <= lastColumn; column++) {
                TextureRegion textureRegion = tmxTileRow[column].mTextureRegion;
                if (textureRegion != null) {
                    textureRegion.onApply(pGL);
                    pGL.glDrawArrays(5, 0, 4);
                }
                pGL.glTranslatef((float) tileWidth, 0.0f, 0.0f);
            }
            pGL.glTranslatef((float) (-visibleTilesTotalWidth), (float) tileHeight, 0.0f);
        }
        pGL.glLoadIdentity();
    }

    protected void onManagedUpdate(float pSecondsElapsed) {
    }

    void initializeTMXTileFromXML(Attributes pAttributes, ITMXTilePropertiesListener pTMXTilePropertyListener) {
        addTileByGlobalTileID(SAXUtils.getIntAttributeOrThrow(pAttributes, TMXConstants.TAG_TILE_ATTRIBUTE_GID), pTMXTilePropertyListener);
    }

    void initializeTMXTilesFromDataString(String pDataString, String pDataEncoding, String pDataCompression, ITMXTilePropertiesListener pTMXTilePropertyListener) throws IOException, IllegalArgumentException {
        Throwable th;
        DataInputStream dataIn = null;
        try {
            InputStream in;
            InputStream in2 = new ByteArrayInputStream(pDataString.getBytes("UTF-8"));
            if (pDataEncoding == null || !pDataEncoding.equals(TMXConstants.TAG_DATA_ATTRIBUTE_ENCODING_VALUE_BASE64)) {
                in = in2;
            } else {
                in = new Base64InputStream(in2, 0);
            }
            if (pDataCompression == null) {
                in2 = in;
            } else if (pDataCompression.equals(TMXConstants.TAG_DATA_ATTRIBUTE_COMPRESSION_VALUE_GZIP)) {
                in2 = new GZIPInputStream(in);
            } else {
                throw new IllegalArgumentException("Supplied compression '" + pDataCompression + "' is not supported yet.");
            }
            DataInputStream dataIn2 = new DataInputStream(in2);
            while (this.mTilesAdded < this.mGlobalTileIDsExpected) {
                try {
                    addTileByGlobalTileID(readGlobalTileID(dataIn2), pTMXTilePropertyListener);
                } catch (Throwable th2) {
                    th = th2;
                    dataIn = dataIn2;
                }
            }
            StreamUtils.close(dataIn2);
        } catch (Throwable th3) {
            th = th3;
            StreamUtils.close(dataIn);
            throw th;
        }
    }

    private void addTileByGlobalTileID(int pGlobalTileID, ITMXTilePropertiesListener pTMXTilePropertyListener) {
        TextureRegion tmxTileTextureRegion;
        TMXTiledMap tmxTiledMap = this.mTMXTiledMap;
        int tilesHorizontal = this.mTileColumns;
        int column = this.mTilesAdded % tilesHorizontal;
        int row = this.mTilesAdded / tilesHorizontal;
        TMXTile[][] tmxTiles = this.mTMXTiles;
        if (pGlobalTileID == 0) {
            tmxTileTextureRegion = null;
        } else {
            tmxTileTextureRegion = tmxTiledMap.getTextureRegionFromGlobalTileID(pGlobalTileID);
        }
        TMXTile tmxTile = new TMXTile(pGlobalTileID, column, row, this.mTMXTiledMap.getTileWidth(), this.mTMXTiledMap.getTileHeight(), tmxTileTextureRegion);
        tmxTiles[row][column] = tmxTile;
        if (!(pGlobalTileID == 0 || pTMXTilePropertyListener == null)) {
            TMXProperties<TMXTileProperty> tmxTileProperties = tmxTiledMap.getTMXTileProperties(pGlobalTileID);
            if (tmxTileProperties != null) {
                pTMXTilePropertyListener.onTMXTileWithPropertiesCreated(tmxTiledMap, this, tmxTile, tmxTileProperties);
            }
        }
        this.mTilesAdded++;
    }

    private int readGlobalTileID(DataInputStream pDataIn) throws IOException {
        int lowestByte = pDataIn.read();
        int secondLowestByte = pDataIn.read();
        int secondHighestByte = pDataIn.read();
        int highestByte = pDataIn.read();
        if (lowestByte >= 0 && secondLowestByte >= 0 && secondHighestByte >= 0 && highestByte >= 0) {
            return (((secondLowestByte << 8) | lowestByte) | (secondHighestByte << 16)) | (highestByte << 24);
        }
        throw new IllegalArgumentException("Couldn't read global Tile ID.");
    }
}
