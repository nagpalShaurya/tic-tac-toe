package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Operation.OperationType;
import com.google.firebase.database.core.view.ViewProcessor.ProcessorResult;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class View {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EventGenerator eventGenerator;
    private final List<EventRegistration> eventRegistrations = new ArrayList();
    private final ViewProcessor processor;
    private final QuerySpec query;
    private ViewCache viewCache;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public static class OperationResult {
        public final List<Change> changes;
        public final List<DataEvent> events;

        public OperationResult(List<DataEvent> events2, List<Change> changes2) {
            this.events = events2;
            this.changes = changes2;
        }
    }

    public View(QuerySpec query2, ViewCache initialViewCache) {
        this.query = query2;
        IndexedFilter indexFilter = new IndexedFilter(query2.getIndex());
        NodeFilter filter = query2.getParams().getNodeFilter();
        this.processor = new ViewProcessor(filter);
        CacheNode initialServerCache = initialViewCache.getServerCache();
        CacheNode initialEventCache = initialViewCache.getEventCache();
        IndexedNode emptyIndexedNode = IndexedNode.from(EmptyNode.Empty(), query2.getIndex());
        IndexedNode serverSnap = indexFilter.updateFullNode(emptyIndexedNode, initialServerCache.getIndexedNode(), null);
        IndexedNode eventSnap = filter.updateFullNode(emptyIndexedNode, initialEventCache.getIndexedNode(), null);
        this.viewCache = new ViewCache(new CacheNode(eventSnap, initialEventCache.isFullyInitialized(), filter.filtersNodes()), new CacheNode(serverSnap, initialServerCache.isFullyInitialized(), indexFilter.filtersNodes()));
        this.eventGenerator = new EventGenerator(query2);
    }

    public QuerySpec getQuery() {
        return this.query;
    }

    public Node getCompleteNode() {
        return this.viewCache.getCompleteEventSnap();
    }

    public Node getServerCache() {
        return this.viewCache.getServerCache().getNode();
    }

    public Node getEventCache() {
        return this.viewCache.getEventCache().getNode();
    }

    public Node getCompleteServerCache(Path path) {
        Node cache = this.viewCache.getCompleteServerSnap();
        if (cache == null || (!this.query.loadsAllData() && (path.isEmpty() || cache.getImmediateChild(path.getFront()).isEmpty()))) {
            return null;
        }
        return cache.getChild(path);
    }

    public boolean isEmpty() {
        return this.eventRegistrations.isEmpty();
    }

    public void addEventRegistration(@NotNull EventRegistration registration) {
        this.eventRegistrations.add(registration);
    }

    public List<Event> removeEventRegistration(@Nullable EventRegistration registration, DatabaseError cancelError) {
        List<Event> cancelEvents;
        if (cancelError != null) {
            cancelEvents = new ArrayList<>();
            Path path = this.query.getPath();
            for (EventRegistration eventRegistration : this.eventRegistrations) {
                cancelEvents.add(new CancelEvent(eventRegistration, cancelError, path));
            }
        } else {
            cancelEvents = Collections.emptyList();
        }
        if (registration != null) {
            int indexToDelete = -1;
            for (int i = 0; i < this.eventRegistrations.size(); i++) {
                EventRegistration candidate = (EventRegistration) this.eventRegistrations.get(i);
                if (candidate.isSameListener(registration)) {
                    indexToDelete = i;
                    if (candidate.isZombied()) {
                        break;
                    }
                }
            }
            if (indexToDelete != -1) {
                EventRegistration deletedRegistration = (EventRegistration) this.eventRegistrations.get(indexToDelete);
                this.eventRegistrations.remove(indexToDelete);
                deletedRegistration.zombify();
            }
        } else {
            for (EventRegistration eventRegistration2 : this.eventRegistrations) {
                eventRegistration2.zombify();
            }
            this.eventRegistrations.clear();
        }
        return cancelEvents;
    }

    public OperationResult applyOperation(Operation operation, WriteTreeRef writesCache, Node optCompleteServerCache) {
        if (!(operation.getType() == OperationType.Merge && operation.getSource().getQueryParams() == null)) {
        }
        ProcessorResult result = this.processor.applyOperation(this.viewCache, operation, writesCache, optCompleteServerCache);
        this.viewCache = result.viewCache;
        return new OperationResult(generateEventsForChanges(result.changes, result.viewCache.getEventCache().getIndexedNode(), null), result.changes);
    }

    public List<DataEvent> getInitialEvents(EventRegistration registration) {
        CacheNode eventSnap = this.viewCache.getEventCache();
        List<Change> initialChanges = new ArrayList<>();
        for (NamedNode child : eventSnap.getNode()) {
            initialChanges.add(Change.childAddedChange(child.getName(), child.getNode()));
        }
        if (eventSnap.isFullyInitialized()) {
            initialChanges.add(Change.valueChange(eventSnap.getIndexedNode()));
        }
        return generateEventsForChanges(initialChanges, eventSnap.getIndexedNode(), registration);
    }

    private List<DataEvent> generateEventsForChanges(List<Change> changes, IndexedNode eventCache, EventRegistration registration) {
        List<EventRegistration> registrations;
        if (registration == null) {
            registrations = this.eventRegistrations;
        } else {
            registrations = Arrays.asList(new EventRegistration[]{registration});
        }
        return this.eventGenerator.generateEventsForChanges(changes, eventCache, registrations);
    }

    /* access modifiers changed from: 0000 */
    public List<EventRegistration> getEventRegistrations() {
        return this.eventRegistrations;
    }
}
