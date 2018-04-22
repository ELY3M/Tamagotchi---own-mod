package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza.zza;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new zzad();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final zzq zzaBA;
    private final int zzaBB;
    private final List<DataType> zzawe;

    public static class Builder {
        private DataType[] zzaAY = new DataType[0];
        private zzq zzaBA;
        private int zzaBB = 10;

        public StartBleScanRequest build() {
            zzx.zza(this.zzaBA != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.zzuJ().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzaAY = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            zzx.zzb(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            zzx.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzaBB = stopTimeSecs;
            return this;
        }

        public Builder zza(zzq com_google_android_gms_fitness_request_zzq) {
            this.zzaBA = com_google_android_gms_fitness_request_zzq;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzawe = dataTypes;
        this.zzaBA = zzq.zza.zzbU(bleScanCallback);
        this.zzaBB = timeoutSecs;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    private StartBleScanRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), builder.zzaBA, builder.zzaBB, null);
    }

    public StartBleScanRequest(StartBleScanRequest request, zzow callback) {
        this(request.zzawe, request.zzaBA, request.zzaBB, callback);
    }

    public StartBleScanRequest(List<DataType> dataTypes, zzq bleScanCallback, int timeoutSecs, zzow callback) {
        this.mVersionCode = 4;
        this.zzawe = dataTypes;
        this.zzaBA = bleScanCallback;
        this.zzaBB = timeoutSecs;
        this.zzaAD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzawe);
    }

    public int getTimeoutSecs() {
        return this.zzaBB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("timeoutSecs", Integer.valueOf(this.zzaBB)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzad.zza(this, parcel, flags);
    }

    public IBinder zzvg() {
        return this.zzaBA.asBinder();
    }
}
