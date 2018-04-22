package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzaIj = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzaIj.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzaIj.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zzwS();
            if (!this.zzaIj.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.zzaIj.get();
            }
        }
        eventIncrementCache.zzw(str, i);
    }

    protected abstract EventIncrementCache zzwS();
}
