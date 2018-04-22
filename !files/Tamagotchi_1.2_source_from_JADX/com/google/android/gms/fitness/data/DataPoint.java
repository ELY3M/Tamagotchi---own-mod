package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzns;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR = new zzd();
    private final int mVersionCode;
    private final DataSource zzavU;
    private long zzawj;
    private long zzawk;
    private final Value[] zzawl;
    private DataSource zzawm;
    private long zzawn;
    private long zzawo;

    DataPoint(int versionCode, DataSource dataSource, long timestampNanos, long startTimeNanos, Value[] values, DataSource originalDataSource, long rawTimestamp, long insertionTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzawm = originalDataSource;
        this.zzawj = timestampNanos;
        this.zzawk = startTimeNanos;
        this.zzawl = values;
        this.zzawn = rawTimestamp;
        this.zzawo = insertionTimeMillis;
    }

    private DataPoint(DataSource dataSource) {
        this.mVersionCode = 4;
        this.zzavU = (DataSource) zzx.zzb((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzawl = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zzawl[i] = new Value(format.getFormat());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource originalDataSource, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzawj), 0), zza(Long.valueOf(rawDataPoint.zzawk), 0), rawDataPoint.zzawl, originalDataSource, zza(Long.valueOf(rawDataPoint.zzawn), 0), zza(Long.valueOf(rawDataPoint.zzawo), 0));
    }

    DataPoint(List<DataSource> dataSources, RawDataPoint rawDataPoint) {
        this(zza((List) dataSources, rawDataPoint.zzaxg), zza((List) dataSources, rawDataPoint.zzaxh), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource zza(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private boolean zza(DataPoint dataPoint) {
        return zzw.equal(this.zzavU, dataPoint.zzavU) && this.zzawj == dataPoint.zzawj && this.zzawk == dataPoint.zzawk && Arrays.equals(this.zzawl, dataPoint.zzawl) && zzw.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource());
    }

    private void zzeO(int i) {
        zzx.zzb(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    private boolean zzue() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof DataPoint) && zza((DataPoint) o));
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavU.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawj, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzawm != null ? this.zzawm : this.zzavU;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawk, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawj, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzawj;
    }

    public Value getValue(Field field) {
        return this.zzawl[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, Long.valueOf(this.zzawj), Long.valueOf(this.zzawk));
    }

    public DataPoint setFloatValues(float... values) {
        zzeO(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzawl[i].setFloat(values[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... values) {
        zzeO(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzawl[i].setInt(values[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
        this.zzawk = timeUnit.toNanos(startTime);
        this.zzawj = timeUnit.toNanos(endTime);
        return this;
    }

    public DataPoint setTimestamp(long timestamp, TimeUnit timeUnit) {
        this.zzawj = timeUnit.toNanos(timestamp);
        if (zzue() && zzns.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzawj = zzns.zza(this.zzawj, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzawl);
        objArr[1] = Long.valueOf(this.zzawk);
        objArr[2] = Long.valueOf(this.zzawj);
        objArr[3] = Long.valueOf(this.zzawn);
        objArr[4] = Long.valueOf(this.zzawo);
        objArr[5] = this.zzavU.toDebugString();
        objArr[6] = this.zzawm != null ? this.zzawm.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd.zza(this, parcel, flags);
    }

    public Value[] zzuf() {
        return this.zzawl;
    }

    public long zzug() {
        return this.zzawn;
    }

    public long zzuh() {
        return this.zzawo;
    }

    public void zzui() {
        zzx.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzx.zzb(this.zzawj > 0, "Data point does not have the timestamp set: %s", this);
        zzx.zzb(this.zzawk <= this.zzawj, "Data point with start time greater than end time found: %s", this);
    }

    public long zzuj() {
        return this.zzawk;
    }
}
