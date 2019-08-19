package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class OffsetClock implements Clock {
    private final Clock baseClock;
    private long offset = 0;

    public OffsetClock(Clock baseClock2, long offset2) {
        this.baseClock = baseClock2;
        this.offset = offset2;
    }

    public void setOffset(long offset2) {
        this.offset = offset2;
    }

    public long millis() {
        return this.baseClock.millis() + this.offset;
    }
}
