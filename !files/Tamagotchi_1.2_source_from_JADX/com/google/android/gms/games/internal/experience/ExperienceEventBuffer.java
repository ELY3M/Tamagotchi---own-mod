package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends AbstractDataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zzgx(i);
    }

    public ExperienceEvent zzgx(int i) {
        return new ExperienceEventRef(this.zzahi, i);
    }
}
