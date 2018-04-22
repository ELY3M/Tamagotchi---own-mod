package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zznz.zzb;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzoc.zza;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzpi;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API = null;
    public static final Api<NoOptions> BLE_API = new Api("Fitness.BLE_API", new zzb(), zzavK);
    public static final BleApi BleApi = zztZ();
    public static final Api<NoOptions> CONFIG_API = new Api("Fitness.CONFIG_API", new zzoa.zzb(), zzavL);
    public static final ConfigApi ConfigApi = new zzpb();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> HISTORY_API = new Api("Fitness.HISTORY_API", new zzob.zzb(), zzavM);
    public static final HistoryApi HistoryApi = new zzpc();
    public static final Api<NoOptions> RECORDING_API = new Api("Fitness.RECORDING_API", new zzod.zzb(), zzavO);
    public static final RecordingApi RecordingApi = new zzpe();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final Scope SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    public static final Api<NoOptions> SENSORS_API = new Api("Fitness.SENSORS_API", new zzoe.zzb(), zzavP);
    public static final Api<NoOptions> SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzof.zzb(), zzavQ);
    public static final SensorsApi SensorsApi = new zzpf();
    public static final SessionsApi SessionsApi = new zzpg();
    public static final Api<NoOptions> zzaoG = new Api("Fitness.INTERNAL_API", new zza(), zzavN);
    public static final zzc<zznz> zzavK = new zzc();
    public static final zzc<zzoa> zzavL = new zzc();
    public static final zzc<zzob> zzavM = new zzc();
    public static final zzc<zzoc> zzavN = new zzc();
    public static final zzc<zzod> zzavO = new zzc();
    public static final zzc<zzoe> zzavP = new zzc();
    public static final zzc<zzof> zzavQ = new zzc();
    public static final zzoy zzavR = new zzpd();

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zztZ() {
        return VERSION.SDK_INT >= 18 ? new zzpa() : new zzpi();
    }
}
