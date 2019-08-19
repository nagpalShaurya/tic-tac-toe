package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DatabaseReference extends Query {
    private static DatabaseConfig defaultConfig;

    @PublicApi
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface CompletionListener {
        @PublicApi
        void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference);
    }

    DatabaseReference(Repo repo, Path path) {
        super(repo, path);
    }

    DatabaseReference(String url, DatabaseConfig config) {
        this(Utilities.parseUrl(url), config);
    }

    private DatabaseReference(ParsedUrl parsedUrl, DatabaseConfig config) {
        this(RepoManager.getRepo(config, parsedUrl.repoInfo), parsedUrl.path);
    }

    @PublicApi
    @NonNull
    public DatabaseReference child(@NonNull String pathString) {
        if (pathString != null) {
            if (getPath().isEmpty()) {
                Validation.validateRootPathString(pathString);
            } else {
                Validation.validatePathString(pathString);
            }
            return new DatabaseReference(this.repo, getPath().child(new Path(pathString)));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
    }

    @PublicApi
    @NonNull
    public DatabaseReference push() {
        return new DatabaseReference(this.repo, getPath().child(ChildKey.fromString(PushIdGenerator.generatePushChildName(this.repo.getServerTime()))));
    }

    @PublicApi
    @NonNull
    public Task<Void> setValue(@Nullable Object value) {
        return setValueInternal(value, PriorityUtilities.parsePriority(this.path, null), null);
    }

    @PublicApi
    @NonNull
    public Task<Void> setValue(@Nullable Object value, @Nullable Object priority) {
        return setValueInternal(value, PriorityUtilities.parsePriority(this.path, priority), null);
    }

    @PublicApi
    public void setValue(@Nullable Object value, @Nullable CompletionListener listener) {
        setValueInternal(value, PriorityUtilities.parsePriority(this.path, null), listener);
    }

    @PublicApi
    public void setValue(@Nullable Object value, @Nullable Object priority, @Nullable CompletionListener listener) {
        setValueInternal(value, PriorityUtilities.parsePriority(this.path, priority), listener);
    }

    private Task<Void> setValueInternal(Object value, Node priority, CompletionListener optListener) {
        Validation.validateWritablePath(getPath());
        ValidationPath.validateWithObject(getPath(), value);
        Object bouncedValue = CustomClassMapper.convertToPlainJavaTypes(value);
        Validation.validateWritableObject(bouncedValue);
        final Node node = NodeUtilities.NodeFromJSON(bouncedValue, priority);
        final Pair<Task<Void>, CompletionListener> wrapped = Utilities.wrapOnComplete(optListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                DatabaseReference.this.repo.setValue(DatabaseReference.this.getPath(), node, (CompletionListener) wrapped.getSecond());
            }
        });
        return (Task) wrapped.getFirst();
    }

    @PublicApi
    @NonNull
    public Task<Void> setPriority(@Nullable Object priority) {
        return setPriorityInternal(PriorityUtilities.parsePriority(this.path, priority), null);
    }

    @PublicApi
    public void setPriority(@Nullable Object priority, @Nullable CompletionListener listener) {
        setPriorityInternal(PriorityUtilities.parsePriority(this.path, priority), listener);
    }

    private Task<Void> setPriorityInternal(final Node priority, CompletionListener optListener) {
        Validation.validateWritablePath(getPath());
        final Pair<Task<Void>, CompletionListener> wrapped = Utilities.wrapOnComplete(optListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                DatabaseReference.this.repo.setValue(DatabaseReference.this.getPath().child(ChildKey.getPriorityKey()), priority, (CompletionListener) wrapped.getSecond());
            }
        });
        return (Task) wrapped.getFirst();
    }

    @PublicApi
    @NonNull
    public Task<Void> updateChildren(@NonNull Map<String, Object> update) {
        return updateChildrenInternal(update, null);
    }

    @PublicApi
    public void updateChildren(@NonNull Map<String, Object> update, @Nullable CompletionListener listener) {
        updateChildrenInternal(update, listener);
    }

    private Task<Void> updateChildrenInternal(Map<String, Object> update, CompletionListener optListener) {
        if (update != null) {
            final Map<String, Object> bouncedUpdate = CustomClassMapper.convertToPlainJavaTypes(update);
            final CompoundWrite merge = CompoundWrite.fromPathMerge(Validation.parseAndValidateUpdate(getPath(), bouncedUpdate));
            final Pair<Task<Void>, CompletionListener> wrapped = Utilities.wrapOnComplete(optListener);
            this.repo.scheduleNow(new Runnable() {
                public void run() {
                    DatabaseReference.this.repo.updateChildren(DatabaseReference.this.getPath(), merge, (CompletionListener) wrapped.getSecond(), bouncedUpdate);
                }
            });
            return (Task) wrapped.getFirst();
        }
        throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
    }

    @PublicApi
    @NonNull
    public Task<Void> removeValue() {
        return setValue(null);
    }

    @PublicApi
    public void removeValue(@Nullable CompletionListener listener) {
        setValue((Object) null, listener);
    }

    @PublicApi
    @NonNull
    public OnDisconnect onDisconnect() {
        Validation.validateWritablePath(getPath());
        return new OnDisconnect(this.repo, getPath());
    }

    @PublicApi
    public void runTransaction(@NonNull Handler handler) {
        runTransaction(handler, true);
    }

    @PublicApi
    public void runTransaction(@NonNull final Handler handler, final boolean fireLocalEvents) {
        if (handler != null) {
            Validation.validateWritablePath(getPath());
            this.repo.scheduleNow(new Runnable() {
                public void run() {
                    DatabaseReference.this.repo.startTransaction(DatabaseReference.this.getPath(), handler, fireLocalEvents);
                }
            });
            return;
        }
        throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
    }

    @PublicApi
    public static void goOffline() {
        goOffline(getDefaultConfig());
    }

    static void goOffline(DatabaseConfig config) {
        RepoManager.interrupt((Context) config);
    }

    @PublicApi
    public static void goOnline() {
        goOnline(getDefaultConfig());
    }

    static void goOnline(DatabaseConfig config) {
        RepoManager.resume((Context) config);
    }

    @PublicApi
    @NonNull
    public FirebaseDatabase getDatabase() {
        return this.repo.getDatabase();
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.repo.toString();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(parent.toString());
            sb.append("/");
            sb.append(URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20"));
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to URLEncode key: ");
            sb2.append(getKey());
            throw new DatabaseException(sb2.toString(), e);
        }
    }

    @Nullable
    @PublicApi
    public DatabaseReference getParent() {
        Path parentPath = getPath().getParent();
        if (parentPath != null) {
            return new DatabaseReference(this.repo, parentPath);
        }
        return null;
    }

    @PublicApi
    @NonNull
    public DatabaseReference getRoot() {
        return new DatabaseReference(this.repo, new Path(""));
    }

    @Nullable
    @PublicApi
    public String getKey() {
        if (getPath().isEmpty()) {
            return null;
        }
        return getPath().getBack().asString();
    }

    public boolean equals(Object other) {
        return (other instanceof DatabaseReference) && toString().equals(other.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    /* access modifiers changed from: 0000 */
    public void setHijackHash(final boolean hijackHash) {
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                DatabaseReference.this.repo.setHijackHash(hijackHash);
            }
        });
    }

    private static synchronized DatabaseConfig getDefaultConfig() {
        DatabaseConfig databaseConfig;
        synchronized (DatabaseReference.class) {
            if (defaultConfig == null) {
                defaultConfig = new DatabaseConfig();
            }
            databaseConfig = defaultConfig;
        }
        return databaseConfig;
    }
}
