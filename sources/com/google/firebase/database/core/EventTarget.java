package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface EventTarget {
    void postEvent(Runnable runnable);

    void restart();

    void shutdown();
}
