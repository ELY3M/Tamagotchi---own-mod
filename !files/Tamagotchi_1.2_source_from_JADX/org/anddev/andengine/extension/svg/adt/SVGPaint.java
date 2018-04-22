package org.anddev.andengine.extension.svg.adt;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import java.util.HashMap;
import org.anddev.andengine.extension.svg.adt.SVGGradient.SVGGradientStop;
import org.anddev.andengine.extension.svg.adt.filter.SVGFilter;
import org.anddev.andengine.extension.svg.adt.filter.element.SVGFilterElementGaussianBlur;
import org.anddev.andengine.extension.svg.exception.SVGParseException;
import org.anddev.andengine.extension.svg.util.SAXHelper;
import org.anddev.andengine.extension.svg.util.SVGParserUtils;
import org.anddev.andengine.extension.svg.util.constants.ColorUtils;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.anddev.andengine.util.constants.ColorConstants;
import org.xml.sax.Attributes;

public class SVGPaint implements ISVGConstants {
    private final RectF mComputedBounds = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    private final Paint mPaint = new Paint();
    private final RectF mRect = new RectF();
    private final ISVGColorMapper mSVGColorMapper;
    private final HashMap<String, SVGFilter> mSVGFilterMap = new HashMap();
    private final HashMap<String, SVGGradient> mSVGGradientMap = new HashMap();

    public SVGPaint(ISVGColorMapper pSVGColorMapper) {
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public RectF getComputedBounds() {
        return this.mComputedBounds;
    }

    public void resetPaint(Style pStyle) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(pStyle);
    }

    public boolean setFill(SVGProperties pSVGProperties) {
        if (isDisplayNone(pSVGProperties) || isFillNone(pSVGProperties)) {
            return false;
        }
        resetPaint(Style.FILL);
        if (pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_FILL) != null) {
            return applyPaintProperties(pSVGProperties, true);
        }
        if (pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_STROKE) != null) {
            return false;
        }
        this.mPaint.setColor(-16777216);
        return true;
    }

    public boolean setStroke(SVGProperties pSVGProperties) {
        if (isDisplayNone(pSVGProperties) || isStrokeNone(pSVGProperties)) {
            return false;
        }
        resetPaint(Style.STROKE);
        return applyPaintProperties(pSVGProperties, false);
    }

    private boolean isDisplayNone(SVGProperties pSVGProperties) {
        return ISVGConstants.VALUE_NONE.equals(pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_DISPLAY));
    }

    private boolean isFillNone(SVGProperties pSVGProperties) {
        return ISVGConstants.VALUE_NONE.equals(pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_FILL));
    }

    private boolean isStrokeNone(SVGProperties pSVGProperties) {
        return ISVGConstants.VALUE_NONE.equals(pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_STROKE));
    }

    public boolean applyPaintProperties(SVGProperties pSVGProperties, boolean pModeFill) {
        if (!setColorProperties(pSVGProperties, pModeFill)) {
            return false;
        }
        if (pModeFill) {
            return applyFillProperties(pSVGProperties);
        }
        return applyStrokeProperties(pSVGProperties);
    }

    private boolean setColorProperties(SVGProperties pSVGProperties, boolean pModeFill) {
        String colorProperty = pSVGProperties.getStringProperty(pModeFill ? ISVGConstants.ATTRIBUTE_FILL : ISVGConstants.ATTRIBUTE_STROKE);
        if (colorProperty == null) {
            return false;
        }
        String filterProperty = pSVGProperties.getStringProperty("filter");
        if (filterProperty != null) {
            if (!SVGProperties.isURLProperty(filterProperty)) {
                return false;
            }
            getFilter(SVGParserUtils.extractIDFromURLProperty(filterProperty)).applyFilterElements(this.mPaint);
        }
        if (SVGProperties.isURLProperty(colorProperty)) {
            this.mPaint.setShader(getGradientShader(SVGParserUtils.extractIDFromURLProperty(colorProperty)));
            return true;
        }
        Integer color = parseColor(colorProperty);
        if (color == null) {
            return false;
        }
        applyColor(pSVGProperties, color, pModeFill);
        return true;
    }

    private boolean applyFillProperties(SVGProperties pSVGProperties) {
        return true;
    }

    private boolean applyStrokeProperties(SVGProperties pSVGProperties) {
        Float width = pSVGProperties.getFloatProperty(ISVGConstants.ATTRIBUTE_STROKE_WIDTH);
        if (width != null) {
            this.mPaint.setStrokeWidth(width.floatValue());
        }
        String linecap = pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_STROKE_LINECAP);
        if ("round".equals(linecap)) {
            this.mPaint.setStrokeCap(Cap.ROUND);
        } else if (ISVGConstants.ATTRIBUTE_STROKE_LINECAP_VALUE_SQUARE.equals(linecap)) {
            this.mPaint.setStrokeCap(Cap.SQUARE);
        } else if (ISVGConstants.ATTRIBUTE_STROKE_LINECAP_VALUE_BUTT.equals(linecap)) {
            this.mPaint.setStrokeCap(Cap.BUTT);
        }
        String linejoin = pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_STROKE_LINEJOIN_VALUE_);
        if (ISVGConstants.ATTRIBUTE_STROKE_LINEJOIN_VALUE_MITER.equals(linejoin)) {
            this.mPaint.setStrokeJoin(Join.MITER);
        } else if ("round".equals(linejoin)) {
            this.mPaint.setStrokeJoin(Join.ROUND);
        } else if (ISVGConstants.ATTRIBUTE_STROKE_LINEJOIN_VALUE_BEVEL.equals(linejoin)) {
            this.mPaint.setStrokeJoin(Join.BEVEL);
        }
        return true;
    }

    private void applyColor(SVGProperties pSVGProperties, Integer pColor, boolean pModeFill) {
        this.mPaint.setColor((16777215 & pColor.intValue()) | -16777216);
        this.mPaint.setAlpha(parseAlpha(pSVGProperties, pModeFill));
    }

    private static int parseAlpha(SVGProperties pSVGProperties, boolean pModeFill) {
        Float opacity = pSVGProperties.getFloatProperty("opacity");
        if (opacity == null) {
            opacity = pSVGProperties.getFloatProperty(pModeFill ? ISVGConstants.ATTRIBUTE_FILL_OPACITY : ISVGConstants.ATTRIBUTE_STROKE_OPACITY);
        }
        if (opacity == null) {
            return 255;
        }
        return (int) (ColorConstants.COLOR_FACTOR_INT_TO_FLOAT * opacity.floatValue());
    }

    public void ensureComputedBoundsInclude(float pX, float pY) {
        if (pX < this.mComputedBounds.left) {
            this.mComputedBounds.left = pX;
        }
        if (pX > this.mComputedBounds.right) {
            this.mComputedBounds.right = pX;
        }
        if (pY < this.mComputedBounds.top) {
            this.mComputedBounds.top = pY;
        }
        if (pY > this.mComputedBounds.bottom) {
            this.mComputedBounds.bottom = pY;
        }
    }

    public void ensureComputedBoundsInclude(float pX, float pY, float pWidth, float pHeight) {
        ensureComputedBoundsInclude(pX, pY);
        ensureComputedBoundsInclude(pX + pWidth, pY + pHeight);
    }

    public void ensureComputedBoundsInclude(Path pPath) {
        pPath.computeBounds(this.mRect, false);
        ensureComputedBoundsInclude(this.mRect.left, this.mRect.top);
        ensureComputedBoundsInclude(this.mRect.right, this.mRect.bottom);
    }

    private Integer parseColor(String pString, Integer pDefault) {
        Integer color = parseColor(pString);
        if (color == null) {
            return applySVGColorMapper(pDefault);
        }
        return color;
    }

    private Integer parseColor(String pString) {
        Integer parsedColor;
        if (pString == null) {
            parsedColor = null;
        } else if (SVGProperties.isHexProperty(pString)) {
            parsedColor = SVGParserUtils.extractColorFromHexProperty(pString);
        } else if (SVGProperties.isRGBProperty(pString)) {
            parsedColor = SVGParserUtils.extractColorFromRGBProperty(pString);
        } else {
            Integer colorByName = ColorUtils.getColorByName(pString.trim());
            if (colorByName != null) {
                parsedColor = colorByName;
            } else {
                parsedColor = SVGParserUtils.extraColorIntegerProperty(pString);
            }
        }
        return applySVGColorMapper(parsedColor);
    }

    private Integer applySVGColorMapper(Integer pColor) {
        return this.mSVGColorMapper == null ? pColor : this.mSVGColorMapper.mapColor(pColor);
    }

    public SVGFilter parseFilter(Attributes pAttributes) {
        String id = SAXHelper.getStringAttribute(pAttributes, "id");
        if (id == null) {
            return null;
        }
        SVGFilter svgFilter = new SVGFilter(id, pAttributes);
        this.mSVGFilterMap.put(id, svgFilter);
        return svgFilter;
    }

    public SVGGradient parseGradient(Attributes pAttributes, boolean pLinear) {
        String id = SAXHelper.getStringAttribute(pAttributes, "id");
        if (id == null) {
            return null;
        }
        SVGGradient svgGradient = new SVGGradient(id, pLinear, pAttributes);
        this.mSVGGradientMap.put(id, svgGradient);
        return svgGradient;
    }

    public SVGGradientStop parseGradientStop(SVGProperties pSVGProperties) {
        return new SVGGradientStop(pSVGProperties.getFloatProperty(ISVGConstants.ATTRIBUTE_OFFSET, 0.0f).floatValue(), parseGradientStopAlpha(pSVGProperties) | parseColor(pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_STOP_COLOR).trim(), Integer.valueOf(-16777216)).intValue());
    }

    private int parseGradientStopAlpha(SVGProperties pSVGProperties) {
        String opacityStyle = pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_STOP_OPACITY);
        if (opacityStyle != null) {
            return Math.round(ColorConstants.COLOR_FACTOR_INT_TO_FLOAT * Float.parseFloat(opacityStyle)) << 24;
        }
        return -16777216;
    }

    private Shader getGradientShader(String pGradientShaderID) {
        SVGGradient svgGradient = (SVGGradient) this.mSVGGradientMap.get(pGradientShaderID);
        if (svgGradient == null) {
            throw new SVGParseException("No SVGGradient found for id: '" + pGradientShaderID + "'.");
        }
        Shader gradientShader = svgGradient.getShader();
        if (gradientShader != null) {
            return gradientShader;
        }
        svgGradient.ensureHrefResolved(this.mSVGGradientMap);
        return svgGradient.createShader();
    }

    private SVGFilter getFilter(String pSVGFilterID) {
        SVGFilter svgFilter = (SVGFilter) this.mSVGFilterMap.get(pSVGFilterID);
        if (svgFilter == null) {
            return null;
        }
        svgFilter.ensureHrefResolved(this.mSVGFilterMap);
        return svgFilter;
    }

    public SVGFilterElementGaussianBlur parseFilterElementGaussianBlur(Attributes pAttributes) {
        return new SVGFilterElementGaussianBlur(SAXHelper.getFloatAttribute(pAttributes, ISVGConstants.ATTRIBUTE_FILTER_ELEMENT_FEGAUSSIANBLUR_STANDARDDEVIATION).floatValue());
    }
}
