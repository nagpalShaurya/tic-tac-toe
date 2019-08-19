package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.core.view.View.OperationResult;
import com.google.firebase.database.core.view.ViewCache;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class SyncPoint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PersistenceManager persistenceManager;
    private final Map<QueryParams, View> views = new HashMap();

    public SyncPoint(PersistenceManager persistenceManager2) {
        this.persistenceManager = persistenceManager2;
    }

    public boolean isEmpty() {
        return this.views.isEmpty();
    }

    private List<DataEvent> applyOperationToView(View view, Operation operation, WriteTreeRef writes, Node optCompleteServerCache) {
        OperationResult result = view.applyOperation(operation, writes, optCompleteServerCache);
        if (!view.getQuery().loadsAllData()) {
            Set<ChildKey> removed = new HashSet<>();
            Set<ChildKey> added = new HashSet<>();
            for (Change change : result.changes) {
                EventType type = change.getEventType();
                if (type == EventType.CHILD_ADDED) {
                    added.add(change.getChildKey());
                } else if (type == EventType.CHILD_REMOVED) {
                    removed.add(change.getChildKey());
                }
            }
            if (!added.isEmpty() || !removed.isEmpty()) {
                this.persistenceManager.updateTrackedQueryKeys(view.getQuery(), added, removed);
            }
        }
        return result.events;
    }

    public List<DataEvent> applyOperation(Operation operation, WriteTreeRef writesCache, Node optCompleteServerCache) {
        QueryParams queryParams = operation.getSource().getQueryParams();
        if (queryParams != null) {
            return applyOperationToView((View) this.views.get(queryParams), operation, writesCache, optCompleteServerCache);
        }
        List<DataEvent> events = new ArrayList<>();
        for (Entry<QueryParams, View> entry : this.views.entrySet()) {
            events.addAll(applyOperationToView((View) entry.getValue(), operation, writesCache, optCompleteServerCache));
        }
        return events;
    }

    public List<DataEvent> addEventRegistration(@NotNull EventRegistration eventRegistration, WriteTreeRef writesCache, CacheNode serverCache) {
        boolean eventCacheComplete;
        QuerySpec query = eventRegistration.getQuerySpec();
        View view = (View) this.views.get(query.getParams());
        if (view == null) {
            Node eventCache = writesCache.calcCompleteEventCache(serverCache.isFullyInitialized() ? serverCache.getNode() : null);
            if (eventCache != null) {
                eventCacheComplete = true;
            } else {
                eventCache = writesCache.calcCompleteEventChildren(serverCache.getNode());
                eventCacheComplete = false;
            }
            view = new View(query, new ViewCache(new CacheNode(IndexedNode.from(eventCache, query.getIndex()), eventCacheComplete, false), serverCache));
            if (!query.loadsAllData()) {
                Set<ChildKey> allChildren = new HashSet<>();
                for (NamedNode node : view.getEventCache()) {
                    allChildren.add(node.getName());
                }
                this.persistenceManager.setTrackedQueryKeys(query, allChildren);
            }
            this.views.put(query.getParams(), view);
        }
        view.addEventRegistration(eventRegistration);
        return view.getInitialEvents(eventRegistration);
    }

    public Pair<List<QuerySpec>, List<Event>> removeEventRegistration(@NotNull QuerySpec query, @Nullable EventRegistration eventRegistration, @Nullable DatabaseError cancelError) {
        List<QuerySpec> removed = new ArrayList<>();
        List<Event> cancelEvents = new ArrayList<>();
        boolean hadCompleteView = hasCompleteView();
        if (query.isDefault()) {
            Iterator<Entry<QueryParams, View>> iterator = this.views.entrySet().iterator();
            while (iterator.hasNext()) {
                View view = (View) ((Entry) iterator.next()).getValue();
                cancelEvents.addAll(view.removeEventRegistration(eventRegistration, cancelError));
                if (view.isEmpty()) {
                    iterator.remove();
                    if (!view.getQuery().loadsAllData()) {
                        removed.add(view.getQuery());
                    }
                }
            }
        } else {
            View view2 = (View) this.views.get(query.getParams());
            if (view2 != null) {
                cancelEvents.addAll(view2.removeEventRegistration(eventRegistration, cancelError));
                if (view2.isEmpty()) {
                    this.views.remove(query.getParams());
                    if (!view2.getQuery().loadsAllData()) {
                        removed.add(view2.getQuery());
                    }
                }
            }
        }
        if (hadCompleteView && !hasCompleteView()) {
            removed.add(QuerySpec.defaultQueryAtPath(query.getPath()));
        }
        return new Pair<>(removed, cancelEvents);
    }

    public List<View> getQueryViews() {
        List<View> views2 = new ArrayList<>();
        for (Entry<QueryParams, View> entry : this.views.entrySet()) {
            View view = (View) entry.getValue();
            if (!view.getQuery().loadsAllData()) {
                views2.add(view);
            }
        }
        return views2;
    }

    public Node getCompleteServerCache(Path path) {
        for (View view : this.views.values()) {
            if (view.getCompleteServerCache(path) != null) {
                return view.getCompleteServerCache(path);
            }
        }
        return null;
    }

    public View viewForQuery(QuerySpec query) {
        if (query.loadsAllData()) {
            return getCompleteView();
        }
        return (View) this.views.get(query.getParams());
    }

    public boolean viewExistsForQuery(QuerySpec query) {
        return viewForQuery(query) != null;
    }

    public boolean hasCompleteView() {
        return getCompleteView() != null;
    }

    public View getCompleteView() {
        for (Entry<QueryParams, View> entry : this.views.entrySet()) {
            View view = (View) entry.getValue();
            if (view.getQuery().loadsAllData()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Map<QueryParams, View> getViews() {
        return this.views;
    }
}
