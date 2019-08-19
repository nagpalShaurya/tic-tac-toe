package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzgv<K, V> extends LinkedHashMap<K, V> {
    private static final zzgv zzzg;
    private boolean zzsh = true;

    private zzgv() {
    }

    private zzgv(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzgv<K, V> zzig() {
        return zzzg;
    }

    public final void zza(zzgv<K, V> zzgv) {
        zzii();
        if (!zzgv.isEmpty()) {
            putAll(zzgv);
        }
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzii();
        super.clear();
    }

    public final V put(K k, V v) {
        zzii();
        zzfu.checkNotNull(k);
        zzfu.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzii();
        for (Object next : map.keySet()) {
            zzfu.checkNotNull(next);
            zzfu.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzii();
        return super.remove(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0060
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x005c
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
            r7 = 0
            goto L_0x005d
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0036
            r7 = 0
            goto L_0x005d
        L_0x0036:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0053
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0053
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0057
        L_0x0053:
            boolean r3 = r4.equals(r3)
        L_0x0057:
            if (r3 != 0) goto L_0x005b
            r7 = 0
            goto L_0x005d
        L_0x005b:
            goto L_0x001e
        L_0x005c:
            r7 = 1
        L_0x005d:
            if (r7 == 0) goto L_0x0060
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzgv.equals(java.lang.Object):boolean");
    }

    private static int zzi(Object obj) {
        if (obj instanceof byte[]) {
            return zzfu.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzfv)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += zzi(entry.getValue()) ^ zzi(entry.getKey());
        }
        return i;
    }

    public final zzgv<K, V> zzih() {
        return isEmpty() ? new zzgv<>() : new zzgv<>(this);
    }

    public final void zzev() {
        this.zzsh = false;
    }

    public final boolean isMutable() {
        return this.zzsh;
    }

    private final void zzii() {
        if (!this.zzsh) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzgv zzgv = new zzgv();
        zzzg = zzgv;
        zzgv.zzsh = false;
    }
}
