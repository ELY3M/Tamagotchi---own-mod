package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Creator<FitnessSensorServiceRequest> CREATOR = new zza();
    public static final int UNSPECIFIED = -1;
    private final int mVersionCode;
    private final long zzaBR;
    private final long zzaBS;
    private final zzk zzaBh;
    private final DataSource zzavU;

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzaBh = zza.zzbt(listenerBinder);
        this.zzaBR = samplingRateMicros;
        this.zzaBS = batchIntervalMicros;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzw.equal(this.zzavU, fitnessSensorServiceRequest.zzavU) && this.zzaBR == fitnessSensorServiceRequest.zzaBR && this.zzaBS == fitnessSensorServiceRequest.zzaBS;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) that));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaBS, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzaBh);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return this.zzaBR == -1 ? -1 : timeUnit.convert(this.zzaBR, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, Long.valueOf(this.zzaBR), Long.valueOf(this.zzaBS));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.zzavU});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public long zzux() {
        return this.zzaBR;
    }

    IBinder zzvb() {
        return this.zzaBh.asBinder();
    }

    public long zzvs() {
        return this.zzaBS;
    }
}
