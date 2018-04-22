package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    public /* synthetic */ Object get(int i) {
        return zzgD(i);
    }

    public GameNotification zzgD(int i) {
        return new GameNotificationRef(this.zzahi, i);
    }
}
