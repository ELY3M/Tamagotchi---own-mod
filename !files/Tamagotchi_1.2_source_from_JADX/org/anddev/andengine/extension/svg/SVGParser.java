package org.anddev.andengine.extension.svg;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Picture;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.SAXParserFactory;
import org.anddev.andengine.extension.svg.adt.ISVGColorMapper;
import org.anddev.andengine.extension.svg.adt.SVG;
import org.anddev.andengine.extension.svg.exception.SVGParseException;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class SVGParser {
    public static SVG parseSVGFromString(String pString) throws SVGParseException {
        return parseSVGFromString(pString, null);
    }

    public static SVG parseSVGFromString(String pString, ISVGColorMapper pSVGColorMapper) throws SVGParseException {
        return parseSVGFromInputStream(new ByteArrayInputStream(pString.getBytes()), pSVGColorMapper);
    }

    public static SVG parseSVGFromResource(Resources pResources, int pRawResourceID) throws SVGParseException {
        return parseSVGFromResource(pResources, pRawResourceID, null);
    }

    public static SVG parseSVGFromResource(Resources pResources, int pRawResourceID, ISVGColorMapper pSVGColorMapper) throws SVGParseException {
        return parseSVGFromInputStream(pResources.openRawResource(pRawResourceID), pSVGColorMapper);
    }

    public static SVG parseSVGFromAsset(AssetManager pAssetManager, String pAssetPath) throws SVGParseException, IOException {
        return parseSVGFromAsset(pAssetManager, pAssetPath, null);
    }

    public static SVG parseSVGFromAsset(AssetManager pAssetManager, String pAssetPath, ISVGColorMapper pSVGColorMapper) throws SVGParseException, IOException {
        InputStream inputStream = pAssetManager.open(pAssetPath);
        SVG svg = parseSVGFromInputStream(inputStream, pSVGColorMapper);
        inputStream.close();
        return svg;
    }

    public static SVG parseSVGFromInputStream(InputStream pInputStream, ISVGColorMapper pSVGColorMapper) throws SVGParseException {
        try {
            XMLReader xr = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Picture picture = new Picture();
            SVGHandler svgHandler = new SVGHandler(picture, pSVGColorMapper);
            xr.setContentHandler(svgHandler);
            xr.parse(new InputSource(pInputStream));
            return new SVG(picture, svgHandler.getBounds(), svgHandler.getComputedBounds());
        } catch (Throwable e) {
            throw new SVGParseException(e);
        }
    }
}
