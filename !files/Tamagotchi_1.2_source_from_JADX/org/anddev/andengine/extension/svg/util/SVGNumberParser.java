package org.anddev.andengine.extension.svg.util;

public class SVGNumberParser {

    public static class SVGNumberParserFloatResult {
        private final float[] mNumbers;

        public SVGNumberParserFloatResult(float[] pNumbers) {
            this.mNumbers = pNumbers;
        }

        public float[] getNumbers() {
            return this.mNumbers;
        }

        public int getNumberCount() {
            return this.mNumbers.length;
        }

        public float getNumber(int pIndex) {
            return this.mNumbers[pIndex];
        }
    }

    public static class SVGNumberParserIntegerResult {
        private final int[] mNumbers;

        public SVGNumberParserIntegerResult(int[] pNumbers) {
            this.mNumbers = pNumbers;
        }

        public int[] getNumbers() {
            return this.mNumbers;
        }

        public int getNumberCount() {
            return this.mNumbers.length;
        }

        public int getNumber(int pIndex) {
            return this.mNumbers[pIndex];
        }
    }

    public static SVGNumberParserFloatResult parseFloats(String pString) {
        if (pString == null) {
            return null;
        }
        String[] parts = pString.split("[\\s,]+");
        float[] numbers = new float[parts.length];
        for (int i = parts.length - 1; i >= 0; i--) {
            numbers[i] = Float.parseFloat(parts[i]);
        }
        return new SVGNumberParserFloatResult(numbers);
    }

    public static SVGNumberParserIntegerResult parseInts(String pString) {
        if (pString == null) {
            return null;
        }
        String[] parts = pString.split("[\\s,]+");
        int[] numbers = new int[parts.length];
        for (int i = parts.length - 1; i >= 0; i--) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return new SVGNumberParserIntegerResult(numbers);
    }
}
