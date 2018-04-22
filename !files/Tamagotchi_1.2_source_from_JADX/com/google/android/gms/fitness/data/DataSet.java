package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR = new zze();
    private final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private boolean zzawi;
    private final List<DataPoint> zzawp;
    private final List<DataSource> zzawq;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzawi = false;
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzavT = dataSource.getDataType();
        this.zzawi = serverHasMoreData;
        this.zzawp = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.zzawq = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.zzawp.add(new DataPoint(this.zzawq, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzx.zzz(dataSource);
        this.zzavT = dataSource.getDataType();
        this.zzawp = new ArrayList();
        this.zzawq = new ArrayList();
        this.zzawq.add(this.zzavU);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzb(uniqueDataSources, dataSet.zzaxg);
        this.zzavT = this.zzavU.getDataType();
        this.zzawq = uniqueDataSources;
        this.zzawi = dataSet.zzawi;
        List<RawDataPoint> list = dataSet.zzaxj;
        this.zzawp = new ArrayList(list.size());
        for (RawDataPoint dataPoint : list) {
            this.zzawp.add(new DataPoint(this.zzawq, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzavU, dataSet.zzavU) && zzw.equal(this.zzawp, dataSet.zzawp) && this.zzawi == dataSet.zzawi;
    }

    private static <T> T zzb(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public void add(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.getDataSource(), this.zzavU};
        zzx.zzb(dataPoint.getDataSource().getStreamIdentifier().equals(this.zzavU.getStreamIdentifier()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.zzui();
        zznw.zze(dataPoint);
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzavU);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzawp);
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavU.getDataType();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU);
    }

    public boolean isEmpty() {
        return this.zzawp.isEmpty();
    }

    public String toString() {
        List zzuk = zzuk();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzavU.toDebugString();
        if (this.zzawp.size() >= 10) {
            zzuk = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzawp.size()), zzuk.subList(0, 5)});
        }
        objArr[1] = zzuk;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzawp.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzawq.contains(originalDataSource)) {
            this.zzawq.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    public boolean zzuc() {
        return this.zzawi;
    }

    List<RawDataPoint> zzuk() {
        return zzv(this.zzawq);
    }

    List<DataSource> zzul() {
        return this.zzawq;
    }

    List<RawDataPoint> zzv(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.zzawp.size());
        for (DataPoint rawDataPoint : this.zzawp) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }
}
