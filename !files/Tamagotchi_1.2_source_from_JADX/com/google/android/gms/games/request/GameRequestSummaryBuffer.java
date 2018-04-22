package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    public /* synthetic */ Object get(int i) {
        return zzgQ(i);
    }

    public GameRequestSummary zzgQ(int i) {
        return new GameRequestSummaryRef(this.zzahi, i);
    }
}
