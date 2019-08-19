package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode.NodeVisitor;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class SyncTree {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long SIZE_THRESHOLD_FOR_COMPOUND_HASH = 1024;
    private final Set<QuerySpec> keepSyncedQueries = new HashSet();
    /* access modifiers changed from: private */
    public final ListenProvider listenProvider;
    /* access modifiers changed from: private */
    public final LogWrapper logger;
    private long nextQueryTag = 1;
    /* access modifiers changed from: private */
    public final WriteTree pendingWriteTree = new WriteTree();
    /* access modifiers changed from: private */
    public final PersistenceManager persistenceManager;
    /* access modifiers changed from: private */
    public final Map<QuerySpec, Tag> queryToTagMap = new HashMap();
    /* access modifiers changed from: private */
    public ImmutableTree<SyncPoint> syncPointTree = ImmutableTree.emptyInstance();
    /* access modifiers changed from: private */
    public final Map<Tag, QuerySpec> tagToQueryMap = new HashMap();

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface CompletionListener {
        List<? extends Event> onListenComplete(DatabaseError databaseError);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class KeepSyncedEventRegistration extends EventRegistration {
        private QuerySpec spec;

        public KeepSyncedEventRegistration(@NotNull QuerySpec spec2) {
            this.spec = spec2;
        }

        public boolean respondsTo(EventType eventType) {
            return false;
        }

        public DataEvent createEvent(Change change, QuerySpec query) {
            return null;
        }

        public void fireEvent(DataEvent dataEvent) {
        }

        public void fireCancelEvent(DatabaseError error) {
        }

        public EventRegistration clone(QuerySpec newQuery) {
            return new KeepSyncedEventRegistration(newQuery);
        }

        public boolean isSameListener(EventRegistration other) {
            return other instanceof KeepSyncedEventRegistration;
        }

        @NotNull
        public QuerySpec getQuerySpec() {
            return this.spec;
        }

        public boolean equals(Object other) {
            return (other instanceof KeepSyncedEventRegistration) && ((KeepSyncedEventRegistration) other).spec.equals(this.spec);
        }

        public int hashCode() {
            return this.spec.hashCode();
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private class ListenContainer implements ListenHashProvider, CompletionListener {
        /* access modifiers changed from: private */
        public final Tag tag;
        private final View view;

        public ListenContainer(View view2) {
            this.view = view2;
            this.tag = SyncTree.this.tagForQuery(view2.getQuery());
        }

        public CompoundHash getCompoundHash() {
            com.google.firebase.database.snapshot.CompoundHash hash = com.google.firebase.database.snapshot.CompoundHash.fromNode(this.view.getServerCache());
            List<Path> pathPosts = hash.getPosts();
            List<List<String>> posts = new ArrayList<>(pathPosts.size());
            for (Path path : pathPosts) {
                posts.add(path.asList());
            }
            return new CompoundHash(posts, hash.getHashes());
        }

        public String getSimpleHash() {
            return this.view.getServerCache().getHash();
        }

        public boolean shouldIncludeCompoundHash() {
            return NodeSizeEstimator.estimateSerializedNodeSize(this.view.getServerCache()) > 1024;
        }

        public List<? extends Event> onListenComplete(DatabaseError error) {
            if (error == null) {
                QuerySpec query = this.view.getQuery();
                Tag tag2 = this.tag;
                if (tag2 != null) {
                    return SyncTree.this.applyTaggedListenComplete(tag2);
                }
                return SyncTree.this.applyListenComplete(query.getPath());
            }
            LogWrapper access$100 = SyncTree.this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Listen at ");
            sb.append(this.view.getQuery().getPath());
            sb.append(" failed: ");
            sb.append(error.toString());
            access$100.warn(sb.toString());
            return SyncTree.this.removeAllEventRegistrations(this.view.getQuery(), error);
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface ListenProvider {
        void startListening(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, CompletionListener completionListener);

        void stopListening(QuerySpec querySpec, Tag tag);
    }

    public SyncTree(Context context, PersistenceManager persistenceManager2, ListenProvider listenProvider2) {
        this.listenProvider = listenProvider2;
        this.persistenceManager = persistenceManager2;
        this.logger = context.getLogger("SyncTree");
    }

    public boolean isEmpty() {
        return this.syncPointTree.isEmpty();
    }

    public List<? extends Event> applyUserOverwrite(Path path, Node newDataUnresolved, Node newData, long writeId, boolean visible, boolean persist) {
        Utilities.hardAssert(visible || !persist, "We shouldn't be persisting non-visible writes.");
        PersistenceManager persistenceManager2 = this.persistenceManager;
        final boolean z = persist;
        final Path path2 = path;
        final Node node = newDataUnresolved;
        final long j = writeId;
        final Node node2 = newData;
        final boolean z2 = visible;
        C04641 r0 = new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                if (z) {
                    SyncTree.this.persistenceManager.saveUserOverwrite(path2, node, j);
                }
                SyncTree.this.pendingWriteTree.addOverwrite(path2, node2, Long.valueOf(j), z2);
                if (!z2) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.USER, path2, node2));
            }
        };
        return (List) persistenceManager2.runInTransaction(r0);
    }

    public List<? extends Event> applyUserMerge(Path path, CompoundWrite unresolvedChildren, CompoundWrite children, long writeId, boolean persist) {
        PersistenceManager persistenceManager2 = this.persistenceManager;
        final boolean z = persist;
        final Path path2 = path;
        final CompoundWrite compoundWrite = unresolvedChildren;
        final long j = writeId;
        final CompoundWrite compoundWrite2 = children;
        C04702 r0 = new Callable<List<? extends Event>>() {
            public List<? extends Event> call() throws Exception {
                if (z) {
                    SyncTree.this.persistenceManager.saveUserMerge(path2, compoundWrite, j);
                }
                SyncTree.this.pendingWriteTree.addMerge(path2, compoundWrite2, Long.valueOf(j));
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.USER, path2, compoundWrite2));
            }
        };
        return (List) persistenceManager2.runInTransaction(r0);
    }

    public List<? extends Event> ackUserWrite(long writeId, boolean revert, boolean persist, Clock serverClock) {
        PersistenceManager persistenceManager2 = this.persistenceManager;
        final boolean z = persist;
        final long j = writeId;
        final boolean z2 = revert;
        final Clock clock = serverClock;
        C04713 r1 = new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                if (z) {
                    SyncTree.this.persistenceManager.removeUserWrite(j);
                }
                UserWriteRecord write = SyncTree.this.pendingWriteTree.getWrite(j);
                boolean needToReevaluate = SyncTree.this.pendingWriteTree.removeWrite(j);
                if (write.isVisible() && !z2) {
                    Map<String, Object> serverValues = ServerValues.generateServerValues(clock);
                    if (write.isOverwrite()) {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), serverValues));
                    } else {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueMerge(write.getMerge(), serverValues));
                    }
                }
                if (!needToReevaluate) {
                    return Collections.emptyList();
                }
                ImmutableTree<Boolean> affectedTree = ImmutableTree.emptyInstance();
                if (write.isOverwrite()) {
                    affectedTree = affectedTree.set(Path.getEmptyPath(), Boolean.valueOf(true));
                } else {
                    Iterator it = write.getMerge().iterator();
                    while (it.hasNext()) {
                        affectedTree = affectedTree.set((Path) ((Entry) it.next()).getKey(), Boolean.valueOf(true));
                    }
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(write.getPath(), affectedTree, z2));
            }
        };
        return (List) persistenceManager2.runInTransaction(r1);
    }

    public List<? extends Event> removeAllWrites() {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() throws Exception {
                SyncTree.this.persistenceManager.removeAllUserWrites();
                if (SyncTree.this.pendingWriteTree.purgeAllWrites().isEmpty()) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(Path.getEmptyPath(), new ImmutableTree<>(Boolean.valueOf(true)), true));
            }
        });
    }

    public List<? extends Event> applyServerOverwrite(final Path path, final Node newData) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.updateServerCache(QuerySpec.defaultQueryAtPath(path), newData);
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.SERVER, path, newData));
            }
        });
    }

    public List<? extends Event> applyServerMerge(final Path path, final Map<Path, Node> changedChildren) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                CompoundWrite merge = CompoundWrite.fromPathMerge(changedChildren);
                SyncTree.this.persistenceManager.updateServerCache(path, merge);
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.SERVER, path, merge));
            }
        });
    }

    public List<? extends Event> applyServerRangeMerges(Path path, List<RangeMerge> rangeMerges) {
        SyncPoint syncPoint = (SyncPoint) this.syncPointTree.get(path);
        if (syncPoint == null) {
            return Collections.emptyList();
        }
        View view = syncPoint.getCompleteView();
        if (view == null) {
            return Collections.emptyList();
        }
        Node serverNode = view.getServerCache();
        for (RangeMerge merge : rangeMerges) {
            serverNode = merge.applyTo(serverNode);
        }
        return applyServerOverwrite(path, serverNode);
    }

    public List<? extends Event> applyTaggedRangeMerges(Path path, List<RangeMerge> rangeMerges, Tag tag) {
        QuerySpec query = queryForTag(tag);
        if (query == null) {
            return Collections.emptyList();
        }
        Node serverNode = ((SyncPoint) this.syncPointTree.get(query.getPath())).viewForQuery(query).getServerCache();
        for (RangeMerge merge : rangeMerges) {
            serverNode = merge.applyTo(serverNode);
        }
        return applyTaggedQueryOverwrite(path, serverNode, tag);
    }

    public List<? extends Event> applyListenComplete(final Path path) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.setQueryComplete(QuerySpec.defaultQueryAtPath(path));
                return SyncTree.this.applyOperationToSyncPoints(new ListenComplete(OperationSource.SERVER, path));
            }
        });
    }

    public List<? extends Event> applyTaggedListenComplete(final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                QuerySpec query = SyncTree.this.queryForTag(tag);
                if (query == null) {
                    return Collections.emptyList();
                }
                SyncTree.this.persistenceManager.setQueryComplete(query);
                return SyncTree.this.applyTaggedOperation(query, new ListenComplete(OperationSource.forServerTaggedQuery(query.getParams()), Path.getEmptyPath()));
            }
        });
    }

    /* access modifiers changed from: private */
    public List<? extends Event> applyTaggedOperation(QuerySpec query, Operation operation) {
        Path queryPath = query.getPath();
        return ((SyncPoint) this.syncPointTree.get(queryPath)).applyOperation(operation, this.pendingWriteTree.childWrites(queryPath), null);
    }

    public List<? extends Event> applyTaggedQueryOverwrite(final Path path, final Node snap, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                QuerySpec query = SyncTree.this.queryForTag(tag);
                if (query == null) {
                    return Collections.emptyList();
                }
                Path relativePath = Path.getRelative(query.getPath(), path);
                SyncTree.this.persistenceManager.updateServerCache(relativePath.isEmpty() ? query : QuerySpec.defaultQueryAtPath(path), snap);
                return SyncTree.this.applyTaggedOperation(query, new Overwrite(OperationSource.forServerTaggedQuery(query.getParams()), relativePath, snap));
            }
        });
    }

    public List<? extends Event> applyTaggedQueryMerge(final Path path, final Map<Path, Node> changedChildren, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            public List<? extends Event> call() {
                QuerySpec query = SyncTree.this.queryForTag(tag);
                if (query == null) {
                    return Collections.emptyList();
                }
                Path relativePath = Path.getRelative(query.getPath(), path);
                CompoundWrite merge = CompoundWrite.fromPathMerge(changedChildren);
                SyncTree.this.persistenceManager.updateServerCache(path, merge);
                return SyncTree.this.applyTaggedOperation(query, new Merge(OperationSource.forServerTaggedQuery(query.getParams()), relativePath, merge));
            }
        });
    }

    public List<? extends Event> addEventRegistration(@NotNull final EventRegistration eventRegistration) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public List<? extends Event> call() {
                CacheNode persistentServerCache;
                Node node;
                Node node2;
                QuerySpec query = eventRegistration.getQuerySpec();
                Path path = query.getPath();
                Node serverCacheNode = null;
                boolean foundAncestorDefaultView = false;
                ImmutableTree<SyncPoint> tree = SyncTree.this.syncPointTree;
                Path currentPath = path;
                while (true) {
                    boolean z = true;
                    if (tree.isEmpty()) {
                        break;
                    }
                    SyncPoint currentSyncPoint = (SyncPoint) tree.getValue();
                    if (currentSyncPoint != null) {
                        if (serverCacheNode != null) {
                            node2 = serverCacheNode;
                        } else {
                            node2 = currentSyncPoint.getCompleteServerCache(currentPath);
                        }
                        serverCacheNode = node2;
                        if (!foundAncestorDefaultView && !currentSyncPoint.hasCompleteView()) {
                            z = false;
                        }
                        foundAncestorDefaultView = z;
                    }
                    tree = tree.getChild(currentPath.isEmpty() ? ChildKey.fromString("") : currentPath.getFront());
                    currentPath = currentPath.popFront();
                }
                SyncPoint syncPoint = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                if (syncPoint == null) {
                    syncPoint = new SyncPoint(SyncTree.this.persistenceManager);
                    SyncTree syncTree = SyncTree.this;
                    syncTree.syncPointTree = syncTree.syncPointTree.set(path, syncPoint);
                } else {
                    foundAncestorDefaultView = foundAncestorDefaultView || syncPoint.hasCompleteView();
                    if (serverCacheNode != null) {
                        node = serverCacheNode;
                    } else {
                        node = syncPoint.getCompleteServerCache(Path.getEmptyPath());
                    }
                    serverCacheNode = node;
                }
                SyncTree.this.persistenceManager.setQueryActive(query);
                if (serverCacheNode != null) {
                    persistentServerCache = new CacheNode(IndexedNode.from(serverCacheNode, query.getIndex()), true, false);
                } else {
                    persistentServerCache = SyncTree.this.persistenceManager.serverCache(query);
                    if (persistentServerCache.isFullyInitialized()) {
                        CacheNode cacheNode = persistentServerCache;
                    } else {
                        Node serverCacheNode2 = EmptyNode.Empty();
                        Iterator it = SyncTree.this.syncPointTree.subtree(path).getChildren().iterator();
                        while (it.hasNext()) {
                            Entry<ChildKey, ImmutableTree<SyncPoint>> child = (Entry) it.next();
                            SyncPoint childSyncPoint = (SyncPoint) ((ImmutableTree) child.getValue()).getValue();
                            if (childSyncPoint != null) {
                                Node completeCache = childSyncPoint.getCompleteServerCache(Path.getEmptyPath());
                                if (completeCache != null) {
                                    serverCacheNode2 = serverCacheNode2.updateImmediateChild((ChildKey) child.getKey(), completeCache);
                                }
                            }
                        }
                        for (NamedNode child2 : persistentServerCache.getNode()) {
                            if (!serverCacheNode2.hasChild(child2.getName())) {
                                serverCacheNode2 = serverCacheNode2.updateImmediateChild(child2.getName(), child2.getNode());
                            }
                        }
                        persistentServerCache = new CacheNode(IndexedNode.from(serverCacheNode2, query.getIndex()), false, false);
                    }
                }
                boolean viewAlreadyExists = syncPoint.viewExistsForQuery(query);
                if (!viewAlreadyExists && !query.loadsAllData()) {
                    Tag tag = SyncTree.this.getNextQueryTag();
                    SyncTree.this.queryToTagMap.put(query, tag);
                    SyncTree.this.tagToQueryMap.put(tag, query);
                }
                List<? extends Event> events = syncPoint.addEventRegistration(eventRegistration, SyncTree.this.pendingWriteTree.childWrites(path), persistentServerCache);
                if (!viewAlreadyExists && !foundAncestorDefaultView) {
                    SyncTree.this.setupListener(query, syncPoint.viewForQuery(query));
                }
                return events;
            }
        });
    }

    public List<Event> removeEventRegistration(@NotNull EventRegistration eventRegistration) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, null);
    }

    public List<Event> removeAllEventRegistrations(@NotNull QuerySpec query, @NotNull DatabaseError error) {
        return removeEventRegistration(query, null, error);
    }

    private List<Event> removeEventRegistration(@NotNull final QuerySpec query, @Nullable final EventRegistration eventRegistration, @Nullable final DatabaseError cancelError) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<Event>>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public List<Event> call() {
                Path path = query.getPath();
                SyncPoint maybeSyncPoint = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                List<Event> cancelEvents = new ArrayList<>();
                if (maybeSyncPoint == null) {
                    SyncPoint syncPoint = maybeSyncPoint;
                } else if (query.isDefault() || maybeSyncPoint.viewExistsForQuery(query)) {
                    Pair<List<QuerySpec>, List<Event>> removedAndEvents = maybeSyncPoint.removeEventRegistration(query, eventRegistration, cancelError);
                    if (maybeSyncPoint.isEmpty()) {
                        SyncTree syncTree = SyncTree.this;
                        syncTree.syncPointTree = syncTree.syncPointTree.remove(path);
                    }
                    List<QuerySpec> removed = (List) removedAndEvents.getFirst();
                    cancelEvents = (List) removedAndEvents.getSecond();
                    boolean removingDefault = false;
                    Iterator it = removed.iterator();
                    while (true) {
                        boolean z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        QuerySpec queryRemoved = (QuerySpec) it.next();
                        SyncTree.this.persistenceManager.setQueryInactive(query);
                        if (!removingDefault && !queryRemoved.loadsAllData()) {
                            z = false;
                        }
                        removingDefault = z;
                    }
                    ImmutableTree<SyncPoint> currentTree = SyncTree.this.syncPointTree;
                    boolean covered = currentTree.getValue() != null && ((SyncPoint) currentTree.getValue()).hasCompleteView();
                    Iterator it2 = path.iterator();
                    while (it2.hasNext()) {
                        currentTree = currentTree.getChild((ChildKey) it2.next());
                        covered = covered || (currentTree.getValue() != null && ((SyncPoint) currentTree.getValue()).hasCompleteView());
                        if (!covered) {
                            if (currentTree.isEmpty()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!removingDefault || covered) {
                        SyncPoint syncPoint2 = maybeSyncPoint;
                    } else {
                        ImmutableTree<SyncPoint> subtree = SyncTree.this.syncPointTree.subtree(path);
                        if (!subtree.isEmpty()) {
                            for (View view : SyncTree.this.collectDistinctViewsForSubTree(subtree)) {
                                ListenContainer container = new ListenContainer(view);
                                Path path2 = path;
                                SyncPoint maybeSyncPoint2 = maybeSyncPoint;
                                SyncTree.this.listenProvider.startListening(SyncTree.this.queryForListening(view.getQuery()), container.tag, container, container);
                                path = path2;
                                maybeSyncPoint = maybeSyncPoint2;
                            }
                            SyncPoint syncPoint3 = maybeSyncPoint;
                        } else {
                            SyncPoint syncPoint4 = maybeSyncPoint;
                        }
                    }
                    if (!covered && !removed.isEmpty() && cancelError == null) {
                        if (removingDefault) {
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query), null);
                        } else {
                            for (QuerySpec queryToRemove : removed) {
                                SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(queryToRemove), SyncTree.this.tagForQuery(queryToRemove));
                            }
                        }
                    }
                    SyncTree.this.removeTags(removed);
                } else {
                    Path path3 = path;
                    SyncPoint syncPoint5 = maybeSyncPoint;
                }
                return cancelEvents;
            }
        });
    }

    public void keepSynced(QuerySpec query, boolean keep) {
        if (keep && !this.keepSyncedQueries.contains(query)) {
            addEventRegistration(new KeepSyncedEventRegistration(query));
            this.keepSyncedQueries.add(query);
        } else if (!keep && this.keepSyncedQueries.contains(query)) {
            removeEventRegistration(new KeepSyncedEventRegistration(query));
            this.keepSyncedQueries.remove(query);
        }
    }

    /* access modifiers changed from: private */
    public List<View> collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> subtree) {
        ArrayList<View> accumulator = new ArrayList<>();
        collectDistinctViewsForSubTree(subtree, accumulator);
        return accumulator;
    }

    private void collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> subtree, List<View> accumulator) {
        SyncPoint maybeSyncPoint = (SyncPoint) subtree.getValue();
        if (maybeSyncPoint == null || !maybeSyncPoint.hasCompleteView()) {
            if (maybeSyncPoint != null) {
                accumulator.addAll(maybeSyncPoint.getQueryViews());
            }
            Iterator it = subtree.getChildren().iterator();
            while (it.hasNext()) {
                collectDistinctViewsForSubTree((ImmutableTree) ((Entry) it.next()).getValue(), accumulator);
            }
            return;
        }
        accumulator.add(maybeSyncPoint.getCompleteView());
    }

    /* access modifiers changed from: private */
    public void removeTags(List<QuerySpec> queries) {
        for (QuerySpec removedQuery : queries) {
            if (!removedQuery.loadsAllData()) {
                Tag tag = tagForQuery(removedQuery);
                this.queryToTagMap.remove(removedQuery);
                this.tagToQueryMap.remove(tag);
            }
        }
    }

    /* access modifiers changed from: private */
    public QuerySpec queryForListening(QuerySpec query) {
        if (!query.loadsAllData() || query.isDefault()) {
            return query;
        }
        return QuerySpec.defaultQueryAtPath(query.getPath());
    }

    /* access modifiers changed from: private */
    public void setupListener(QuerySpec query, View view) {
        Path path = query.getPath();
        Tag tag = tagForQuery(query);
        ListenContainer container = new ListenContainer(view);
        this.listenProvider.startListening(queryForListening(query), tag, container, container);
        ImmutableTree<SyncPoint> subtree = this.syncPointTree.subtree(path);
        if (tag == null) {
            subtree.foreach(new TreeVisitor<SyncPoint, Void>() {
                public Void onNodeValue(Path relativePath, SyncPoint maybeChildSyncPoint, Void accum) {
                    if (relativePath.isEmpty() || !maybeChildSyncPoint.hasCompleteView()) {
                        for (View syncPointView : maybeChildSyncPoint.getQueryViews()) {
                            QuerySpec childQuery = syncPointView.getQuery();
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(childQuery), SyncTree.this.tagForQuery(childQuery));
                        }
                    } else {
                        QuerySpec query = maybeChildSyncPoint.getCompleteView().getQuery();
                        SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query), SyncTree.this.tagForQuery(query));
                    }
                    return null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public QuerySpec queryForTag(Tag tag) {
        return (QuerySpec) this.tagToQueryMap.get(tag);
    }

    /* access modifiers changed from: private */
    public Tag tagForQuery(QuerySpec query) {
        return (Tag) this.queryToTagMap.get(query);
    }

    public Node calcCompleteEventCache(Path path, List<Long> writeIdsToExclude) {
        ImmutableTree<SyncPoint> tree = this.syncPointTree;
        SyncPoint syncPoint = (SyncPoint) tree.getValue();
        Node serverCache = null;
        Path pathToFollow = path;
        Path pathSoFar = Path.getEmptyPath();
        do {
            ChildKey front = pathToFollow.getFront();
            pathToFollow = pathToFollow.popFront();
            pathSoFar = pathSoFar.child(front);
            Path relativePath = Path.getRelative(pathSoFar, path);
            tree = front != null ? tree.getChild(front) : ImmutableTree.emptyInstance();
            SyncPoint currentSyncPoint = (SyncPoint) tree.getValue();
            if (currentSyncPoint != null) {
                serverCache = currentSyncPoint.getCompleteServerCache(relativePath);
            }
            if (pathToFollow.isEmpty()) {
                break;
            }
        } while (serverCache == null);
        return this.pendingWriteTree.calcCompleteEventCache(path, serverCache, writeIdsToExclude, true);
    }

    /* access modifiers changed from: private */
    public Tag getNextQueryTag() {
        long j = this.nextQueryTag;
        this.nextQueryTag = 1 + j;
        return new Tag(j);
    }

    /* access modifiers changed from: private */
    public List<Event> applyOperationToSyncPoints(Operation operation) {
        return applyOperationHelper(operation, this.syncPointTree, null, this.pendingWriteTree.childWrites(Path.getEmptyPath()));
    }

    private List<Event> applyOperationHelper(Operation operation, ImmutableTree<SyncPoint> syncPointTree2, Node serverCache, WriteTreeRef writesCache) {
        if (operation.getPath().isEmpty()) {
            return applyOperationDescendantsHelper(operation, syncPointTree2, serverCache, writesCache);
        }
        SyncPoint syncPoint = (SyncPoint) syncPointTree2.getValue();
        if (serverCache == null && syncPoint != null) {
            serverCache = syncPoint.getCompleteServerCache(Path.getEmptyPath());
        }
        List<Event> events = new ArrayList<>();
        ChildKey childKey = operation.getPath().getFront();
        Operation childOperation = operation.operationForChild(childKey);
        ImmutableTree<SyncPoint> childTree = (ImmutableTree) syncPointTree2.getChildren().get(childKey);
        if (!(childTree == null || childOperation == null)) {
            events.addAll(applyOperationHelper(childOperation, childTree, serverCache != null ? serverCache.getImmediateChild(childKey) : null, writesCache.child(childKey)));
        }
        if (syncPoint != null) {
            events.addAll(syncPoint.applyOperation(operation, writesCache, serverCache));
        }
        return events;
    }

    /* access modifiers changed from: private */
    public List<Event> applyOperationDescendantsHelper(Operation operation, ImmutableTree<SyncPoint> syncPointTree2, Node serverCache, WriteTreeRef writesCache) {
        Node resolvedServerCache;
        SyncPoint syncPoint = (SyncPoint) syncPointTree2.getValue();
        if (serverCache != null || syncPoint == null) {
            resolvedServerCache = serverCache;
        } else {
            resolvedServerCache = syncPoint.getCompleteServerCache(Path.getEmptyPath());
        }
        ArrayList arrayList = new ArrayList();
        ImmutableSortedMap children = syncPointTree2.getChildren();
        final Node node = resolvedServerCache;
        final WriteTreeRef writeTreeRef = writesCache;
        final Operation operation2 = operation;
        final ArrayList arrayList2 = arrayList;
        C046914 r2 = new NodeVisitor<ChildKey, ImmutableTree<SyncPoint>>() {
            public void visitEntry(ChildKey key, ImmutableTree<SyncPoint> childTree) {
                Node childServerCache = null;
                Node node = node;
                if (node != null) {
                    childServerCache = node.getImmediateChild(key);
                }
                WriteTreeRef childWritesCache = writeTreeRef.child(key);
                Operation childOperation = operation2.operationForChild(key);
                if (childOperation != null) {
                    arrayList2.addAll(SyncTree.this.applyOperationDescendantsHelper(childOperation, childTree, childServerCache, childWritesCache));
                }
            }
        };
        children.inOrderTraversal(r2);
        if (syncPoint != null) {
            arrayList.addAll(syncPoint.applyOperation(operation, writesCache, resolvedServerCache));
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public ImmutableTree<SyncPoint> getSyncPointTree() {
        return this.syncPointTree;
    }
}
