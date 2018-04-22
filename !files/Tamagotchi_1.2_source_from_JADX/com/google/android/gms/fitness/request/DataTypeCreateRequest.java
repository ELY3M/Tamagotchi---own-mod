package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR = new zzi();
    private final String mName;
    private final int mVersionCode;
    private final zzoj zzaBa;
    private final List<Field> zzawE;

    public static class Builder {
        private String mName;
        private List<Field> zzawE = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzawE.contains(field)) {
                this.zzawE.add(field);
            }
            return this;
        }

        public Builder addField(String name, int format) {
            boolean z = (name == null || name.isEmpty()) ? false : true;
            zzx.zzb(z, (Object) "Invalid name specified");
            return addField(Field.zzn(name, format));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            zzx.zza(this.mName != null, (Object) "Must set the name");
            if (this.zzawE.isEmpty()) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }
    }

    DataTypeCreateRequest(int versionCode, String name, List<Field> fields, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzawE = Collections.unmodifiableList(fields);
        this.zzaBa = zza.zzbE(callback);
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzawE, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest request, zzoj callback) {
        this(request.mName, request.zzawE, callback);
    }

    public DataTypeCreateRequest(String name, List<Field> fields, zzoj callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzawE = Collections.unmodifiableList(fields);
        this.zzaBa = callback;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return zzw.equal(this.mName, dataTypeCreateRequest.mName) && zzw.equal(this.zzawE, dataTypeCreateRequest.zzawE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaBa == null ? null : this.zzaBa.asBinder();
    }

    public List<Field> getFields() {
        return this.zzawE;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzawE);
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("fields", this.zzawE).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
