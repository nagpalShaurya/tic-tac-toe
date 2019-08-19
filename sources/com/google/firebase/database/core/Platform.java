package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface Platform {
    PersistenceManager createPersistenceManager(Context context, String str);

    String getPlatformVersion();

    File getSSLCacheDirectory();

    String getUserAgent(Context context);

    AuthTokenProvider newAuthTokenProvider(ScheduledExecutorService scheduledExecutorService);

    EventTarget newEventTarget(Context context);

    Logger newLogger(Context context, Level level, List<String> list);

    PersistentConnection newPersistentConnection(Context context, ConnectionContext connectionContext, HostInfo hostInfo, Delegate delegate);

    RunLoop newRunLoop(Context context);
}
