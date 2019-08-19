package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface Event {

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public enum EventType {
        CHILD_REMOVED,
        CHILD_ADDED,
        CHILD_MOVED,
        CHILD_CHANGED,
        VALUE
    }

    void fire();

    Path getPath();

    String toString();
}
