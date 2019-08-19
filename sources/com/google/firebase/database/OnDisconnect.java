package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Map;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class OnDisconnect {
    /* access modifiers changed from: private */
    public Path path;
    /* access modifiers changed from: private */
    public Repo repo;

    OnDisconnect(Repo repo2, Path path2) {
        this.repo = repo2;
        this.path = path2;
    }

    @PublicApi
    @NonNull
    public Task<Void> setValue(@Nullable Object value) {
        return onDisconnectSetInternal(value, PriorityUtilities.NullPriority(), null);
    }

    @PublicApi
    @NonNull
    public Task<Void> setValue(@Nullable Object value, @Nullable String priority) {
        return onDisconnectSetInternal(value, PriorityUtilities.parsePriority(this.path, priority), null);
    }

    @PublicApi
    @NonNull
    public Task<Void> setValue(@Nullable Object value, double priority) {
        return onDisconnectSetInternal(value, PriorityUtilities.parsePriority(this.path, Double.valueOf(priority)), null);
    }

    @PublicApi
    public void setValue(@Nullable Object value, @Nullable CompletionListener listener) {
        onDisconnectSetInternal(value, PriorityUtilities.NullPriority(), listener);
    }

    @PublicApi
    public void setValue(@Nullable Object value, @Nullable String priority, @Nullable CompletionListener listener) {
        onDisconnectSetInternal(value, PriorityUtilities.parsePriority(this.path, priority), listener);
    }

    @PublicApi
    public void setValue(@Nullable Object value, double priority, @Nullable CompletionListener listener) {
        onDisconnectSetInternal(value, PriorityUtilities.parsePriority(this.path, Double.valueOf(priority)), listener);
    }

    @PublicApi
    public void setValue(@Nullable Object value, @Nullable Map priority, @Nullable CompletionListener listener) {
        onDisconnectSetInternal(value, PriorityUtilities.parsePriority(this.path, priority), listener);
    }

    private Task<Void> onDisconnectSetInternal(Object value, Node priority, CompletionListener optListener) {
        Validation.validateWritablePath(this.path);
        ValidationPath.validateWithObject(this.path, value);
        Object bouncedValue = CustomClassMapper.convertToPlainJavaTypes(value);
        Validation.validateWritableObject(bouncedValue);
        final Node node = NodeUtilities.NodeFromJSON(bouncedValue, priority);
        final Pair<Task<Void>, CompletionListener> wrapped = Utilities.wrapOnComplete(optListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                OnDisconnect.this.repo.onDisconnectSetValue(OnDisconnect.this.path, node, (CompletionListener) wrapped.getSecond());
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

    private Task<Void> updateChildrenInternal(final Map<String, Object> update, CompletionListener optListener) {
        final Map<Path, Node> parsedUpdate = Validation.parseAndValidateUpdate(this.path, update);
        final Pair<Task<Void>, CompletionListener> wrapped = Utilities.wrapOnComplete(optListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                OnDisconnect.this.repo.onDisconnectUpdate(OnDisconnect.this.path, parsedUpdate, (CompletionListener) wrapped.getSecond(), update);
            }
        });
        return (Task) wrapped.getFirst();
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
    public Task<Void> cancel() {
        return cancelInternal(null);
    }

    @PublicApi
    public void cancel(@NonNull CompletionListener listener) {
        cancelInternal(listener);
    }

    private Task<Void> cancelInternal(CompletionListener optListener) {
        final Pair<Task<Void>, CompletionListener> wrapped = Utilities.wrapOnComplete(optListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                OnDisconnect.this.repo.onDisconnectCancel(OnDisconnect.this.path, (CompletionListener) wrapped.getSecond());
            }
        });
        return (Task) wrapped.getFirst();
    }
}
