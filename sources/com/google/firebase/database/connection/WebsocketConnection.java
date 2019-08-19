package com.google.firebase.database.connection;

import com.google.firebase.database.connection.util.StringListReader;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.tubesock.WebSocket;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketMessage;
import com.google.firebase.database.util.JsonMapper;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
class WebsocketConnection {
    private static final long CONNECT_TIMEOUT_MS = 30000;
    private static final long KEEP_ALIVE_TIMEOUT_MS = 45000;
    private static final int MAX_FRAME_SIZE = 16384;
    private static long connectionId = 0;
    /* access modifiers changed from: private */
    public WSClient conn;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> connectTimeout;
    private final ConnectionContext connectionContext;
    private Delegate delegate;
    /* access modifiers changed from: private */
    public boolean everConnected = false;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService executorService;
    private StringListReader frameReader;
    private boolean isClosed = false;
    private ScheduledFuture<?> keepAlive;
    /* access modifiers changed from: private */
    public final LogWrapper logger;
    private long totalFrames = 0;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface Delegate {
        void onDisconnect(boolean z);

        void onMessage(Map<String, Object> map);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private interface WSClient {
        void close();

        void connect();

        void send(String str);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private class WSClientTubesock implements WSClient, WebSocketEventHandler {

        /* renamed from: ws */
        private WebSocket f43ws;

        private WSClientTubesock(WebSocket ws) {
            this.f43ws = ws;
            this.f43ws.setEventHandler(this);
        }

        public void onOpen() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    WebsocketConnection.this.connectTimeout.cancel(false);
                    WebsocketConnection.this.everConnected = true;
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("websocket opened", new Object[0]);
                    }
                    WebsocketConnection.this.resetKeepAlive();
                }
            });
        }

        public void onMessage(WebSocketMessage msg) {
            final String str = msg.getText();
            if (WebsocketConnection.this.logger.logsDebug()) {
                LogWrapper access$200 = WebsocketConnection.this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("ws message: ");
                sb.append(str);
                access$200.debug(sb.toString(), new Object[0]);
            }
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    WebsocketConnection.this.handleIncomingFrame(str);
                }
            });
        }

        public void onClose() {
            String str = "closed";
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("closed", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        public void onError(final WebSocketException e) {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                public void run() {
                    if (e.getCause() == null || !(e.getCause() instanceof EOFException)) {
                        WebsocketConnection.this.logger.debug("WebSocket error.", e, new Object[0]);
                    } else {
                        WebsocketConnection.this.logger.debug("WebSocket reached EOF.", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        public void onLogMessage(String msg) {
            if (WebsocketConnection.this.logger.logsDebug()) {
                LogWrapper access$200 = WebsocketConnection.this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Tubesock: ");
                sb.append(msg);
                access$200.debug(sb.toString(), new Object[0]);
            }
        }

        public void send(String msg) {
            this.f43ws.send(msg);
        }

        public void close() {
            this.f43ws.close();
        }

        private void shutdown() {
            this.f43ws.close();
            try {
                this.f43ws.blockClose();
            } catch (InterruptedException e) {
                WebsocketConnection.this.logger.error("Interrupted while shutting down websocket threads", e);
            }
        }

        public void connect() {
            try {
                this.f43ws.connect();
            } catch (WebSocketException e) {
                if (WebsocketConnection.this.logger.logsDebug()) {
                    WebsocketConnection.this.logger.debug("Error connecting", e, new Object[0]);
                }
                shutdown();
            }
        }
    }

    public WebsocketConnection(ConnectionContext connectionContext2, HostInfo hostInfo, String optCachedHost, Delegate delegate2, String optLastSessionId) {
        this.connectionContext = connectionContext2;
        this.executorService = connectionContext2.getExecutorService();
        this.delegate = delegate2;
        long connId = connectionId;
        connectionId = 1 + connId;
        Logger logger2 = connectionContext2.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("ws_");
        sb.append(connId);
        this.logger = new LogWrapper(logger2, "WebSocket", sb.toString());
        this.conn = createConnection(hostInfo, optCachedHost, optLastSessionId);
    }

    private WSClient createConnection(HostInfo hostInfo, String optCachedHost, String optLastSessionId) {
        URI uri = HostInfo.getConnectionUrl(optCachedHost != null ? optCachedHost : hostInfo.getHost(), hostInfo.isSecure(), hostInfo.getNamespace(), optLastSessionId);
        Map<String, String> extraHeaders = new HashMap<>();
        extraHeaders.put("User-Agent", this.connectionContext.getUserAgent());
        return new WSClientTubesock(new WebSocket(this.connectionContext, uri, null, extraHeaders));
    }

    public void open() {
        this.conn.connect();
        this.connectTimeout = this.executorService.schedule(new Runnable() {
            public void run() {
                WebsocketConnection.this.closeIfNeverConnected();
            }
        }, CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public void close() {
        if (this.logger.logsDebug()) {
            this.logger.debug("websocket is being closed", new Object[0]);
        }
        this.isClosed = true;
        this.conn.close();
        ScheduledFuture<?> scheduledFuture = this.connectTimeout;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.keepAlive;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public void send(Map<String, Object> message) {
        resetKeepAlive();
        try {
            String[] segs = splitIntoFrames(JsonMapper.serializeJson(message), 16384);
            if (segs.length > 1) {
                WSClient wSClient = this.conn;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(segs.length);
                wSClient.send(sb.toString());
            }
            for (String send : segs) {
                this.conn.send(send);
            }
        } catch (IOException e) {
            LogWrapper logWrapper = this.logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to serialize message: ");
            sb2.append(message.toString());
            logWrapper.error(sb2.toString(), e);
            shutdown();
        }
    }

    private void appendFrame(String message) {
        this.frameReader.addString(message);
        this.totalFrames--;
        if (this.totalFrames == 0) {
            try {
                this.frameReader.freeze();
                Map<String, Object> decoded = JsonMapper.parseJson(this.frameReader.toString());
                this.frameReader = null;
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleIncomingFrame complete frame: ");
                    sb.append(decoded);
                    logWrapper.debug(sb.toString(), new Object[0]);
                }
                this.delegate.onMessage(decoded);
            } catch (IOException e) {
                LogWrapper logWrapper2 = this.logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error parsing frame: ");
                sb2.append(this.frameReader.toString());
                logWrapper2.error(sb2.toString(), e);
                close();
                shutdown();
            } catch (ClassCastException e2) {
                LogWrapper logWrapper3 = this.logger;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error parsing frame (cast error): ");
                sb3.append(this.frameReader.toString());
                logWrapper3.error(sb3.toString(), e2);
                close();
                shutdown();
            }
        }
    }

    private void handleNewFrameCount(int numFrames) {
        this.totalFrames = (long) numFrames;
        this.frameReader = new StringListReader();
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("HandleNewFrameCount: ");
            sb.append(this.totalFrames);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
    }

    private String extractFrameCount(String message) {
        if (message.length() <= 6) {
            try {
                int frameCount = Integer.parseInt(message);
                if (frameCount > 0) {
                    handleNewFrameCount(frameCount);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        handleNewFrameCount(1);
        return message;
    }

    /* access modifiers changed from: private */
    public void handleIncomingFrame(String message) {
        if (!this.isClosed) {
            resetKeepAlive();
            if (isBuffering()) {
                appendFrame(message);
                return;
            }
            String remaining = extractFrameCount(message);
            if (remaining != null) {
                appendFrame(remaining);
            }
        }
    }

    /* access modifiers changed from: private */
    public void resetKeepAlive() {
        if (!this.isClosed) {
            ScheduledFuture<?> scheduledFuture = this.keepAlive;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Reset keepAlive. Remaining: ");
                    sb.append(this.keepAlive.getDelay(TimeUnit.MILLISECONDS));
                    logWrapper.debug(sb.toString(), new Object[0]);
                }
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Reset keepAlive", new Object[0]);
            }
            this.keepAlive = this.executorService.schedule(nop(), KEEP_ALIVE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    private Runnable nop() {
        return new Runnable() {
            public void run() {
                if (WebsocketConnection.this.conn != null) {
                    WebsocketConnection.this.conn.send("0");
                    WebsocketConnection.this.resetKeepAlive();
                }
            }
        };
    }

    private boolean isBuffering() {
        return this.frameReader != null;
    }

    /* access modifiers changed from: private */
    public void onClosed() {
        if (!this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing itself", new Object[0]);
            }
            shutdown();
        }
        this.conn = null;
        ScheduledFuture<?> scheduledFuture = this.keepAlive;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private void shutdown() {
        this.isClosed = true;
        this.delegate.onDisconnect(this.everConnected);
    }

    /* access modifiers changed from: private */
    public void closeIfNeverConnected() {
        if (!this.everConnected && !this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("timed out on connect", new Object[0]);
            }
            this.conn.close();
        }
    }

    private static String[] splitIntoFrames(String src, int maxFrameSize) {
        if (src.length() <= maxFrameSize) {
            return new String[]{src};
        }
        ArrayList<String> segs = new ArrayList<>();
        int i = 0;
        while (i < src.length()) {
            segs.add(src.substring(i, Math.min(i + maxFrameSize, src.length())));
            i += maxFrameSize;
        }
        return (String[]) segs.toArray(new String[segs.size()]);
    }
}
