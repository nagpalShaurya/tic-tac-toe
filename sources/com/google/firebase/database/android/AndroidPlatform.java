package com.google.firebase.database.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.BackgroundStateChangeListener;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.core.Platform;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.persistence.DefaultPersistenceManager;
import com.google.firebase.database.core.persistence.LRUCachePolicy;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.AndroidLogger;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class AndroidPlatform implements Platform {
    private static final String APP_IN_BACKGROUND_INTERRUPT_REASON = "app_in_background";
    /* access modifiers changed from: private */
    public final Context applicationContext;
    private final Set<String> createdPersistenceCaches = new HashSet();
    private final FirebaseApp firebaseApp;

    public AndroidPlatform(FirebaseApp app) {
        this.firebaseApp = app;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        if (firebaseApp2 != null) {
            this.applicationContext = firebaseApp2.getApplicationContext();
            return;
        }
        String str = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        String str2 = "FirebaseDatabase";
        Log.e(str2, str);
        Log.e(str2, "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e(str2, str);
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }

    public EventTarget newEventTarget(com.google.firebase.database.core.Context context) {
        return new AndroidEventTarget();
    }

    public RunLoop newRunLoop(com.google.firebase.database.core.Context ctx) {
        final LogWrapper logger = ctx.getLogger("RunLoop");
        return new DefaultRunLoop() {
            public void handleException(final Throwable e) {
                final String message = DefaultRunLoop.messageForException(e);
                logger.error(message, e);
                new Handler(AndroidPlatform.this.applicationContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        throw new RuntimeException(message, e);
                    }
                });
                getExecutorService().shutdownNow();
            }
        };
    }

    public AuthTokenProvider newAuthTokenProvider(ScheduledExecutorService executorService) {
        return new AndroidAuthTokenProvider(this.firebaseApp, executorService);
    }

    public PersistentConnection newPersistentConnection(com.google.firebase.database.core.Context context, ConnectionContext connectionContext, HostInfo info, Delegate delegate) {
        final PersistentConnection connection = new PersistentConnectionImpl(connectionContext, info, delegate);
        this.firebaseApp.addBackgroundStateChangeListener(new BackgroundStateChangeListener() {
            public void onBackgroundStateChanged(boolean background) {
                String str = AndroidPlatform.APP_IN_BACKGROUND_INTERRUPT_REASON;
                if (background) {
                    connection.interrupt(str);
                } else {
                    connection.resume(str);
                }
            }
        });
        return connection;
    }

    public Logger newLogger(com.google.firebase.database.core.Context context, Level component, List<String> enabledComponents) {
        return new AndroidLogger(component, enabledComponents);
    }

    public String getUserAgent(com.google.firebase.database.core.Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERSION.SDK_INT);
        sb.append("/Android");
        return sb.toString();
    }

    public String getPlatformVersion() {
        StringBuilder sb = new StringBuilder();
        sb.append("android-");
        sb.append(FirebaseDatabase.getSdkVersion());
        return sb.toString();
    }

    public PersistenceManager createPersistenceManager(com.google.firebase.database.core.Context firebaseContext, String firebaseId) {
        String sessionId = firebaseContext.getSessionPersistenceKey();
        StringBuilder sb = new StringBuilder();
        sb.append(firebaseId);
        sb.append("_");
        sb.append(sessionId);
        String cacheId = sb.toString();
        if (!this.createdPersistenceCaches.contains(cacheId)) {
            this.createdPersistenceCaches.add(cacheId);
            return new DefaultPersistenceManager(firebaseContext, new SqlPersistenceStorageEngine(this.applicationContext, firebaseContext, cacheId), new LRUCachePolicy(firebaseContext.getPersistenceCacheSizeBytes()));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SessionPersistenceKey '");
        sb2.append(sessionId);
        sb2.append("' has already been used.");
        throw new DatabaseException(sb2.toString());
    }

    public File getSSLCacheDirectory() {
        return this.applicationContext.getApplicationContext().getDir("sslcache", 0);
    }
}
