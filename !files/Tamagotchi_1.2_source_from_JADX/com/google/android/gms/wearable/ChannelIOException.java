package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException extends IOException {
    private final int zzbqW;
    private final int zzbqX;

    public ChannelIOException(String message, int closeReason, int appSpecificErrorCode) {
        super(message);
        this.zzbqW = closeReason;
        this.zzbqX = appSpecificErrorCode;
    }

    public int getAppSpecificErrorCode() {
        return this.zzbqX;
    }

    public int getCloseReason() {
        return this.zzbqW;
    }
}
