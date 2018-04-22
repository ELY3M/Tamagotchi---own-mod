package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;
import java.util.concurrent.TimeUnit;

public class DataUpdateRequest implements SafeParcelable {
    public static final Creator<DataUpdateRequest> CREATOR = new zzm();
    private final int mVersionCode;
    private final long zzRD;
    private final zzow zzaAD;
    private final long zzavV;
    private final DataSet zzaxn;

    public static class Builder {
        private long zzRD;
        private long zzavV;
        private DataSet zzaxn;

        private void zzuV() {
            zzx.zza(this.zzRD, (Object) "Must set a non-zero value for startTimeMillis/startTime");
            zzx.zza(this.zzavV, (Object) "Must set a non-zero value for endTimeMillis/endTime");
            zzx.zzb(this.zzaxn, (Object) "Must set the data set");
            for (DataPoint dataPoint : this.zzaxn.getDataPoints()) {
                long startTime = dataPoint.getStartTime(TimeUnit.MILLISECONDS);
                long endTime = dataPoint.getEndTime(TimeUnit.MILLISECONDS);
                int i = (startTime > endTime || ((startTime != 0 && startTime < this.zzRD) || ((startTime != 0 && startTime > this.zzavV) || endTime > this.zzavV || endTime < this.zzRD))) ? 1 : 0;
                zzx.zza(i == 0, "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", Long.valueOf(startTime), Long.valueOf(endTime), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
            }
        }

        public DataUpdateRequest build() {
            zzuV();
            return new DataUpdateRequest();
        }

        public Builder setDataSet(DataSet dataSet) {
            zzx.zzb((Object) dataSet, (Object) "Must set the data set");
            this.zzaxn = dataSet;
            return this;
        }

        public Builder setTimeInterval(long startTimeMillis, long endTimeMillis, TimeUnit timeUnit) {
            zzx.zzb(startTimeMillis > 0, "Invalid start time :%d", Long.valueOf(startTimeMillis));
            zzx.zzb(endTimeMillis >= startTimeMillis, "Invalid end time :%d", Long.valueOf(endTimeMillis));
            this.zzRD = timeUnit.toMillis(startTimeMillis);
            this.zzavV = timeUnit.toMillis(endTimeMillis);
            return this;
        }
    }

    DataUpdateRequest(int versionCode, long startTimeMillis, long endTimeMillis, DataSet dataSet, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzaxn = dataSet;
        this.zzaAD = zza.zzbR(callback);
    }

    public DataUpdateRequest(long startTimeMillis, long endTimeMillis, DataSet dataSet, IBinder callback) {
        this.mVersionCode = 1;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzaxn = dataSet;
        this.zzaAD = zza.zzbR(callback);
    }

    private DataUpdateRequest(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.zzaxn, null);
    }

    public DataUpdateRequest(DataUpdateRequest request, IBinder callback) {
        this(request.zzlO(), request.zzud(), request.getDataSet(), callback);
    }

    private boolean zzb(DataUpdateRequest dataUpdateRequest) {
        return this.zzRD == dataUpdateRequest.zzRD && this.zzavV == dataUpdateRequest.zzavV && zzw.equal(this.zzaxn, dataUpdateRequest.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataUpdateRequest) && zzb((DataUpdateRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSet", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public long zzud() {
        return this.zzavV;
    }
}
