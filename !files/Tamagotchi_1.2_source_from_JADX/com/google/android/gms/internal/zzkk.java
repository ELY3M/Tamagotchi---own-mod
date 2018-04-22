package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzkk implements zzk, AppIndexApi {

    @Deprecated
    private static final class zza implements ActionResult {
        private zzkk zzUD;
        private PendingResult<Status> zzUE;
        private Action zzUF;

        zza(zzkk com_google_android_gms_internal_zzkk, PendingResult<Status> pendingResult, Action action) {
            this.zzUD = com_google_android_gms_internal_zzkk;
            this.zzUE = pendingResult;
            this.zzUF = action;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = apiClient.getContext().getPackageName();
            UsageInfo zza = zzkj.zza(this.zzUF, System.currentTimeMillis(), packageName, 2);
            return this.zzUD.zza(apiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzUE;
        }
    }

    private static abstract class zzb<T extends Result> extends com.google.android.gms.common.api.internal.zza.zza<T, zzki> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzTy, googleApiClient);
        }

        protected abstract void zza(zzkf com_google_android_gms_internal_zzkf) throws RemoteException;

        protected final void zza(zzki com_google_android_gms_internal_zzki) throws RemoteException {
            zza(com_google_android_gms_internal_zzki.zzmj());
        }
    }

    private static final class zzd extends zzkh<Status> {
        public zzd(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(Status status) {
            this.zzUz.zzs(status);
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        if (zzk(uri)) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        if (zzl(uri)) {
            return new Intent("android.intent.action.VIEW", zzj(uri));
        }
        throw new RuntimeException("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: " + uri);
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzkj.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        if (zzk(uri)) {
            if (uri.getHost().isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The web URL must have a host (follow the format http(s)://<host>/[path]). Provided URI: " + uri);
            }
        } else if (!zzl(uri)) {
            throw new IllegalArgumentException("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/[host_path]'. Provided URI: " + uri);
        } else if (str == null || str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
            }
        } else {
            throw new IllegalArgumentException("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/[host_path]. Provided URI: " + uri);
        }
    }

    private static Uri zzj(Uri uri) {
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return builder.build();
    }

    private static boolean zzk(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    private static boolean zzl(Uri uri) {
        return "android-app".equals(uri.getScheme());
    }

    public static void zzt(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        return new zza(this, zza(apiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzt(outLinks);
        return zza(apiClient, new UsageInfo(packageName, viewIntent, title, webUrl, null, outLinks, 1));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzb(packageName, appIndexingUrl);
        return view(apiClient, activity, zza(packageName, appIndexingUrl), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        String packageName = apiClient.getContext().getPackageName();
        return zza(apiClient, new com.google.android.gms.appdatasearch.UsageInfo.zza().zza(UsageInfo.zza(packageName, viewIntent)).zzw(System.currentTimeMillis()).zzar(0).zzas(2).zzmi());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appUri) {
        return viewEnd(apiClient, activity, zza(apiClient.getContext().getPackageName(), appUri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final UsageInfo... usageInfoArr) {
        final String packageName = googleApiClient.getContext().getPackageName();
        return googleApiClient.zza(new zzc<Status>(this, googleApiClient) {
            final /* synthetic */ zzkk zzUC;

            protected void zza(zzkf com_google_android_gms_internal_zzkf) throws RemoteException {
                com_google_android_gms_internal_zzkf.zza(new zzd(this), packageName, usageInfoArr);
            }
        });
    }
}
