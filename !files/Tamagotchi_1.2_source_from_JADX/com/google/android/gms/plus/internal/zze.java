package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze extends zzj<zzd> {
    private Person zzbei;
    private final PlusSession zzbej;

    static final class zza implements LoadMomentsResult {
        private final Status zzUX;
        private final String zzbek;
        private final String zzbel;
        private final MomentBuffer zzbem;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzUX = status;
            this.zzbek = str;
            this.zzbel = str2;
            this.zzbem = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzbem;
        }

        public String getNextPageToken() {
            return this.zzbek;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public String getUpdated() {
            return this.zzbel;
        }

        public void release() {
            if (this.zzbem != null) {
                this.zzbem.release();
            }
        }
    }

    static final class zzb implements LoadPeopleResult {
        private final Status zzUX;
        private final String zzbek;
        private final PersonBuffer zzben;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzUX = status;
            this.zzbek = str;
            this.zzben = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzbek;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzben;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzben != null) {
                this.zzben.release();
            }
        }
    }

    static final class zzc extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzaON;

        public zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzaON = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzbe(Status status) {
            this.zzaON.zzs(status);
        }
    }

    static final class zzd extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadMomentsResult> zzaON;

        public zzd(com.google.android.gms.common.api.internal.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
            this.zzaON = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpZ() != null ? (PendingIntent) dataHolder.zzpZ().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaON.zzs(new zza(status, dataHolder, str, str2));
        }
    }

    static final class zze extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> zzaON;

        public zze(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
            this.zzaON = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpZ() != null ? (PendingIntent) dataHolder.zzpZ().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaON.zzs(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzaON;

        public zzf(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzaON = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzi(int i, Bundle bundle) {
            this.zzaON.zzs(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, PlusSession plusSession, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzbej = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        return (set == null || set.isEmpty()) ? false : (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    public String getAccountName() {
        zzqI();
        try {
            return ((zzd) zzqJ()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzEY() {
        zzqI();
        try {
            this.zzbei = null;
            ((zzd) zzqJ()).zzEY();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzFa() {
        zzqI();
        return this.zzbei;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdS(iBinder);
    }

    public zzq zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, int i, String str) {
        zzqI();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            return ((zzd) zzqJ()).zza(com_google_android_gms_plus_internal_zze_zze, 1, i, -1, str);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbI(8), null);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzbei = PersonEntity.zzv(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, int i, String str, Uri uri, String str2, String str3) {
        zzqI();
        Object com_google_android_gms_plus_internal_zze_zzd = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult != null ? new zzd(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) : null;
        try {
            ((zzd) zzqJ()).zza(com_google_android_gms_plus_internal_zze_zzd, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzd.zza(DataHolder.zzbI(8), null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, Moment moment) {
        zzqI();
        zzb com_google_android_gms_plus_internal_zze_zzc = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status != null ? new zzc(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) : null;
        try {
            ((zzd) zzqJ()).zza(com_google_android_gms_plus_internal_zze_zzc, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (Throwable e) {
            if (com_google_android_gms_plus_internal_zze_zzc == null) {
                throw new IllegalStateException(e);
            }
            com_google_android_gms_plus_internal_zze_zzc.zzbe(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Collection<String> collection) {
        zzqI();
        zzb com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzqJ()).zza(com_google_android_gms_plus_internal_zze_zze, new ArrayList(collection));
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbI(8), null);
        }
    }

    public void zzd(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String[] strArr) {
        zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Arrays.asList(strArr));
    }

    protected zzd zzdS(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdR(iBinder);
    }

    public void zzfG(String str) {
        zzqI();
        try {
            ((zzd) zzqJ()).zzfG(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected String zzgu() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public boolean zzmE() {
        return zzd(zzqH().zzb(Plus.API));
    }

    protected Bundle zzml() {
        Bundle zzFk = this.zzbej.zzFk();
        zzFk.putStringArray("request_visible_actions", this.zzbej.zzFe());
        zzFk.putString("auth_package", this.zzbej.zzFg());
        return zzFk;
    }

    public void zzo(com.google.android.gms.common.api.internal.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
        zza(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, 20, null, null, null, "me");
    }

    public void zzp(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
        zzqI();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzqJ()).zza(com_google_android_gms_plus_internal_zze_zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbI(8), null);
        }
    }

    public zzq zzq(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String str) {
        return zza(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, 0, str);
    }

    public void zzq(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
        zzqI();
        zzEY();
        Object com_google_android_gms_plus_internal_zze_zzf = new zzf(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        try {
            ((zzd) zzqJ()).zzb(com_google_android_gms_plus_internal_zze_zzf);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzf.zzi(8, null);
        }
    }
}
