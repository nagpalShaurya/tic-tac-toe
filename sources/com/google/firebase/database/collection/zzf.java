package com.google.firebase.database.collection;

import java.util.Iterator;

final class zzf implements Iterable<zzh> {
    /* access modifiers changed from: private */
    public final int length;
    /* access modifiers changed from: private */
    public long value;

    public zzf(int i) {
        int i2 = i + 1;
        this.length = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
        this.value = (((long) Math.pow(2.0d, (double) this.length)) - 1) & ((long) i2);
    }

    public final Iterator<zzh> iterator() {
        return new zzg(this);
    }
}
