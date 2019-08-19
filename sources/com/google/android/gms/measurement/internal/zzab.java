package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class zzab implements Iterator<String> {
    private Iterator<String> zzain = this.zzaio.zzaim.keySet().iterator();
    private final /* synthetic */ zzaa zzaio;

    zzab(zzaa zzaa) {
        this.zzaio = zzaa;
    }

    public final boolean hasNext() {
        return this.zzain.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzain.next();
    }
}
