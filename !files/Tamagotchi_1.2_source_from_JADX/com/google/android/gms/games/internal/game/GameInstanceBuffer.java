package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameInstanceBuffer extends AbstractDataBuffer<GameInstance> {
    public GameInstanceBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zzgA(i);
    }

    public GameInstance zzgA(int i) {
        return new GameInstanceRef(this.zzahi, i);
    }
}
