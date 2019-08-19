package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DefaultPersistenceManager implements PersistenceManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CachePolicy cachePolicy;
    private final LogWrapper logger;
    private long serverCacheUpdatesSinceLastPruneCheck;
    private final PersistenceStorageEngine storageLayer;
    private final TrackedQueryManager trackedQueryManager;

    public DefaultPersistenceManager(Context ctx, PersistenceStorageEngine engine, CachePolicy cachePolicy2) {
        this(ctx, engine, cachePolicy2, new DefaultClock());
    }

    public DefaultPersistenceManager(Context ctx, PersistenceStorageEngine engine, CachePolicy cachePolicy2, Clock clock) {
        this.serverCacheUpdatesSinceLastPruneCheck = 0;
        this.storageLayer = engine;
        this.logger = ctx.getLogger("Persistence");
        this.trackedQueryManager = new TrackedQueryManager(this.storageLayer, this.logger, clock);
        this.cachePolicy = cachePolicy2;
    }

    public void saveUserOverwrite(Path path, Node node, long writeId) {
        this.storageLayer.saveUserOverwrite(path, node, writeId);
    }

    public void saveUserMerge(Path path, CompoundWrite children, long writeId) {
        this.storageLayer.saveUserMerge(path, children, writeId);
    }

    public void removeUserWrite(long writeId) {
        this.storageLayer.removeUserWrite(writeId);
    }

    public void removeAllUserWrites() {
        this.storageLayer.removeAllUserWrites();
    }

    public void applyUserWriteToServerCache(Path path, Node node) {
        if (!this.trackedQueryManager.hasActiveDefaultQuery(path)) {
            this.storageLayer.overwriteServerCache(path, node);
            this.trackedQueryManager.ensureCompleteTrackedQuery(path);
        }
    }

    public void applyUserWriteToServerCache(Path path, CompoundWrite merge) {
        Iterator it = merge.iterator();
        while (it.hasNext()) {
            Entry<Path, Node> write = (Entry) it.next();
            applyUserWriteToServerCache(path.child((Path) write.getKey()), (Node) write.getValue());
        }
    }

    public List<UserWriteRecord> loadUserWrites() {
        return this.storageLayer.loadUserWrites();
    }

    public CacheNode serverCache(QuerySpec query) {
        Set<ChildKey> trackedKeys;
        boolean complete;
        if (this.trackedQueryManager.isQueryComplete(query)) {
            complete = true;
            TrackedQuery trackedQuery = this.trackedQueryManager.findTrackedQuery(query);
            if (query.loadsAllData() || trackedQuery == null || !trackedQuery.complete) {
                trackedKeys = null;
            } else {
                trackedKeys = this.storageLayer.loadTrackedQueryKeys(trackedQuery.f45id);
            }
        } else {
            complete = false;
            trackedKeys = this.trackedQueryManager.getKnownCompleteChildren(query.getPath());
        }
        Node serverCacheNode = this.storageLayer.serverCache(query.getPath());
        if (trackedKeys == null) {
            return new CacheNode(IndexedNode.from(serverCacheNode, query.getIndex()), complete, false);
        }
        Node filteredNode = EmptyNode.Empty();
        for (ChildKey key : trackedKeys) {
            filteredNode = filteredNode.updateImmediateChild(key, serverCacheNode.getImmediateChild(key));
        }
        return new CacheNode(IndexedNode.from(filteredNode, query.getIndex()), complete, true);
    }

    public void updateServerCache(QuerySpec query, Node node) {
        if (query.loadsAllData()) {
            this.storageLayer.overwriteServerCache(query.getPath(), node);
        } else {
            this.storageLayer.mergeIntoServerCache(query.getPath(), node);
        }
        setQueryComplete(query);
        doPruneCheckAfterServerUpdate();
    }

    public void updateServerCache(Path path, CompoundWrite children) {
        this.storageLayer.mergeIntoServerCache(path, children);
        doPruneCheckAfterServerUpdate();
    }

    public void setQueryActive(QuerySpec query) {
        this.trackedQueryManager.setQueryActive(query);
    }

    public void setQueryInactive(QuerySpec query) {
        this.trackedQueryManager.setQueryInactive(query);
    }

    public void setQueryComplete(QuerySpec query) {
        if (query.loadsAllData()) {
            this.trackedQueryManager.setQueriesComplete(query.getPath());
        } else {
            this.trackedQueryManager.setQueryCompleteIfExists(query);
        }
    }

    public void setTrackedQueryKeys(QuerySpec query, Set<ChildKey> keys) {
        this.storageLayer.saveTrackedQueryKeys(this.trackedQueryManager.findTrackedQuery(query).f45id, keys);
    }

    public void updateTrackedQueryKeys(QuerySpec query, Set<ChildKey> added, Set<ChildKey> removed) {
        this.storageLayer.updateTrackedQueryKeys(this.trackedQueryManager.findTrackedQuery(query).f45id, added, removed);
    }

    public <T> T runInTransaction(Callable<T> callable) {
        this.storageLayer.beginTransaction();
        try {
            T result = callable.call();
            this.storageLayer.setTransactionSuccessful();
            this.storageLayer.endTransaction();
            return result;
        } catch (Throwable result2) {
            this.storageLayer.endTransaction();
            throw result2;
        }
    }

    private void doPruneCheckAfterServerUpdate() {
        this.serverCacheUpdatesSinceLastPruneCheck++;
        if (this.cachePolicy.shouldCheckCacheSize(this.serverCacheUpdatesSinceLastPruneCheck)) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Reached prune check threshold.", new Object[0]);
            }
            this.serverCacheUpdatesSinceLastPruneCheck = 0;
            boolean canPrune = true;
            long cacheSize = this.storageLayer.serverCacheEstimatedSizeInBytes();
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper = this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Cache size: ");
                sb.append(cacheSize);
                logWrapper.debug(sb.toString(), new Object[0]);
            }
            while (canPrune && this.cachePolicy.shouldPrune(cacheSize, this.trackedQueryManager.countOfPrunableQueries())) {
                PruneForest pruneForest = this.trackedQueryManager.pruneOldQueries(this.cachePolicy);
                if (pruneForest.prunesAnything()) {
                    this.storageLayer.pruneCache(Path.getEmptyPath(), pruneForest);
                } else {
                    canPrune = false;
                }
                cacheSize = this.storageLayer.serverCacheEstimatedSizeInBytes();
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper2 = this.logger;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cache size after prune: ");
                    sb2.append(cacheSize);
                    logWrapper2.debug(sb2.toString(), new Object[0]);
                }
            }
        }
    }
}
