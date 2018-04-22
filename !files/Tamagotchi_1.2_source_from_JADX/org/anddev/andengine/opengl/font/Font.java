package org.anddev.andengine.opengl.font;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLUtils;
import android.util.FloatMath;
import android.util.SparseArray;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.ITexture;

public class Font {
    protected static final int LETTER_EXTRA_WIDTH = 10;
    protected static final float LETTER_LEFT_OFFSET = 0.0f;
    protected static final int PADDING = 1;
    private final Paint mBackgroundPaint;
    protected final Canvas mCanvas = new Canvas();
    private final Size mCreateLetterTemporarySize = new Size();
    private int mCurrentTextureX = 0;
    private int mCurrentTextureY = 0;
    protected final FontMetrics mFontMetrics;
    private final Rect mGetLetterBitmapTemporaryRect = new Rect();
    private final Rect mGetLetterBoundsTemporaryRect = new Rect();
    private final Rect mGetStringWidthTemporaryRect = new Rect();
    private final ArrayList<Letter> mLettersPendingToBeDrawnToTexture = new ArrayList();
    private final int mLineGap;
    private final int mLineHeight;
    private final SparseArray<Letter> mManagedCharacterToLetterMap = new SparseArray();
    protected final Paint mPaint;
    private final float[] mTemporaryTextWidthFetchers = new float[1];
    private final ITexture mTexture;
    private final float mTextureHeight;
    private final float mTextureWidth;

    public Font(ITexture pTexture, Typeface pTypeface, float pSize, boolean pAntiAlias, int pColor) {
        this.mTexture = pTexture;
        this.mTextureWidth = (float) pTexture.getWidth();
        this.mTextureHeight = (float) pTexture.getHeight();
        this.mPaint = new Paint();
        this.mPaint.setTypeface(pTypeface);
        this.mPaint.setColor(pColor);
        this.mPaint.setTextSize(pSize);
        this.mPaint.setAntiAlias(pAntiAlias);
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setColor(0);
        this.mBackgroundPaint.setStyle(Style.FILL);
        this.mFontMetrics = this.mPaint.getFontMetrics();
        this.mLineHeight = ((int) FloatMath.ceil(Math.abs(this.mFontMetrics.ascent) + Math.abs(this.mFontMetrics.descent))) + 2;
        this.mLineGap = (int) FloatMath.ceil(this.mFontMetrics.leading);
    }

    public int getLineGap() {
        return this.mLineGap;
    }

    public int getLineHeight() {
        return this.mLineHeight;
    }

    public ITexture getTexture() {
        return this.mTexture;
    }

    public synchronized void reload() {
        ArrayList<Letter> lettersPendingToBeDrawnToTexture = this.mLettersPendingToBeDrawnToTexture;
        SparseArray<Letter> managedCharacterToLetterMap = this.mManagedCharacterToLetterMap;
        for (int i = managedCharacterToLetterMap.size() - 1; i >= 0; i--) {
            lettersPendingToBeDrawnToTexture.add((Letter) managedCharacterToLetterMap.valueAt(i));
        }
    }

    private int getLetterAdvance(char pCharacter) {
        this.mPaint.getTextWidths(String.valueOf(pCharacter), this.mTemporaryTextWidthFetchers);
        return (int) FloatMath.ceil(this.mTemporaryTextWidthFetchers[0]);
    }

    private Bitmap getLetterBitmap(char pCharacter) {
        Rect getLetterBitmapTemporaryRect = this.mGetLetterBitmapTemporaryRect;
        String characterAsString = String.valueOf(pCharacter);
        this.mPaint.getTextBounds(characterAsString, 0, 1, getLetterBitmapTemporaryRect);
        getLetterBitmapTemporaryRect.right += 2;
        Bitmap bitmap = Bitmap.createBitmap(getLetterBitmapTemporaryRect.width() == 0 ? 3 : getLetterBitmapTemporaryRect.width() + 10, getLineHeight(), Config.ARGB_8888);
        this.mCanvas.setBitmap(bitmap);
        this.mCanvas.drawRect(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), this.mBackgroundPaint);
        drawCharacterString(characterAsString);
        return bitmap;
    }

    protected void drawCharacterString(String pCharacterAsString) {
        this.mCanvas.drawText(pCharacterAsString, 1.0f, (-this.mFontMetrics.ascent) + 1.0f, this.mPaint);
    }

    public int getStringWidth(String pText) {
        this.mPaint.getTextBounds(pText, 0, pText.length(), this.mGetStringWidthTemporaryRect);
        return this.mGetStringWidthTemporaryRect.width();
    }

    private void getLetterBounds(char pCharacter, Size pSize) {
        this.mPaint.getTextBounds(String.valueOf(pCharacter), 0, 1, this.mGetLetterBoundsTemporaryRect);
        pSize.set((this.mGetLetterBoundsTemporaryRect.width() + 10) + 2, getLineHeight());
    }

    public void prepareLetters(char... pCharacters) {
        for (char character : pCharacters) {
            getLetter(character);
        }
    }

    public synchronized Letter getLetter(char pCharacter) {
        Letter letter;
        SparseArray<Letter> managedCharacterToLetterMap = this.mManagedCharacterToLetterMap;
        letter = (Letter) managedCharacterToLetterMap.get(pCharacter);
        if (letter == null) {
            letter = createLetter(pCharacter);
            this.mLettersPendingToBeDrawnToTexture.add(letter);
            managedCharacterToLetterMap.put(pCharacter, letter);
        }
        return letter;
    }

    private Letter createLetter(char pCharacter) {
        float textureWidth = this.mTextureWidth;
        float textureHeight = this.mTextureHeight;
        Size createLetterTemporarySize = this.mCreateLetterTemporarySize;
        getLetterBounds(pCharacter, createLetterTemporarySize);
        float letterWidth = createLetterTemporarySize.getWidth();
        float letterHeight = createLetterTemporarySize.getHeight();
        if (((float) this.mCurrentTextureX) + letterWidth >= textureWidth) {
            this.mCurrentTextureX = 0;
            this.mCurrentTextureY += getLineGap() + getLineHeight();
        }
        char c = pCharacter;
        Letter letter = new Letter(c, getLetterAdvance(pCharacter), (int) letterWidth, (int) letterHeight, ((float) this.mCurrentTextureX) / textureWidth, ((float) this.mCurrentTextureY) / textureHeight, letterWidth / textureWidth, letterHeight / textureHeight);
        this.mCurrentTextureX = (int) (((float) this.mCurrentTextureX) + letterWidth);
        return letter;
    }

    public synchronized void update(GL10 pGL) {
        ArrayList<Letter> lettersPendingToBeDrawnToTexture = this.mLettersPendingToBeDrawnToTexture;
        if (lettersPendingToBeDrawnToTexture.size() > 0) {
            this.mTexture.bind(pGL);
            float textureWidth = this.mTextureWidth;
            float textureHeight = this.mTextureHeight;
            for (int i = lettersPendingToBeDrawnToTexture.size() - 1; i >= 0; i--) {
                Letter letter = (Letter) lettersPendingToBeDrawnToTexture.get(i);
                Bitmap bitmap = getLetterBitmap(letter.mCharacter);
                GLUtils.texSubImage2D(3553, 0, (int) (letter.mTextureX * textureWidth), (int) (letter.mTextureY * textureHeight), bitmap);
                bitmap.recycle();
            }
            lettersPendingToBeDrawnToTexture.clear();
            System.gc();
        }
    }
}
