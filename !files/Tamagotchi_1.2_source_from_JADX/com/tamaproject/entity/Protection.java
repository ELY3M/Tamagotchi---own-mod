package com.tamaproject.entity;

public class Protection {
    public static final int NONE = -1;
    public static final int RAIN = 2;
    public static final int SNOW = 8;

    public static String getString(int code) {
        switch (code) {
            case -1:
                return "None";
            case 2:
                return "Rain";
            case 8:
                return "Snow";
            default:
                return "None";
        }
    }
}
