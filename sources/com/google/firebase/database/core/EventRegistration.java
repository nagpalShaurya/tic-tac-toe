package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public abstract class EventRegistration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean isUserInitiated = false;
    private EventRegistrationZombieListener listener;
    private AtomicBoolean zombied = new AtomicBoolean(false);

    public abstract EventRegistration clone(QuerySpec querySpec);

    public abstract DataEvent createEvent(Change change, QuerySpec querySpec);

    public abstract void fireCancelEvent(DatabaseError databaseError);

    public abstract void fireEvent(DataEvent dataEvent);

    @NotNull
    public abstract QuerySpec getQuerySpec();

    public abstract boolean isSameListener(EventRegistration eventRegistration);

    public abstract boolean respondsTo(EventType eventType);

    public void zombify() {
        if (this.zombied.compareAndSet(false, true)) {
            EventRegistrationZombieListener eventRegistrationZombieListener = this.listener;
            if (eventRegistrationZombieListener != null) {
                eventRegistrationZombieListener.onZombied(this);
                this.listener = null;
            }
        }
    }

    public boolean isZombied() {
        return this.zombied.get();
    }

    public void setOnZombied(EventRegistrationZombieListener listener2) {
        this.listener = listener2;
    }

    public boolean isUserInitiated() {
        return this.isUserInitiated;
    }

    public void setIsUserInitiated(boolean isUserInitiated2) {
        this.isUserInitiated = isUserInitiated2;
    }

    /* access modifiers changed from: 0000 */
    public Repo getRepo() {
        return null;
    }
}
