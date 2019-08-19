package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzia implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzabb;
    private final /* synthetic */ zzhy zzabc;

    private zzia(zzhy zzhy) {
        this.zzabc = zzhy;
        this.pos = this.zzabc.zzaaw.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzabc.zzaaw.size()) || zzji().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Entry<K, V>> zzji() {
        if (this.zzabb == null) {
            this.zzabb = this.zzabc.zzaaz.entrySet().iterator();
        }
        return this.zzabb;
    }

    public final /* synthetic */ Object next() {
        if (zzji().hasNext()) {
            return (Entry) zzji().next();
        }
        List zzb = this.zzabc.zzaaw;
        int i = this.pos - 1;
        this.pos = i;
        return (Entry) zzb.get(i);
    }

    /* synthetic */ zzia(zzhy zzhy, zzhz zzhz) {
        this(zzhy);
    }
}
