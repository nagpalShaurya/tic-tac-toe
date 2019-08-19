package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ChildChangeAccumulator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<ChildKey, Change> changeMap = new HashMap();

    public void trackChildChange(Change change) {
        EventType type = change.getEventType();
        ChildKey childKey = change.getChildKey();
        if (this.changeMap.containsKey(childKey)) {
            Change oldChange = (Change) this.changeMap.get(childKey);
            EventType oldType = oldChange.getEventType();
            if (type == EventType.CHILD_ADDED && oldType == EventType.CHILD_REMOVED) {
                this.changeMap.put(change.getChildKey(), Change.childChangedChange(childKey, change.getIndexedNode(), oldChange.getIndexedNode()));
            } else if (type == EventType.CHILD_REMOVED && oldType == EventType.CHILD_ADDED) {
                this.changeMap.remove(childKey);
            } else if (type == EventType.CHILD_REMOVED && oldType == EventType.CHILD_CHANGED) {
                this.changeMap.put(childKey, Change.childRemovedChange(childKey, oldChange.getOldIndexedNode()));
            } else if (type == EventType.CHILD_CHANGED && oldType == EventType.CHILD_ADDED) {
                this.changeMap.put(childKey, Change.childAddedChange(childKey, change.getIndexedNode()));
            } else if (type == EventType.CHILD_CHANGED && oldType == EventType.CHILD_CHANGED) {
                this.changeMap.put(childKey, Change.childChangedChange(childKey, change.getIndexedNode(), oldChange.getOldIndexedNode()));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal combination of changes: ");
                sb.append(change);
                sb.append(" occurred after ");
                sb.append(oldChange);
                throw new IllegalStateException(sb.toString());
            }
        } else {
            this.changeMap.put(change.getChildKey(), change);
        }
    }

    public List<Change> getChanges() {
        return new ArrayList(this.changeMap.values());
    }
}
