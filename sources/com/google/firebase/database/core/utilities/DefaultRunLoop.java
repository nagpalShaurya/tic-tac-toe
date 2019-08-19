package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.ThreadInitializer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public abstract class DefaultRunLoop implements RunLoop {
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new FirebaseThreadFactory()) {
        /* access modifiers changed from: protected */
        public void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            if (t == null && (r instanceof Future)) {
                Future<?> future = (Future) r;
                try {
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (CancellationException e) {
                } catch (ExecutionException ee) {
                    t = ee.getCause();
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            }
            if (t != null) {
                DefaultRunLoop.this.handleException(t);
            }
        }
    };

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private class FirebaseThreadFactory implements ThreadFactory {
        private FirebaseThreadFactory() {
        }

        public Thread newThread(Runnable r) {
            Thread thread = DefaultRunLoop.this.getThreadFactory().newThread(r);
            ThreadInitializer initializer = DefaultRunLoop.this.getThreadInitializer();
            initializer.setName(thread, "FirebaseDatabaseWorker");
            initializer.setDaemon(thread, true);
            initializer.setUncaughtExceptionHandler(thread, new UncaughtExceptionHandler() {
                public void uncaughtException(Thread t, Throwable e) {
                    DefaultRunLoop.this.handleException(e);
                }
            });
            return thread;
        }
    }

    public abstract void handleException(Throwable th);

    /* access modifiers changed from: protected */
    public ThreadFactory getThreadFactory() {
        return Executors.defaultThreadFactory();
    }

    /* access modifiers changed from: protected */
    public ThreadInitializer getThreadInitializer() {
        return ThreadInitializer.defaultInstance;
    }

    public DefaultRunLoop() {
        this.executor.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executor;
    }

    public void scheduleNow(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public ScheduledFuture schedule(Runnable runnable, long milliseconds) {
        return this.executor.schedule(runnable, milliseconds, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }

    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    public static String messageForException(Throwable t) {
        if (t instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (t instanceof DatabaseException) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Uncaught exception in Firebase Database runloop (");
        sb.append(FirebaseDatabase.getSdkVersion());
        sb.append("). Please report to firebase-database-client@google.com");
        return sb.toString();
    }
}
