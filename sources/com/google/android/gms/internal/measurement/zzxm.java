package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzxm<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzbpo;
    private final int zzcca;
    /* access modifiers changed from: private */
    public List<zzxt> zzccb;
    /* access modifiers changed from: private */
    public Map<K, V> zzccc;
    private volatile zzxv zzccd;
    /* access modifiers changed from: private */
    public Map<K, V> zzcce;
    private volatile zzxp zzccf;

    static <FieldDescriptorType extends zzvf<FieldDescriptorType>> zzxm<FieldDescriptorType, Object> zzbt(int i) {
        return new zzxn(i);
    }

    private zzxm(int i) {
        this.zzcca = i;
        this.zzccb = Collections.emptyList();
        this.zzccc = Collections.emptyMap();
        this.zzcce = Collections.emptyMap();
    }

    public void zzsm() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzbpo) {
            if (this.zzccc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzccc);
            }
            this.zzccc = map;
            if (this.zzcce.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzcce);
            }
            this.zzcce = map2;
            this.zzbpo = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzbpo;
    }

    public final int zzxw() {
        return this.zzccb.size();
    }

    public final Entry<K, V> zzbu(int i) {
        return (Entry) this.zzccb.get(i);
    }

    public final Iterable<Entry<K, V>> zzxx() {
        if (this.zzccc.isEmpty()) {
            return zzxq.zzyc();
        }
        return this.zzccc.entrySet();
    }

    public int size() {
        return this.zzccb.size() + this.zzccc.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((K) comparable) >= 0 || this.zzccc.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return ((zzxt) this.zzccb.get(zza)).getValue();
        }
        return this.zzccc.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzxz();
        int zza = zza(k);
        if (zza >= 0) {
            return ((zzxt) this.zzccb.get(zza)).setValue(v);
        }
        zzxz();
        if (this.zzccb.isEmpty() && !(this.zzccb instanceof ArrayList)) {
            this.zzccb = new ArrayList(this.zzcca);
        }
        int i = -(zza + 1);
        if (i >= this.zzcca) {
            return zzya().put(k, v);
        }
        int size = this.zzccb.size();
        int i2 = this.zzcca;
        if (size == i2) {
            zzxt zzxt = (zzxt) this.zzccb.remove(i2 - 1);
            zzya().put((Comparable) zzxt.getKey(), zzxt.getValue());
        }
        this.zzccb.add(i, new zzxt(this, k, v));
        return null;
    }

    public void clear() {
        zzxz();
        if (!this.zzccb.isEmpty()) {
            this.zzccb.clear();
        }
        if (!this.zzccc.isEmpty()) {
            this.zzccc.clear();
        }
    }

    public V remove(Object obj) {
        zzxz();
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return zzbv(zza);
        }
        if (this.zzccc.isEmpty()) {
            return null;
        }
        return this.zzccc.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzbv(int i) {
        zzxz();
        V value = ((zzxt) this.zzccb.remove(i)).getValue();
        if (!this.zzccc.isEmpty()) {
            Iterator it = zzya().entrySet().iterator();
            this.zzccb.add(new zzxt(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzccb.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((zzxt) this.zzccb.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) ((zzxt) this.zzccb.get(i2)).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.zzccd == null) {
            this.zzccd = new zzxv(this, null);
        }
        return this.zzccd;
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> zzxy() {
        if (this.zzccf == null) {
            this.zzccf = new zzxp(this, null);
        }
        return this.zzccf;
    }

    /* access modifiers changed from: private */
    public final void zzxz() {
        if (this.zzbpo) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzya() {
        zzxz();
        if (this.zzccc.isEmpty() && !(this.zzccc instanceof TreeMap)) {
            this.zzccc = new TreeMap();
            this.zzcce = ((TreeMap) this.zzccc).descendingMap();
        }
        return (SortedMap) this.zzccc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxm)) {
            return super.equals(obj);
        }
        zzxm zzxm = (zzxm) obj;
        int size = size();
        if (size != zzxm.size()) {
            return false;
        }
        int zzxw = zzxw();
        if (zzxw != zzxm.zzxw()) {
            return entrySet().equals(zzxm.entrySet());
        }
        for (int i = 0; i < zzxw; i++) {
            if (!zzbu(i).equals(zzxm.zzbu(i))) {
                return false;
            }
        }
        if (zzxw != size) {
            return this.zzccc.equals(zzxm.zzccc);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzxw(); i2++) {
            i += ((zzxt) this.zzccb.get(i2)).hashCode();
        }
        if (this.zzccc.size() > 0) {
            return i + this.zzccc.hashCode();
        }
        return i;
    }

    /* synthetic */ zzxm(int i, zzxn zzxn) {
        this(i);
    }
}
