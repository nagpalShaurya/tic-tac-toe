package com.google.firebase.database.connection;

import com.google.firebase.database.logging.Logger;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ConnectionContext {
    private final ConnectionAuthTokenProvider authTokenProvider;
    private final String clientSdkVersion;
    private final ScheduledExecutorService executorService;
    private final Logger logger;
    private final boolean persistenceEnabled;
    private final String sslCacheDirectory;
    private final String userAgent;

    public ConnectionContext(Logger logger2, ConnectionAuthTokenProvider authTokenProvider2, ScheduledExecutorService executorService2, boolean persistenceEnabled2, String clientSdkVersion2, String userAgent2, String sslCacheDirectory2) {
        this.logger = logger2;
        this.authTokenProvider = authTokenProvider2;
        this.executorService = executorService2;
        this.persistenceEnabled = persistenceEnabled2;
        this.clientSdkVersion = clientSdkVersion2;
        this.userAgent = userAgent2;
        this.sslCacheDirectory = sslCacheDirectory2;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public ConnectionAuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public String getClientSdkVersion() {
        return this.clientSdkVersion;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getSslCacheDirectory() {
        return this.sslCacheDirectory;
    }
}
