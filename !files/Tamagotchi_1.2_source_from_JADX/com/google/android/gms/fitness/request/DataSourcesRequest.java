package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzoi.zza;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new zzh();
    private final int mVersionCode;
    private final List<Integer> zzaAV;
    private final boolean zzaAW;
    private final zzoi zzaAX;
    private final List<DataType> zzawe;

    public static class Builder {
        private boolean zzaAW = false;
        private DataType[] zzaAY = new DataType[0];
        private int[] zzaAZ = new int[]{0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            zzx.zza(this.zzaAY.length > 0, (Object) "Must add at least one data type");
            if (this.zzaAZ.length <= 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.zzaAZ = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzaAY = dataTypes;
            return this;
        }
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzawe = dataTypes;
        this.zzaAV = dataSourceTypes;
        this.zzaAW = includeDbOnlySources;
        this.zzaAX = zza.zzbD(callback);
    }

    private DataSourcesRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), Arrays.asList(zzmn.zza(builder.zzaAZ)), builder.zzaAW, null);
    }

    public DataSourcesRequest(DataSourcesRequest request, zzoi callback) {
        this(request.zzawe, request.zzaAV, request.zzaAW, callback);
    }

    public DataSourcesRequest(List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, zzoi callback) {
        this.mVersionCode = 4;
        this.zzawe = dataTypes;
        this.zzaAV = dataSourceTypes;
        this.zzaAW = includeDbOnlySources;
        this.zzaAX = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAX == null ? null : this.zzaAX.asBinder();
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzw.zza zzg = zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("sourceTypes", this.zzaAV);
        if (this.zzaAW) {
            zzg.zzg("includeDbOnlySources", "true");
        }
        return zzg.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public List<Integer> zzuT() {
        return this.zzaAV;
    }

    public boolean zzuU() {
        return this.zzaAW;
    }
}
