package com.google.android.gms.internal.firebase_auth;

import java.util.ListIterator;

final class zzit implements ListIterator<String> {
    private ListIterator<String> zzabp = this.zzabr.zzabo.listIterator(this.zzabq);
    private final /* synthetic */ int zzabq;
    private final /* synthetic */ zzis zzabr;

    zzit(zzis zzis, int i) {
        this.zzabr = zzis;
        this.zzabq = i;
    }

    public final boolean hasNext() {
        return this.zzabp.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzabp.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzabp.nextIndex();
    }

    public final int previousIndex() {
        return this.zzabp.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.zzabp.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzabp.next();
    }
}
