package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.ChildEventRegistration;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PathIndex;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.ValueIndex;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Query {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean orderByCalled;
    protected final QueryParams params;
    protected final Path path;
    protected final Repo repo;

    Query(Repo repo2, Path path2, QueryParams params2, boolean orderByCalled2) throws DatabaseException {
        this.repo = repo2;
        this.path = path2;
        this.params = params2;
        this.orderByCalled = orderByCalled2;
        Utilities.hardAssert(params2.isValid(), "Validation of queries failed.");
    }

    Query(Repo repo2, Path path2) {
        this.repo = repo2;
        this.path = path2;
        this.params = QueryParams.DEFAULT_PARAMS;
        this.orderByCalled = false;
    }

    private void validateQueryEndpoints(QueryParams params2) {
        if (params2.getIndex().equals(KeyIndex.getInstance())) {
            String message = "You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported";
            if (params2.hasStart()) {
                Node startNode = params2.getIndexStartValue();
                if (!Objects.equal(params2.getIndexStartName(), ChildKey.getMinName()) || !(startNode instanceof StringNode)) {
                    throw new IllegalArgumentException(message);
                }
            }
            if (params2.hasEnd()) {
                Node endNode = params2.getIndexEndValue();
                if (!params2.getIndexEndName().equals(ChildKey.getMaxName()) || !(endNode instanceof StringNode)) {
                    throw new IllegalArgumentException(message);
                }
            }
        } else if (!params2.getIndex().equals(PriorityIndex.getInstance())) {
        } else {
            if ((params2.hasStart() && !PriorityUtilities.isValidPriority(params2.getIndexStartValue())) || (params2.hasEnd() && !PriorityUtilities.isValidPriority(params2.getIndexEndValue()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
            }
        }
    }

    private void validateLimit(QueryParams params2) {
        if (params2.hasStart() && params2.hasEnd() && params2.hasLimit() && !params2.hasAnchoredLimit()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private void validateEqualToCall() {
        if (this.params.hasStart()) {
            throw new IllegalArgumentException("Can't call equalTo() and startAt() combined");
        } else if (this.params.hasEnd()) {
            throw new IllegalArgumentException("Can't call equalTo() and endAt() combined");
        }
    }

    private void validateNoOrderByCall() {
        if (this.orderByCalled) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    @PublicApi
    @NonNull
    public ValueEventListener addValueEventListener(@NonNull ValueEventListener listener) {
        addEventRegistration(new ValueEventRegistration(this.repo, listener, getSpec()));
        return listener;
    }

    @PublicApi
    @NonNull
    public ChildEventListener addChildEventListener(@NonNull ChildEventListener listener) {
        addEventRegistration(new ChildEventRegistration(this.repo, listener, getSpec()));
        return listener;
    }

    @PublicApi
    public void addListenerForSingleValueEvent(@NonNull final ValueEventListener listener) {
        addEventRegistration(new ValueEventRegistration(this.repo, new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                Query.this.removeEventListener((ValueEventListener) this);
                listener.onDataChange(snapshot);
            }

            public void onCancelled(DatabaseError error) {
                listener.onCancelled(error);
            }
        }, getSpec()));
    }

    @PublicApi
    public void removeEventListener(@NonNull ValueEventListener listener) {
        if (listener != null) {
            removeEventRegistration(new ValueEventRegistration(this.repo, listener, getSpec()));
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    @PublicApi
    public void removeEventListener(@NonNull ChildEventListener listener) {
        if (listener != null) {
            removeEventRegistration(new ChildEventRegistration(this.repo, listener, getSpec()));
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    private void removeEventRegistration(final EventRegistration registration) {
        ZombieEventManager.getInstance().zombifyForRemove(registration);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                Query.this.repo.removeEventCallback(registration);
            }
        });
    }

    private void addEventRegistration(final EventRegistration listener) {
        ZombieEventManager.getInstance().recordEventRegistration(listener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                Query.this.repo.addEventCallback(listener);
            }
        });
    }

    @PublicApi
    public void keepSynced(final boolean keepSynced) {
        if (this.path.isEmpty() || !this.path.getFront().equals(ChildKey.getInfoKey())) {
            this.repo.scheduleNow(new Runnable() {
                public void run() {
                    Query.this.repo.keepSynced(Query.this.getSpec(), keepSynced);
                }
            });
            return;
        }
        throw new DatabaseException("Can't call keepSynced() on .info paths.");
    }

    @PublicApi
    @NonNull
    public Query startAt(@Nullable String value) {
        return startAt(value, (String) null);
    }

    @PublicApi
    @NonNull
    public Query startAt(double value) {
        return startAt(value, (String) null);
    }

    @PublicApi
    @NonNull
    public Query startAt(boolean value) {
        return startAt(value, (String) null);
    }

    @PublicApi
    @NonNull
    public Query startAt(@Nullable String value, @Nullable String key) {
        return startAt(value != null ? new StringNode(value, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), key);
    }

    @PublicApi
    @NonNull
    public Query startAt(double value, @Nullable String key) {
        return startAt((Node) new DoubleNode(Double.valueOf(value), PriorityUtilities.NullPriority()), key);
    }

    @PublicApi
    @NonNull
    public Query startAt(boolean value, @Nullable String key) {
        return startAt((Node) new BooleanNode(Boolean.valueOf(value), PriorityUtilities.NullPriority()), key);
    }

    private Query startAt(Node node, String key) {
        Validation.validateNullableKey(key);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        } else if (!this.params.hasStart()) {
            QueryParams newParams = this.params.startAt(node, key != null ? ChildKey.fromString(key) : null);
            validateLimit(newParams);
            validateQueryEndpoints(newParams);
            return new Query(this.repo, this.path, newParams, this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        }
    }

    @PublicApi
    @NonNull
    public Query endAt(@Nullable String value) {
        return endAt(value, (String) null);
    }

    @PublicApi
    @NonNull
    public Query endAt(double value) {
        return endAt(value, (String) null);
    }

    @PublicApi
    @NonNull
    public Query endAt(boolean value) {
        return endAt(value, (String) null);
    }

    @PublicApi
    @NonNull
    public Query endAt(@Nullable String value, @Nullable String key) {
        return endAt(value != null ? new StringNode(value, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), key);
    }

    @PublicApi
    @NonNull
    public Query endAt(double value, @Nullable String key) {
        return endAt((Node) new DoubleNode(Double.valueOf(value), PriorityUtilities.NullPriority()), key);
    }

    @PublicApi
    @NonNull
    public Query endAt(boolean value, @Nullable String key) {
        return endAt((Node) new BooleanNode(Boolean.valueOf(value), PriorityUtilities.NullPriority()), key);
    }

    private Query endAt(Node node, String key) {
        Validation.validateNullableKey(key);
        if (node.isLeafNode() || node.isEmpty()) {
            ChildKey childKey = key != null ? ChildKey.fromString(key) : null;
            if (!this.params.hasEnd()) {
                QueryParams newParams = this.params.endAt(node, childKey);
                validateLimit(newParams);
                validateQueryEndpoints(newParams);
                return new Query(this.repo, this.path, newParams, this.orderByCalled);
            }
            throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        }
        throw new IllegalArgumentException("Can only use simple values for endAt()");
    }

    @PublicApi
    @NonNull
    public Query equalTo(@Nullable String value) {
        validateEqualToCall();
        return startAt(value).endAt(value);
    }

    @PublicApi
    @NonNull
    public Query equalTo(double value) {
        validateEqualToCall();
        return startAt(value).endAt(value);
    }

    @PublicApi
    @NonNull
    public Query equalTo(boolean value) {
        validateEqualToCall();
        return startAt(value).endAt(value);
    }

    @PublicApi
    @NonNull
    public Query equalTo(@Nullable String value, @Nullable String key) {
        validateEqualToCall();
        return startAt(value, key).endAt(value, key);
    }

    @PublicApi
    @NonNull
    public Query equalTo(double value, @Nullable String key) {
        validateEqualToCall();
        return startAt(value, key).endAt(value, key);
    }

    @PublicApi
    @NonNull
    public Query equalTo(boolean value, @Nullable String key) {
        validateEqualToCall();
        return startAt(value, key).endAt(value, key);
    }

    @PublicApi
    @NonNull
    public Query limitToFirst(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.params.hasLimit()) {
            return new Query(this.repo, this.path, this.params.limitToFirst(limit), this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    @PublicApi
    @NonNull
    public Query limitToLast(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.params.hasLimit()) {
            return new Query(this.repo, this.path, this.params.limitToLast(limit), this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    @PublicApi
    @NonNull
    public Query orderByChild(@NonNull String path2) {
        if (path2 != null) {
            String str = "Can't use '";
            if (path2.equals("$key") || path2.equals(".key")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(path2);
                sb.append("' as path, please use orderByKey() instead!");
                throw new IllegalArgumentException(sb.toString());
            } else if (path2.equals("$priority") || path2.equals(".priority")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(path2);
                sb2.append("' as path, please use orderByPriority() instead!");
                throw new IllegalArgumentException(sb2.toString());
            } else if (path2.equals("$value") || path2.equals(".value")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(path2);
                sb3.append("' as path, please use orderByValue() instead!");
                throw new IllegalArgumentException(sb3.toString());
            } else {
                Validation.validatePathString(path2);
                validateNoOrderByCall();
                Path indexPath = new Path(path2);
                if (indexPath.size() != 0) {
                    return new Query(this.repo, this.path, this.params.orderBy(new PathIndex(indexPath)), true);
                }
                throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
            }
        } else {
            throw new NullPointerException("Key can't be null");
        }
    }

    @PublicApi
    @NonNull
    public Query orderByPriority() {
        validateNoOrderByCall();
        QueryParams newParams = this.params.orderBy(PriorityIndex.getInstance());
        validateQueryEndpoints(newParams);
        return new Query(this.repo, this.path, newParams, true);
    }

    @PublicApi
    @NonNull
    public Query orderByKey() {
        validateNoOrderByCall();
        QueryParams newParams = this.params.orderBy(KeyIndex.getInstance());
        validateQueryEndpoints(newParams);
        return new Query(this.repo, this.path, newParams, true);
    }

    @PublicApi
    @NonNull
    public Query orderByValue() {
        validateNoOrderByCall();
        return new Query(this.repo, this.path, this.params.orderBy(ValueIndex.getInstance()), true);
    }

    @PublicApi
    @NonNull
    public DatabaseReference getRef() {
        return new DatabaseReference(this.repo, getPath());
    }

    public Path getPath() {
        return this.path;
    }

    public Repo getRepo() {
        return this.repo;
    }

    public QuerySpec getSpec() {
        return new QuerySpec(this.path, this.params);
    }
}
