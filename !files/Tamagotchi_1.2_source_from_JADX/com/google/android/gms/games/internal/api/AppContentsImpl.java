package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        public LoadAppContentResult zzae(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl zzaFZ;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzae(status);
        }
    }

    class C11971 extends LoadsImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaFW;
        final /* synthetic */ String zzaFX;
        final /* synthetic */ String[] zzaFY;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFW, this.zzaFX, this.zzaFY, this.zzaFO);
        }
    }
}
