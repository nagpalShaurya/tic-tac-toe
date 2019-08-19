package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzis extends AbstractList<String> implements zzgk, RandomAccess {
    /* access modifiers changed from: private */
    public final zzgk zzabo;

    public zzis(zzgk zzgk) {
        this.zzabo = zzgk;
    }

    public final Object zzas(int i) {
        return this.zzabo.zzas(i);
    }

    public final int size() {
        return this.zzabo.size();
    }

    public final void zzc(zzeh zzeh) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzit(this, i);
    }

    public final Iterator<String> iterator() {
        return new zziu(this);
    }

    public final List<?> zzib() {
        return this.zzabo.zzib();
    }

    public final zzgk zzic() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzabo.get(i);
    }
}
