package org.anddev.andengine.extension.svg.util;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.v7.app.AppCompatDelegate;
import android.util.FloatMath;
import java.util.LinkedList;
import java.util.Queue;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.anddev.andengine.extension.svg.util.constants.MathUtils;

public class SVGPathParser implements ISVGConstants {
    private final RectF mArcRect = new RectF();
    private Character mCommand = null;
    private final Queue<Float> mCommandParameters = new LinkedList();
    private int mCommandStart = 0;
    private char mCurrentChar;
    private float mLastCubicBezierX2;
    private float mLastCubicBezierY2;
    private float mLastQuadraticBezierX2;
    private float mLastQuadraticBezierY2;
    private float mLastX;
    private float mLastY;
    private int mLength;
    private Path mPath;
    private final PathParserHelper mPathParserHelper = new PathParserHelper();
    private int mPosition;
    private String mString;
    private float mSubPathStartX;
    private float mSubPathStartY;

    public class PathParserHelper {
        private char read() {
            if (SVGPathParser.this.mPosition < SVGPathParser.this.mLength) {
                SVGPathParser sVGPathParser = SVGPathParser.this;
                sVGPathParser.mPosition = sVGPathParser.mPosition + 1;
            }
            if (SVGPathParser.this.mPosition == SVGPathParser.this.mLength) {
                return '\u0000';
            }
            return SVGPathParser.this.mString.charAt(SVGPathParser.this.mPosition);
        }

        public void skipWhitespace() {
            while (SVGPathParser.this.mPosition < SVGPathParser.this.mLength && Character.isWhitespace(SVGPathParser.this.mString.charAt(SVGPathParser.this.mPosition))) {
                advance();
            }
        }

        public void skipNumberSeparator() {
            while (SVGPathParser.this.mPosition < SVGPathParser.this.mLength) {
                switch (SVGPathParser.this.mString.charAt(SVGPathParser.this.mPosition)) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                        advance();
                    default:
                        return;
                }
            }
        }

        public void advance() {
            SVGPathParser.this.mCurrentChar = read();
        }

        private float parseFloat() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r12 = this;
            r11 = 9;
            r8 = 0;
            r5 = 0;
            r6 = 0;
            r4 = 1;
            r7 = 0;
            r0 = 0;
            r2 = 0;
            r1 = 0;
            r3 = 1;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            switch(r9) {
                case 43: goto L_0x0021;
                case 44: goto L_0x0014;
                case 45: goto L_0x0020;
                default: goto L_0x0014;
            };
        L_0x0014:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            switch(r9) {
                case 46: goto L_0x003f;
                case 47: goto L_0x001d;
                case 48: goto L_0x002b;
                case 49: goto L_0x007e;
                case 50: goto L_0x007e;
                case 51: goto L_0x007e;
                case 52: goto L_0x007e;
                case 53: goto L_0x007e;
                case 54: goto L_0x007e;
                case 55: goto L_0x007e;
                case 56: goto L_0x007e;
                case 57: goto L_0x007e;
                default: goto L_0x001d;
            };
        L_0x001d:
            r8 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        L_0x001f:
            return r8;
        L_0x0020:
            r4 = 0;
        L_0x0021:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r12.read();
            r9.mCurrentChar = r10;
            goto L_0x0014;
        L_0x002b:
            r7 = 1;
        L_0x002c:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r12.read();
            r9.mCurrentChar = r10;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            switch(r9) {
                case 46: goto L_0x003f;
                case 48: goto L_0x002c;
                case 49: goto L_0x007e;
                case 50: goto L_0x007e;
                case 51: goto L_0x007e;
                case 52: goto L_0x007e;
                case 53: goto L_0x007e;
                case 54: goto L_0x007e;
                case 55: goto L_0x007e;
                case 56: goto L_0x007e;
                case 57: goto L_0x007e;
                case 69: goto L_0x003f;
                case 101: goto L_0x003f;
                default: goto L_0x003e;
            };
        L_0x003e:
            goto L_0x001f;
        L_0x003f:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            r10 = 46;
            if (r9 != r10) goto L_0x00bd;
        L_0x0049:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r12.read();
            r9.mCurrentChar = r10;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            switch(r9) {
                case 48: goto L_0x00a5;
                case 49: goto L_0x00d3;
                case 50: goto L_0x00d3;
                case 51: goto L_0x00d3;
                case 52: goto L_0x00d3;
                case 53: goto L_0x00d3;
                case 54: goto L_0x00d3;
                case 55: goto L_0x00d3;
                case 56: goto L_0x00d3;
                case 57: goto L_0x00d3;
                default: goto L_0x005b;
            };
        L_0x005b:
            if (r7 != 0) goto L_0x00bd;
        L_0x005d:
            r8 = new java.lang.IllegalArgumentException;
            r9 = new java.lang.StringBuilder;
            r10 = "Unexpected char '";
            r9.<init>(r10);
            r10 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r10.mCurrentChar;
            r9 = r9.append(r10);
            r10 = "'.";
            r9 = r9.append(r10);
            r9 = r9.toString();
            r8.<init>(r9);
            throw r8;
        L_0x007e:
            r7 = 1;
        L_0x007f:
            if (r6 >= r11) goto L_0x00a2;
        L_0x0081:
            r6 = r6 + 1;
            r9 = r5 * 10;
            r10 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r10.mCurrentChar;
            r10 = r10 + -48;
            r5 = r9 + r10;
        L_0x008f:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r12.read();
            r9.mCurrentChar = r10;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            switch(r9) {
                case 48: goto L_0x007f;
                case 49: goto L_0x007f;
                case 50: goto L_0x007f;
                case 51: goto L_0x007f;
                case 52: goto L_0x007f;
                case 53: goto L_0x007f;
                case 54: goto L_0x007f;
                case 55: goto L_0x007f;
                case 56: goto L_0x007f;
                case 57: goto L_0x007f;
                default: goto L_0x00a1;
            };
        L_0x00a1:
            goto L_0x003f;
        L_0x00a2:
            r1 = r1 + 1;
            goto L_0x008f;
        L_0x00a5:
            if (r6 != 0) goto L_0x00d3;
        L_0x00a7:
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r12.read();
            r9.mCurrentChar = r10;
            r1 = r1 + -1;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            switch(r9) {
                case 48: goto L_0x00a7;
                case 49: goto L_0x00d3;
                case 50: goto L_0x00d3;
                case 51: goto L_0x00d3;
                case 52: goto L_0x00d3;
                case 53: goto L_0x00d3;
                case 54: goto L_0x00d3;
                case 55: goto L_0x00d3;
                case 56: goto L_0x00d3;
                case 57: goto L_0x00d3;
                default: goto L_0x00bb;
            };
        L_0x00bb:
            if (r7 == 0) goto L_0x001f;
        L_0x00bd:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 69: goto L_0x00f8;
                case 101: goto L_0x00f8;
                default: goto L_0x00c6;
            };
        L_0x00c6:
            if (r3 != 0) goto L_0x00c9;
        L_0x00c8:
            r0 = -r0;
        L_0x00c9:
            r0 = r0 + r1;
            if (r4 != 0) goto L_0x00cd;
        L_0x00cc:
            r5 = -r5;
        L_0x00cd:
            r8 = r12.buildFloat(r5, r0);
            goto L_0x001f;
        L_0x00d3:
            if (r6 >= r11) goto L_0x00e5;
        L_0x00d5:
            r6 = r6 + 1;
            r8 = r5 * 10;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            r9 = r9 + -48;
            r5 = r8 + r9;
            r1 = r1 + -1;
        L_0x00e5:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r12.read();
            r8.mCurrentChar = r9;
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 48: goto L_0x00d3;
                case 49: goto L_0x00d3;
                case 50: goto L_0x00d3;
                case 51: goto L_0x00d3;
                case 52: goto L_0x00d3;
                case 53: goto L_0x00d3;
                case 54: goto L_0x00d3;
                case 55: goto L_0x00d3;
                case 56: goto L_0x00d3;
                case 57: goto L_0x00d3;
                default: goto L_0x00f7;
            };
        L_0x00f7:
            goto L_0x00bd;
        L_0x00f8:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r12.read();
            r8.mCurrentChar = r9;
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 43: goto L_0x012c;
                case 44: goto L_0x010a;
                case 45: goto L_0x012b;
                case 46: goto L_0x010a;
                case 47: goto L_0x010a;
                case 48: goto L_0x015f;
                case 49: goto L_0x015f;
                case 50: goto L_0x015f;
                case 51: goto L_0x015f;
                case 52: goto L_0x015f;
                case 53: goto L_0x015f;
                case 54: goto L_0x015f;
                case 55: goto L_0x015f;
                case 56: goto L_0x015f;
                case 57: goto L_0x015f;
                default: goto L_0x010a;
            };
        L_0x010a:
            r8 = new java.lang.IllegalArgumentException;
            r9 = new java.lang.StringBuilder;
            r10 = "Unexpected char '";
            r9.<init>(r10);
            r10 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r10.mCurrentChar;
            r9 = r9.append(r10);
            r10 = "'.";
            r9 = r9.append(r10);
            r9 = r9.toString();
            r8.<init>(r9);
            throw r8;
        L_0x012b:
            r3 = 0;
        L_0x012c:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r12.read();
            r8.mCurrentChar = r9;
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 48: goto L_0x015f;
                case 49: goto L_0x015f;
                case 50: goto L_0x015f;
                case 51: goto L_0x015f;
                case 52: goto L_0x015f;
                case 53: goto L_0x015f;
                case 54: goto L_0x015f;
                case 55: goto L_0x015f;
                case 56: goto L_0x015f;
                case 57: goto L_0x015f;
                default: goto L_0x013e;
            };
        L_0x013e:
            r8 = new java.lang.IllegalArgumentException;
            r9 = new java.lang.StringBuilder;
            r10 = "Unexpected char '";
            r9.<init>(r10);
            r10 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r10 = r10.mCurrentChar;
            r9 = r9.append(r10);
            r10 = "'.";
            r9 = r9.append(r10);
            r9 = r9.toString();
            r8.<init>(r9);
            throw r8;
        L_0x015f:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 48: goto L_0x016a;
                case 49: goto L_0x017e;
                case 50: goto L_0x017e;
                case 51: goto L_0x017e;
                case 52: goto L_0x017e;
                case 53: goto L_0x017e;
                case 54: goto L_0x017e;
                case 55: goto L_0x017e;
                case 56: goto L_0x017e;
                case 57: goto L_0x017e;
                default: goto L_0x0168;
            };
        L_0x0168:
            goto L_0x00c6;
        L_0x016a:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r12.read();
            r8.mCurrentChar = r9;
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 48: goto L_0x016a;
                case 49: goto L_0x017e;
                case 50: goto L_0x017e;
                case 51: goto L_0x017e;
                case 52: goto L_0x017e;
                case 53: goto L_0x017e;
                case 54: goto L_0x017e;
                case 55: goto L_0x017e;
                case 56: goto L_0x017e;
                case 57: goto L_0x017e;
                default: goto L_0x017c;
            };
        L_0x017c:
            goto L_0x00c6;
        L_0x017e:
            r8 = 3;
            if (r2 >= r8) goto L_0x018f;
        L_0x0181:
            r2 = r2 + 1;
            r8 = r0 * 10;
            r9 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r9.mCurrentChar;
            r9 = r9 + -48;
            r0 = r8 + r9;
        L_0x018f:
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r9 = r12.read();
            r8.mCurrentChar = r9;
            r8 = org.anddev.andengine.extension.svg.util.SVGPathParser.this;
            r8 = r8.mCurrentChar;
            switch(r8) {
                case 48: goto L_0x017e;
                case 49: goto L_0x017e;
                case 50: goto L_0x017e;
                case 51: goto L_0x017e;
                case 52: goto L_0x017e;
                case 53: goto L_0x017e;
                case 54: goto L_0x017e;
                case 55: goto L_0x017e;
                case 56: goto L_0x017e;
                case 57: goto L_0x017e;
                default: goto L_0x01a1;
            };
        L_0x01a1:
            goto L_0x00c6;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.anddev.andengine.extension.svg.util.SVGPathParser.PathParserHelper.parseFloat():float");
        }

        public float nextFloat() {
            skipWhitespace();
            float f = parseFloat();
            skipNumberSeparator();
            return f;
        }

        public float buildFloat(int pMantissa, int pExponent) {
            if (pExponent < -125 || pMantissa == 0) {
                return 0.0f;
            }
            if (pExponent >= 128) {
                if (pMantissa > 0) {
                    return Float.POSITIVE_INFINITY;
                }
                return Float.NEGATIVE_INFINITY;
            } else if (pExponent == 0) {
                return (float) pMantissa;
            } else {
                if (pMantissa >= 67108864) {
                    pMantissa++;
                }
                return (float) (pExponent > 0 ? ((double) pMantissa) * MathUtils.POWERS_OF_10[pExponent] : ((double) pMantissa) / MathUtils.POWERS_OF_10[-pExponent]);
            }
        }
    }

    public void parse(SVGProperties pSVGProperties, Canvas pCanvas, SVGPaint pSVGPaint) {
        Path path = parse(pSVGProperties);
        boolean fill = pSVGPaint.setFill(pSVGProperties);
        if (fill) {
            pCanvas.drawPath(path, pSVGPaint.getPaint());
        }
        boolean stroke = pSVGPaint.setStroke(pSVGProperties);
        if (stroke) {
            pCanvas.drawPath(path, pSVGPaint.getPaint());
        }
        if (fill || stroke) {
            pSVGPaint.ensureComputedBoundsInclude(path);
        }
    }

    private Path parse(SVGProperties pSVGProperties) {
        String pathString = pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_PATHDATA);
        if (pathString == null) {
            return null;
        }
        this.mString = pathString.trim();
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mLastCubicBezierX2 = 0.0f;
        this.mLastCubicBezierY2 = 0.0f;
        this.mCommand = null;
        this.mCommandParameters.clear();
        this.mPath = new Path();
        if (this.mString.length() == 0) {
            return this.mPath;
        }
        String fillrule = pSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_FILLRULE);
        if (fillrule != null) {
            if (ISVGConstants.ATTRIBUTE_FILLRULE_VALUE_EVENODD.equals(fillrule)) {
                this.mPath.setFillType(FillType.EVEN_ODD);
            } else {
                this.mPath.setFillType(FillType.WINDING);
            }
        }
        this.mCurrentChar = this.mString.charAt(0);
        this.mPosition = 0;
        this.mLength = this.mString.length();
        while (this.mPosition < this.mLength) {
            this.mPathParserHelper.skipWhitespace();
            if (!Character.isLetter(this.mCurrentChar) || this.mCurrentChar == 'e' || this.mCurrentChar == 'E') {
                try {
                    this.mCommandParameters.add(Float.valueOf(this.mPathParserHelper.nextFloat()));
                } catch (Throwable t) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error parsing: '" + this.mString.substring(this.mCommandStart, this.mPosition) + "'. Command: '" + this.mCommand + "'. Parameters: '" + this.mCommandParameters.size() + "'.", t);
                }
            } else {
                processCommand();
                this.mCommand = Character.valueOf(this.mCurrentChar);
                this.mCommandStart = this.mPosition;
                this.mPathParserHelper.advance();
            }
        }
        processCommand();
        return this.mPath;
    }

    private void processCommand() {
        if (this.mCommand != null) {
            generatePathElement();
            this.mCommandParameters.clear();
        }
    }

    private void generatePathElement() {
        boolean wasCubicBezierCurve = false;
        boolean wasQuadraticBezierCurve = false;
        switch (this.mCommand.charValue()) {
            case 'A':
                generateArc(true);
                break;
            case 'C':
                generateCubicBezierCurve(true);
                wasCubicBezierCurve = true;
                break;
            case 'H':
                generateHorizontalLine(true);
                break;
            case 'L':
                generateLine(true);
                break;
            case 'M':
                generateMove(true);
                break;
            case 'Q':
                generateQuadraticBezierCurve(true);
                wasQuadraticBezierCurve = true;
                break;
            case 'S':
                generateSmoothCubicBezierCurve(true);
                wasCubicBezierCurve = true;
                break;
            case 'T':
                generateSmoothQuadraticBezierCurve(true);
                wasQuadraticBezierCurve = true;
                break;
            case 'V':
                generateVerticalLine(true);
                break;
            case 'Z':
            case 'z':
                generateClose();
                break;
            case 'a':
                generateArc(false);
                break;
            case 'c':
                generateCubicBezierCurve(false);
                wasCubicBezierCurve = true;
                break;
            case 'h':
                generateHorizontalLine(false);
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /*108*/:
                generateLine(false);
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /*109*/:
                generateMove(false);
                break;
            case 'q':
                generateQuadraticBezierCurve(false);
                wasQuadraticBezierCurve = true;
                break;
            case 's':
                generateSmoothCubicBezierCurve(false);
                wasCubicBezierCurve = true;
                break;
            case 't':
                generateSmoothQuadraticBezierCurve(false);
                wasQuadraticBezierCurve = true;
                break;
            case 'v':
                generateVerticalLine(false);
                break;
            default:
                throw new RuntimeException("Unexpected SVG command: " + this.mCommand);
        }
        if (!wasCubicBezierCurve) {
            this.mLastCubicBezierX2 = this.mLastX;
            this.mLastCubicBezierY2 = this.mLastY;
        }
        if (!wasQuadraticBezierCurve) {
            this.mLastQuadraticBezierX2 = this.mLastX;
            this.mLastQuadraticBezierY2 = this.mLastY;
        }
    }

    private void assertParameterCountMinimum(int pParameterCount) {
        if (this.mCommandParameters.size() < pParameterCount) {
            throw new RuntimeException("Incorrect parameter count: '" + this.mCommandParameters.size() + "'. Expected at least: '" + pParameterCount + "'.");
        }
    }

    private void assertParameterCount(int pParameterCount) {
        if (this.mCommandParameters.size() != pParameterCount) {
            throw new RuntimeException("Incorrect parameter count: '" + this.mCommandParameters.size() + "'. Expected: '" + pParameterCount + "'.");
        }
    }

    private void generateMove(boolean pAbsolute) {
        assertParameterCountMinimum(2);
        float x = ((Float) this.mCommandParameters.poll()).floatValue();
        float y = ((Float) this.mCommandParameters.poll()).floatValue();
        if (pAbsolute) {
            this.mPath.moveTo(x, y);
            this.mLastX = x;
            this.mLastY = y;
        } else {
            this.mPath.rMoveTo(x, y);
            this.mLastX += x;
            this.mLastY += y;
        }
        this.mSubPathStartX = this.mLastX;
        this.mSubPathStartY = this.mLastY;
        if (this.mCommandParameters.size() >= 2) {
            generateLine(pAbsolute);
        }
    }

    private void generateLine(boolean pAbsolute) {
        assertParameterCountMinimum(2);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 2) {
                float x = ((Float) this.mCommandParameters.poll()).floatValue();
                float y = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.lineTo(x, y);
                this.mLastX = x;
                this.mLastY = y;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 2) {
            x = ((Float) this.mCommandParameters.poll()).floatValue();
            y = ((Float) this.mCommandParameters.poll()).floatValue();
            this.mPath.rLineTo(x, y);
            this.mLastX += x;
            this.mLastY += y;
        }
    }

    private void generateHorizontalLine(boolean pAbsolute) {
        assertParameterCountMinimum(1);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 1) {
                float x = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.lineTo(x, this.mLastY);
                this.mLastX = x;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 1) {
            x = ((Float) this.mCommandParameters.poll()).floatValue();
            this.mPath.rLineTo(x, 0.0f);
            this.mLastX += x;
        }
    }

    private void generateVerticalLine(boolean pAbsolute) {
        assertParameterCountMinimum(1);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 1) {
                float y = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.lineTo(this.mLastX, y);
                this.mLastY = y;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 1) {
            y = ((Float) this.mCommandParameters.poll()).floatValue();
            this.mPath.rLineTo(0.0f, y);
            this.mLastY += y;
        }
    }

    private void generateCubicBezierCurve(boolean pAbsolute) {
        assertParameterCountMinimum(6);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 6) {
                float x1 = ((Float) this.mCommandParameters.poll()).floatValue();
                float y1 = ((Float) this.mCommandParameters.poll()).floatValue();
                float x2 = ((Float) this.mCommandParameters.poll()).floatValue();
                float y2 = ((Float) this.mCommandParameters.poll()).floatValue();
                float x = ((Float) this.mCommandParameters.poll()).floatValue();
                float y = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.cubicTo(x1, y1, x2, y2, x, y);
                this.mLastCubicBezierX2 = x2;
                this.mLastCubicBezierY2 = y2;
                this.mLastX = x;
                this.mLastY = y;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 6) {
            x2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            x = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            this.mPath.cubicTo(((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX, ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY, x2, y2, x, y);
            this.mLastCubicBezierX2 = x2;
            this.mLastCubicBezierY2 = y2;
            this.mLastX = x;
            this.mLastY = y;
        }
    }

    private void generateSmoothCubicBezierCurve(boolean pAbsolute) {
        assertParameterCountMinimum(4);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 4) {
                float x1 = (this.mLastX * 2.0f) - this.mLastCubicBezierX2;
                float y1 = (this.mLastY * 2.0f) - this.mLastCubicBezierY2;
                float x2 = ((Float) this.mCommandParameters.poll()).floatValue();
                float y2 = ((Float) this.mCommandParameters.poll()).floatValue();
                float x = ((Float) this.mCommandParameters.poll()).floatValue();
                float y = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.cubicTo(x1, y1, x2, y2, x, y);
                this.mLastCubicBezierX2 = x2;
                this.mLastCubicBezierY2 = y2;
                this.mLastX = x;
                this.mLastY = y;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 4) {
            x2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            x = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            this.mPath.cubicTo((this.mLastX * 2.0f) - this.mLastCubicBezierX2, (this.mLastY * 2.0f) - this.mLastCubicBezierY2, x2, y2, x, y);
            this.mLastCubicBezierX2 = x2;
            this.mLastCubicBezierY2 = y2;
            this.mLastX = x;
            this.mLastY = y;
        }
    }

    private void generateQuadraticBezierCurve(boolean pAbsolute) {
        assertParameterCountMinimum(4);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 4) {
                float x1 = ((Float) this.mCommandParameters.poll()).floatValue();
                float y1 = ((Float) this.mCommandParameters.poll()).floatValue();
                float x2 = ((Float) this.mCommandParameters.poll()).floatValue();
                float y2 = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.quadTo(x1, y1, x2, y2);
                this.mLastQuadraticBezierX2 = x2;
                this.mLastQuadraticBezierY2 = y2;
                this.mLastX = x2;
                this.mLastY = y2;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 4) {
            x2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            this.mPath.quadTo(((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX, ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY, x2, y2);
            this.mLastQuadraticBezierX2 = x2;
            this.mLastQuadraticBezierY2 = y2;
            this.mLastX = x2;
            this.mLastY = y2;
        }
    }

    private void generateSmoothQuadraticBezierCurve(boolean pAbsolute) {
        assertParameterCountMinimum(2);
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 2) {
                float x1 = (this.mLastX * 2.0f) - this.mLastQuadraticBezierX2;
                float y1 = (this.mLastY * 2.0f) - this.mLastQuadraticBezierY2;
                float x2 = ((Float) this.mCommandParameters.poll()).floatValue();
                float y2 = ((Float) this.mCommandParameters.poll()).floatValue();
                this.mPath.quadTo(x1, y1, x2, y2);
                this.mLastQuadraticBezierX2 = x2;
                this.mLastQuadraticBezierY2 = y2;
                this.mLastX = x2;
                this.mLastY = y2;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 2) {
            x2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y2 = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            this.mPath.quadTo((this.mLastX * 2.0f) - this.mLastQuadraticBezierX2, (this.mLastY * 2.0f) - this.mLastQuadraticBezierY2, x2, y2);
            this.mLastQuadraticBezierX2 = x2;
            this.mLastQuadraticBezierY2 = y2;
            this.mLastX = x2;
            this.mLastY = y2;
        }
    }

    private void generateArc(boolean pAbsolute) {
        assertParameterCountMinimum(7);
        boolean largeArcFlag;
        boolean sweepFlag;
        if (pAbsolute) {
            while (this.mCommandParameters.size() >= 7) {
                float rx = ((Float) this.mCommandParameters.poll()).floatValue();
                float ry = ((Float) this.mCommandParameters.poll()).floatValue();
                float theta = ((Float) this.mCommandParameters.poll()).floatValue();
                if (((Float) this.mCommandParameters.poll()).intValue() == 1) {
                    largeArcFlag = true;
                } else {
                    largeArcFlag = false;
                }
                if (((Float) this.mCommandParameters.poll()).intValue() == 1) {
                    sweepFlag = true;
                } else {
                    sweepFlag = false;
                }
                float x = ((Float) this.mCommandParameters.poll()).floatValue();
                float y = ((Float) this.mCommandParameters.poll()).floatValue();
                generateArc(rx, ry, theta, largeArcFlag, sweepFlag, x, y);
                this.mLastX = x;
                this.mLastY = y;
            }
            return;
        }
        while (this.mCommandParameters.size() >= 7) {
            rx = ((Float) this.mCommandParameters.poll()).floatValue();
            ry = ((Float) this.mCommandParameters.poll()).floatValue();
            theta = ((Float) this.mCommandParameters.poll()).floatValue();
            if (((Float) this.mCommandParameters.poll()).intValue() == 1) {
                largeArcFlag = true;
            } else {
                largeArcFlag = false;
            }
            if (((Float) this.mCommandParameters.poll()).intValue() == 1) {
                sweepFlag = true;
            } else {
                sweepFlag = false;
            }
            x = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastX;
            y = ((Float) this.mCommandParameters.poll()).floatValue() + this.mLastY;
            generateArc(rx, ry, theta, largeArcFlag, sweepFlag, x, y);
            this.mLastX = x;
            this.mLastY = y;
        }
    }

    private void generateArc(float rx, float ry, float pTheta, boolean pLargeArcFlag, boolean pSweepFlag, float pX, float pY) {
        float dx = (this.mLastX - pX) * 0.5f;
        float dy = (this.mLastY - pY) * 0.5f;
        float thetaRad = org.anddev.andengine.util.MathUtils.degToRad(pTheta % 360.0f);
        float cosAngle = FloatMath.cos(thetaRad);
        float sinAngle = FloatMath.sin(thetaRad);
        float x1 = (cosAngle * dx) + (sinAngle * dy);
        float y1 = ((-sinAngle) * dx) + (cosAngle * dy);
        float radiusX = Math.abs(rx);
        float radiusY = Math.abs(ry);
        float Prx = radiusX * radiusX;
        float Pry = radiusY * radiusY;
        float Px1 = x1 * x1;
        float Py1 = y1 * y1;
        float radiiCheck = (Px1 / Prx) + (Py1 / Pry);
        if (radiiCheck > 1.0f) {
            radiusX *= FloatMath.sqrt(radiiCheck);
            radiusY *= FloatMath.sqrt(radiiCheck);
            Prx = radiusX * radiusX;
            Pry = radiusY * radiusY;
        }
        float sign = (float) (pLargeArcFlag == pSweepFlag ? -1 : 1);
        float sq = (((Prx * Pry) - (Prx * Py1)) - (Pry * Px1)) / ((Prx * Py1) + (Pry * Px1));
        if (sq < 0.0f) {
            sq = 0.0f;
        }
        float coef = sign * FloatMath.sqrt(sq);
        float cx_dash = coef * ((radiusX * y1) / radiusY);
        float cy_dash = coef * (-((radiusY * x1) / radiusX));
        float cx = ((this.mLastX + pX) * 0.5f) + ((cosAngle * cx_dash) - (sinAngle * cy_dash));
        float cy = ((this.mLastY + pY) * 0.5f) + ((sinAngle * cx_dash) + (cosAngle * cy_dash));
        float ux = (x1 - cx_dash) / radiusX;
        float uy = (y1 - cy_dash) / radiusY;
        float vx = ((-x1) - cx_dash) / radiusX;
        float vy = ((-y1) - cy_dash) / radiusY;
        float startAngle = org.anddev.andengine.util.MathUtils.radToDeg(((float) Math.acos((double) (ux / FloatMath.sqrt((ux * ux) + (uy * uy))))) * (uy < 0.0f ? -1.0f : 1.0f));
        float sweepAngle = org.anddev.andengine.util.MathUtils.radToDeg(((float) Math.acos((double) (((ux * vx) + (uy * vy)) / FloatMath.sqrt(((ux * ux) + (uy * uy)) * ((vx * vx) + (vy * vy)))))) * ((ux * vy) - (uy * vx) < 0.0f ? -1.0f : 1.0f));
        if (!pSweepFlag && sweepAngle > 0.0f) {
            sweepAngle -= 360.0f;
        } else if (pSweepFlag && sweepAngle < 0.0f) {
            sweepAngle += 360.0f;
        }
        sweepAngle %= 360.0f;
        startAngle %= 360.0f;
        this.mArcRect.set(cx - radiusX, cy - radiusY, cx + radiusX, cy + radiusY);
        this.mPath.arcTo(this.mArcRect, startAngle, sweepAngle);
    }

    private void generateClose() {
        assertParameterCount(0);
        this.mPath.close();
        this.mLastX = this.mSubPathStartX;
        this.mLastY = this.mSubPathStartY;
    }
}
