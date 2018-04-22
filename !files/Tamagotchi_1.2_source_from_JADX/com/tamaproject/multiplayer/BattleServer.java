package com.tamaproject.multiplayer;

import android.util.SparseArray;
import com.tamaproject.adt.messages.client.ClientMessageFlags;
import com.tamaproject.adt.messages.server.ConnectionCloseServerMessage;
import com.tamaproject.adt.messages.server.ServerMessageFlags;
import com.tamaproject.multiplayer.BattleMessages.AddSpriteClientMessage;
import com.tamaproject.multiplayer.BattleMessages.AddSpriteServerMessage;
import com.tamaproject.multiplayer.BattleMessages.DeathMatchServerMessage;
import com.tamaproject.multiplayer.BattleMessages.FireBulletClientMessage;
import com.tamaproject.multiplayer.BattleMessages.FireBulletServerMessage;
import com.tamaproject.multiplayer.BattleMessages.GetPlayerIdServerMessage;
import com.tamaproject.multiplayer.BattleMessages.ModifyPlayerStatsServerMessage;
import com.tamaproject.multiplayer.BattleMessages.MoveSpriteClientMessage;
import com.tamaproject.multiplayer.BattleMessages.MoveSpriteServerMessage;
import com.tamaproject.multiplayer.BattleMessages.ReceivedDamageServerMessage;
import com.tamaproject.multiplayer.BattleMessages.RequestPlayerIdClientMessage;
import com.tamaproject.multiplayer.BattleMessages.SendPlayerStatsClientMessage;
import com.tamaproject.multiplayer.BattleMessages.SendPlayerStatsServerMessage;
import com.tamaproject.multiplayer.BattleMessages.StartGameServerMessage;
import com.tamaproject.multiplayer.BattleMessages.VoteDeathMatchClientMessage;
import com.tamaproject.util.TamaBattleConstants;
import com.tamaproject.util.TextUtil;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.IMessage;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.anddev.andengine.extension.multiplayer.protocol.server.IClientMessageHandler;
import org.anddev.andengine.extension.multiplayer.protocol.server.SocketServer;
import org.anddev.andengine.extension.multiplayer.protocol.server.SocketServer.ISocketServerListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector.ISocketConnectionClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.extension.multiplayer.protocol.util.MessagePool;

public class BattleServer extends SocketServer<SocketConnectionClientConnector> implements IUpdateHandler, TamaBattleConstants, BattleMessages, ServerMessageFlags, ClientMessageFlags {
    private IBattleServerListener battleServerListener;
    private int deathMatchVotes = 0;
    private boolean gameStarted = false;
    private final MessagePool<IMessage> mMessagePool = new MessagePool();
    private int mSpriteIDCounter = 0;
    private int numPlayers = 0;
    private final SparseArray<String> playerIps = new SparseArray();
    private LinkedList<Integer> playerNumbers = new LinkedList();

    public interface IBattleServerListener {
        void server_addPlayerSpriteToServer(int i);

        void server_addPlayerToLobby(String str, int i, int i2);

        void server_updateAllPlayerInfo();

        void server_updateAllPlayerSprites();

        void server_updateSkull(String str, boolean z);

        void setPlayerData(int i, int i2, int i3, int i4);
    }

    class C10341 implements IClientMessageHandler<SocketConnection> {
        C10341() {
        }

        public void onHandleMessage(ClientConnector<SocketConnection> pClientConnector, IClientMessage pClientMessage) throws IOException {
            System.out.println("Incoming client request...");
            if (BattleServer.this.gameStarted) {
                try {
                    ConnectionCloseServerMessage closeMessage = (ConnectionCloseServerMessage) BattleServer.this.mMessagePool.obtainMessage(Short.MIN_VALUE);
                    pClientConnector.sendServerMessage(closeMessage);
                    BattleServer.this.mMessagePool.recycleMessage(closeMessage);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            BattleServer.this.numPlayers = BattleServer.this.numPlayers + 1;
            String IP = TextUtil.getIpAndPort(pClientConnector);
            int newPlayerNumber = 0;
            for (int i = 1; i <= BattleServer.this.numPlayers; i++) {
                if (!BattleServer.this.playerNumbers.contains(Integer.valueOf(i))) {
                    newPlayerNumber = i;
                    break;
                }
            }
            BattleServer.this.playerIps.put(newPlayerNumber, IP);
            BattleServer.this.playerNumbers.add(Integer.valueOf(newPlayerNumber));
            System.out.println("New player IP added: " + newPlayerNumber + ", " + IP);
            GetPlayerIdServerMessage sMessage = (GetPlayerIdServerMessage) BattleServer.this.mMessagePool.obtainMessage((short) 3);
            sMessage.playerNumber = newPlayerNumber;
            pClientConnector.sendServerMessage(sMessage);
            BattleServer.this.mMessagePool.recycleMessage(sMessage);
            BattleServer.this.battleServerListener.server_addPlayerSpriteToServer(newPlayerNumber);
            BattleServer.this.battleServerListener.server_updateAllPlayerSprites();
        }
    }

    class C10352 implements IClientMessageHandler<SocketConnection> {
        C10352() {
        }

        public void onHandleMessage(ClientConnector<SocketConnection> clientConnector, IClientMessage clientMessage) throws IOException {
            MoveSpriteClientMessage message = (MoveSpriteClientMessage) clientMessage;
            try {
                MoveSpriteServerMessage moveSpriteServerMessage = (MoveSpriteServerMessage) BattleServer.this.mMessagePool.obtainMessage((short) 2);
                moveSpriteServerMessage.set(message.playerID, message.mID, message.mX, message.mY, message.mIsPlayer);
                BattleServer.this.sendBroadcastServerMessage(moveSpriteServerMessage);
                BattleServer.this.mMessagePool.recycleMessage(moveSpriteServerMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C10363 implements IClientMessageHandler<SocketConnection> {
        C10363() {
        }

        public void onHandleMessage(ClientConnector<SocketConnection> clientConnector, IClientMessage clientMessage) throws IOException {
            AddSpriteClientMessage message = (AddSpriteClientMessage) clientMessage;
            try {
                AddSpriteServerMessage addSpriteServerMessage = (AddSpriteServerMessage) BattleServer.this.mMessagePool.obtainMessage((short) 1);
                addSpriteServerMessage.set(message.playerID, message.mID, message.mX, message.mY, message.mIsPlayer);
                BattleServer.this.sendBroadcastServerMessage(addSpriteServerMessage);
                BattleServer.this.mMessagePool.recycleMessage(addSpriteServerMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C10374 implements IClientMessageHandler<SocketConnection> {
        C10374() {
        }

        public void onHandleMessage(ClientConnector<SocketConnection> clientConnector, IClientMessage clientMessage) throws IOException {
            FireBulletClientMessage message = (FireBulletClientMessage) clientMessage;
            try {
                FireBulletServerMessage bMessage = (FireBulletServerMessage) BattleServer.this.mMessagePool.obtainMessage((short) 8);
                bMessage.set(message.playerID, BattleServer.this.mSpriteIDCounter = BattleServer.this.mSpriteIDCounter + 1, message.mX, message.mY, message.mIsPlayer);
                BattleServer.this.sendBroadcastServerMessage(bMessage);
                BattleServer.this.mMessagePool.recycleMessage(bMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C10385 implements IClientMessageHandler<SocketConnection> {
        C10385() {
        }

        public void onHandleMessage(ClientConnector<SocketConnection> clientConnector, IClientMessage clientMessage) throws IOException {
            SendPlayerStatsClientMessage message = (SendPlayerStatsClientMessage) clientMessage;
            BattleServer.this.battleServerListener.server_addPlayerToLobby((String) BattleServer.this.playerIps.get(message.playerID), message.playerID, message.battleLevel);
            BattleServer.this.battleServerListener.setPlayerData(message.playerID, message.health, message.maxHealth, message.battleLevel);
            BattleServer.this.battleServerListener.server_updateAllPlayerInfo();
        }
    }

    class C10396 implements IClientMessageHandler<SocketConnection> {
        C10396() {
        }

        public void onHandleMessage(ClientConnector<SocketConnection> pConnector, IClientMessage clientMessage) throws IOException {
            VoteDeathMatchClientMessage msg = (VoteDeathMatchClientMessage) clientMessage;
            if (msg.voteDeathMatch) {
                BattleServer.this.deathMatchVotes = BattleServer.this.deathMatchVotes + 1;
            } else {
                BattleServer.this.deathMatchVotes = BattleServer.this.deathMatchVotes - 1;
            }
            String ip = TextUtil.getIpAndPort(pConnector);
            System.out.println("IP: " + ip);
            BattleServer.this.battleServerListener.server_updateSkull(ip, msg.voteDeathMatch);
        }
    }

    public BattleServer(ISocketConnectionClientConnectorListener pSocketConnectionClientConnectorListener, ISocketServerListener<SocketConnectionClientConnector> pSocketServerListener, IBattleServerListener pBattleServerListener) {
        super(TamaBattleConstants.SERVER_PORT, pSocketConnectionClientConnectorListener, pSocketServerListener);
        initMessagePool();
        this.battleServerListener = pBattleServerListener;
    }

    private void initMessagePool() {
        this.mMessagePool.registerMessage((short) 1, AddSpriteServerMessage.class);
        this.mMessagePool.registerMessage((short) 2, MoveSpriteServerMessage.class);
        this.mMessagePool.registerMessage((short) 3, GetPlayerIdServerMessage.class);
        this.mMessagePool.registerMessage((short) 8, FireBulletServerMessage.class);
        this.mMessagePool.registerMessage((short) 13, SendPlayerStatsServerMessage.class);
        this.mMessagePool.registerMessage((short) 11, ModifyPlayerStatsServerMessage.class);
        this.mMessagePool.registerMessage((short) 14, StartGameServerMessage.class);
        this.mMessagePool.registerMessage(Short.MIN_VALUE, ConnectionCloseServerMessage.class);
        this.mMessagePool.registerMessage((short) 15, ReceivedDamageServerMessage.class);
        this.mMessagePool.registerMessage((short) 16, DeathMatchServerMessage.class);
    }

    public void onUpdate(float arg0) {
    }

    public void reset() {
    }

    protected SocketConnectionClientConnector newClientConnector(SocketConnection pSocketConnection) throws IOException {
        SocketConnectionClientConnector clientConnector = new SocketConnectionClientConnector(pSocketConnection);
        clientConnector.registerClientMessage((short) 4, RequestPlayerIdClientMessage.class, new C10341());
        clientConnector.registerClientMessage((short) 6, MoveSpriteClientMessage.class, new C10352());
        clientConnector.registerClientMessage((short) 7, AddSpriteClientMessage.class, new C10363());
        clientConnector.registerClientMessage((short) 9, FireBulletClientMessage.class, new C10374());
        clientConnector.registerClientMessage((short) 12, SendPlayerStatsClientMessage.class, new C10385());
        clientConnector.registerClientMessage((short) 16, VoteDeathMatchClientMessage.class, new C10396());
        return clientConnector;
    }

    public void sendRemovePlayerMessage(int playerID) {
        try {
            AddSpriteServerMessage message = (AddSpriteServerMessage) this.mMessagePool.obtainMessage((short) 1);
            message.set(0, playerID, -1.0f, -1.0f, true);
            sendBroadcastServerMessage(message);
            this.mMessagePool.recycleMessage(message);
            this.playerIps.remove(playerID);
            this.playerNumbers.remove(Integer.valueOf(playerID));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendStartMessage() {
        this.gameStarted = true;
        try {
            StartGameServerMessage startMessage = (StartGameServerMessage) this.mMessagePool.obtainMessage((short) 14);
            sendBroadcastServerMessage(startMessage);
            this.mMessagePool.recycleMessage(startMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendAddPlayerSpriteMessage(int playerID, float x, float y) {
        try {
            AddSpriteServerMessage apMessage = (AddSpriteServerMessage) this.mMessagePool.obtainMessage((short) 1);
            apMessage.set(0, playerID, x, y, true);
            sendBroadcastServerMessage(apMessage);
            this.mMessagePool.recycleMessage(apMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendPlayerStatsMessage(int health, int maxHealth, int battleLevel, int playerID) {
        try {
            SendPlayerStatsServerMessage spssMessage = (SendPlayerStatsServerMessage) this.mMessagePool.obtainMessage((short) 13);
            spssMessage.set(health, maxHealth, battleLevel, playerID);
            sendBroadcastServerMessage(spssMessage);
            this.mMessagePool.recycleMessage(spssMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendDamageMessage(int playerID) {
        try {
            ReceivedDamageServerMessage msg = (ReceivedDamageServerMessage) this.mMessagePool.obtainMessage((short) 15);
            msg.set(playerID);
            sendBroadcastServerMessage(msg);
            this.mMessagePool.recycleMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendDeathMatchMessage(boolean isDeathMatch) {
        try {
            DeathMatchServerMessage msg = (DeathMatchServerMessage) this.mMessagePool.obtainMessage((short) 16);
            msg.set(isDeathMatch);
            sendBroadcastServerMessage(msg);
            this.mMessagePool.recycleMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDeathMatchVotes() {
        return this.deathMatchVotes;
    }

    public int getLowestTeamCount() {
        int team1 = 0;
        int team2 = 0;
        Iterator it = this.playerNumbers.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next()).intValue() % 2 == 0) {
                team2++;
            } else {
                team1++;
            }
        }
        return team1 < team2 ? team1 : team2;
    }

    public int getNumPlayers() {
        return this.playerNumbers.size();
    }

    public boolean isGameStarted() {
        return this.gameStarted;
    }
}
