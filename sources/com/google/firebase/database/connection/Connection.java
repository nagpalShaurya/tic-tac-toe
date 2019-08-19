package com.google.firebase.database.connection;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
class Connection implements com.google.firebase.database.connection.WebsocketConnection.Delegate {
    private static final String REQUEST_PAYLOAD = "d";
    private static final String REQUEST_TYPE = "t";
    private static final String REQUEST_TYPE_DATA = "d";
    private static final String SERVER_CONTROL_MESSAGE = "c";
    private static final String SERVER_CONTROL_MESSAGE_DATA = "d";
    private static final String SERVER_CONTROL_MESSAGE_HELLO = "h";
    private static final String SERVER_CONTROL_MESSAGE_RESET = "r";
    private static final String SERVER_CONTROL_MESSAGE_SHUTDOWN = "s";
    private static final String SERVER_CONTROL_MESSAGE_TYPE = "t";
    private static final String SERVER_DATA_MESSAGE = "d";
    private static final String SERVER_ENVELOPE_DATA = "d";
    private static final String SERVER_ENVELOPE_TYPE = "t";
    private static final String SERVER_HELLO_HOST = "h";
    private static final String SERVER_HELLO_SESSION_ID = "s";
    private static final String SERVER_HELLO_TIMESTAMP = "ts";
    private static long connectionIds = 0;
    private WebsocketConnection conn;
    private Delegate delegate;
    private HostInfo hostInfo;
    private final LogWrapper logger;
    private State state = State.REALTIME_CONNECTING;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface Delegate {
        void onCacheHost(String str);

        void onDataMessage(Map<String, Object> map);

        void onDisconnect(DisconnectReason disconnectReason);

        void onKill(String str);

        void onReady(long j, String str);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public enum DisconnectReason {
        SERVER_RESET,
        OTHER
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private enum State {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public Connection(ConnectionContext context, HostInfo hostInfo2, String cachedHost, Delegate delegate2, String optLastSessionId) {
        long connId = connectionIds;
        connectionIds = 1 + connId;
        this.hostInfo = hostInfo2;
        this.delegate = delegate2;
        Logger logger2 = context.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("conn_");
        sb.append(connId);
        this.logger = new LogWrapper(logger2, "Connection", sb.toString());
        WebsocketConnection websocketConnection = new WebsocketConnection(context, hostInfo2, cachedHost, this, optLastSessionId);
        this.conn = websocketConnection;
    }

    public void open() {
        if (this.logger.logsDebug()) {
            this.logger.debug("Opening a connection", new Object[0]);
        }
        this.conn.open();
    }

    public void close(DisconnectReason reason) {
        if (this.state != State.REALTIME_DISCONNECTED) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing realtime connection", new Object[0]);
            }
            this.state = State.REALTIME_DISCONNECTED;
            WebsocketConnection websocketConnection = this.conn;
            if (websocketConnection != null) {
                websocketConnection.close();
                this.conn = null;
            }
            this.delegate.onDisconnect(reason);
        }
    }

    public void close() {
        close(DisconnectReason.OTHER);
    }

    public void sendRequest(Map<String, Object> message, boolean isSensitive) {
        Map<String, Object> request = new HashMap<>();
        String str = "d";
        request.put("t", str);
        request.put(str, message);
        sendData(request, isSensitive);
    }

    public void onMessage(Map<String, Object> message) {
        String str = "d";
        try {
            String messageType = (String) message.get("t");
            if (messageType == null) {
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to parse server message: missing message type:");
                    sb.append(message.toString());
                    logWrapper.debug(sb.toString(), new Object[0]);
                }
                close();
            } else if (messageType.equals(str)) {
                onDataMessage((Map) message.get(str));
            } else if (messageType.equals(SERVER_CONTROL_MESSAGE)) {
                onControlMessage((Map) message.get(str));
            } else if (this.logger.logsDebug()) {
                LogWrapper logWrapper2 = this.logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Ignoring unknown server message type: ");
                sb2.append(messageType);
                logWrapper2.debug(sb2.toString(), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper3 = this.logger;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to parse server message: ");
                sb3.append(e.toString());
                logWrapper3.debug(sb3.toString(), new Object[0]);
            }
            close();
        }
    }

    public void onDisconnect(boolean wasEverConnected) {
        this.conn = null;
        if (wasEverConnected || this.state != State.REALTIME_CONNECTING) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Realtime connection lost", new Object[0]);
            }
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Realtime connection failed", new Object[0]);
        }
        close();
    }

    private void onDataMessage(Map<String, Object> data) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("received data message: ");
            sb.append(data.toString());
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        this.delegate.onDataMessage(data);
    }

    private void onControlMessage(Map<String, Object> data) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Got control message: ");
            sb.append(data.toString());
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        try {
            String messageType = (String) data.get("t");
            if (messageType != null) {
                String str = "d";
                if (messageType.equals("s")) {
                    onConnectionShutdown((String) data.get(str));
                } else if (messageType.equals(SERVER_CONTROL_MESSAGE_RESET)) {
                    onReset((String) data.get(str));
                } else if (messageType.equals("h")) {
                    onHandshake((Map) data.get(str));
                } else if (this.logger.logsDebug()) {
                    LogWrapper logWrapper2 = this.logger;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring unknown control message: ");
                    sb2.append(messageType);
                    logWrapper2.debug(sb2.toString(), new Object[0]);
                }
            } else {
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper3 = this.logger;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Got invalid control message: ");
                    sb3.append(data.toString());
                    logWrapper3.debug(sb3.toString(), new Object[0]);
                }
                close();
            }
        } catch (ClassCastException e) {
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper4 = this.logger;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to parse control message: ");
                sb4.append(e.toString());
                logWrapper4.debug(sb4.toString(), new Object[0]);
            }
            close();
        }
    }

    private void onConnectionShutdown(String reason) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.delegate.onKill(reason);
        close();
    }

    private void onHandshake(Map<String, Object> handshake) {
        long timestamp = ((Long) handshake.get(SERVER_HELLO_TIMESTAMP)).longValue();
        this.delegate.onCacheHost((String) handshake.get("h"));
        String sessionId = (String) handshake.get("s");
        if (this.state == State.REALTIME_CONNECTING) {
            this.conn.start();
            onConnectionReady(timestamp, sessionId);
        }
    }

    private void onConnectionReady(long timestamp, String sessionId) {
        if (this.logger.logsDebug()) {
            this.logger.debug("realtime connection established", new Object[0]);
        }
        this.state = State.REALTIME_CONNECTED;
        this.delegate.onReady(timestamp, sessionId);
    }

    private void onReset(String host) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Got a reset; killing connection to ");
            sb.append(this.hostInfo.getHost());
            sb.append("; Updating internalHost to ");
            sb.append(host);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        this.delegate.onCacheHost(host);
        close(DisconnectReason.SERVER_RESET);
    }

    private void sendData(Map<String, Object> data, boolean isSensitive) {
        if (this.state != State.REALTIME_CONNECTED) {
            this.logger.debug("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (isSensitive) {
            this.logger.debug("Sending data (contents hidden)", new Object[0]);
        } else {
            this.logger.debug("Sending data: %s", data);
        }
        this.conn.send(data);
    }

    public void injectConnectionFailure() {
        close();
    }
}
