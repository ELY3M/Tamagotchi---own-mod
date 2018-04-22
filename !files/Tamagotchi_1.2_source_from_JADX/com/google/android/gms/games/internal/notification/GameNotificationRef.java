package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public final class GameNotificationRef extends zzc implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE);
    }

    public String toString() {
        return zzw.zzy(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzxt()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzxu()).zzg("Text", getText()).zzg("CoalescedText", zzxv()).zzg("isAcknowledged", Boolean.valueOf(zzxw())).zzg("isSilent", Boolean.valueOf(zzxx())).toString();
    }

    public String zzxt() {
        return getString("notification_id");
    }

    public String zzxu() {
        return getString("ticker");
    }

    public String zzxv() {
        return getString("coalesced_text");
    }

    public boolean zzxw() {
        return getInteger("acknowledged") > 0;
    }

    public boolean zzxx() {
        return getInteger("alert_level") == 0;
    }
}
