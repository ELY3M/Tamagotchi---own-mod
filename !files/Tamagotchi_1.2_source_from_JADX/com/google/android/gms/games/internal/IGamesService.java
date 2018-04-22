package com.google.android.gms.games.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import java.util.List;

public interface IGamesService extends IInterface {

    public static abstract class Stub extends Binder implements IGamesService {

        private static class Proxy implements IGamesService {
            private IBinder zzoz;

            Proxy(IBinder remote) {
                this.zzoz = remote;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zzE(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzF(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.zzoz.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzF(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(8025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzG(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.zzoz.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzH(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.zzoz.transact(8013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzI(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzJ(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.zzoz.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzK(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.zzoz.transact(15502, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zza(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(int i, byte[] bArr, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.zzoz.transact(10012, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(PlayerEntity playerEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (playerEntity != null) {
                        obtain.writeInt(1);
                        playerEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(15503, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(AchievementEntity achievementEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (achievementEntity != null) {
                        obtain.writeInt(1);
                        achievementEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13005, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(ZInvitationCluster zInvitationCluster, Account account, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        obtain.writeInt(1);
                        zInvitationCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zzoz.transact(21006, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        obtain.writeInt(1);
                        zInvitationCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(10021, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(GameRequestCluster gameRequestCluster, Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        obtain.writeInt(1);
                        gameRequestCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(21005, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(GameRequestCluster gameRequestCluster, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        obtain.writeInt(1);
                        gameRequestCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zzoz.transact(10022, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(RoomEntity roomEntity, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        obtain.writeInt(1);
                        roomEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(9011, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.zzoz.transact(SafetyNetStatusCodes.SAFE_BROWSING_MISSING_API_KEY, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(ParticipantEntity[] participantEntityArr, Account account, String str, Uri uri, Uri uri2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.zzoz.transact(21004, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9031, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    this.zzoz.transact(14003, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(10016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.zzoz.transact(10009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.zzoz.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i, String str, String[] strArr, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(14002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(FitnessStatusCodes.INCONSISTENT_PACKAGE_NAME, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.zzoz.transact(10018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.zzoz.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(8018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.zzoz.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.zzoz.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.DISABLED_BLUETOOTH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(10011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.zzoz.transact(FitnessStatusCodes.DATASET_TIMESTAMP_INCONSISTENT_WITH_UPDATE_TIME_RANGE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(8023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.zzoz.transact(10019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzoz.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.zzoz.transact(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (snapshotMetadataChangeEntity != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChangeEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(8001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.zzoz.transact(10010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.zzoz.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(9028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (snapshotMetadataChangeEntity != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChangeEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, VideoConfiguration videoConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (videoConfiguration != null) {
                        obtain.writeInt(1);
                        videoConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(19003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_INVALID_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z, int i) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.zzoz.transact(15001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str2);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.zzoz.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.zzoz.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.zzoz.transact(8017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(12031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    this.zzoz.transact(8003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(12010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesClient iGamesClient, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesClient != null ? iGamesClient.asBinder() : null);
                    obtain.writeLong(j);
                    this.zzoz.transact(15501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(21003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(20001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzai(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaj(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzak(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzb(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.zzoz.transact(PlacesStatusCodes.INVALID_APP, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzb(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeIntArray(iArr);
                    this.zzoz.transact(12030, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(8019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.zzoz.transact(8012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(8020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.DATA_SOURCE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(12023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.zzoz.transact(FitnessStatusCodes.INVALID_SESSION_TIMESTAMPS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(10017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.zzoz.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(12018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(15002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzc(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.zzoz.transact(9009, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(8021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.zzoz.transact(10001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(12024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(PlacesStatusCodes.USAGE_LIMIT_EXCEEDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(8011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(8027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(10020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.zzoz.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(9020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(8015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzdI(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(12034, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzdK(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzdL(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzdM(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzdN(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Uri zzdO(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return uri;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzdP(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(8002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzdQ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(PlacesStatusCodes.INVALID_ARGUMENT, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor zzdR(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(9030, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Account zzdS(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.zzoz.transact(21002, obtain, obtain2, 0);
                    obtain2.readException();
                    Account account = obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return account;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.zzoz.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(12021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(8016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(8026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(12022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(12009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(13006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(13003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgt(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    this.zzoz.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public RoomEntity zzh(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                RoomEntity roomEntity = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        roomEntity = (RoomEntity) RoomEntity.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return roomEntity;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(13004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(17001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(19001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(19004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzm(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(18001, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(21007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor zzn(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(21008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(21009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zzoi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(8014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzq(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(PlacesStatusCodes.KEY_INVALID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzq(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzr(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(12020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzr(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzs(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzt(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(12027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzt(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzu(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzu(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(10014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzv(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(14001, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.RATE_LIMIT_EXCEEDED, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.DEVICE_RATE_LIMIT_EXCEEDED, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.KEY_EXPIRED, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9010, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9012, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzwJ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9019, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzwK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzwL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(8024, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(10015, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzwN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(10013, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzwO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(10023, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzwP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(12035, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzwQ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(12036, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzwR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzwT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.AGGREGATION_NOT_SUPPORTED, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DataHolder zzwU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.UNSUPPORTED_ACCOUNT, obtain, obtain2, 0);
                    obtain2.readException();
                    DataHolder zzak = obtain2.readInt() != 0 ? DataHolder.CREATOR.zzak(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzak;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzwV() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(5067, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DataHolder zzwW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    DataHolder zzak = obtain2.readInt() != 0 ? DataHolder.CREATOR.zzak(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzak;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzwX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(8022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9013, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzwZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(11002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzww() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzwz() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.ACCESS_NOT_CONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzxa() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(12025, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzxb() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(15504, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzxc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(16001, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent zzxd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(19002, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Account zzxe() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(21001, obtain, obtain2, 0);
                    obtain2.readException();
                    Account account = obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return account;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List zzxf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(21010, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        public static IGamesService zzbY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesService)) ? new Proxy(iBinder) : (IGamesService) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ZInvitationCluster zInvitationCluster = null;
            boolean z = false;
            String zzwK;
            DataHolder zzwU;
            IGamesCallbacks zzbW;
            int readInt;
            boolean z2;
            int readInt2;
            int zza;
            String readString;
            String readString2;
            int readInt3;
            int readInt4;
            IGamesCallbacks zzbW2;
            String readString3;
            int i;
            ParcelFileDescriptor zzn;
            Intent zzwz;
            Account zzxe;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzF(data.readLong());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwK = zzwK();
                    reply.writeNoException();
                    reply.writeString(zzwK);
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Bundle zzoi = zzoi();
                    reply.writeNoException();
                    if (zzoi != null) {
                        reply.writeInt(1);
                        zzoi.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwR();
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwK = zzww();
                    reply.writeNoException();
                    reply.writeString(zzwK);
                    return true;
                case FitnessStatusCodes.AGGREGATION_NOT_SUPPORTED /*5012*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwK = zzwT();
                    reply.writeNoException();
                    reply.writeString(zzwK);
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_ACCOUNT /*5013*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwU = zzwU();
                    reply.writeNoException();
                    if (zzwU != null) {
                        reply.writeInt(1);
                        zzwU.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case FitnessStatusCodes.DISABLED_BLUETOOTH /*5014*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_PACKAGE_NAME /*5015*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 5017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_SOURCE_NOT_FOUND /*5018*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATASET_TIMESTAMP_INCONSISTENT_WITH_UPDATE_TIME_RANGE /*5019*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.INVALID_SESSION_TIMESTAMPS /*5020*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzr(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzq(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5030:
                    Bundle bundle;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks zzbW3 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    IBinder readStrongBinder = data.readStrongBinder();
                    readInt2 = data.readInt();
                    String[] createStringArray = data.createStringArray();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW3, readStrongBinder, readInt2, createStringArray, bundle, z, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readStrongBinder(), data.readString(), data.readInt() != 0, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.createByteArray(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 5034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzb(data.createByteArray(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 5035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwK = zzdL(data.readString());
                    reply.writeNoException();
                    reply.writeString(zzwK);
                    return true;
                case 5036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzgt(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5037:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5038:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5039:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    readInt2 = data.readInt();
                    readInt3 = data.readInt();
                    readInt4 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW, readString, readString2, readInt2, readInt3, readInt4, z);
                    reply.writeNoException();
                    return true;
                case 5040:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    readInt2 = data.readInt();
                    readInt3 = data.readInt();
                    readInt4 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzbW, readString, readString2, readInt2, readInt3, readInt4, z);
                    reply.writeNoException();
                    return true;
                case 5041:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5042:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5043:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5044:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5045:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5046:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzbW, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5047:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5048:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzc(zzbW, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5049:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzg(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5050:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzdM(data.readString());
                    reply.writeNoException();
                    return true;
                case 5051:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5052:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzg(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5053:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity zzh = zzh(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    if (zzh != null) {
                        reply.writeInt(1);
                        zzh.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5054:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, readString3, z);
                    reply.writeNoException();
                    return true;
                case 5055:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzt(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5056:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzh(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5057:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzj(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5058:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 5059:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzG(data.readLong());
                    reply.writeNoException();
                    return true;
                case 5060:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzdN(data.readString());
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 5061:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzi(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5062:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzi(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5063:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW, z, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5064:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwK = zzdK(data.readString());
                    reply.writeNoException();
                    reply.writeString(zzwK);
                    return true;
                case 5065:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzE(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5066:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri zzdO = zzdO(data.readString());
                    reply.writeNoException();
                    if (zzdO != null) {
                        reply.writeInt(1);
                        zzdO.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5067:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    z2 = zzwV();
                    reply.writeNoException();
                    if (z2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 5068:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzai(z);
                    reply.writeNoException();
                    return true;
                case 5501:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5502:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwU = zzwW();
                    reply.writeNoException();
                    if (zzwU != null) {
                        reply.writeInt(1);
                        zzwU.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*6002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED /*6003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzd(zzbW, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION /*6004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zze(zzbW, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH /*6501*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString = data.readString();
                    int readInt5 = data.readInt();
                    boolean z3 = data.readInt() != 0;
                    boolean z4 = data.readInt() != 0;
                    boolean z5 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW, readString, readInt5, z3, z4, z5, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE /*6502*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzbW2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /*6503*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /*6504*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzc(zzbW2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED /*6505*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzd(zzbW2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_NOT_FOUND /*6506*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzbW2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED /*6507*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzn = zzn(data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzn != null) {
                        reply.writeInt(1);
                        zzn.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED /*7001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzk(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID /*7002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED /*7003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 8001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzdP(data.readString());
                    reply.writeNoException();
                    return true;
                case 8003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED /*8004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt(), data.readInt(), data.createStringArray(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT /*8005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzl(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzm(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.createByteArray(), data.readString(), (ParticipantResult[]) data.createTypedArray(ParticipantResult.CREATOR));
                    reply.writeNoException();
                    return true;
                case 8008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.createByteArray(), (ParticipantResult[]) data.createTypedArray(ParticipantResult.CREATOR));
                    reply.writeNoException();
                    return true;
                case 8009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzn(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzo(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 8013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzH(data.readLong());
                    reply.writeNoException();
                    return true;
                case 8014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzp(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 8018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwX();
                    reply.writeNoException();
                    return true;
                case 8023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, readString3, readInt, z);
                    reply.writeNoException();
                    return true;
                case 8024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzwL();
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 8025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzF(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzc(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case PlacesStatusCodes.USAGE_LIMIT_EXCEEDED /*9001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case PlacesStatusCodes.KEY_INVALID /*9002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzq(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case PlacesStatusCodes.ACCESS_NOT_CONFIGURED /*9003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwz();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case PlacesStatusCodes.INVALID_ARGUMENT /*9004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzdQ(data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case PlacesStatusCodes.RATE_LIMIT_EXCEEDED /*9005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwA();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case PlacesStatusCodes.DEVICE_RATE_LIMIT_EXCEEDED /*9006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwB();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case PlacesStatusCodes.KEY_EXPIRED /*9007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwC();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case PlacesStatusCodes.INVALID_APP /*9008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzb(data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzc(data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwH();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readInt() != 0 ? (RoomEntity) RoomEntity.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwI();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwY();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzwJ();
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 9020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzn = zzdR(data.readString());
                    reply.writeNoException();
                    if (zzn != null) {
                        reply.writeInt(1);
                        zzn.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza((ParticipantEntity[]) data.createTypedArray(ParticipantEntity.CREATOR), data.readString(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzI(data.readLong());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.createStringArray(), data.readInt(), data.createByteArray(), data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /*10006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED /*10007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_INVALID_ROOM /*10008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 10009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readInt(), data.createByteArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzwN();
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 10014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzu(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzwM();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzbW2, readString3, readInt, z);
                    reply.writeNoException();
                    return true;
                case 10018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 10019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 10020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 10021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        zInvitationCluster = ZInvitationCluster.CREATOR.zzeo(data);
                    }
                    zzwz = zza(zInvitationCluster, data.readString(), data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10022:
                    GameRequestCluster zzeq;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        zzeq = GameRequestCluster.CREATOR.zzeq(data);
                    }
                    zzwz = zza(zzeq, data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzwO();
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 11001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzj(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwZ();
                    reply.writeNoException();
                    return true;
                case SafetyNetStatusCodes.SAFE_BROWSING_MISSING_API_KEY /*12001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readString(), data.readInt() != 0, data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzd(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case 12003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzc(zzbW2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case 12005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzs(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zze(zzbW2, readString3, z);
                    reply.writeNoException();
                    return true;
                case 12007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? SnapshotMetadataChangeEntity.CREATOR.zzeC(data) : null, data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzu(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    int[] createIntArray = data.createIntArray();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, createIntArray, readInt, z);
                    reply.writeNoException();
                    return true;
                case 12011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 12012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzJ(data.readLong());
                    reply.writeNoException();
                    return true;
                case 12013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.createIntArray(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzf(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case 12017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzp(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 12018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzr(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 12024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 12025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    z2 = zzxa();
                    reply.writeNoException();
                    if (z2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 12026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzaj(z);
                    reply.writeNoException();
                    return true;
                case 12027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzt(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    String[] createStringArray2 = data.createStringArray();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, createStringArray2, z);
                    reply.writeNoException();
                    return true;
                case 12030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzb(data.createIntArray());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, z, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 12032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zze(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case 12033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0 ? SnapshotMetadataChangeEntity.CREATOR.zzeC(data) : null, data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzdI(data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzwP();
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 12036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza = zzwQ();
                    reply.writeNoException();
                    reply.writeInt(zza);
                    return true;
                case 13001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzak(z);
                    reply.writeNoException();
                    return true;
                case 13002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 13003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzg(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case 13004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzh(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case 13005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readInt() != 0 ? (AchievementEntity) AchievementEntity.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 13006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzf(zzbW2, readString3, z);
                    reply.writeNoException();
                    return true;
                case 14001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzv(data.readString(), data.readInt());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 14002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readInt(), data.readString(), data.createStringArray(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 14003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza((ParticipantEntity[]) data.createTypedArray(ParticipantEntity.CREATOR), data.readString(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 15001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbW2, readString3, z, data.readInt());
                    reply.writeNoException();
                    return true;
                case 15002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 15501:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesClient.Stub.zzbX(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 15502:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzK(data.readLong());
                    reply.writeNoException();
                    return true;
                case 15503:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readInt() != 0 ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 15504:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzxb();
                    reply.writeNoException();
                    return true;
                case 16001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzxc();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 17001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzbW2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzi(zzbW2, z);
                    reply.writeNoException();
                    return true;
                case 18001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzm(data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 19001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzk(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zzxd();
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 19003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0 ? (VideoConfiguration) VideoConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 19004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzl(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(data.readString(), com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzxe = zzxe();
                    reply.writeNoException();
                    if (zzxe != null) {
                        reply.writeInt(1);
                        zzxe.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 21002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzxe = zzdS(data.readString());
                    reply.writeNoException();
                    if (zzxe != null) {
                        reply.writeInt(1);
                        zzxe.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 21003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(data.readString(), data.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 21004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza((ParticipantEntity[]) data.createTypedArray(ParticipantEntity.CREATOR), data.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(data) : null, data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 21005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readInt() != 0 ? GameRequestCluster.CREATOR.zzeq(data) : null, data.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 21006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwz = zza(data.readInt() != 0 ? ZInvitationCluster.CREATOR.zzeo(data) : null, data.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    if (zzwz != null) {
                        reply.writeInt(1);
                        zzwz.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 21007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzm(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzn(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzo(com.google.android.gms.games.internal.IGamesCallbacks.Stub.zzbW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    List zzxf = zzxf();
                    reply.writeNoException();
                    reply.writeList(zzxf);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzE(String str, String str2) throws RemoteException;

    void zzF(long j) throws RemoteException;

    void zzF(String str, String str2) throws RemoteException;

    void zzG(long j) throws RemoteException;

    void zzH(long j) throws RemoteException;

    void zzI(long j) throws RemoteException;

    void zzJ(long j) throws RemoteException;

    void zzK(long j) throws RemoteException;

    int zza(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException;

    Intent zza(int i, byte[] bArr, int i2, String str) throws RemoteException;

    Intent zza(PlayerEntity playerEntity) throws RemoteException;

    Intent zza(AchievementEntity achievementEntity) throws RemoteException;

    Intent zza(ZInvitationCluster zInvitationCluster, Account account, String str) throws RemoteException;

    Intent zza(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException;

    Intent zza(GameRequestCluster gameRequestCluster, Account account) throws RemoteException;

    Intent zza(GameRequestCluster gameRequestCluster, String str) throws RemoteException;

    Intent zza(RoomEntity roomEntity, int i) throws RemoteException;

    Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException;

    Intent zza(ParticipantEntity[] participantEntityArr, Account account, String str, Uri uri, Uri uri2, String str2) throws RemoteException;

    Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException;

    Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2, String str3) throws RemoteException;

    void zza(IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(Contents contents) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i, String str, String[] strArr, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, VideoConfiguration videoConfiguration) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z, int i) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void zza(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException;

    void zza(IGamesClient iGamesClient, long j) throws RemoteException;

    void zza(String str, Account account) throws RemoteException;

    void zza(String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(String str, IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzai(boolean z) throws RemoteException;

    void zzaj(boolean z) throws RemoteException;

    void zzak(boolean z) throws RemoteException;

    int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException;

    Intent zzb(int i, int i2, boolean z) throws RemoteException;

    Intent zzb(int[] iArr) throws RemoteException;

    void zzb(long j, String str) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzb(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void zzb(String[] strArr) throws RemoteException;

    Intent zzc(int i, int i2, boolean z) throws RemoteException;

    void zzc(long j, String str) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzc(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void zzd(long j, String str) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void zzd(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzd(String str, String str2, int i) throws RemoteException;

    Intent zzdI(String str) throws RemoteException;

    String zzdK(String str) throws RemoteException;

    String zzdL(String str) throws RemoteException;

    void zzdM(String str) throws RemoteException;

    int zzdN(String str) throws RemoteException;

    Uri zzdO(String str) throws RemoteException;

    void zzdP(String str) throws RemoteException;

    Intent zzdQ(String str) throws RemoteException;

    ParcelFileDescriptor zzdR(String str) throws RemoteException;

    Account zzdS(String str) throws RemoteException;

    void zze(long j, String str) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void zze(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zze(String str, String str2, int i) throws RemoteException;

    void zzf(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzf(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzf(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zzf(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void zzf(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void zzf(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzg(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzg(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzg(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzgt(int i) throws RemoteException;

    RoomEntity zzh(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzh(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzh(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzi(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzi(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzi(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void zzj(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzj(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzk(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzk(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzl(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzl(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent zzm(String str, int i, int i2) throws RemoteException;

    void zzm(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzm(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    ParcelFileDescriptor zzn(Uri uri) throws RemoteException;

    void zzn(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzn(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzo(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void zzo(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Bundle zzoi() throws RemoteException;

    void zzp(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzp(String str, int i) throws RemoteException;

    void zzq(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzq(String str, int i) throws RemoteException;

    void zzr(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzr(String str, int i) throws RemoteException;

    void zzs(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzt(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzt(String str, int i) throws RemoteException;

    void zzu(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void zzu(String str, int i) throws RemoteException;

    Intent zzv(String str, int i) throws RemoteException;

    Intent zzwA() throws RemoteException;

    Intent zzwB() throws RemoteException;

    Intent zzwC() throws RemoteException;

    Intent zzwH() throws RemoteException;

    Intent zzwI() throws RemoteException;

    int zzwJ() throws RemoteException;

    String zzwK() throws RemoteException;

    int zzwL() throws RemoteException;

    Intent zzwM() throws RemoteException;

    int zzwN() throws RemoteException;

    int zzwO() throws RemoteException;

    int zzwP() throws RemoteException;

    int zzwQ() throws RemoteException;

    void zzwR() throws RemoteException;

    String zzwT() throws RemoteException;

    DataHolder zzwU() throws RemoteException;

    boolean zzwV() throws RemoteException;

    DataHolder zzwW() throws RemoteException;

    void zzwX() throws RemoteException;

    Intent zzwY() throws RemoteException;

    void zzwZ() throws RemoteException;

    String zzww() throws RemoteException;

    Intent zzwz() throws RemoteException;

    boolean zzxa() throws RemoteException;

    void zzxb() throws RemoteException;

    Intent zzxc() throws RemoteException;

    Intent zzxd() throws RemoteException;

    Account zzxe() throws RemoteException;

    List zzxf() throws RemoteException;
}
