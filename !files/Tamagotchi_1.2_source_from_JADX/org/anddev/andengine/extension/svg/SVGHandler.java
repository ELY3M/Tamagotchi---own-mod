package org.anddev.andengine.extension.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import java.util.Stack;
import org.anddev.andengine.extension.svg.adt.ISVGColorMapper;
import org.anddev.andengine.extension.svg.adt.SVGGradient;
import org.anddev.andengine.extension.svg.adt.SVGGroup;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.adt.filter.SVGFilter;
import org.anddev.andengine.extension.svg.util.SAXHelper;
import org.anddev.andengine.extension.svg.util.SVGCircleParser;
import org.anddev.andengine.extension.svg.util.SVGEllipseParser;
import org.anddev.andengine.extension.svg.util.SVGLineParser;
import org.anddev.andengine.extension.svg.util.SVGPathParser;
import org.anddev.andengine.extension.svg.util.SVGPolygonParser;
import org.anddev.andengine.extension.svg.util.SVGPolylineParser;
import org.anddev.andengine.extension.svg.util.SVGRectParser;
import org.anddev.andengine.extension.svg.util.SVGTransformParser;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.anddev.andengine.util.Debug;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SVGHandler extends DefaultHandler implements ISVGConstants {
    private RectF mBounds;
    private boolean mBoundsMode;
    private Canvas mCanvas;
    private SVGFilter mCurrentSVGFilter;
    private SVGGradient mCurrentSVGGradient;
    private boolean mHidden;
    private final Picture mPicture;
    private final RectF mRect = new RectF();
    private final Stack<SVGGroup> mSVGGroupStack = new Stack();
    private final SVGPaint mSVGPaint;
    private final SVGPathParser mSVGPathParser = new SVGPathParser();

    public SVGHandler(Picture pPicture, ISVGColorMapper pSVGColorMapper) {
        this.mPicture = pPicture;
        this.mSVGPaint = new SVGPaint(pSVGColorMapper);
    }

    public RectF getBounds() {
        return this.mBounds;
    }

    public RectF getComputedBounds() {
        return this.mSVGPaint.getComputedBounds();
    }

    public void startElement(String pNamespace, String pLocalName, String pQualifiedName, Attributes pAttributes) throws SAXException {
        if (this.mBoundsMode) {
            parseBounds(pLocalName, pAttributes);
        } else if (pLocalName.equals(ISVGConstants.TAG_SVG)) {
            parseSVG(pAttributes);
        } else if (!pLocalName.equals(ISVGConstants.TAG_DEFS)) {
            if (pLocalName.equals(ISVGConstants.TAG_GROUP)) {
                parseGroup(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_LINEARGRADIENT)) {
                parseLinearGradient(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_RADIALGRADIENT)) {
                parseRadialGradient(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_STOP)) {
                parseGradientStop(pAttributes);
            } else if (pLocalName.equals("filter")) {
                parseFilter(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_FILTER_ELEMENT_FEGAUSSIANBLUR)) {
                parseFilterElementGaussianBlur(pAttributes);
            } else if (this.mHidden) {
                Debug.m59d("Unexpected SVG tag: '" + pLocalName + "'.");
            } else if (pLocalName.equals(ISVGConstants.TAG_RECTANGLE)) {
                parseRect(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_LINE)) {
                parseLine(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_CIRCLE)) {
                parseCircle(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_ELLIPSE)) {
                parseEllipse(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_POLYLINE)) {
                parsePolyline(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_POLYGON)) {
                parsePolygon(pAttributes);
            } else if (pLocalName.equals(ISVGConstants.TAG_PATH)) {
                parsePath(pAttributes);
            } else {
                Debug.m59d("Unexpected SVG tag: '" + pLocalName + "'.");
            }
        }
    }

    public void endElement(String pNamespace, String pLocalName, String pQualifiedName) throws SAXException {
        if (pLocalName.equals(ISVGConstants.TAG_SVG)) {
            this.mPicture.endRecording();
        } else if (pLocalName.equals(ISVGConstants.TAG_GROUP)) {
            parseGroupEnd();
        }
    }

    private void parseSVG(Attributes pAttributes) {
        this.mCanvas = this.mPicture.beginRecording((int) Math.ceil((double) SAXHelper.getFloatAttribute(pAttributes, "width", 0.0f)), (int) Math.ceil((double) SAXHelper.getFloatAttribute(pAttributes, "height", 0.0f)));
    }

    private void parseBounds(String pLocalName, Attributes pAttributes) {
        if (pLocalName.equals(ISVGConstants.TAG_RECTANGLE)) {
            float x = SAXHelper.getFloatAttribute(pAttributes, "x", 0.0f);
            float y = SAXHelper.getFloatAttribute(pAttributes, "y", 0.0f);
            this.mBounds = new RectF(x, y, x + SAXHelper.getFloatAttribute(pAttributes, "width", 0.0f), y + SAXHelper.getFloatAttribute(pAttributes, "height", 0.0f));
        }
    }

    private void parseFilter(Attributes pAttributes) {
        this.mCurrentSVGFilter = this.mSVGPaint.parseFilter(pAttributes);
    }

    private void parseFilterElementGaussianBlur(Attributes pAttributes) {
        this.mCurrentSVGFilter.addFilterElement(this.mSVGPaint.parseFilterElementGaussianBlur(pAttributes));
    }

    private void parseLinearGradient(Attributes pAttributes) {
        this.mCurrentSVGGradient = this.mSVGPaint.parseGradient(pAttributes, true);
    }

    private void parseRadialGradient(Attributes pAttributes) {
        this.mCurrentSVGGradient = this.mSVGPaint.parseGradient(pAttributes, false);
    }

    private void parseGradientStop(Attributes pAttributes) {
        this.mCurrentSVGGradient.addSVGGradientStop(this.mSVGPaint.parseGradientStop(getSVGPropertiesFromAttributes(pAttributes)));
    }

    private void parseGroup(Attributes pAttributes) {
        if ("bounds".equals(SAXHelper.getStringAttribute(pAttributes, "id"))) {
            this.mBoundsMode = true;
        }
        this.mSVGGroupStack.push(new SVGGroup(this.mSVGGroupStack.size() > 0 ? (SVGGroup) this.mSVGGroupStack.peek() : null, getSVGPropertiesFromAttributes(pAttributes, true), pushTransform(pAttributes)));
        updateHidden();
    }

    private void parseGroupEnd() {
        if (this.mBoundsMode) {
            this.mBoundsMode = false;
        }
        if (((SVGGroup) this.mSVGGroupStack.pop()).hasTransform()) {
            popTransform();
        }
        updateHidden();
    }

    private void updateHidden() {
        if (this.mSVGGroupStack.size() == 0) {
            this.mHidden = false;
        } else {
            ((SVGGroup) this.mSVGGroupStack.peek()).isHidden();
        }
    }

    private void parsePath(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        this.mSVGPathParser.parse(svgProperties, this.mCanvas, this.mSVGPaint);
        if (pushed) {
            popTransform();
        }
    }

    private void parsePolygon(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        SVGPolygonParser.parse(svgProperties, this.mCanvas, this.mSVGPaint);
        if (pushed) {
            popTransform();
        }
    }

    private void parsePolyline(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        SVGPolylineParser.parse(svgProperties, this.mCanvas, this.mSVGPaint);
        if (pushed) {
            popTransform();
        }
    }

    private void parseEllipse(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        SVGEllipseParser.parse(svgProperties, this.mCanvas, this.mSVGPaint, this.mRect);
        if (pushed) {
            popTransform();
        }
    }

    private void parseCircle(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        SVGCircleParser.parse(svgProperties, this.mCanvas, this.mSVGPaint);
        if (pushed) {
            popTransform();
        }
    }

    private void parseLine(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        SVGLineParser.parse(svgProperties, this.mCanvas, this.mSVGPaint);
        if (pushed) {
            popTransform();
        }
    }

    private void parseRect(Attributes pAttributes) {
        SVGProperties svgProperties = getSVGPropertiesFromAttributes(pAttributes);
        boolean pushed = pushTransform(pAttributes);
        SVGRectParser.parse(svgProperties, this.mCanvas, this.mSVGPaint, this.mRect);
        if (pushed) {
            popTransform();
        }
    }

    private SVGProperties getSVGPropertiesFromAttributes(Attributes pAttributes) {
        return getSVGPropertiesFromAttributes(pAttributes, false);
    }

    private SVGProperties getSVGPropertiesFromAttributes(Attributes pAttributes, boolean pDeepCopy) {
        if (this.mSVGGroupStack.size() > 0) {
            return new SVGProperties(((SVGGroup) this.mSVGGroupStack.peek()).getSVGProperties(), pAttributes, pDeepCopy);
        }
        return new SVGProperties(null, pAttributes, pDeepCopy);
    }

    private boolean pushTransform(Attributes pAttributes) {
        String transform = SAXHelper.getStringAttribute(pAttributes, ISVGConstants.ATTRIBUTE_TRANSFORM);
        if (transform == null) {
            return false;
        }
        Matrix matrix = SVGTransformParser.parseTransform(transform);
        this.mCanvas.save();
        this.mCanvas.concat(matrix);
        return true;
    }

    private void popTransform() {
        this.mCanvas.restore();
    }
}
