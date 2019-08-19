package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider.GetTokenCallback;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Context {
    private static final long DEFAULT_CACHE_SIZE = 10485760;
    protected AuthTokenProvider authTokenProvider;
    protected long cacheSize = DEFAULT_CACHE_SIZE;
    protected EventTarget eventTarget;
    protected FirebaseApp firebaseApp;
    private PersistenceManager forcedPersistenceManager;
    private boolean frozen = false;
    protected Level logLevel = Level.INFO;
    protected List<String> loggedComponents;
    protected Logger logger;
    protected boolean persistenceEnabled;
    protected String persistenceKey;
    private Platform platform;
    protected RunLoop runLoop;
    private boolean stopped = false;
    protected String userAgent;

    private Platform getPlatform() {
        if (this.platform == null) {
            initializeAndroidPlatform();
        }
        return this.platform;
    }

    private synchronized void initializeAndroidPlatform() {
        this.platform = new AndroidPlatform(this.firebaseApp);
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void freeze() {
        if (!this.frozen) {
            this.frozen = true;
            initServices();
        }
    }

    public void requireStarted() {
        if (this.stopped) {
            restartServices();
            this.stopped = false;
        }
    }

    private void initServices() {
        ensureLogger();
        getPlatform();
        ensureUserAgent();
        ensureEventTarget();
        ensureRunLoop();
        ensureSessionIdentifier();
        ensureAuthTokenProvider();
    }

    private void restartServices() {
        this.eventTarget.restart();
        this.runLoop.restart();
    }

    /* access modifiers changed from: 0000 */
    public void stop() {
        this.stopped = true;
        this.eventTarget.shutdown();
        this.runLoop.shutdown();
    }

    /* access modifiers changed from: protected */
    public void assertUnfrozen() {
        if (isFrozen()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public List<String> getOptDebugLogComponents() {
        return this.loggedComponents;
    }

    public Level getLogLevel() {
        return this.logLevel;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public LogWrapper getLogger(String component) {
        return new LogWrapper(this.logger, component);
    }

    public LogWrapper getLogger(String component, String prefix) {
        return new LogWrapper(this.logger, component, prefix);
    }

    public ConnectionContext getConnectionContext() {
        ConnectionContext connectionContext = new ConnectionContext(getLogger(), wrapAuthTokenProvider(getAuthTokenProvider()), getExecutorService(), isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), getUserAgent(), getSSLCacheDirectory().getAbsolutePath());
        return connectionContext;
    }

    /* access modifiers changed from: 0000 */
    public PersistenceManager getPersistenceManager(String firebaseId) {
        PersistenceManager persistenceManager = this.forcedPersistenceManager;
        if (persistenceManager != null) {
            return persistenceManager;
        }
        if (!this.persistenceEnabled) {
            return new NoopPersistenceManager();
        }
        PersistenceManager cache = this.platform.createPersistenceManager(this, firebaseId);
        if (cache != null) {
            return cache;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public long getPersistenceCacheSizeBytes() {
        return this.cacheSize;
    }

    /* access modifiers changed from: 0000 */
    public void forcePersistenceManager(PersistenceManager persistenceManager) {
        this.forcedPersistenceManager = persistenceManager;
    }

    public EventTarget getEventTarget() {
        return this.eventTarget;
    }

    public RunLoop getRunLoop() {
        return this.runLoop;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getPlatformVersion() {
        return getPlatform().getPlatformVersion();
    }

    public String getSessionPersistenceKey() {
        return this.persistenceKey;
    }

    public AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public PersistentConnection newPersistentConnection(HostInfo info, Delegate delegate) {
        return getPlatform().newPersistentConnection(this, getConnectionContext(), info, delegate);
    }

    private ScheduledExecutorService getExecutorService() {
        RunLoop loop = getRunLoop();
        if (loop instanceof DefaultRunLoop) {
            return ((DefaultRunLoop) loop).getExecutorService();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private void ensureLogger() {
        if (this.logger == null) {
            this.logger = getPlatform().newLogger(this, this.logLevel, this.loggedComponents);
        }
    }

    private void ensureRunLoop() {
        if (this.runLoop == null) {
            this.runLoop = this.platform.newRunLoop(this);
        }
    }

    private void ensureEventTarget() {
        if (this.eventTarget == null) {
            this.eventTarget = getPlatform().newEventTarget(this);
        }
    }

    private void ensureUserAgent() {
        if (this.userAgent == null) {
            this.userAgent = buildUserAgent(getPlatform().getUserAgent(this));
        }
    }

    private void ensureAuthTokenProvider() {
        if (this.authTokenProvider == null) {
            this.authTokenProvider = getPlatform().newAuthTokenProvider(getExecutorService());
        }
    }

    private void ensureSessionIdentifier() {
        if (this.persistenceKey == null) {
            this.persistenceKey = "default";
        }
    }

    private String buildUserAgent(String platformAgent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase/");
        sb.append("5");
        String str = "/";
        sb.append(str);
        sb.append(FirebaseDatabase.getSdkVersion());
        sb.append(str);
        return sb.append(platformAgent).toString();
    }

    private static ConnectionAuthTokenProvider wrapAuthTokenProvider(final AuthTokenProvider provider) {
        return new ConnectionAuthTokenProvider() {
            public void getToken(boolean forceRefresh, final GetTokenCallback callback) {
                AuthTokenProvider.this.getToken(forceRefresh, new GetTokenCompletionListener() {
                    public void onSuccess(String token) {
                        callback.onSuccess(token);
                    }

                    public void onError(String error) {
                        callback.onError(error);
                    }
                });
            }
        };
    }

    public File getSSLCacheDirectory() {
        return getPlatform().getSSLCacheDirectory();
    }
}
