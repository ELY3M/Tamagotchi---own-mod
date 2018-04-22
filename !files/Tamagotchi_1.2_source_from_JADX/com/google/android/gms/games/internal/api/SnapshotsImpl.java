package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {
        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult zzaD(final Status status) {
            return new CommitSnapshotResult(this) {
                final /* synthetic */ CommitImpl zzaHA;

                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaD(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {
        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult zzaE(final Status status) {
            return new DeleteSnapshotResult(this) {
                final /* synthetic */ DeleteImpl zzaHB;

                public String getSnapshotId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaE(status);
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadSnapshotsResult zzaF(final Status status) {
            return new LoadSnapshotsResult(this) {
                final /* synthetic */ LoadImpl zzaHC;

                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaF(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {
        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult zzaG(final Status status) {
            return new OpenSnapshotResult(this) {
                final /* synthetic */ OpenImpl zzaHD;

                public String getConflictId() {
                    return null;
                }

                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                public Snapshot getSnapshot() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaG(status);
        }
    }

    class C12476 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzacQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzacQ, this.zzaFQ, this.zzaFO);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, final Snapshot snapshot, final SnapshotMetadataChange metadataChange) {
        return apiClient.zzb(new CommitImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl zzaHq;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, snapshot, metadataChange);
            }
        });
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, final SnapshotMetadata metadata) {
        return apiClient.zzb(new DeleteImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl zzaHq;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzi((zzb) this, metadata.getSnapshotId());
            }
        });
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.zzh(apiClient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwQ();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwP();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.zzh(apiClient).zza(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        return (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl zzaHq;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata, int conflictPolicy) {
        return open(apiClient, metadata.getUniqueName(), false, conflictPolicy);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound) {
        return open(apiClient, fileName, createIfNotFound, -1);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound, int conflictPolicy) {
        final String str = fileName;
        final boolean z = createIfNotFound;
        final int i = conflictPolicy;
        return apiClient.zzb(new OpenImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl zzaHq;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, z, i);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, SnapshotContents snapshotContents) {
        final String str = conflictId;
        final String str2 = snapshotId;
        final SnapshotMetadataChange snapshotMetadataChange = metadataChange;
        final SnapshotContents snapshotContents2 = snapshotContents;
        return apiClient.zzb(new OpenImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl zzaHq;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, str2, snapshotMetadataChange, snapshotContents2);
            }
        });
    }
}
