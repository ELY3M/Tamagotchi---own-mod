package org.anddev.andengine.opengl.vertex;

import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.Letter;
import org.anddev.andengine.opengl.util.FastFloatBuffer;
import org.anddev.andengine.util.HorizontalAlign;

public class TextVertexBuffer extends VertexBuffer {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$anddev$andengine$util$HorizontalAlign = null;
    public static final int VERTICES_PER_CHARACTER = 6;
    private final HorizontalAlign mHorizontalAlign;

    static /* synthetic */ int[] $SWITCH_TABLE$org$anddev$andengine$util$HorizontalAlign() {
        int[] iArr = $SWITCH_TABLE$org$anddev$andengine$util$HorizontalAlign;
        if (iArr == null) {
            iArr = new int[HorizontalAlign.values().length];
            try {
                iArr[HorizontalAlign.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HorizontalAlign.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HorizontalAlign.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$org$anddev$andengine$util$HorizontalAlign = iArr;
        }
        return iArr;
    }

    public TextVertexBuffer(int pCharacterCount, HorizontalAlign pHorizontalAlign, int pDrawType, boolean pManaged) {
        super(pCharacterCount * 12, pDrawType, pManaged);
        this.mHorizontalAlign = pHorizontalAlign;
    }

    public synchronized void update(Font font, int pMaximumLineWidth, int[] pWidths, String[] pLines) {
        int[] bufferData = this.mBufferData;
        int i = 0;
        int lineHeight = font.getLineHeight();
        int lineCount = pLines.length;
        int lineIndex = 0;
        while (lineIndex < lineCount) {
            int lineX;
            String line = pLines[lineIndex];
            switch ($SWITCH_TABLE$org$anddev$andengine$util$HorizontalAlign()[this.mHorizontalAlign.ordinal()]) {
                case 2:
                    lineX = (pMaximumLineWidth - pWidths[lineIndex]) >> 1;
                    break;
                case 3:
                    lineX = pMaximumLineWidth - pWidths[lineIndex];
                    break;
                default:
                    lineX = 0;
                    break;
            }
            int lineY = lineIndex * (font.getLineHeight() + font.getLineGap());
            int lineYBits = Float.floatToRawIntBits((float) lineY);
            int lineLength = line.length();
            int i2 = i;
            for (int letterIndex = 0; letterIndex < lineLength; letterIndex++) {
                Letter letter = font.getLetter(line.charAt(letterIndex));
                int lineY2 = lineY + lineHeight;
                int lineX2 = lineX + letter.mWidth;
                int lineXBits = Float.floatToRawIntBits((float) lineX);
                int lineX2Bits = Float.floatToRawIntBits((float) lineX2);
                int lineY2Bits = Float.floatToRawIntBits((float) lineY2);
                i = i2 + 1;
                bufferData[i2] = lineXBits;
                i2 = i + 1;
                bufferData[i] = lineYBits;
                i = i2 + 1;
                bufferData[i2] = lineXBits;
                i2 = i + 1;
                bufferData[i] = lineY2Bits;
                i = i2 + 1;
                bufferData[i2] = lineX2Bits;
                i2 = i + 1;
                bufferData[i] = lineY2Bits;
                i = i2 + 1;
                bufferData[i2] = lineX2Bits;
                i2 = i + 1;
                bufferData[i] = lineY2Bits;
                i = i2 + 1;
                bufferData[i2] = lineX2Bits;
                i2 = i + 1;
                bufferData[i] = lineYBits;
                i = i2 + 1;
                bufferData[i2] = lineXBits;
                i2 = i + 1;
                bufferData[i] = lineYBits;
                lineX += letter.mAdvance;
            }
            lineIndex++;
            i = i2;
        }
        FastFloatBuffer vertexFloatBuffer = this.mFloatBuffer;
        vertexFloatBuffer.position(0);
        vertexFloatBuffer.put(bufferData);
        vertexFloatBuffer.position(0);
        super.setHardwareBufferNeedsUpdate();
    }
}
