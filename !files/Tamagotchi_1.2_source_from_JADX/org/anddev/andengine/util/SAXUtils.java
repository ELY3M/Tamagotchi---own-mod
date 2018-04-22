package org.anddev.andengine.util;

import org.xml.sax.Attributes;

public class SAXUtils {
    public static String getAttribute(Attributes pAttributes, String pAttributeName, String pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? value : pDefaultValue;
    }

    public static String getAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        String value = pAttributes.getValue("", pAttributeName);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException("No value found for attribute: '" + pAttributeName + "'");
    }

    public static boolean getBooleanAttribute(Attributes pAttributes, String pAttributeName, boolean pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Boolean.parseBoolean(value) : pDefaultValue;
    }

    public static boolean getBooleanAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Boolean.parseBoolean(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static byte getByteAttribute(Attributes pAttributes, String pAttributeName, byte pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Byte.parseByte(value) : pDefaultValue;
    }

    public static byte getByteAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Byte.parseByte(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static short getShortAttribute(Attributes pAttributes, String pAttributeName, short pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Short.parseShort(value) : pDefaultValue;
    }

    public static short getShortAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Short.parseShort(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static int getIntAttribute(Attributes pAttributes, String pAttributeName, int pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Integer.parseInt(value) : pDefaultValue;
    }

    public static int getIntAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Integer.parseInt(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static long getLongAttribute(Attributes pAttributes, String pAttributeName, long pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Long.parseLong(value) : pDefaultValue;
    }

    public static long getLongAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Long.parseLong(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static float getFloatAttribute(Attributes pAttributes, String pAttributeName, float pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Float.parseFloat(value) : pDefaultValue;
    }

    public static float getFloatAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Float.parseFloat(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static double getDoubleAttribute(Attributes pAttributes, String pAttributeName, double pDefaultValue) {
        String value = pAttributes.getValue("", pAttributeName);
        return value != null ? Double.parseDouble(value) : pDefaultValue;
    }

    public static double getDoubleAttributeOrThrow(Attributes pAttributes, String pAttributeName) {
        return Double.parseDouble(getAttributeOrThrow(pAttributes, pAttributeName));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, boolean pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, byte pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, short pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, int pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, long pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, float pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, double pValue) {
        appendAttribute(pStringBuilder, pName, String.valueOf(pValue));
    }

    public static void appendAttribute(StringBuilder pStringBuilder, String pName, String pValue) {
        pStringBuilder.append(' ').append(pName).append('=').append('\"').append(pValue).append('\"');
    }
}
