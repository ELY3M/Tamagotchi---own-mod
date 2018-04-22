package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class DataUpdateListenerRegistrationRequest implements SafeParcelable {
    public static final Creator<DataUpdateListenerRegistrationRequest> CREATOR = new zzk();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private DataType zzavT;
    private DataSource zzavU;

    public static class Builder {
        private PendingIntent mPendingIntent;
        private DataType zzavT;
        private DataSource zzavU;

        public DataUpdateListenerRegistrationRequest build() {
            boolean z = (this.zzavU == null && this.zzavT == null) ? false : true;
            zzx.zza(z, (Object) "Set either dataSource or dataTYpe");
            zzx.zzb(this.mPendingIntent, (Object) "pendingIntent must be set");
            return new DataUpdateListenerRegistrationRequest();
        }

        public Builder setDataSource(DataSource dataSource) throws NullPointerException {
            zzx.zzz(dataSource);
            this.zzavU = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            zzx.zzz(dataType);
            this.zzavT = dataType;
            return this;
        }

        public Builder setPendingIntent(PendingIntent pendingIntent) {
            zzx.zzz(pendingIntent);
            this.mPendingIntent = pendingIntent;
            return this;
        }
    }

    DataUpdateListenerRegistrationRequest(int versionCode, DataSource dataSource, DataType dataType, PendingIntent intent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.mPendingIntent = intent;
        this.zzaAD = zza.zzbR(callback);
    }

    public DataUpdateListenerRegistrationRequest(DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder callback) {
        this.mVersionCode = 1;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zza.zzbR(callback);
    }

    private DataUpdateListenerRegistrationRequest(Builder builder) {
        this(builder.zzavU, builder.zzavT, builder.mPendingIntent, null);
    }

    private boolean zzb(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return zzw.equal(this.zzavU, dataUpdateListenerRegistrationRequest.zzavU) && zzw.equal(this.zzavT, dataUpdateListenerRegistrationRequest.zzavT) && zzw.equal(this.mPendingIntent, dataUpdateListenerRegistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataUpdateListenerRegistrationRequest) && zzb((DataUpdateListenerRegistrationRequest) that));
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, this.zzavT, this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzk.zza(this, parcel, flags);
    }
}
