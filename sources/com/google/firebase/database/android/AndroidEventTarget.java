package com.google.firebase.database.android;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.database.core.EventTarget;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class AndroidEventTarget implements EventTarget {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public void postEvent(Runnable r) {
        this.handler.post(r);
    }

    public void shutdown() {
    }

    public void restart() {
    }
}
