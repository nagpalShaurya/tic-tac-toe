package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

final class zziu implements Iterator<String> {
    private final /* synthetic */ zzis zzabr;
    private Iterator<String> zzabs = this.zzabr.zzabo.iterator();

    zziu(zzis zzis) {
        this.zzabr = zzis;
    }

    public final boolean hasNext() {
        return this.zzabs.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzabs.next();
    }
}
