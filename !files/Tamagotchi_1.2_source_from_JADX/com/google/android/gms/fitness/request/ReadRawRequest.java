package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzos.zza;
import java.util.List;

public class ReadRawRequest implements SafeParcelable {
    public static final Creator<ReadRawRequest> CREATOR = new zzt();
    private final int mVersionCode;
    private final boolean zzaAP;
    private final boolean zzaAQ;
    private final zzos zzaBe;
    private final List<DataSourceQueryParams> zzaBf;

    ReadRawRequest(int versionCode, IBinder callback, List<DataSourceQueryParams> queryParams, boolean flushBufferBeforeRead, boolean serverQueriesEnabled) {
        this.mVersionCode = versionCode;
        this.zzaBe = zza.zzbN(callback);
        this.zzaBf = queryParams;
        this.zzaAP = flushBufferBeforeRead;
        this.zzaAQ = serverQueriesEnabled;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBe != null ? this.zzaBe.asBinder() : null;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzt.zza(this, parcel, flags);
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public boolean zzuQ() {
        return this.zzaAP;
    }

    public List<DataSourceQueryParams> zzuW() {
        return this.zzaBf;
    }
}
