package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.Logger.Level;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import java.util.HashMap;
import java.util.Map;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class FirebaseDatabase {
    private static final String SDK_VERSION = "3.0.0";
    private static final Map<String, Map<RepoInfo, FirebaseDatabase>> databaseInstances = new HashMap();
    private final FirebaseApp app;
    private final DatabaseConfig config;
    /* access modifiers changed from: private */
    public Repo repo;
    private final RepoInfo repoInfo;

    @PublicApi
    @NonNull
    public static FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, instance.getOptions().getDatabaseUrl());
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @PublicApi
    @NonNull
    public static FirebaseDatabase getInstance(@NonNull String url) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, url);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @PublicApi
    @NonNull
    public static FirebaseDatabase getInstance(@NonNull FirebaseApp app2) {
        return getInstance(app2, app2.getOptions().getDatabaseUrl());
    }

    @PublicApi
    @NonNull
    public static synchronized FirebaseDatabase getInstance(@NonNull FirebaseApp app2, @NonNull String url) {
        FirebaseDatabase database;
        synchronized (FirebaseDatabase.class) {
            if (!TextUtils.isEmpty(url)) {
                Map map = (Map) databaseInstances.get(app2.getName());
                if (map == null) {
                    map = new HashMap();
                    databaseInstances.put(app2.getName(), map);
                }
                ParsedUrl parsedUrl = Utilities.parseUrl(url);
                if (parsedUrl.path.isEmpty()) {
                    database = (FirebaseDatabase) map.get(parsedUrl.repoInfo);
                    if (database == null) {
                        DatabaseConfig config2 = new DatabaseConfig();
                        if (!app2.isDefaultApp()) {
                            config2.setSessionPersistenceKey(app2.getName());
                        }
                        config2.setFirebaseApp(app2);
                        database = new FirebaseDatabase(app2, parsedUrl.repoInfo, config2);
                        map.put(parsedUrl.repoInfo, database);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Specified Database URL '");
                    sb.append(url);
                    sb.append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ");
                    sb.append(parsedUrl.path.toString());
                    throw new DatabaseException(sb.toString());
                }
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
        }
        return database;
    }

    static FirebaseDatabase createForTests(FirebaseApp app2, RepoInfo repoInfo2, DatabaseConfig config2) {
        FirebaseDatabase db = new FirebaseDatabase(app2, repoInfo2, config2);
        db.ensureRepo();
        return db;
    }

    private FirebaseDatabase(FirebaseApp app2, RepoInfo repoInfo2, DatabaseConfig config2) {
        this.app = app2;
        this.repoInfo = repoInfo2;
        this.config = config2;
    }

    @PublicApi
    @NonNull
    public FirebaseApp getApp() {
        return this.app;
    }

    @PublicApi
    @NonNull
    public DatabaseReference getReference() {
        ensureRepo();
        return new DatabaseReference(this.repo, Path.getEmptyPath());
    }

    @PublicApi
    @NonNull
    public DatabaseReference getReference(@NonNull String path) {
        ensureRepo();
        if (path != null) {
            Validation.validateRootPathString(path);
            return new DatabaseReference(this.repo, new Path(path));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
    }

    @PublicApi
    @NonNull
    public DatabaseReference getReferenceFromUrl(@NonNull String url) {
        ensureRepo();
        if (url != null) {
            ParsedUrl parsedUrl = Utilities.parseUrl(url);
            if (parsedUrl.repoInfo.host.equals(this.repo.getRepoInfo().host)) {
                return new DatabaseReference(this.repo, parsedUrl.path);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid URL (");
            sb.append(url);
            sb.append(") passed to getReference().  URL was expected to match configured Database URL: ");
            sb.append(getReference().toString());
            throw new DatabaseException(sb.toString());
        }
        throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
    }

    @PublicApi
    public void purgeOutstandingWrites() {
        ensureRepo();
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                FirebaseDatabase.this.repo.purgeOutstandingWrites();
            }
        });
    }

    @PublicApi
    public void goOnline() {
        ensureRepo();
        RepoManager.resume(this.repo);
    }

    @PublicApi
    public void goOffline() {
        ensureRepo();
        RepoManager.interrupt(this.repo);
    }

    @PublicApi
    public synchronized void setLogLevel(@NonNull Level logLevel) {
        assertUnfrozen("setLogLevel");
        this.config.setLogLevel(logLevel);
    }

    @PublicApi
    public synchronized void setPersistenceEnabled(boolean isEnabled) {
        assertUnfrozen("setPersistenceEnabled");
        this.config.setPersistenceEnabled(isEnabled);
    }

    @PublicApi
    public synchronized void setPersistenceCacheSizeBytes(long cacheSizeInBytes) {
        assertUnfrozen("setPersistenceCacheSizeBytes");
        this.config.setPersistenceCacheSizeBytes(cacheSizeInBytes);
    }

    @PublicApi
    @NonNull
    public static String getSdkVersion() {
        return SDK_VERSION;
    }

    private void assertUnfrozen(String methodCalled) {
        if (this.repo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calls to ");
            sb.append(methodCalled);
            sb.append("() must be made before any other usage of FirebaseDatabase instance.");
            throw new DatabaseException(sb.toString());
        }
    }

    private synchronized void ensureRepo() {
        if (this.repo == null) {
            this.repo = RepoManager.createRepo(this.config, this.repoInfo, this);
        }
    }

    /* access modifiers changed from: 0000 */
    public DatabaseConfig getConfig() {
        return this.config;
    }
}
