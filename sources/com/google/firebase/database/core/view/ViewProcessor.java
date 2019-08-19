package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Operation.OperationType;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ViewProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static CompleteChildSource NO_COMPLETE_SOURCE = new CompleteChildSource() {
        public Node getCompleteChild(ChildKey childKey) {
            return null;
        }

        public NamedNode getChildAfterChild(Index index, NamedNode child, boolean reverse) {
            return null;
        }
    };
    private final NodeFilter filter;

    /* renamed from: com.google.firebase.database.core.view.ViewProcessor$2 */
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    static /* synthetic */ class C05052 {

        /* renamed from: $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType */
        static final /* synthetic */ int[] f48xc0d7b136 = new int[OperationType.values().length];

        static {
            try {
                f48xc0d7b136[OperationType.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f48xc0d7b136[OperationType.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f48xc0d7b136[OperationType.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f48xc0d7b136[OperationType.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public static class ProcessorResult {
        public final List<Change> changes;
        public final ViewCache viewCache;

        public ProcessorResult(ViewCache viewCache2, List<Change> changes2) {
            this.viewCache = viewCache2;
            this.changes = changes2;
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class WriteTreeCompleteChildSource implements CompleteChildSource {
        private final Node optCompleteServerCache;
        private final ViewCache viewCache;
        private final WriteTreeRef writes;

        public WriteTreeCompleteChildSource(WriteTreeRef writes2, ViewCache viewCache2, Node optCompleteServerCache2) {
            this.writes = writes2;
            this.viewCache = viewCache2;
            this.optCompleteServerCache = optCompleteServerCache2;
        }

        public Node getCompleteChild(ChildKey childKey) {
            CacheNode serverNode;
            CacheNode node = this.viewCache.getEventCache();
            if (node.isCompleteForChild(childKey)) {
                return node.getNode().getImmediateChild(childKey);
            }
            Node node2 = this.optCompleteServerCache;
            if (node2 != null) {
                serverNode = new CacheNode(IndexedNode.from(node2, KeyIndex.getInstance()), true, false);
            } else {
                serverNode = this.viewCache.getServerCache();
            }
            return this.writes.calcCompleteChild(childKey, serverNode);
        }

        public NamedNode getChildAfterChild(Index index, NamedNode child, boolean reverse) {
            Node completeServerData = this.optCompleteServerCache;
            if (completeServerData == null) {
                completeServerData = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(completeServerData, child, reverse, index);
        }
    }

    public ViewProcessor(NodeFilter filter2) {
        this.filter = filter2;
    }

    public ProcessorResult applyOperation(ViewCache oldViewCache, Operation operation, WriteTreeRef writesCache, Node optCompleteCache) {
        ViewCache newViewCache;
        ChildChangeAccumulator accumulator = new ChildChangeAccumulator();
        int i = C05052.f48xc0d7b136[operation.getType().ordinal()];
        if (i == 1) {
            Overwrite overwrite = (Overwrite) operation;
            if (overwrite.getSource().isFromUser()) {
                newViewCache = applyUserOverwrite(oldViewCache, overwrite.getPath(), overwrite.getSnapshot(), writesCache, optCompleteCache, accumulator);
            } else {
                newViewCache = applyServerOverwrite(oldViewCache, overwrite.getPath(), overwrite.getSnapshot(), writesCache, optCompleteCache, overwrite.getSource().isTagged() || (oldViewCache.getServerCache().isFiltered() && !overwrite.getPath().isEmpty()), accumulator);
            }
        } else if (i == 2) {
            Merge merge = (Merge) operation;
            if (merge.getSource().isFromUser()) {
                newViewCache = applyUserMerge(oldViewCache, merge.getPath(), merge.getChildren(), writesCache, optCompleteCache, accumulator);
            } else {
                newViewCache = applyServerMerge(oldViewCache, merge.getPath(), merge.getChildren(), writesCache, optCompleteCache, merge.getSource().isTagged() || oldViewCache.getServerCache().isFiltered(), accumulator);
            }
        } else if (i == 3) {
            AckUserWrite ackUserWrite = (AckUserWrite) operation;
            if (!ackUserWrite.isRevert()) {
                newViewCache = ackUserWrite(oldViewCache, ackUserWrite.getPath(), ackUserWrite.getAffectedTree(), writesCache, optCompleteCache, accumulator);
            } else {
                newViewCache = revertUserWrite(oldViewCache, ackUserWrite.getPath(), writesCache, optCompleteCache, accumulator);
            }
        } else if (i == 4) {
            newViewCache = listenComplete(oldViewCache, operation.getPath(), writesCache, optCompleteCache, accumulator);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown operation: ");
            sb.append(operation.getType());
            throw new AssertionError(sb.toString());
        }
        List<Change> changes = new ArrayList<>(accumulator.getChanges());
        ViewCache viewCache = oldViewCache;
        maybeAddValueEvent(oldViewCache, newViewCache, changes);
        return new ProcessorResult(newViewCache, changes);
    }

    private void maybeAddValueEvent(ViewCache oldViewCache, ViewCache newViewCache, List<Change> accumulator) {
        CacheNode eventSnap = newViewCache.getEventCache();
        if (eventSnap.isFullyInitialized()) {
            boolean isLeafOrEmpty = eventSnap.getNode().isLeafNode() || eventSnap.getNode().isEmpty();
            if (!accumulator.isEmpty() || !oldViewCache.getEventCache().isFullyInitialized() || ((isLeafOrEmpty && !eventSnap.getNode().equals(oldViewCache.getCompleteEventSnap())) || !eventSnap.getNode().getPriority().equals(oldViewCache.getCompleteEventSnap().getPriority()))) {
                accumulator.add(Change.valueChange(eventSnap.getIndexedNode()));
            }
        }
    }

    private ViewCache generateEventCacheAfterServerEvent(ViewCache viewCache, Path changePath, WriteTreeRef writesCache, CompleteChildSource source, ChildChangeAccumulator accumulator) {
        IndexedNode newEventCache;
        Node serverNode;
        Node newEventChild;
        IndexedNode newEventCache2;
        Node serverCache;
        ViewCache viewCache2 = viewCache;
        Path path = changePath;
        WriteTreeRef writeTreeRef = writesCache;
        CacheNode oldEventSnap = viewCache.getEventCache();
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache2;
        }
        if (changePath.isEmpty()) {
            if (viewCache.getServerCache().isFiltered()) {
                Node serverCache2 = viewCache.getCompleteServerSnap();
                serverCache = writeTreeRef.calcCompleteEventChildren(serverCache2 instanceof ChildrenNode ? serverCache2 : EmptyNode.Empty());
            } else {
                serverCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            newEventCache = this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(serverCache, this.filter.getIndex()), accumulator);
        } else {
            ChildChangeAccumulator childChangeAccumulator = accumulator;
            ChildKey childKey = changePath.getFront();
            if (childKey.isPriorityChildName()) {
                Node updatedPriority = writeTreeRef.calcEventCacheAfterServerOverwrite(path, oldEventSnap.getNode(), viewCache.getServerCache().getNode());
                if (updatedPriority != null) {
                    newEventCache2 = this.filter.updatePriority(oldEventSnap.getIndexedNode(), updatedPriority);
                } else {
                    newEventCache2 = oldEventSnap.getIndexedNode();
                }
                newEventCache = newEventCache2;
            } else {
                Path childChangePath = changePath.popFront();
                if (oldEventSnap.isCompleteForChild(childKey)) {
                    Node eventChildUpdate = writeTreeRef.calcEventCacheAfterServerOverwrite(path, oldEventSnap.getNode(), viewCache.getServerCache().getNode());
                    if (eventChildUpdate != null) {
                        newEventChild = oldEventSnap.getNode().getImmediateChild(childKey).updateChild(childChangePath, eventChildUpdate);
                    } else {
                        newEventChild = oldEventSnap.getNode().getImmediateChild(childKey);
                    }
                    serverNode = newEventChild;
                } else {
                    serverNode = writeTreeRef.calcCompleteChild(childKey, viewCache.getServerCache());
                }
                if (serverNode != null) {
                    newEventCache = this.filter.updateChild(oldEventSnap.getIndexedNode(), childKey, serverNode, childChangePath, source, accumulator);
                } else {
                    newEventCache = oldEventSnap.getIndexedNode();
                }
            }
        }
        return viewCache2.updateEventSnap(newEventCache, oldEventSnap.isFullyInitialized() || changePath.isEmpty(), this.filter.filtersNodes());
    }

    private ViewCache applyServerOverwrite(ViewCache oldViewCache, Path changePath, Node changedSnap, WriteTreeRef writesCache, Node optCompleteCache, boolean filterServerNode, ChildChangeAccumulator accumulator) {
        IndexedNode newServerCache;
        ViewCache viewCache = oldViewCache;
        Node node = changedSnap;
        CacheNode oldServerSnap = oldViewCache.getServerCache();
        NodeFilter serverFilter = filterServerNode ? this.filter : this.filter.getIndexedFilter();
        boolean z = true;
        if (changePath.isEmpty()) {
            Path path = changePath;
            newServerCache = serverFilter.updateFullNode(oldServerSnap.getIndexedNode(), IndexedNode.from(node, serverFilter.getIndex()), null);
        } else if (!serverFilter.filtersNodes() || oldServerSnap.isFiltered()) {
            ChildKey childKey = changePath.getFront();
            if (!oldServerSnap.isCompleteForPath(changePath) && changePath.size() > 1) {
                return viewCache;
            }
            Path childChangePath = changePath.popFront();
            Node newChildNode = oldServerSnap.getNode().getImmediateChild(childKey).updateChild(childChangePath, node);
            if (childKey.isPriorityChildName()) {
                newServerCache = serverFilter.updatePriority(oldServerSnap.getIndexedNode(), newChildNode);
            } else {
                Node node2 = newChildNode;
                newServerCache = serverFilter.updateChild(oldServerSnap.getIndexedNode(), childKey, newChildNode, childChangePath, NO_COMPLETE_SOURCE, null);
            }
        } else {
            ChildKey childKey2 = changePath.getFront();
            Path updatePath = changePath;
            newServerCache = serverFilter.updateFullNode(oldServerSnap.getIndexedNode(), oldServerSnap.getIndexedNode().updateChild(childKey2, oldServerSnap.getNode().getImmediateChild(childKey2).updateChild(changePath.popFront(), node)), null);
        }
        if (!oldServerSnap.isFullyInitialized() && !changePath.isEmpty()) {
            z = false;
        }
        ViewCache newViewCache = viewCache.updateServerSnap(newServerCache, z, serverFilter.filtersNodes());
        NodeFilter nodeFilter = serverFilter;
        return generateEventCacheAfterServerEvent(newViewCache, changePath, writesCache, new WriteTreeCompleteChildSource(writesCache, newViewCache, optCompleteCache), accumulator);
    }

    private ViewCache applyUserOverwrite(ViewCache oldViewCache, Path changePath, Node changedSnap, WriteTreeRef writesCache, Node optCompleteCache, ChildChangeAccumulator accumulator) {
        Node newChild;
        ViewCache viewCache = oldViewCache;
        Node node = changedSnap;
        CacheNode oldEventSnap = oldViewCache.getEventCache();
        WriteTreeCompleteChildSource writeTreeCompleteChildSource = new WriteTreeCompleteChildSource(writesCache, viewCache, optCompleteCache);
        if (changePath.isEmpty()) {
            return viewCache.updateEventSnap(this.filter.updateFullNode(oldViewCache.getEventCache().getIndexedNode(), IndexedNode.from(node, this.filter.getIndex()), accumulator), true, this.filter.filtersNodes());
        }
        ChildChangeAccumulator childChangeAccumulator = accumulator;
        ChildKey childKey = changePath.getFront();
        if (childKey.isPriorityChildName()) {
            return viewCache.updateEventSnap(this.filter.updatePriority(oldViewCache.getEventCache().getIndexedNode(), node), oldEventSnap.isFullyInitialized(), oldEventSnap.isFiltered());
        }
        Path childChangePath = changePath.popFront();
        Node oldChild = oldEventSnap.getNode().getImmediateChild(childKey);
        if (childChangePath.isEmpty()) {
            newChild = changedSnap;
        } else {
            Node newChild2 = writeTreeCompleteChildSource.getCompleteChild(childKey);
            if (newChild2 == null) {
                newChild = EmptyNode.Empty();
            } else if (!childChangePath.getBack().isPriorityChildName() || !newChild2.getChild(childChangePath.getParent()).isEmpty()) {
                newChild = newChild2.updateChild(childChangePath, node);
            } else {
                newChild = newChild2;
            }
        }
        if (!oldChild.equals(newChild)) {
            Node node2 = newChild;
            Node node3 = oldChild;
            Path path = childChangePath;
            return viewCache.updateEventSnap(this.filter.updateChild(oldEventSnap.getIndexedNode(), childKey, newChild, childChangePath, writeTreeCompleteChildSource, accumulator), oldEventSnap.isFullyInitialized(), this.filter.filtersNodes());
        }
        Node node4 = oldChild;
        Path path2 = childChangePath;
        return oldViewCache;
    }

    private static boolean cacheHasChild(ViewCache viewCache, ChildKey childKey) {
        return viewCache.getEventCache().isCompleteForChild(childKey);
    }

    private ViewCache applyUserMerge(ViewCache viewCache, Path path, CompoundWrite changedChildren, WriteTreeRef writesCache, Node serverCache, ChildChangeAccumulator accumulator) {
        ViewCache viewCache2 = viewCache;
        Path path2 = path;
        ViewCache currentViewCache = viewCache;
        Iterator it = changedChildren.iterator();
        while (it.hasNext()) {
            Entry<Path, Node> entry = (Entry) it.next();
            Path writePath = path.child((Path) entry.getKey());
            if (cacheHasChild(viewCache, writePath.getFront())) {
                currentViewCache = applyUserOverwrite(currentViewCache, writePath, (Node) entry.getValue(), writesCache, serverCache, accumulator);
            }
        }
        Iterator it2 = changedChildren.iterator();
        while (it2.hasNext()) {
            Entry<Path, Node> entry2 = (Entry) it2.next();
            Path writePath2 = path.child((Path) entry2.getKey());
            if (!cacheHasChild(viewCache, writePath2.getFront())) {
                currentViewCache = applyUserOverwrite(currentViewCache, writePath2, (Node) entry2.getValue(), writesCache, serverCache, accumulator);
            }
        }
        return currentViewCache;
    }

    private ViewCache applyServerMerge(ViewCache viewCache, Path path, CompoundWrite changedChildren, WriteTreeRef writesCache, Node serverCache, boolean filterServerNode, ChildChangeAccumulator accumulator) {
        CompoundWrite actualMerge;
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            return viewCache;
        }
        ViewCache curViewCache = viewCache;
        if (path.isEmpty()) {
            actualMerge = changedChildren;
            Path path2 = path;
            CompoundWrite compoundWrite = changedChildren;
        } else {
            actualMerge = CompoundWrite.emptyWrite().addWrites(path, changedChildren);
        }
        Node serverNode = viewCache.getServerCache().getNode();
        Map<ChildKey, CompoundWrite> childCompoundWrites = actualMerge.childCompoundWrites();
        for (Entry<ChildKey, CompoundWrite> childMerge : childCompoundWrites.entrySet()) {
            ChildKey childKey = (ChildKey) childMerge.getKey();
            if (serverNode.hasChild(childKey)) {
                Node serverChild = serverNode.getImmediateChild(childKey);
                Node node = serverChild;
                ChildKey childKey2 = childKey;
                curViewCache = applyServerOverwrite(curViewCache, new Path(childKey), ((CompoundWrite) childMerge.getValue()).apply(serverChild), writesCache, serverCache, filterServerNode, accumulator);
            }
        }
        for (Entry<ChildKey, CompoundWrite> childMerge2 : childCompoundWrites.entrySet()) {
            ChildKey childKey3 = (ChildKey) childMerge2.getKey();
            boolean isUnknownDeepMerge = !viewCache.getServerCache().isCompleteForChild(childKey3) && ((CompoundWrite) childMerge2.getValue()).rootWrite() == null;
            if (serverNode.hasChild(childKey3) || isUnknownDeepMerge) {
            } else {
                Node serverChild2 = serverNode.getImmediateChild(childKey3);
                Node node2 = serverChild2;
                ChildKey childKey4 = childKey3;
                curViewCache = applyServerOverwrite(curViewCache, new Path(childKey3), ((CompoundWrite) childMerge2.getValue()).apply(serverChild2), writesCache, serverCache, filterServerNode, accumulator);
            }
        }
        return curViewCache;
    }

    private ViewCache ackUserWrite(ViewCache viewCache, Path ackPath, ImmutableTree<Boolean> affectedTree, WriteTreeRef writesCache, Node optCompleteCache, ChildChangeAccumulator accumulator) {
        Path path = ackPath;
        if (writesCache.shadowingWrite(ackPath) != null) {
            return viewCache;
        }
        boolean filterServerNode = viewCache.getServerCache().isFiltered();
        CacheNode serverCache = viewCache.getServerCache();
        if (affectedTree.getValue() == null) {
            CompoundWrite changedChildren = CompoundWrite.emptyWrite();
            Iterator it = affectedTree.iterator();
            CompoundWrite changedChildren2 = changedChildren;
            while (it.hasNext()) {
                Path mergePath = (Path) ((Entry) it.next()).getKey();
                Path serverCachePath = ackPath.child(mergePath);
                if (serverCache.isCompleteForPath(serverCachePath)) {
                    changedChildren2 = changedChildren2.addWrite(mergePath, serverCache.getNode().getChild(serverCachePath));
                }
            }
            return applyServerMerge(viewCache, ackPath, changedChildren2, writesCache, optCompleteCache, filterServerNode, accumulator);
        } else if ((ackPath.isEmpty() && serverCache.isFullyInitialized()) || serverCache.isCompleteForPath(ackPath)) {
            return applyServerOverwrite(viewCache, ackPath, serverCache.getNode().getChild(ackPath), writesCache, optCompleteCache, filterServerNode, accumulator);
        } else if (!ackPath.isEmpty()) {
            return viewCache;
        } else {
            CompoundWrite changedChildren3 = CompoundWrite.emptyWrite();
            CompoundWrite changedChildren4 = changedChildren3;
            for (NamedNode child : serverCache.getNode()) {
                changedChildren4 = changedChildren4.addWrite(child.getName(), child.getNode());
            }
            return applyServerMerge(viewCache, ackPath, changedChildren4, writesCache, optCompleteCache, filterServerNode, accumulator);
        }
    }

    public ViewCache revertUserWrite(ViewCache viewCache, Path path, WriteTreeRef writesCache, Node optCompleteServerCache, ChildChangeAccumulator accumulator) {
        IndexedNode newEventCache;
        IndexedNode oldEventCache;
        ChildChangeAccumulator childChangeAccumulator;
        Node newNode;
        Node newChild;
        ChildChangeAccumulator childChangeAccumulator2;
        ViewCache viewCache2 = viewCache;
        WriteTreeRef writeTreeRef = writesCache;
        ChildChangeAccumulator childChangeAccumulator3 = accumulator;
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache2;
        }
        WriteTreeCompleteChildSource writeTreeCompleteChildSource = new WriteTreeCompleteChildSource(writeTreeRef, viewCache2, optCompleteServerCache);
        IndexedNode oldEventCache2 = viewCache.getEventCache().getIndexedNode();
        if (path.isEmpty()) {
            oldEventCache = oldEventCache2;
            childChangeAccumulator = childChangeAccumulator3;
        } else if (path.getFront().isPriorityChildName()) {
            oldEventCache = oldEventCache2;
            childChangeAccumulator = childChangeAccumulator3;
        } else {
            ChildKey childKey = path.getFront();
            Node newChild2 = writeTreeRef.calcCompleteChild(childKey, viewCache.getServerCache());
            if (newChild2 != null || !viewCache.getServerCache().isCompleteForChild(childKey)) {
                newChild = newChild2;
            } else {
                newChild = oldEventCache2.getNode().getImmediateChild(childKey);
            }
            if (newChild != null) {
                newEventCache = this.filter.updateChild(oldEventCache2, childKey, newChild, path.popFront(), writeTreeCompleteChildSource, accumulator);
                IndexedNode indexedNode = oldEventCache2;
                childChangeAccumulator2 = childChangeAccumulator3;
            } else if (newChild != null || !viewCache.getEventCache().getNode().hasChild(childKey)) {
                childChangeAccumulator2 = childChangeAccumulator3;
                newEventCache = oldEventCache2;
            } else {
                ChildKey childKey2 = childKey;
                IndexedNode indexedNode2 = oldEventCache2;
                childChangeAccumulator2 = childChangeAccumulator3;
                newEventCache = this.filter.updateChild(oldEventCache2, childKey, EmptyNode.Empty(), path.popFront(), writeTreeCompleteChildSource, accumulator);
            }
            if (newEventCache.getNode().isEmpty() && viewCache.getServerCache().isFullyInitialized()) {
                Node complete = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                if (complete.isLeafNode()) {
                    newEventCache = this.filter.updateFullNode(newEventCache, IndexedNode.from(complete, this.filter.getIndex()), childChangeAccumulator2);
                }
            }
            return viewCache2.updateEventSnap(newEventCache, !viewCache.getServerCache().isFullyInitialized() || writeTreeRef.shadowingWrite(Path.getEmptyPath()) != null, this.filter.filtersNodes());
        }
        if (viewCache.getServerCache().isFullyInitialized()) {
            newNode = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
        } else {
            newNode = writeTreeRef.calcCompleteEventChildren(viewCache.getServerCache().getNode());
        }
        newEventCache = this.filter.updateFullNode(oldEventCache, IndexedNode.from(newNode, this.filter.getIndex()), childChangeAccumulator);
        return viewCache2.updateEventSnap(newEventCache, !viewCache.getServerCache().isFullyInitialized() || writeTreeRef.shadowingWrite(Path.getEmptyPath()) != null, this.filter.filtersNodes());
    }

    private ViewCache listenComplete(ViewCache viewCache, Path path, WriteTreeRef writesCache, Node serverCache, ChildChangeAccumulator accumulator) {
        CacheNode oldServerNode = viewCache.getServerCache();
        return generateEventCacheAfterServerEvent(viewCache.updateServerSnap(oldServerNode.getIndexedNode(), oldServerNode.isFullyInitialized() || path.isEmpty(), oldServerNode.isFiltered()), path, writesCache, NO_COMPLETE_SOURCE, accumulator);
    }
}
