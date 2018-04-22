package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzx implements DataApi {

    public static class zza implements DataItemResult {
        private final Status zzUX;
        private final DataItem zzbsv;

        public zza(Status status, DataItem dataItem) {
            this.zzUX = status;
            this.zzbsv = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzbsv;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements DeleteDataItemsResult {
        private final Status zzUX;
        private final int zzbsw;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzbsw = i;
        }

        public int getNumDeleted() {
            return this.zzbsw;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzc implements GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzUX;
        private volatile InputStream zzbsh;
        private volatile ParcelFileDescriptor zzbsx;

        public zzc(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzUX = status;
            this.zzbsx = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzbsx;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzbsx == null) {
                return null;
            } else {
                if (this.zzbsh == null) {
                    this.zzbsh = new AutoCloseInputStream(this.zzbsx);
                }
                return this.zzbsh;
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsx != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzbsh != null) {
                        this.zzbsh.close();
                    } else {
                        this.zzbsx.close();
                    }
                    this.mClosed = true;
                    this.zzbsx = null;
                    this.zzbsh = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), dataListener);
    }

    private static zza<DataListener> zza(final IntentFilter[] intentFilterArr) {
        return new zza<DataListener>() {
            public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, DataListener dataListener, zzq<DataListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, dataListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener, intentFilterArr);
            }
        };
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, new IntentFilter[]{zzbn.zzgM(DataApi.ACTION_DATA_CHANGED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener, Uri uri, int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(DataApi.ACTION_DATA_CHANGED, uri, filterType)});
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (filterType == 0 || filterType == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return client.zza(new zzi<DeleteDataItemsResult>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zzb(this, uri, filterType);
            }

            protected DeleteDataItemsResult zzbx(Status status) {
                return new zzb(status, 0);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbx(status);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzi<DataItemResult>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, uri);
            }

            protected DataItemResult zzbv(Status status) {
                return new zza(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbv(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzi<DataItemBuffer>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zzr(this);
            }

            protected DataItemBuffer zzbw(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbw(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (filterType == 0 || filterType == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return client.zza(new zzi<DataItemBuffer>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, uri, filterType);
            }

            protected DataItemBuffer zzbw(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbw(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzi<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzby(Status status) {
                return new zzc(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzby(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzi<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzby(Status status) {
                return new zzc(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzby(status);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzi<DataItemResult>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, request);
            }

            public DataItemResult zzbv(Status status) {
                return new zza(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbv(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ zzx zzbsq;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }
}
