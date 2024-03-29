package com.google.firebase.database.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
class ThreadPoolEventTarget implements EventTarget {
    private final ThreadPoolExecutor executor;

    public ThreadPoolEventTarget(final ThreadFactory wrappedFactory, final ThreadInitializer threadInitializer) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread = wrappedFactory.newThread(r);
                threadInitializer.setName(thread, "FirebaseDatabaseEventTarget");
                threadInitializer.setDaemon(thread, true);
                return thread;
            }
        });
        this.executor = threadPoolExecutor;
    }

    public void postEvent(Runnable r) {
        this.executor.execute(r);
    }

    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }

    public void restart() {
        this.executor.setCorePoolSize(1);
    }
}
