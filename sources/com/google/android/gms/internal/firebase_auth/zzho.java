package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.List;

final class zzho<E> extends zzed<E> {
    private static final zzho<Object> zzaah;
    private final List<E> zzyt;

    public static <E> zzho<E> zziu() {
        return zzaah;
    }

    zzho() {
        this(new ArrayList(10));
    }

    private zzho(List<E> list) {
        this.zzyt = list;
    }

    public final void add(int i, E e) {
        zzew();
        this.zzyt.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzyt.get(i);
    }

    public final E remove(int i) {
        zzew();
        E remove = this.zzyt.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzew();
        E e2 = this.zzyt.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzyt.size();
    }

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzyt);
            return new zzho(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzho<Object> zzho = new zzho<>();
        zzaah = zzho;
        zzho.zzev();
    }
}
