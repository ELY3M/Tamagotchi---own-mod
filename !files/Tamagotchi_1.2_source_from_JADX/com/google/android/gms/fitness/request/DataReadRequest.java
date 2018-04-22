package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoh.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzRD;
    private final List<DataSource> zzaAF;
    private final List<DataType> zzaAK;
    private final List<DataSource> zzaAL;
    private final long zzaAM;
    private final DataSource zzaAN;
    private final int zzaAO;
    private final boolean zzaAP;
    private final boolean zzaAQ;
    private final zzoh zzaAR;
    private final List<Device> zzaAS;
    private final long zzavV;
    private final List<DataType> zzawe;
    private final int zzawh;

    public static class Builder {
        private long zzRD;
        private List<DataSource> zzaAF = new ArrayList();
        private List<DataType> zzaAK = new ArrayList();
        private List<DataSource> zzaAL = new ArrayList();
        private long zzaAM = 0;
        private DataSource zzaAN;
        private int zzaAO = 0;
        private boolean zzaAP = false;
        private boolean zzaAQ = false;
        private List<Device> zzaAS = new ArrayList();
        private long zzavV;
        private List<DataType> zzawe = new ArrayList();
        private int zzawh = 0;

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzx.zza(!this.zzaAF.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            zzx.zzb(DataType.getAggregatesForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.zzaAL.contains(dataSource)) {
                this.zzaAL.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            zzx.zzb((Object) inputDataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzawe.contains(inputDataType), (Object) "Cannot add the same data type as aggregated and detailed");
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            zzx.zzb(DataType.getAggregatesForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.zzaAK.contains(inputDataType)) {
                this.zzaAK.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzawh = 4;
            this.zzaAM = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzx.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzaAN = activityDataSource;
            this.zzawh = 4;
            this.zzaAM = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzawh = 3;
            this.zzaAM = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzx.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzaAN = activityDataSource;
            this.zzawh = 3;
            this.zzaAM = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzawh = 2;
            this.zzaAM = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.zzawh = 1;
            this.zzaAM = timeUnit.toMillis((long) duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.zzaAF.isEmpty() && this.zzawe.isEmpty() && this.zzaAL.isEmpty() && this.zzaAK.isEmpty()) ? false : true;
            zzx.zza(z2, (Object) "Must add at least one data source (aggregated or detailed)");
            zzx.zza(this.zzRD > 0, "Invalid start time: %s", Long.valueOf(this.zzRD));
            z2 = this.zzavV > 0 && this.zzavV > this.zzRD;
            zzx.zza(z2, "Invalid end time: %s", Long.valueOf(this.zzavV));
            z2 = this.zzaAL.isEmpty() && this.zzaAK.isEmpty();
            if (!(z2 && this.zzawh == 0) && (z2 || this.zzawh == 0)) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzaAQ = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzx.zzb(!this.zzaAL.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzaAK.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int limit) {
            zzx.zzb(limit > 0, "Invalid limit %d is specified", Integer.valueOf(limit));
            this.zzaAO = limit;
            return this;
        }

        public Builder setTimeRange(long start, long end, TimeUnit timeUnit) {
            this.zzRD = timeUnit.toMillis(start);
            this.zzavV = timeUnit.toMillis(end);
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, IBinder callback, List<Device> filteredDevices) {
        this.mVersionCode = versionCode;
        this.zzawe = dataTypes;
        this.zzaAF = dataSources;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzaAK = aggregatedDataTypes;
        this.zzaAL = aggregatedDataSources;
        this.zzawh = bucketType;
        this.zzaAM = bucketDurationMillis;
        this.zzaAN = activityDataSource;
        this.zzaAO = limit;
        this.zzaAP = flushBeforeRead;
        this.zzaAQ = serverQueriesEnabled;
        this.zzaAR = callback == null ? null : zza.zzbC(callback);
        if (filteredDevices == null) {
            filteredDevices = Collections.emptyList();
        }
        this.zzaAS = filteredDevices;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzawe, builder.zzaAF, builder.zzRD, builder.zzavV, builder.zzaAK, builder.zzaAL, builder.zzawh, builder.zzaAM, builder.zzaAN, builder.zzaAO, builder.zzaAP, builder.zzaAQ, null, builder.zzaAS);
    }

    public DataReadRequest(DataReadRequest request, zzoh callback) {
        this(request.zzawe, request.zzaAF, request.zzRD, request.zzavV, request.zzaAK, request.zzaAL, request.zzawh, request.zzaAM, request.zzaAN, request.zzaAO, request.zzaAP, request.zzaAQ, callback, request.zzaAS);
    }

    public DataReadRequest(List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, zzoh callback, List<Device> filteredDevices) {
        this(5, dataTypes, dataSources, startTimeMillis, endTimeMillis, aggregatedDataTypes, aggregatedDataSources, bucketType, bucketDurationMillis, activityDataSource, limit, flushBeforeRead, serverQueriesEnabled, callback == null ? null : callback.asBinder(), filteredDevices);
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzawe.equals(dataReadRequest.zzawe) && this.zzaAF.equals(dataReadRequest.zzaAF) && this.zzRD == dataReadRequest.zzRD && this.zzavV == dataReadRequest.zzavV && this.zzawh == dataReadRequest.zzawh && this.zzaAL.equals(dataReadRequest.zzaAL) && this.zzaAK.equals(dataReadRequest.zzaAK) && zzw.equal(this.zzaAN, dataReadRequest.zzaAN) && this.zzaAM == dataReadRequest.zzaAM && this.zzaAQ == dataReadRequest.zzaAQ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && zzb((DataReadRequest) that));
    }

    public DataSource getActivityDataSource() {
        return this.zzaAN;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzaAL;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzaAK;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaAM, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzawh;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAR == null ? null : this.zzaAR.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzaAO;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzawh), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.zzawe.isEmpty()) {
            for (DataType zzuo : this.zzawe) {
                stringBuilder.append(zzuo.zzuo()).append(" ");
            }
        }
        if (!this.zzaAF.isEmpty()) {
            for (DataSource toDebugString : this.zzaAF) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.zzawh != 0) {
            stringBuilder.append("bucket by ").append(Bucket.zzeM(this.zzawh));
            if (this.zzaAM > 0) {
                stringBuilder.append(" >").append(this.zzaAM).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.zzaAK.isEmpty()) {
            for (DataType zzuo2 : this.zzaAK) {
                stringBuilder.append(zzuo2.zzuo()).append(" ");
            }
        }
        if (!this.zzaAL.isEmpty()) {
            for (DataSource toDebugString2 : this.zzaAL) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Long.valueOf(this.zzavV)}));
        if (this.zzaAN != null) {
            stringBuilder.append("activities: ").append(this.zzaAN.toDebugString());
        }
        if (this.zzaAQ) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public boolean zzuQ() {
        return this.zzaAP;
    }

    public long zzuR() {
        return this.zzaAM;
    }

    public List<Device> zzuS() {
        return this.zzaAS;
    }

    public long zzud() {
        return this.zzavV;
    }
}
