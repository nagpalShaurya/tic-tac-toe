package com.google.android.gms.internal.firebase_auth;

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

class zzhy<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zzaav;
    /* access modifiers changed from: private */
    public List<zzif> zzaaw;
    /* access modifiers changed from: private */
    public Map<K, V> zzaax;
    private volatile zzih zzaay;
    /* access modifiers changed from: private */
    public Map<K, V> zzaaz;
    private volatile zzib zzaba;
    private boolean zzuc;

    static <FieldDescriptorType extends zzfl<FieldDescriptorType>> zzhy<FieldDescriptorType, Object> zzba(int i) {
        return new zzhz(i);
    }

    private zzhy(int i) {
        this.zzaav = i;
        this.zzaaw = Collections.emptyList();
        this.zzaax = Collections.emptyMap();
        this.zzaaz = Collections.emptyMap();
    }

    public void zzev() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzuc) {
            if (this.zzaax.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzaax);
            }
            this.zzaax = map;
            if (this.zzaaz.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzaaz);
            }
            this.zzaaz = map2;
            this.zzuc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzuc;
    }

    public final int zzjd() {
        return this.zzaaw.size();
    }

    public final Entry<K, V> zzbb(int i) {
        return (Entry) this.zzaaw.get(i);
    }

    public final Iterable<Entry<K, V>> zzje() {
        if (this.zzaax.isEmpty()) {
            return zzic.zzjj();
        }
        return this.zzaax.entrySet();
    }

    public int size() {
        return this.zzaaw.size() + this.zzaax.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((K) comparable) >= 0 || this.zzaax.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return ((zzif) this.zzaaw.get(zza)).getValue();
        }
        return this.zzaax.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzjg();
        int zza = zza(k);
        if (zza >= 0) {
            return ((zzif) this.zzaaw.get(zza)).setValue(v);
        }
        zzjg();
        if (this.zzaaw.isEmpty() && !(this.zzaaw instanceof ArrayList)) {
            this.zzaaw = new ArrayList(this.zzaav);
        }
        int i = -(zza + 1);
        if (i >= this.zzaav) {
            return zzjh().put(k, v);
        }
        int size = this.zzaaw.size();
        int i2 = this.zzaav;
        if (size == i2) {
            zzif zzif = (zzif) this.zzaaw.remove(i2 - 1);
            zzjh().put((Comparable) zzif.getKey(), zzif.getValue());
        }
        this.zzaaw.add(i, new zzif(this, k, v));
        return null;
    }

    public void clear() {
        zzjg();
        if (!this.zzaaw.isEmpty()) {
            this.zzaaw.clear();
        }
        if (!this.zzaax.isEmpty()) {
            this.zzaax.clear();
        }
    }

    public V remove(Object obj) {
        zzjg();
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return zzbc(zza);
        }
        if (this.zzaax.isEmpty()) {
            return null;
        }
        return this.zzaax.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzbc(int i) {
        zzjg();
        V value = ((zzif) this.zzaaw.remove(i)).getValue();
        if (!this.zzaax.isEmpty()) {
            Iterator it = zzjh().entrySet().iterator();
            this.zzaaw.add(new zzif(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzaaw.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((zzif) this.zzaaw.get(size)).getKey());
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
            int compareTo2 = k.compareTo((Comparable) ((zzif) this.zzaaw.get(i2)).getKey());
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
        if (this.zzaay == null) {
            this.zzaay = new zzih(this, null);
        }
        return this.zzaay;
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> zzjf() {
        if (this.zzaba == null) {
            this.zzaba = new zzib(this, null);
        }
        return this.zzaba;
    }

    /* access modifiers changed from: private */
    public final void zzjg() {
        if (this.zzuc) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzjh() {
        zzjg();
        if (this.zzaax.isEmpty() && !(this.zzaax instanceof TreeMap)) {
            this.zzaax = new TreeMap();
            this.zzaaz = ((TreeMap) this.zzaax).descendingMap();
        }
        return (SortedMap) this.zzaax;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhy)) {
            return super.equals(obj);
        }
        zzhy zzhy = (zzhy) obj;
        int size = size();
        if (size != zzhy.size()) {
            return false;
        }
        int zzjd = zzjd();
        if (zzjd != zzhy.zzjd()) {
            return entrySet().equals(zzhy.entrySet());
        }
        for (int i = 0; i < zzjd; i++) {
            if (!zzbb(i).equals(zzhy.zzbb(i))) {
                return false;
            }
        }
        if (zzjd != size) {
            return this.zzaax.equals(zzhy.zzaax);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzjd(); i2++) {
            i += ((zzif) this.zzaaw.get(i2)).hashCode();
        }
        if (this.zzaax.size() > 0) {
            return i + this.zzaax.hashCode();
        }
        return i;
    }

    /* synthetic */ zzhy(int i, zzhz zzhz) {
        this(i);
    }
}
