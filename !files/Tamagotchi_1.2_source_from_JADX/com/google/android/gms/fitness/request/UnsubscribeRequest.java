package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class UnsubscribeRequest implements SafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR = new zzah();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final DataType zzavT;
    private final DataSource zzavU;

    UnsubscribeRequest(int versionCode, DataType dataType, DataSource dataSource, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavT = dataType;
        this.zzavU = dataSource;
        this.zzaAD = zza.zzbR(callback);
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzow callback) {
        this.mVersionCode = 3;
        this.zzavT = dataType;
        this.zzavU = dataSource;
        this.zzaAD = callback;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return zzw.equal(this.zzavU, unsubscribeRequest.zzavU) && zzw.equal(this.zzavT, unsubscribeRequest.zzavT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) o));
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

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, this.zzavT);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzah.zza(this, parcel, flags);
    }
}
