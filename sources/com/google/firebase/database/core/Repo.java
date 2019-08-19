package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.Transaction.Result;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener;
import com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor;
import com.google.firebase.database.core.SyncTree.CompletionListener;
import com.google.firebase.database.core.SyncTree.ListenProvider;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Tree.TreeFilter;
import com.google.firebase.database.core.utilities.Tree.TreeVisitor;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Repo implements Delegate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INTERRUPT_REASON = "repo_interrupt";
    private static final int TRANSACTION_MAX_RETRIES = 25;
    private static final String TRANSACTION_OVERRIDE_BY_SET = "overriddenBySet";
    private static final String TRANSACTION_TOO_MANY_RETRIES = "maxretries";
    /* access modifiers changed from: private */
    public PersistentConnection connection;
    private final Context ctx;
    private final LogWrapper dataLogger;
    public long dataUpdateCount = 0;
    private FirebaseDatabase database;
    private final EventRaiser eventRaiser;
    private boolean hijackHash = false;
    /* access modifiers changed from: private */
    public SnapshotHolder infoData;
    /* access modifiers changed from: private */
    public SyncTree infoSyncTree;
    private boolean loggedTransactionPersistenceWarning = false;
    private long nextWriteId = 1;
    /* access modifiers changed from: private */
    public SparseSnapshotTree onDisconnect;
    /* access modifiers changed from: private */
    public final LogWrapper operationLogger;
    private final RepoInfo repoInfo;
    /* access modifiers changed from: private */
    public final OffsetClock serverClock = new OffsetClock(new DefaultClock(), 0);
    /* access modifiers changed from: private */
    public SyncTree serverSyncTree;
    private final LogWrapper transactionLogger;
    private long transactionOrder = 0;
    /* access modifiers changed from: private */
    public Tree<List<TransactionData>> transactionQueueTree;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class TransactionData implements Comparable<TransactionData> {
        /* access modifiers changed from: private */
        public DatabaseError abortReason;
        /* access modifiers changed from: private */
        public boolean applyLocally;
        /* access modifiers changed from: private */
        public Node currentInputSnapshot;
        /* access modifiers changed from: private */
        public Node currentOutputSnapshotRaw;
        /* access modifiers changed from: private */
        public Node currentOutputSnapshotResolved;
        /* access modifiers changed from: private */
        public long currentWriteId;
        /* access modifiers changed from: private */
        public Handler handler;
        private long order;
        /* access modifiers changed from: private */
        public ValueEventListener outstandingListener;
        /* access modifiers changed from: private */
        public Path path;
        /* access modifiers changed from: private */
        public int retryCount;
        /* access modifiers changed from: private */
        public TransactionStatus status;

        private TransactionData(Path path2, Handler handler2, ValueEventListener outstandingListener2, TransactionStatus status2, boolean applyLocally2, long order2) {
            this.path = path2;
            this.handler = handler2;
            this.outstandingListener = outstandingListener2;
            this.status = status2;
            this.retryCount = 0;
            this.applyLocally = applyLocally2;
            this.order = order2;
            this.abortReason = null;
            this.currentInputSnapshot = null;
            this.currentOutputSnapshotRaw = null;
            this.currentOutputSnapshotResolved = null;
        }

        public int compareTo(TransactionData o) {
            long j = this.order;
            long j2 = o.order;
            if (j < j2) {
                return -1;
            }
            if (j == j2) {
                return 0;
            }
            return 1;
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private enum TransactionStatus {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    Repo(RepoInfo repoInfo2, Context ctx2, FirebaseDatabase database2) {
        this.repoInfo = repoInfo2;
        this.ctx = ctx2;
        this.database = database2;
        this.operationLogger = this.ctx.getLogger("RepoOperation");
        this.transactionLogger = this.ctx.getLogger("Transaction");
        this.dataLogger = this.ctx.getLogger("DataOperation");
        this.eventRaiser = new EventRaiser(this.ctx);
        scheduleNow(new Runnable() {
            public void run() {
                Repo.this.deferredInitialization();
            }
        });
    }

    /* access modifiers changed from: private */
    public void deferredInitialization() {
        this.connection = this.ctx.newPersistentConnection(new HostInfo(this.repoInfo.host, this.repoInfo.namespace, this.repoInfo.secure), this);
        this.ctx.getAuthTokenProvider().addTokenChangeListener(new TokenChangeListener() {
            public void onTokenChange() {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken();
            }

            public void onTokenChange(String token) {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken(token);
            }
        });
        this.connection.initialize();
        PersistenceManager persistenceManager = this.ctx.getPersistenceManager(this.repoInfo.host);
        this.infoData = new SnapshotHolder();
        this.onDisconnect = new SparseSnapshotTree();
        this.transactionQueueTree = new Tree<>();
        this.infoSyncTree = new SyncTree(this.ctx, new NoopPersistenceManager(), new ListenProvider() {
            public void startListening(final QuerySpec query, Tag tag, ListenHashProvider hash, final CompletionListener onComplete) {
                Repo.this.scheduleNow(new Runnable() {
                    public void run() {
                        Node node = Repo.this.infoData.getNode(query.getPath());
                        if (!node.isEmpty()) {
                            Repo.this.postEvents(Repo.this.infoSyncTree.applyServerOverwrite(query.getPath(), node));
                            onComplete.onListenComplete(null);
                        }
                    }
                });
            }

            public void stopListening(QuerySpec query, Tag tag) {
            }
        });
        this.serverSyncTree = new SyncTree(this.ctx, persistenceManager, new ListenProvider() {
            public void startListening(QuerySpec query, Tag tag, ListenHashProvider hash, final CompletionListener onListenComplete) {
                Repo.this.connection.listen(query.getPath().asList(), query.getParams().getWireProtocolParams(), hash, tag != null ? Long.valueOf(tag.getTagNumber()) : null, new RequestResultCallback() {
                    public void onRequestResult(String optErrorCode, String optErrorMessage) {
                        Repo.this.postEvents(onListenComplete.onListenComplete(Repo.fromErrorCode(optErrorCode, optErrorMessage)));
                    }
                });
            }

            public void stopListening(QuerySpec query, Tag tag) {
                Repo.this.connection.unlisten(query.getPath().asList(), query.getParams().getWireProtocolParams());
            }
        });
        restoreWrites(persistenceManager);
        ChildKey childKey = Constants.DOT_INFO_AUTHENTICATED;
        Boolean valueOf = Boolean.valueOf(false);
        updateInfo(childKey, valueOf);
        updateInfo(Constants.DOT_INFO_CONNECTED, valueOf);
    }

    private void restoreWrites(PersistenceManager persistenceManager) {
        List<UserWriteRecord> writes = persistenceManager.loadUserWrites();
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        long lastWriteId = Long.MIN_VALUE;
        for (final UserWriteRecord write : writes) {
            RequestResultCallback onComplete = new RequestResultCallback() {
                public void onRequestResult(String optErrorCode, String optErrorMessage) {
                    DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                    Repo.this.warnIfWriteFailed("Persisted write", write.getPath(), error);
                    Repo.this.ackWriteAndRerunTransactions(write.getWriteId(), write.getPath(), error);
                }
            };
            if (lastWriteId < write.getWriteId()) {
                lastWriteId = write.getWriteId();
                this.nextWriteId = write.getWriteId() + 1;
                if (write.isOverwrite()) {
                    if (this.operationLogger.logsDebug()) {
                        LogWrapper logWrapper = this.operationLogger;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Restoring overwrite with id ");
                        sb.append(write.getWriteId());
                        logWrapper.debug(sb.toString(), new Object[0]);
                    }
                    this.connection.put(write.getPath().asList(), write.getOverwrite().getValue(true), onComplete);
                    this.serverSyncTree.applyUserOverwrite(write.getPath(), write.getOverwrite(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), serverValues), write.getWriteId(), true, false);
                } else {
                    if (this.operationLogger.logsDebug()) {
                        LogWrapper logWrapper2 = this.operationLogger;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Restoring merge with id ");
                        sb2.append(write.getWriteId());
                        logWrapper2.debug(sb2.toString(), new Object[0]);
                    }
                    this.connection.merge(write.getPath().asList(), write.getMerge().getValue(true), onComplete);
                    this.serverSyncTree.applyUserMerge(write.getPath(), write.getMerge(), ServerValues.resolveDeferredValueMerge(write.getMerge(), serverValues), write.getWriteId(), false);
                }
            } else {
                throw new IllegalStateException("Write ids were not in order.");
            }
        }
    }

    public FirebaseDatabase getDatabase() {
        return this.database;
    }

    public String toString() {
        return this.repoInfo.toString();
    }

    public RepoInfo getRepoInfo() {
        return this.repoInfo;
    }

    public void scheduleNow(Runnable r) {
        this.ctx.requireStarted();
        this.ctx.getRunLoop().scheduleNow(r);
    }

    public void postEvent(Runnable r) {
        this.ctx.requireStarted();
        this.ctx.getEventTarget().postEvent(r);
    }

    /* access modifiers changed from: private */
    public void postEvents(List<? extends Event> events) {
        if (!events.isEmpty()) {
            this.eventRaiser.raiseEvents(events);
        }
    }

    public long getServerTime() {
        return this.serverClock.millis();
    }

    /* access modifiers changed from: 0000 */
    public boolean hasListeners() {
        return !this.infoSyncTree.isEmpty() || !this.serverSyncTree.isEmpty();
    }

    public void onDataUpdate(List<String> pathSegments, Object message, boolean isMerge, Long optTag) {
        List list;
        Path path = new Path(pathSegments);
        String str = "onDataUpdate: ";
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(path);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.operationLogger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(path);
            sb2.append(" ");
            sb2.append(message);
            logWrapper2.debug(sb2.toString(), new Object[0]);
        }
        this.dataUpdateCount++;
        if (optTag != null) {
            try {
                Tag tag = new Tag(optTag.longValue());
                if (isMerge) {
                    Map<Path, Node> taggedChildren = new HashMap<>();
                    for (Entry<String, Object> entry : ((Map) message).entrySet()) {
                        taggedChildren.put(new Path((String) entry.getKey()), NodeUtilities.NodeFromJSON(entry.getValue()));
                    }
                    list = this.serverSyncTree.applyTaggedQueryMerge(path, taggedChildren, tag);
                } else {
                    list = this.serverSyncTree.applyTaggedQueryOverwrite(path, NodeUtilities.NodeFromJSON(message), tag);
                }
            } catch (DatabaseException e) {
                this.operationLogger.error("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (isMerge) {
            Map<Path, Node> changedChildren = new HashMap<>();
            for (Entry<String, Object> entry2 : ((Map) message).entrySet()) {
                changedChildren.put(new Path((String) entry2.getKey()), NodeUtilities.NodeFromJSON(entry2.getValue()));
            }
            list = this.serverSyncTree.applyServerMerge(path, changedChildren);
        } else {
            list = this.serverSyncTree.applyServerOverwrite(path, NodeUtilities.NodeFromJSON(message));
        }
        if (list.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(list);
    }

    public void onRangeMergeUpdate(List<String> pathSegments, List<RangeMerge> merges, Long tagNumber) {
        List<? extends Event> events;
        Path path = new Path(pathSegments);
        String str = "onRangeMergeUpdate: ";
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(path);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.operationLogger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(path);
            sb2.append(" ");
            sb2.append(merges);
            logWrapper2.debug(sb2.toString(), new Object[0]);
        }
        this.dataUpdateCount++;
        List<com.google.firebase.database.snapshot.RangeMerge> parsedMerges = new ArrayList<>(merges.size());
        for (RangeMerge merge : merges) {
            parsedMerges.add(new com.google.firebase.database.snapshot.RangeMerge(merge));
        }
        if (tagNumber != null) {
            events = this.serverSyncTree.applyTaggedRangeMerges(path, parsedMerges, new Tag(tagNumber.longValue()));
        } else {
            events = this.serverSyncTree.applyServerRangeMerges(path, parsedMerges);
        }
        if (events.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(events);
    }

    /* access modifiers changed from: 0000 */
    public void callOnComplete(final DatabaseReference.CompletionListener onComplete, final DatabaseError error, Path path) {
        final DatabaseReference ref;
        if (onComplete != null) {
            ChildKey last = path.getBack();
            if (last == null || !last.isPriorityChildName()) {
                ref = InternalHelpers.createReference(this, path);
            } else {
                ref = InternalHelpers.createReference(this, path.getParent());
            }
            postEvent(new Runnable() {
                public void run() {
                    onComplete.onComplete(error, ref);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void ackWriteAndRerunTransactions(long writeId, Path path, DatabaseError error) {
        if (error == null || error.getCode() != -25) {
            List<? extends Event> clearEvents = this.serverSyncTree.ackUserWrite(writeId, !(error == null), true, this.serverClock);
            if (clearEvents.size() > 0) {
                rerunTransactions(path);
            }
            postEvents(clearEvents);
        }
    }

    public void setValue(Path path, Node newValueUnresolved, DatabaseReference.CompletionListener onComplete) {
        Path path2 = path;
        Node node = newValueUnresolved;
        String str = "set: ";
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(path2);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(path2);
            sb2.append(" ");
            sb2.append(node);
            logWrapper2.debug(sb2.toString(), new Object[0]);
        }
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        Node newValue = ServerValues.resolveDeferredValueSnapshot(node, serverValues);
        long writeId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserOverwrite(path, newValueUnresolved, newValue, writeId, true, true));
        PersistentConnection persistentConnection = this.connection;
        List asList = path.asList();
        Object value = node.getValue(true);
        final Path path3 = path;
        Map map = serverValues;
        final long j = writeId;
        final DatabaseReference.CompletionListener completionListener = onComplete;
        C04537 r0 = new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("setValue", path3, error);
                Repo.this.ackWriteAndRerunTransactions(j, path3, error);
                Repo.this.callOnComplete(completionListener, error, path3);
            }
        };
        persistentConnection.put(asList, value, r0);
        rerunTransactions(abortTransactions(path2, -9));
    }

    public void updateChildren(Path path, CompoundWrite updates, DatabaseReference.CompletionListener onComplete, Map<String, Object> unParsedUpdates) {
        Path path2 = path;
        Map<String, Object> map = unParsedUpdates;
        String str = "update: ";
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(path2);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(path2);
            sb2.append(" ");
            sb2.append(map);
            logWrapper2.debug(sb2.toString(), new Object[0]);
        }
        if (updates.isEmpty()) {
            if (this.operationLogger.logsDebug()) {
                this.operationLogger.debug("update called with no changes. No-op", new Object[0]);
            }
            callOnComplete(onComplete, null, path2);
            return;
        }
        final DatabaseReference.CompletionListener completionListener = onComplete;
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        CompoundWrite resolved = ServerValues.resolveDeferredValueMerge(updates, serverValues);
        long writeId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserMerge(path, updates, resolved, writeId, true));
        PersistentConnection persistentConnection = this.connection;
        List asList = path.asList();
        final Path path3 = path;
        Map map2 = serverValues;
        final long j = writeId;
        C04548 r0 = new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("updateChildren", path3, error);
                Repo.this.ackWriteAndRerunTransactions(j, path3, error);
                Repo.this.callOnComplete(completionListener, error, path3);
            }
        };
        persistentConnection.merge(asList, map, r0);
        Iterator it = updates.iterator();
        while (it.hasNext()) {
            rerunTransactions(abortTransactions(path2.child((Path) ((Entry) it.next()).getKey()), -9));
        }
    }

    public void purgeOutstandingWrites() {
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("Purging writes", new Object[0]);
        }
        postEvents(this.serverSyncTree.removeAllWrites());
        abortTransactions(Path.getEmptyPath(), -25);
        this.connection.purgeOutstandingWrites();
    }

    public void removeEventCallback(@NotNull EventRegistration eventRegistration) {
        List<Event> events;
        if (Constants.DOT_INFO.equals(eventRegistration.getQuerySpec().getPath().getFront())) {
            events = this.infoSyncTree.removeEventRegistration(eventRegistration);
        } else {
            events = this.serverSyncTree.removeEventRegistration(eventRegistration);
        }
        postEvents(events);
    }

    public void onDisconnectSetValue(final Path path, final Node newValue, final DatabaseReference.CompletionListener onComplete) {
        this.connection.onDisconnectPut(path.asList(), newValue.getValue(true), new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("onDisconnect().setValue", path, error);
                if (error == null) {
                    Repo.this.onDisconnect.remember(path, newValue);
                }
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
    }

    public void onDisconnectUpdate(final Path path, final Map<Path, Node> newChildren, final DatabaseReference.CompletionListener listener, Map<String, Object> unParsedUpdates) {
        this.connection.onDisconnectMerge(path.asList(), unParsedUpdates, new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("onDisconnect().updateChildren", path, error);
                if (error == null) {
                    for (Entry<Path, Node> entry : newChildren.entrySet()) {
                        Repo.this.onDisconnect.remember(path.child((Path) entry.getKey()), (Node) entry.getValue());
                    }
                }
                Repo.this.callOnComplete(listener, error, path);
            }
        });
    }

    public void onDisconnectCancel(final Path path, final DatabaseReference.CompletionListener onComplete) {
        this.connection.onDisconnectCancel(path.asList(), new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                if (error == null) {
                    Repo.this.onDisconnect.forget(path);
                }
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
    }

    public void onConnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, Boolean.valueOf(true));
    }

    public void onDisconnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, Boolean.valueOf(false));
        runOnDisconnectEvents();
    }

    public void onAuthStatus(boolean authOk) {
        onServerInfoUpdate(Constants.DOT_INFO_AUTHENTICATED, Boolean.valueOf(authOk));
    }

    public void onServerInfoUpdate(ChildKey key, Object value) {
        updateInfo(key, value);
    }

    public void onServerInfoUpdate(Map<String, Object> updates) {
        for (Entry<String, Object> entry : updates.entrySet()) {
            updateInfo(ChildKey.fromString((String) entry.getKey()), entry.getValue());
        }
    }

    /* access modifiers changed from: 0000 */
    public void interrupt() {
        this.connection.interrupt(INTERRUPT_REASON);
    }

    /* access modifiers changed from: 0000 */
    public void resume() {
        this.connection.resume(INTERRUPT_REASON);
    }

    public void addEventCallback(@NotNull EventRegistration eventRegistration) {
        List<? extends Event> events;
        ChildKey front = eventRegistration.getQuerySpec().getPath().getFront();
        if (front == null || !front.equals(Constants.DOT_INFO)) {
            events = this.serverSyncTree.addEventRegistration(eventRegistration);
        } else {
            events = this.infoSyncTree.addEventRegistration(eventRegistration);
        }
        postEvents(events);
    }

    public void keepSynced(QuerySpec query, boolean keep) {
        this.serverSyncTree.keepSynced(query, keep);
    }

    /* access modifiers changed from: 0000 */
    public PersistentConnection getConnection() {
        return this.connection;
    }

    private void updateInfo(ChildKey childKey, Object value) {
        if (childKey.equals(Constants.DOT_INFO_SERVERTIME_OFFSET)) {
            this.serverClock.setOffset(((Long) value).longValue());
        }
        Path path = new Path(Constants.DOT_INFO, childKey);
        try {
            Node node = NodeUtilities.NodeFromJSON(value);
            this.infoData.update(path, node);
            postEvents(this.infoSyncTree.applyServerOverwrite(path, node));
        } catch (DatabaseException e) {
            this.operationLogger.error("Failed to parse info update", e);
        }
    }

    private long getNextWriteId() {
        long j = this.nextWriteId;
        this.nextWriteId = 1 + j;
        return j;
    }

    private void runOnDisconnectEvents() {
        SparseSnapshotTree resolvedTree = ServerValues.resolveDeferredValueTree(this.onDisconnect, ServerValues.generateServerValues(this.serverClock));
        final List<Event> events = new ArrayList<>();
        resolvedTree.forEachTree(Path.getEmptyPath(), new SparseSnapshotTreeVisitor() {
            public void visitTree(Path prefixPath, Node node) {
                events.addAll(Repo.this.serverSyncTree.applyServerOverwrite(prefixPath, node));
                Repo.this.rerunTransactions(Repo.this.abortTransactions(prefixPath, -9));
            }
        });
        this.onDisconnect = new SparseSnapshotTree();
        postEvents(events);
    }

    /* access modifiers changed from: private */
    public void warnIfWriteFailed(String writeType, Path path, DatabaseError error) {
        if (error != null && error.getCode() != -1 && error.getCode() != -25) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append(writeType);
            sb.append(" at ");
            sb.append(path.toString());
            sb.append(" failed: ");
            sb.append(error.toString());
            logWrapper.warn(sb.toString());
        }
    }

    public void startTransaction(Path path, Handler handler, boolean applyLocally) {
        DatabaseError error;
        Result result;
        List<TransactionData> nodeQueue;
        Path path2 = path;
        final Handler handler2 = handler;
        String str = "transaction: ";
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(path2);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.operationLogger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(path2);
            logWrapper2.debug(sb2.toString(), new Object[0]);
        }
        if (this.ctx.isPersistenceEnabled() && !this.loggedTransactionPersistenceWarning) {
            this.loggedTransactionPersistenceWarning = true;
            this.transactionLogger.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference watchRef = InternalHelpers.createReference(this, path);
        C043413 r14 = new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
            }

            public void onCancelled(DatabaseError error) {
            }
        };
        addEventCallback(new ValueEventRegistration(this, r14, watchRef.getSpec()));
        TransactionData transactionData = new TransactionData(path, handler, r14, TransactionStatus.INITIALIZING, applyLocally, nextTransactionOrder());
        TransactionData transaction = transactionData;
        Node currentState = getLatestState(path);
        transaction.currentInputSnapshot = currentState;
        MutableData mutableCurrent = InternalHelpers.createMutableData(currentState);
        try {
            result = handler2.doTransaction(mutableCurrent);
            if (result != null) {
                error = null;
                if (!result.isSuccess()) {
                    transaction.currentOutputSnapshotRaw = null;
                    transaction.currentOutputSnapshotResolved = null;
                    final DatabaseError innerClassError = error;
                    final DataSnapshot snap = InternalHelpers.createDataSnapshot(watchRef, IndexedNode.from(transaction.currentInputSnapshot));
                    postEvent(new Runnable() {
                        public void run() {
                            handler2.onComplete(innerClassError, false, snap);
                        }
                    });
                    MutableData mutableData = mutableCurrent;
                    return;
                }
                transaction.status = TransactionStatus.RUN;
                Tree<List<TransactionData>> queueNode = this.transactionQueueTree.subTree(path2);
                List<TransactionData> nodeQueue2 = (List) queueNode.getValue();
                if (nodeQueue2 == null) {
                    nodeQueue = new ArrayList<>();
                } else {
                    nodeQueue = nodeQueue2;
                }
                nodeQueue.add(transaction);
                queueNode.setValue(nodeQueue);
                Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
                Node newNodeUnresolved = result.getNode();
                Node newNode = ServerValues.resolveDeferredValueSnapshot(newNodeUnresolved, serverValues);
                transaction.currentOutputSnapshotRaw = newNodeUnresolved;
                transaction.currentOutputSnapshotResolved = newNode;
                transaction.currentWriteId = getNextWriteId();
                Node node = newNodeUnresolved;
                List list = nodeQueue;
                Map map = serverValues;
                Tree tree = queueNode;
                MutableData mutableData2 = mutableCurrent;
                postEvents(this.serverSyncTree.applyUserOverwrite(path, newNodeUnresolved, newNode, transaction.currentWriteId, applyLocally, false));
                sendAllReadyTransactions();
                return;
            }
            throw new NullPointerException("Transaction returned null as result");
        } catch (Throwable e) {
            this.operationLogger.error("Caught Throwable.", e);
            DatabaseError error2 = DatabaseError.fromException(e);
            result = Transaction.abort();
            error = error2;
        }
    }

    private Node getLatestState(Path path) {
        return getLatestState(path, new ArrayList());
    }

    private Node getLatestState(Path path, List<Long> excudeSets) {
        Node state = this.serverSyncTree.calcCompleteEventCache(path, excudeSets);
        if (state == null) {
            return EmptyNode.Empty();
        }
        return state;
    }

    public void setHijackHash(boolean hijackHash2) {
        this.hijackHash = hijackHash2;
    }

    /* access modifiers changed from: private */
    public void sendAllReadyTransactions() {
        Tree<List<TransactionData>> node = this.transactionQueueTree;
        pruneCompletedTransactions(node);
        sendReadyTransactions(node);
    }

    /* access modifiers changed from: private */
    public void sendReadyTransactions(Tree<List<TransactionData>> node) {
        if (((List) node.getValue()) != null) {
            List<TransactionData> queue = buildTransactionQueue(node);
            Boolean allRun = Boolean.valueOf(true);
            Iterator it = queue.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((TransactionData) it.next()).status != TransactionStatus.RUN) {
                        allRun = Boolean.valueOf(false);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (allRun.booleanValue()) {
                sendTransactionQueue(queue, node.getPath());
            }
        } else if (node.hasChildren()) {
            node.forEachChild(new TreeVisitor<List<TransactionData>>() {
                public void visitTree(Tree<List<TransactionData>> tree) {
                    Repo.this.sendReadyTransactions(tree);
                }
            });
        }
    }

    private void sendTransactionQueue(final List<TransactionData> queue, final Path path) {
        List<Long> setsToIgnore = new ArrayList<>();
        for (TransactionData txn : queue) {
            setsToIgnore.add(Long.valueOf(txn.currentWriteId));
        }
        Node latestState = getLatestState(path, setsToIgnore);
        Node snapToSend = latestState;
        String latestHash = "badhash";
        if (!this.hijackHash) {
            latestHash = latestState.getHash();
        }
        for (TransactionData txn2 : queue) {
            txn2.status = TransactionStatus.SENT;
            txn2.retryCount = txn2.retryCount + 1;
            snapToSend = snapToSend.updateChild(Path.getRelative(path, txn2.path), txn2.currentOutputSnapshotRaw);
        }
        this.connection.compareAndPut(path.asList(), snapToSend.getValue(true), latestHash, new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("Transaction", path, error);
                List<Event> events = new ArrayList<>();
                if (error == null) {
                    List<Runnable> callbacks = new ArrayList<>();
                    for (final TransactionData txn : queue) {
                        txn.status = TransactionStatus.COMPLETED;
                        events.addAll(Repo.this.serverSyncTree.ackUserWrite(txn.currentWriteId, false, false, Repo.this.serverClock));
                        final DataSnapshot snap = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, txn.path), IndexedNode.from(txn.currentOutputSnapshotResolved));
                        callbacks.add(new Runnable() {
                            public void run() {
                                txn.handler.onComplete(null, true, snap);
                            }
                        });
                        Repo repo = Repo.this;
                        repo.removeEventCallback(new ValueEventRegistration(repo, txn.outstandingListener, QuerySpec.defaultQueryAtPath(txn.path)));
                    }
                    Repo repo2 = Repo.this;
                    repo2.pruneCompletedTransactions(repo2.transactionQueueTree.subTree(path));
                    Repo.this.sendAllReadyTransactions();
                    this.postEvents(events);
                    for (int i = 0; i < callbacks.size(); i++) {
                        Repo.this.postEvent((Runnable) callbacks.get(i));
                    }
                    return;
                }
                if (error.getCode() == -1) {
                    for (TransactionData transaction : queue) {
                        if (transaction.status == TransactionStatus.SENT_NEEDS_ABORT) {
                            transaction.status = TransactionStatus.NEEDS_ABORT;
                        } else {
                            transaction.status = TransactionStatus.RUN;
                        }
                    }
                } else {
                    for (TransactionData transaction2 : queue) {
                        transaction2.status = TransactionStatus.NEEDS_ABORT;
                        transaction2.abortReason = error;
                    }
                }
                Repo.this.rerunTransactions(path);
            }
        });
    }

    /* access modifiers changed from: private */
    public void pruneCompletedTransactions(Tree<List<TransactionData>> node) {
        List<TransactionData> queue = (List) node.getValue();
        if (queue != null) {
            int i = 0;
            while (i < queue.size()) {
                if (((TransactionData) queue.get(i)).status == TransactionStatus.COMPLETED) {
                    queue.remove(i);
                } else {
                    i++;
                }
            }
            if (queue.size() > 0) {
                node.setValue(queue);
            } else {
                node.setValue(null);
            }
        }
        node.forEachChild(new TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.pruneCompletedTransactions(tree);
            }
        });
    }

    private long nextTransactionOrder() {
        long j = this.transactionOrder;
        this.transactionOrder = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    public Path rerunTransactions(Path changedPath) {
        Tree<List<TransactionData>> rootMostTransactionNode = getAncestorTransactionNode(changedPath);
        Path path = rootMostTransactionNode.getPath();
        rerunTransactionQueue(buildTransactionQueue(rootMostTransactionNode), path);
        return path;
    }

    private void rerunTransactionQueue(List<TransactionData> queue, Path path) {
        Iterator it;
        Result result;
        if (!queue.isEmpty()) {
            List<Runnable> callbacks = new ArrayList<>();
            List<Long> setsToIgnore = new ArrayList<>();
            for (TransactionData transaction : queue) {
                setsToIgnore.add(Long.valueOf(transaction.currentWriteId));
            }
            Iterator it2 = queue.iterator();
            while (it2.hasNext()) {
                final TransactionData transaction2 = (TransactionData) it2.next();
                Path relativePath = Path.getRelative(path, transaction2.path);
                boolean abortTransaction = false;
                DatabaseError abortReason = null;
                List<Event> events = new ArrayList<>();
                if (transaction2.status == TransactionStatus.NEEDS_ABORT) {
                    abortTransaction = true;
                    abortReason = transaction2.abortReason;
                    if (abortReason.getCode() != -25) {
                        events.addAll(this.serverSyncTree.ackUserWrite(transaction2.currentWriteId, true, false, this.serverClock));
                    }
                    it = it2;
                    Path path2 = relativePath;
                } else if (transaction2.status != TransactionStatus.RUN) {
                    it = it2;
                    Path path3 = relativePath;
                } else if (transaction2.retryCount >= 25) {
                    abortTransaction = true;
                    abortReason = DatabaseError.fromStatus(TRANSACTION_TOO_MANY_RETRIES);
                    events.addAll(this.serverSyncTree.ackUserWrite(transaction2.currentWriteId, true, false, this.serverClock));
                    it = it2;
                    Path path4 = relativePath;
                } else {
                    Node currentNode = getLatestState(transaction2.path, setsToIgnore);
                    transaction2.currentInputSnapshot = currentNode;
                    DatabaseError error = null;
                    try {
                        result = transaction2.handler.doTransaction(InternalHelpers.createMutableData(currentNode));
                    } catch (Throwable e) {
                        this.operationLogger.error("Caught Throwable.", e);
                        error = DatabaseError.fromException(e);
                        result = Transaction.abort();
                    }
                    if (result.isSuccess()) {
                        Long oldWriteId = Long.valueOf(transaction2.currentWriteId);
                        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
                        it = it2;
                        Node newDataNode = result.getNode();
                        Result result2 = result;
                        Node newNodeResolved = ServerValues.resolveDeferredValueSnapshot(newDataNode, serverValues);
                        transaction2.currentOutputSnapshotRaw = newDataNode;
                        transaction2.currentOutputSnapshotResolved = newNodeResolved;
                        Path path5 = relativePath;
                        transaction2.currentWriteId = getNextWriteId();
                        setsToIgnore.remove(oldWriteId);
                        events.addAll(this.serverSyncTree.applyUserOverwrite(transaction2.path, newDataNode, newNodeResolved, transaction2.currentWriteId, transaction2.applyLocally, false));
                        events.addAll(this.serverSyncTree.ackUserWrite(oldWriteId.longValue(), true, false, this.serverClock));
                    } else {
                        it = it2;
                        Path path6 = relativePath;
                        abortTransaction = true;
                        abortReason = error;
                        events.addAll(this.serverSyncTree.ackUserWrite(transaction2.currentWriteId, true, false, this.serverClock));
                    }
                }
                postEvents(events);
                if (abortTransaction) {
                    transaction2.status = TransactionStatus.COMPLETED;
                    final DataSnapshot snapshot = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, transaction2.path), IndexedNode.from(transaction2.currentInputSnapshot));
                    scheduleNow(new Runnable() {
                        public void run() {
                            Repo repo = Repo.this;
                            repo.removeEventCallback(new ValueEventRegistration(repo, transaction2.outstandingListener, QuerySpec.defaultQueryAtPath(transaction2.path)));
                        }
                    });
                    final DatabaseError callbackError = abortReason;
                    callbacks.add(new Runnable() {
                        public void run() {
                            transaction2.handler.onComplete(callbackError, false, snapshot);
                        }
                    });
                }
                it2 = it;
            }
            pruneCompletedTransactions(this.transactionQueueTree);
            for (int i = 0; i < callbacks.size(); i++) {
                postEvent((Runnable) callbacks.get(i));
            }
            sendAllReadyTransactions();
        }
    }

    private Tree<List<TransactionData>> getAncestorTransactionNode(Path path) {
        Tree<List<TransactionData>> transactionNode = this.transactionQueueTree;
        while (!path.isEmpty() && transactionNode.getValue() == null) {
            transactionNode = transactionNode.subTree(new Path(path.getFront()));
            path = path.popFront();
        }
        return transactionNode;
    }

    private List<TransactionData> buildTransactionQueue(Tree<List<TransactionData>> transactionNode) {
        List<TransactionData> queue = new ArrayList<>();
        aggregateTransactionQueues(queue, transactionNode);
        Collections.sort(queue);
        return queue;
    }

    /* access modifiers changed from: private */
    public void aggregateTransactionQueues(final List<TransactionData> queue, Tree<List<TransactionData>> node) {
        List<TransactionData> childQueue = (List) node.getValue();
        if (childQueue != null) {
            queue.addAll(childQueue);
        }
        node.forEachChild(new TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.aggregateTransactionQueues(queue, tree);
            }
        });
    }

    /* access modifiers changed from: private */
    public Path abortTransactions(Path path, final int reason) {
        Path affectedPath = getAncestorTransactionNode(path).getPath();
        if (this.transactionLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder sb = new StringBuilder();
            sb.append("Aborting transactions for path: ");
            sb.append(path);
            sb.append(". Affected: ");
            sb.append(affectedPath);
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        Tree<List<TransactionData>> transactionNode = this.transactionQueueTree.subTree(path);
        transactionNode.forEachAncestor(new TreeFilter<List<TransactionData>>() {
            public boolean filterTreeNode(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, reason);
                return false;
            }
        });
        abortTransactionsAtNode(transactionNode, reason);
        transactionNode.forEachDescendant(new TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, reason);
            }
        });
        return affectedPath;
    }

    /* access modifiers changed from: private */
    public void abortTransactionsAtNode(Tree<List<TransactionData>> node, int reason) {
        final DatabaseError abortError;
        Tree<List<TransactionData>> tree = node;
        int i = reason;
        List<TransactionData> queue = (List) node.getValue();
        List<Event> events = new ArrayList<>();
        if (queue != null) {
            List<Runnable> callbacks = new ArrayList<>();
            String str = "Unknown transaction abort reason: ";
            if (i == -9) {
                abortError = DatabaseError.fromStatus(TRANSACTION_OVERRIDE_BY_SET);
            } else {
                boolean z = i == -25;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i);
                Utilities.hardAssert(z, sb.toString());
                abortError = DatabaseError.fromCode(-25);
            }
            int lastSent = -1;
            for (int i2 = 0; i2 < queue.size(); i2++) {
                final TransactionData transaction = (TransactionData) queue.get(i2);
                if (transaction.status != TransactionStatus.SENT_NEEDS_ABORT) {
                    if (transaction.status == TransactionStatus.SENT) {
                        int lastSent2 = i2;
                        transaction.status = TransactionStatus.SENT_NEEDS_ABORT;
                        transaction.abortReason = abortError;
                        lastSent = lastSent2;
                    } else {
                        removeEventCallback(new ValueEventRegistration(this, transaction.outstandingListener, QuerySpec.defaultQueryAtPath(transaction.path)));
                        if (i == -9) {
                            events.addAll(this.serverSyncTree.ackUserWrite(transaction.currentWriteId, true, false, this.serverClock));
                        } else {
                            boolean z2 = i == -25;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(i);
                            Utilities.hardAssert(z2, sb2.toString());
                        }
                        callbacks.add(new Runnable() {
                            public void run() {
                                transaction.handler.onComplete(abortError, false, null);
                            }
                        });
                    }
                }
            }
            if (lastSent == -1) {
                tree.setValue(null);
            } else {
                tree.setValue(queue.subList(0, lastSent + 1));
            }
            postEvents(events);
            for (Runnable r : callbacks) {
                postEvent(r);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public SyncTree getServerSyncTree() {
        return this.serverSyncTree;
    }

    /* access modifiers changed from: 0000 */
    public SyncTree getInfoSyncTree() {
        return this.infoSyncTree;
    }

    /* access modifiers changed from: private */
    public static DatabaseError fromErrorCode(String optErrorCode, String optErrorReason) {
        if (optErrorCode != null) {
            return DatabaseError.fromStatus(optErrorCode, optErrorReason);
        }
        return null;
    }
}
