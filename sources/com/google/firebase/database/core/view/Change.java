package com.google.firebase.database.core.view;

import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Change {
    private final ChildKey childKey;
    private final EventType eventType;
    private final IndexedNode indexedNode;
    private final IndexedNode oldIndexedNode;
    private final ChildKey prevName;

    private Change(EventType eventType2, IndexedNode indexedNode2, ChildKey childKey2, ChildKey prevName2, IndexedNode oldIndexedNode2) {
        this.eventType = eventType2;
        this.indexedNode = indexedNode2;
        this.childKey = childKey2;
        this.prevName = prevName2;
        this.oldIndexedNode = oldIndexedNode2;
    }

    public static Change valueChange(IndexedNode snapshot) {
        Change change = new Change(EventType.VALUE, snapshot, null, null, null);
        return change;
    }

    public static Change childAddedChange(ChildKey childKey2, Node snapshot) {
        return childAddedChange(childKey2, IndexedNode.from(snapshot));
    }

    public static Change childAddedChange(ChildKey childKey2, IndexedNode snapshot) {
        Change change = new Change(EventType.CHILD_ADDED, snapshot, childKey2, null, null);
        return change;
    }

    public static Change childRemovedChange(ChildKey childKey2, Node snapshot) {
        return childRemovedChange(childKey2, IndexedNode.from(snapshot));
    }

    public static Change childRemovedChange(ChildKey childKey2, IndexedNode snapshot) {
        Change change = new Change(EventType.CHILD_REMOVED, snapshot, childKey2, null, null);
        return change;
    }

    public static Change childChangedChange(ChildKey childKey2, Node newSnapshot, Node oldSnapshot) {
        return childChangedChange(childKey2, IndexedNode.from(newSnapshot), IndexedNode.from(oldSnapshot));
    }

    public static Change childChangedChange(ChildKey childKey2, IndexedNode newSnapshot, IndexedNode oldSnapshot) {
        Change change = new Change(EventType.CHILD_CHANGED, newSnapshot, childKey2, null, oldSnapshot);
        return change;
    }

    public static Change childMovedChange(ChildKey childKey2, Node snapshot) {
        return childMovedChange(childKey2, IndexedNode.from(snapshot));
    }

    public static Change childMovedChange(ChildKey childKey2, IndexedNode snapshot) {
        Change change = new Change(EventType.CHILD_MOVED, snapshot, childKey2, null, null);
        return change;
    }

    public Change changeWithPrevName(ChildKey prevName2) {
        Change change = new Change(this.eventType, this.indexedNode, this.childKey, prevName2, this.oldIndexedNode);
        return change;
    }

    public ChildKey getChildKey() {
        return this.childKey;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public IndexedNode getIndexedNode() {
        return this.indexedNode;
    }

    public ChildKey getPrevName() {
        return this.prevName;
    }

    public IndexedNode getOldIndexedNode() {
        return this.oldIndexedNode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Change: ");
        sb.append(this.eventType);
        sb.append(" ");
        sb.append(this.childKey);
        return sb.toString();
    }
}
