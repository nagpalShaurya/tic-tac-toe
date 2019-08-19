package com.google.firebase.database.core.view;

import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class EventGenerator {
    /* access modifiers changed from: private */
    public final Index index;
    private final QuerySpec query;

    public EventGenerator(QuerySpec query2) {
        this.query = query2;
        this.index = query2.getIndex();
    }

    private void generateEventsForType(List<DataEvent> events, EventType type, List<Change> changes, List<EventRegistration> eventRegistrations, IndexedNode eventCache) {
        List<Change> filteredChanges = new ArrayList<>();
        for (Change change : changes) {
            if (change.getEventType().equals(type)) {
                filteredChanges.add(change);
            }
        }
        Collections.sort(filteredChanges, changeComparator());
        for (Change change2 : filteredChanges) {
            for (EventRegistration registration : eventRegistrations) {
                if (registration.respondsTo(type)) {
                    events.add(generateEvent(change2, registration, eventCache));
                }
            }
        }
    }

    private DataEvent generateEvent(Change change, EventRegistration registration, IndexedNode eventCache) {
        Change newChange;
        if (change.getEventType().equals(EventType.VALUE) || change.getEventType().equals(EventType.CHILD_REMOVED)) {
            newChange = change;
        } else {
            newChange = change.changeWithPrevName(eventCache.getPredecessorChildName(change.getChildKey(), change.getIndexedNode().getNode(), this.index));
        }
        return registration.createEvent(newChange, this.query);
    }

    public List<DataEvent> generateEventsForChanges(List<Change> changes, IndexedNode eventCache, List<EventRegistration> eventRegistrations) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Change change : changes) {
            if (change.getEventType().equals(EventType.CHILD_CHANGED) && this.index.indexedValueChanged(change.getOldIndexedNode().getNode(), change.getIndexedNode().getNode())) {
                arrayList2.add(Change.childMovedChange(change.getChildKey(), change.getIndexedNode()));
            }
        }
        ArrayList arrayList3 = arrayList;
        List<Change> list = changes;
        List<EventRegistration> list2 = eventRegistrations;
        IndexedNode indexedNode = eventCache;
        generateEventsForType(arrayList3, EventType.CHILD_REMOVED, list, list2, indexedNode);
        generateEventsForType(arrayList3, EventType.CHILD_ADDED, list, list2, indexedNode);
        generateEventsForType(arrayList3, EventType.CHILD_MOVED, arrayList2, list2, indexedNode);
        List<Change> list3 = changes;
        generateEventsForType(arrayList3, EventType.CHILD_CHANGED, list3, list2, indexedNode);
        generateEventsForType(arrayList3, EventType.VALUE, list3, list2, indexedNode);
        return arrayList;
    }

    private Comparator<Change> changeComparator() {
        return new Comparator<Change>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public int compare(Change a, Change b) {
                return EventGenerator.this.index.compare(new NamedNode(a.getChildKey(), a.getIndexedNode().getNode()), new NamedNode(b.getChildKey(), b.getIndexedNode().getNode()));
            }
        };
    }
}
