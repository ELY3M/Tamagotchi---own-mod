package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzqz implements People {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadPeopleResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult zzbg(final Status status) {
            return new LoadPeopleResult(this) {
                final /* synthetic */ zza zzbeL;

                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbg(status);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzFa();
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzqz zzbeI;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zza((zzb) this, personIds);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzqz zzbeI;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zzd(this, personIds);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzqz zzbeI;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zzp(this);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzqz zzbeI;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                zza(com_google_android_gms_plus_internal_zze.zza(this, orderBy, pageToken));
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzqz zzbeI;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                zza(com_google_android_gms_plus_internal_zze.zzq(this, pageToken));
            }
        });
    }
}
