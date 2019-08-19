package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class CancelEvent implements Event {
    private final DatabaseError error;
    private final EventRegistration eventRegistration;
    private final Path path;

    public CancelEvent(EventRegistration eventRegistration2, DatabaseError error2, Path path2) {
        this.eventRegistration = eventRegistration2;
        this.path = path2;
        this.error = error2;
    }

    public Path getPath() {
        return this.path;
    }

    public void fire() {
        this.eventRegistration.fireCancelEvent(this.error);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPath());
        sb.append(":CANCEL");
        return sb.toString();
    }
}
