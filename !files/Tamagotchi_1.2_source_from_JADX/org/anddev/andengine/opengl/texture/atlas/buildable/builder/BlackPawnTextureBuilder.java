package org.anddev.andengine.opengl.texture.atlas.buildable.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlas.TextureAtlasSourceWithWithLocationCallback;
import org.anddev.andengine.opengl.texture.atlas.buildable.builder.ITextureBuilder.TextureAtlasSourcePackingException;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;

public class BlackPawnTextureBuilder<T extends ITextureAtlasSource, A extends ITextureAtlas<T>> implements ITextureBuilder<T, A> {
    private static final Comparator<TextureAtlasSourceWithWithLocationCallback<?>> TEXTURESOURCE_COMPARATOR = new C05951();
    private final int mTextureAtlasSourceSpacing;

    class C05951 implements Comparator<TextureAtlasSourceWithWithLocationCallback<?>> {
        C05951() {
        }

        public int compare(TextureAtlasSourceWithWithLocationCallback<?> pTextureAtlasSourceWithWithLocationCallbackA, TextureAtlasSourceWithWithLocationCallback<?> pTextureAtlasSourceWithWithLocationCallbackB) {
            int deltaWidth = pTextureAtlasSourceWithWithLocationCallbackB.getTextureAtlasSource().getWidth() - pTextureAtlasSourceWithWithLocationCallbackA.getTextureAtlasSource().getWidth();
            return deltaWidth != 0 ? deltaWidth : pTextureAtlasSourceWithWithLocationCallbackB.getTextureAtlasSource().getHeight() - pTextureAtlasSourceWithWithLocationCallbackA.getTextureAtlasSource().getHeight();
        }
    }

    protected static class Node {
        private Node mChildA;
        private Node mChildB;
        private final Rect mRect;
        private ITextureAtlasSource mTextureAtlasSource;

        public Node(int pLeft, int pTop, int pWidth, int pHeight) {
            this(new Rect(pLeft, pTop, pWidth, pHeight));
        }

        public Node(Rect pRect) {
            this.mRect = pRect;
        }

        public Rect getRect() {
            return this.mRect;
        }

        public Node getChildA() {
            return this.mChildA;
        }

        public Node getChildB() {
            return this.mChildB;
        }

        public Node insert(ITextureAtlasSource pTextureAtlasSource, int pTextureWidth, int pTextureHeight, int pTextureSpacing) throws IllegalArgumentException {
            if (this.mChildA != null && this.mChildB != null) {
                Node newNode = this.mChildA.insert(pTextureAtlasSource, pTextureWidth, pTextureHeight, pTextureSpacing);
                if (newNode != null) {
                    return newNode;
                }
                return this.mChildB.insert(pTextureAtlasSource, pTextureWidth, pTextureHeight, pTextureSpacing);
            } else if (this.mTextureAtlasSource != null) {
                return null;
            } else {
                int textureSourceWidth = pTextureAtlasSource.getWidth();
                int textureSourceHeight = pTextureAtlasSource.getHeight();
                int rectWidth = this.mRect.getWidth();
                int rectHeight = this.mRect.getHeight();
                if (textureSourceWidth > rectWidth || textureSourceHeight > rectHeight) {
                    return null;
                }
                int textureSourceWidthWithSpacing = textureSourceWidth + pTextureSpacing;
                int textureSourceHeightWithSpacing = textureSourceHeight + pTextureSpacing;
                int rectLeft = this.mRect.getLeft();
                boolean fitToBottomWithoutSpacing = textureSourceHeight == rectHeight && this.mRect.getTop() + textureSourceHeight == pTextureHeight;
                boolean fitToRightWithoutSpacing = textureSourceWidth == rectWidth && rectLeft + textureSourceWidth == pTextureWidth;
                if (textureSourceWidthWithSpacing == rectWidth) {
                    if (textureSourceHeightWithSpacing == rectHeight) {
                        this.mTextureAtlasSource = pTextureAtlasSource;
                        return this;
                    } else if (fitToBottomWithoutSpacing) {
                        this.mTextureAtlasSource = pTextureAtlasSource;
                        return this;
                    }
                }
                if (fitToRightWithoutSpacing) {
                    if (textureSourceHeightWithSpacing == rectHeight) {
                        this.mTextureAtlasSource = pTextureAtlasSource;
                        return this;
                    } else if (fitToBottomWithoutSpacing) {
                        this.mTextureAtlasSource = pTextureAtlasSource;
                        return this;
                    } else if (textureSourceHeightWithSpacing > rectHeight) {
                        return null;
                    } else {
                        return createChildren(pTextureAtlasSource, pTextureWidth, pTextureHeight, pTextureSpacing, rectWidth - textureSourceWidth, rectHeight - textureSourceHeightWithSpacing);
                    }
                } else if (fitToBottomWithoutSpacing) {
                    if (textureSourceWidthWithSpacing == rectWidth) {
                        this.mTextureAtlasSource = pTextureAtlasSource;
                        return this;
                    } else if (textureSourceWidthWithSpacing > rectWidth) {
                        return null;
                    } else {
                        return createChildren(pTextureAtlasSource, pTextureWidth, pTextureHeight, pTextureSpacing, rectWidth - textureSourceWidthWithSpacing, rectHeight - textureSourceHeight);
                    }
                } else if (textureSourceWidthWithSpacing > rectWidth || textureSourceHeightWithSpacing > rectHeight) {
                    return null;
                } else {
                    return createChildren(pTextureAtlasSource, pTextureWidth, pTextureHeight, pTextureSpacing, rectWidth - textureSourceWidthWithSpacing, rectHeight - textureSourceHeightWithSpacing);
                }
            }
        }

        private Node createChildren(ITextureAtlasSource pTextureAtlasSource, int pTextureWidth, int pTextureHeight, int pTextureSpacing, int pDeltaWidth, int pDeltaHeight) {
            Rect rect = this.mRect;
            if (pDeltaWidth >= pDeltaHeight) {
                this.mChildA = new Node(rect.getLeft(), rect.getTop(), pTextureAtlasSource.getWidth() + pTextureSpacing, rect.getHeight());
                this.mChildB = new Node(rect.getLeft() + (pTextureAtlasSource.getWidth() + pTextureSpacing), rect.getTop(), rect.getWidth() - (pTextureAtlasSource.getWidth() + pTextureSpacing), rect.getHeight());
            } else {
                this.mChildA = new Node(rect.getLeft(), rect.getTop(), rect.getWidth(), pTextureAtlasSource.getHeight() + pTextureSpacing);
                this.mChildB = new Node(rect.getLeft(), rect.getTop() + (pTextureAtlasSource.getHeight() + pTextureSpacing), rect.getWidth(), rect.getHeight() - (pTextureAtlasSource.getHeight() + pTextureSpacing));
            }
            return this.mChildA.insert(pTextureAtlasSource, pTextureWidth, pTextureHeight, pTextureSpacing);
        }
    }

    protected static class Rect {
        private final int mHeight;
        private final int mLeft;
        private final int mTop;
        private final int mWidth;

        public Rect(int pLeft, int pTop, int pWidth, int pHeight) {
            this.mLeft = pLeft;
            this.mTop = pTop;
            this.mWidth = pWidth;
            this.mHeight = pHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getLeft() {
            return this.mLeft;
        }

        public int getTop() {
            return this.mTop;
        }

        public int getRight() {
            return this.mLeft + this.mWidth;
        }

        public int getBottom() {
            return this.mTop + this.mHeight;
        }

        public String toString() {
            return "@: " + this.mLeft + "/" + this.mTop + " * " + this.mWidth + "x" + this.mHeight;
        }
    }

    public BlackPawnTextureBuilder(int pTextureAtlasSourceSpacing) {
        this.mTextureAtlasSourceSpacing = pTextureAtlasSourceSpacing;
    }

    public void pack(A pTextureAtlas, ArrayList<TextureAtlasSourceWithWithLocationCallback<T>> pTextureAtlasSourcesWithLocationCallback) throws TextureAtlasSourcePackingException {
        Collections.sort(pTextureAtlasSourcesWithLocationCallback, TEXTURESOURCE_COMPARATOR);
        Node root = new Node(new Rect(0, 0, pTextureAtlas.getWidth(), pTextureAtlas.getHeight()));
        int textureSourceCount = pTextureAtlasSourcesWithLocationCallback.size();
        for (int i = 0; i < textureSourceCount; i++) {
            TextureAtlasSourceWithWithLocationCallback<T> textureSourceWithLocationCallback = (TextureAtlasSourceWithWithLocationCallback) pTextureAtlasSourcesWithLocationCallback.get(i);
            T textureSource = textureSourceWithLocationCallback.getTextureAtlasSource();
            Node inserted = root.insert(textureSource, pTextureAtlas.getWidth(), pTextureAtlas.getHeight(), this.mTextureAtlasSourceSpacing);
            if (inserted == null) {
                throw new TextureAtlasSourcePackingException("Could not pack: " + textureSource.toString());
            }
            pTextureAtlas.addTextureAtlasSource(textureSource, inserted.mRect.mLeft, inserted.mRect.mTop);
            textureSourceWithLocationCallback.getCallback().onCallback(textureSource);
        }
    }
}
