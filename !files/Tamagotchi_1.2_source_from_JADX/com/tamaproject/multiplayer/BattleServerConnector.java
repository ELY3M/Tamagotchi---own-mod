package com.tamaproject.multiplayer;

import com.tamaproject.adt.messages.client.ClientMessageFlags;
import com.tamaproject.adt.messages.server.ConnectionCloseServerMessage;
import com.tamaproject.adt.messages.server.ServerMessageFlags;
import com.tamaproject.multiplayer.BattleMessages.AddSpriteClientMessage;
import com.tamaproject.multiplayer.BattleMessages.AddSpriteServerMessage;
import com.tamaproject.multiplayer.BattleMessages.DeathMatchServerMessage;
import com.tamaproject.multiplayer.BattleMessages.FireBulletClientMessage;
import com.tamaproject.multiplayer.BattleMessages.FireBulletServerMessage;
import com.tamaproject.multiplayer.BattleMessages.GetPlayerIdServerMessage;
import com.tamaproject.multiplayer.BattleMessages.MoveSpriteClientMessage;
import com.tamaproject.multiplayer.BattleMessages.MoveSpriteServerMessage;
import com.tamaproject.multiplayer.BattleMessages.ReceivedDamageServerMessage;
import com.tamaproject.multiplayer.BattleMessages.SendPlayerStatsClientMessage;
import com.tamaproject.multiplayer.BattleMessages.SendPlayerStatsServerMessage;
import com.tamaproject.multiplayer.BattleMessages.StartGameServerMessage;
import com.tamaproject.multiplayer.BattleMessages.VoteDeathMatchClientMessage;
import com.tamaproject.util.TamaBattleConstants;
import java.io.IOException;
import java.net.Socket;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.IMessage;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.anddev.andengine.extension.multiplayer.protocol.client.IServerMessageHandler;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.ServerConnector;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.SocketConnectionServerConnector.ISocketConnectionServerConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.extension.multiplayer.protocol.util.MessagePool;
import org.anddev.andengine.util.Debug;

public class BattleServerConnector extends ServerConnector<SocketConnection> implements TamaBattleConstants, ClientMessageFlags, ServerMessageFlags, BattleMessages {
    private final MessagePool<IMessage> mMessagePool = new MessagePool();

    public interface IBattleServerConnectorListener {
        void client_addPlayerSprite(int i, float f, float f2);

        void client_endGame();

        void client_fireBullet(int i, int i2, float f, float f2);

        void client_handleReceivedDamage(int i);

        void client_moveSprite(int i, float f, float f2, boolean z);

        void client_removePlayer(int i);

        void client_sendPlayerInfoToServer();

        void client_setDeathMatch(boolean z);

        void client_setPlayerNumber(int i);

        void client_startGame();

        void setPlayerData(int i, int i2, int i3, int i4);
    }

    private void initMessagePool() {
        this.mMessagePool.registerMessage((short) 7, AddSpriteClientMessage.class);
        this.mMessagePool.registerMessage((short) 6, MoveSpriteClientMessage.class);
        this.mMessagePool.registerMessage((short) 9, FireBulletClientMessage.class);
        this.mMessagePool.registerMessage((short) 12, SendPlayerStatsClientMessage.class);
        this.mMessagePool.registerMessage((short) 16, VoteDeathMatchClientMessage.class);
    }

    public BattleServerConnector(String pServerIP, ISocketConnectionServerConnectorListener pSocketConnectionServerConnectorListener, final IBattleServerConnectorListener pBattleServerConnectorListener) throws IOException {
        super(new SocketConnection(new Socket(pServerIP, TamaBattleConstants.SERVER_PORT)), pSocketConnectionServerConnectorListener);
        initMessagePool();
        registerServerMessage(Short.MIN_VALUE, ConnectionCloseServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                pBattleServerConnectorListener.client_endGame();
            }
        });
        registerServerMessage((short) 1, AddSpriteServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                AddSpriteServerMessage addSpriteServerMessage = (AddSpriteServerMessage) pServerMessage;
                if (!addSpriteServerMessage.mIsPlayer) {
                    return;
                }
                if (addSpriteServerMessage.mX < 0.0f || addSpriteServerMessage.mY < 0.0f) {
                    pBattleServerConnectorListener.client_removePlayer(addSpriteServerMessage.mID);
                    Debug.m59d("[SERVER] Removing player " + addSpriteServerMessage.mID);
                    return;
                }
                pBattleServerConnectorListener.client_addPlayerSprite(addSpriteServerMessage.mID, addSpriteServerMessage.mX, addSpriteServerMessage.mY);
                Debug.m59d("[SERVER] Adding player " + addSpriteServerMessage.mID);
            }
        });
        registerServerMessage((short) 2, MoveSpriteServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                MoveSpriteServerMessage moveSpriteServerMessage = (MoveSpriteServerMessage) pServerMessage;
                pBattleServerConnectorListener.client_moveSprite(moveSpriteServerMessage.mID, moveSpriteServerMessage.mX, moveSpriteServerMessage.mY, moveSpriteServerMessage.mIsPlayer);
            }
        });
        registerServerMessage((short) 3, GetPlayerIdServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                pBattleServerConnectorListener.client_setPlayerNumber(((GetPlayerIdServerMessage) pServerMessage).playerNumber);
                pBattleServerConnectorListener.client_sendPlayerInfoToServer();
            }
        });
        registerServerMessage((short) 8, FireBulletServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                FireBulletServerMessage message = (FireBulletServerMessage) pServerMessage;
                pBattleServerConnectorListener.client_fireBullet(message.playerID, message.mID, message.mX, message.mY);
            }
        });
        registerServerMessage((short) 13, SendPlayerStatsServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                SendPlayerStatsServerMessage message = (SendPlayerStatsServerMessage) pServerMessage;
                pBattleServerConnectorListener.setPlayerData(message.playerID, message.health, message.maxHealth, message.battleLevel);
            }
        });
        registerServerMessage((short) 14, StartGameServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                pBattleServerConnectorListener.client_startGame();
            }
        });
        registerServerMessage((short) 15, ReceivedDamageServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                pBattleServerConnectorListener.client_handleReceivedDamage(((ReceivedDamageServerMessage) pServerMessage).playerNumber);
            }
        });
        registerServerMessage((short) 16, DeathMatchServerMessage.class, new IServerMessageHandler<SocketConnection>() {
            public void onHandleMessage(ServerConnector<SocketConnection> serverConnector, IServerMessage pServerMessage) throws IOException {
                pBattleServerConnectorListener.client_setDeathMatch(((DeathMatchServerMessage) pServerMessage).isDeathMatch);
            }
        });
    }

    public void sendMoveSpriteMessage(int playerID, int id, float x, float y, boolean isPlayer) {
        try {
            MoveSpriteClientMessage message = (MoveSpriteClientMessage) this.mMessagePool.obtainMessage((short) 6);
            message.set(playerID, id, x, y, isPlayer);
            sendClientMessage(message);
            this.mMessagePool.recycleMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFireBulletMessage(int playerID, float x, float y) {
        try {
            FireBulletClientMessage message = (FireBulletClientMessage) this.mMessagePool.obtainMessage((short) 9);
            message.set(playerID, 0, x, y, false);
            sendClientMessage(message);
            this.mMessagePool.recycleMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPlayerStatsMessage(int health, int maxHealth, int battleLevel, int playerID) {
        try {
            SendPlayerStatsClientMessage message = (SendPlayerStatsClientMessage) this.mMessagePool.obtainMessage((short) 12);
            message.set(health, maxHealth, battleLevel, playerID);
            sendClientMessage(message);
            this.mMessagePool.recycleMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendVoteDeathMatch(boolean vote) {
        try {
            VoteDeathMatchClientMessage message = (VoteDeathMatchClientMessage) this.mMessagePool.obtainMessage((short) 16);
            message.set(vote);
            sendClientMessage(message);
            this.mMessagePool.recycleMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
