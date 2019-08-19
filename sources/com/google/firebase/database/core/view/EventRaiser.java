package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.logging.LogWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class EventRaiser {
    private final EventTarget eventTarget;
    /* access modifiers changed from: private */
    public final LogWrapper logger;

    public EventRaiser(Context ctx) {
        this.eventTarget = ctx.getEventTarget();
        this.logger = ctx.getLogger("EventRaiser");
    }

    public void raiseEvents(List<? extends Event> events) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Raising ");
            sb.append(events.size());
            sb.append(" event(s)");
            logWrapper.debug(sb.toString(), new Object[0]);
        }
        final ArrayList<Event> eventsClone = new ArrayList<>(events);
        this.eventTarget.postEvent(new Runnable() {
            public void run() {
                Iterator it = eventsClone.iterator();
                while (it.hasNext()) {
                    Event event = (Event) it.next();
                    if (EventRaiser.this.logger.logsDebug()) {
                        LogWrapper access$000 = EventRaiser.this.logger;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Raising ");
                        sb.append(event.toString());
                        access$000.debug(sb.toString(), new Object[0]);
                    }
                    event.fire();
                }
            }
        });
    }
}
