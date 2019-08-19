package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzih extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzhy zzabc;

    private zzih(zzhy zzhy) {
        this.zzabc = zzhy;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzig(this.zzabc, null);
    }

    public int size() {
        return this.zzabc.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzabc.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzabc.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzabc.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzabc.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzih(zzhy zzhy, zzhz zzhz) {
        this(zzhy);
    }
}
