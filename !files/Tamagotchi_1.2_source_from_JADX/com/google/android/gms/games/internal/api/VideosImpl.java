package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.games.video.Videos.VideoAvailableResult;
import com.google.android.gms.games.video.Videos.VideoCapabilitiesResult;

public final class VideosImpl implements Videos {

    class C10931 extends BaseGamesApiMethodImpl<Status> {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHU;
        final /* synthetic */ VideoConfiguration zzaHV;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((BaseGamesApiMethodImpl) this, this.zzaFQ, this.zzaHU, this.zzaHV);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class AvailableImpl extends BaseGamesApiMethodImpl<VideoAvailableResult> {
        public VideoAvailableResult zzaO(final Status status) {
            return new VideoAvailableResult(this) {
                final /* synthetic */ AvailableImpl zzaHW;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaO(status);
        }
    }

    private static abstract class CapabilitiesImpl extends BaseGamesApiMethodImpl<VideoCapabilitiesResult> {
        public VideoCapabilitiesResult zzaP(final Status status) {
            return new VideoCapabilitiesResult(this) {
                final /* synthetic */ CapabilitiesImpl zzaHX;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaP(status);
        }
    }

    private static abstract class ListImpl extends BaseGamesApiMethodImpl<ListVideosResult> {
        public ListVideosResult zzaQ(final Status status) {
            return new ListVideosResult(this) {
                final /* synthetic */ ListImpl zzaHY;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaQ(status);
        }
    }

    class C12582 extends CapabilitiesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    class C12593 extends AvailableImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    class C12604 extends ListImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }
}
