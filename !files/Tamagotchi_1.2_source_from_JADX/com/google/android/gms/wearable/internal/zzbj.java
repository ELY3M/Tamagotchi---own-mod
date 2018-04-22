package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzbj implements ChannelListener {
    private final String zzVo;
    private final ChannelListener zzbtb;

    zzbj(String str, ChannelListener channelListener) {
        this.zzVo = (String) zzx.zzz(str);
        this.zzbtb = (ChannelListener) zzx.zzz(channelListener);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzbj)) {
            return false;
        }
        zzbj com_google_android_gms_wearable_internal_zzbj = (zzbj) o;
        return this.zzbtb.equals(com_google_android_gms_wearable_internal_zzbj.zzbtb) && this.zzVo.equals(com_google_android_gms_wearable_internal_zzbj.zzVo);
    }

    public int hashCode() {
        return (this.zzVo.hashCode() * 31) + this.zzbtb.hashCode();
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzbtb.onChannelClosed(channel, closeReason, appSpecificErrorCode);
    }

    public void onChannelOpened(Channel channel) {
        this.zzbtb.onChannelOpened(channel);
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzbtb.onInputClosed(channel, closeReason, appSpecificErrorCode);
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzbtb.onOutputClosed(channel, closeReason, appSpecificErrorCode);
    }
}
