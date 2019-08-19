package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzib extends zzih {
    private final /* synthetic */ zzhy zzabc;

    private zzib(zzhy zzhy) {
        this.zzabc = zzhy;
        super(zzhy, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzia(this.zzabc, null);
    }

    /* synthetic */ zzib(zzhy zzhy, zzhz zzhz) {
        this(zzhy);
    }
}
