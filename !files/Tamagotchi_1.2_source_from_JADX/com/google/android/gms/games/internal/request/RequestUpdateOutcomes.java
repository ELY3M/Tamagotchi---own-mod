package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] zzaIX = new String[]{"requestId", "outcome"};
    private final HashMap<String, Integer> zzaIY;
    private final int zzade;

    public static final class Builder {
        private HashMap<String, Integer> zzaIY = new HashMap();
        private int zzade = 0;

        public Builder zzgG(int i) {
            this.zzade = i;
            return this;
        }

        public Builder zzx(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzaIY.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public RequestUpdateOutcomes zzxH() {
            return new RequestUpdateOutcomes(this.zzade, this.zzaIY);
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.zzade = statusCode;
        this.zzaIY = outcomeMap;
    }

    public static RequestUpdateOutcomes zzab(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zzgG(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int zzbH = dataHolder.zzbH(i);
            builder.zzx(dataHolder.zzd("requestId", i, zzbH), dataHolder.zzc("outcome", i, zzbH));
        }
        return builder.zzxH();
    }

    public Set<String> getRequestIds() {
        return this.zzaIY.keySet();
    }

    public int getRequestOutcome(String requestId) {
        zzx.zzb(this.zzaIY.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.zzaIY.get(requestId)).intValue();
    }
}
