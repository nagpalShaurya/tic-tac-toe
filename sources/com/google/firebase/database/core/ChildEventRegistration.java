package com.google.firebase.database.core;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ChildEventRegistration extends EventRegistration {
    private final ChildEventListener eventListener;
    private final Repo repo;
    private final QuerySpec spec;

    /* renamed from: com.google.firebase.database.core.ChildEventRegistration$1 */
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    static /* synthetic */ class C04231 {

        /* renamed from: $SwitchMap$com$google$firebase$database$core$view$Event$EventType */
        static final /* synthetic */ int[] f44x916339dc = new int[EventType.values().length];

        static {
            try {
                f44x916339dc[EventType.CHILD_ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f44x916339dc[EventType.CHILD_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f44x916339dc[EventType.CHILD_MOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f44x916339dc[EventType.CHILD_REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ChildEventRegistration(@NotNull Repo repo2, @NotNull ChildEventListener eventListener2, @NotNull QuerySpec spec2) {
        this.repo = repo2;
        this.eventListener = eventListener2;
        this.spec = spec2;
    }

    public boolean respondsTo(EventType eventType) {
        return eventType != EventType.VALUE;
    }

    public boolean equals(Object other) {
        return (other instanceof ChildEventRegistration) && ((ChildEventRegistration) other).eventListener.equals(this.eventListener) && ((ChildEventRegistration) other).repo.equals(this.repo) && ((ChildEventRegistration) other).spec.equals(this.spec);
    }

    public int hashCode() {
        return (((this.eventListener.hashCode() * 31) + this.repo.hashCode()) * 31) + this.spec.hashCode();
    }

    public DataEvent createEvent(Change change, QuerySpec query) {
        return new DataEvent(change.getEventType(), this, InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this.repo, query.getPath().child(change.getChildKey())), change.getIndexedNode()), change.getPrevName() != null ? change.getPrevName().asString() : null);
    }

    public void fireEvent(DataEvent eventData) {
        if (!isZombied()) {
            int i = C04231.f44x916339dc[eventData.getEventType().ordinal()];
            if (i == 1) {
                this.eventListener.onChildAdded(eventData.getSnapshot(), eventData.getPreviousName());
            } else if (i == 2) {
                this.eventListener.onChildChanged(eventData.getSnapshot(), eventData.getPreviousName());
            } else if (i == 3) {
                this.eventListener.onChildMoved(eventData.getSnapshot(), eventData.getPreviousName());
            } else if (i == 4) {
                this.eventListener.onChildRemoved(eventData.getSnapshot());
            }
        }
    }

    public void fireCancelEvent(DatabaseError error) {
        this.eventListener.onCancelled(error);
    }

    public EventRegistration clone(QuerySpec newQuery) {
        return new ChildEventRegistration(this.repo, this.eventListener, newQuery);
    }

    public boolean isSameListener(EventRegistration other) {
        return (other instanceof ChildEventRegistration) && ((ChildEventRegistration) other).eventListener.equals(this.eventListener);
    }

    @NotNull
    public QuerySpec getQuerySpec() {
        return this.spec;
    }

    public String toString() {
        return "ChildEventRegistration";
    }

    /* access modifiers changed from: 0000 */
    public Repo getRepo() {
        return this.repo;
    }
}
