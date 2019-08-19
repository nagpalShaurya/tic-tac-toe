package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzgh<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzyn;

    public zzgh(Iterator<Entry<K, Object>> it) {
        this.zzyn = it;
    }

    public final boolean hasNext() {
        return this.zzyn.hasNext();
    }

    public final void remove() {
        this.zzyn.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzyn.next();
        if (entry.getValue() instanceof zzge) {
            return new zzgg(entry);
        }
        return entry;
    }
}
