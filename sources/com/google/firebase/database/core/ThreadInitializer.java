package com.google.firebase.database.core;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface ThreadInitializer {
    public static final ThreadInitializer defaultInstance = new ThreadInitializer() {
        public void setName(Thread t, String name) {
            t.setName(name);
        }

        public void setDaemon(Thread t, boolean isDaemon) {
            t.setDaemon(isDaemon);
        }

        public void setUncaughtExceptionHandler(Thread t, UncaughtExceptionHandler handler) {
            t.setUncaughtExceptionHandler(handler);
        }
    };

    void setDaemon(Thread thread, boolean z);

    void setName(Thread thread, String str);

    void setUncaughtExceptionHandler(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler);
}
