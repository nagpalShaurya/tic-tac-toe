package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzvn extends zztz<Integer> implements zzvs<Integer>, zzxe, RandomAccess {
    private static final zzvn zzbzh;
    private int size;
    private int[] zzbzi;

    zzvn() {
        this(new int[10], 0);
    }

    private zzvn(int[] iArr, int i) {
        this.zzbzi = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zztx();
        if (i2 >= i) {
            int[] iArr = this.zzbzi;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvn)) {
            return super.equals(obj);
        }
        zzvn zzvn = (zzvn) obj;
        if (this.size != zzvn.size) {
            return false;
        }
        int[] iArr = zzvn.zzbzi;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbzi[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzbzi[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzai(i);
        return this.zzbzi[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbm(int i) {
        zzp(this.size, i);
    }

    private final void zzp(int i, int i2) {
        zztx();
        if (i >= 0) {
            int i3 = this.size;
            if (i <= i3) {
                int[] iArr = this.zzbzi;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.zzbzi, i, iArr2, i + 1, this.size - i);
                    this.zzbzi = iArr2;
                }
                this.zzbzi[i] = i2;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzaj(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zztx();
        zzvo.checkNotNull(collection);
        if (!(collection instanceof zzvn)) {
            return super.addAll(collection);
        }
        zzvn zzvn = (zzvn) collection;
        int i = zzvn.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzbzi;
            if (i3 > iArr.length) {
                this.zzbzi = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzvn.zzbzi, 0, this.zzbzi, this.size, zzvn.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zztx();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzbzi[i]))) {
                int[] iArr = this.zzbzi;
                System.arraycopy(iArr, i + 1, iArr, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzai(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzaj(i));
        }
    }

    private final String zzaj(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zztx();
        zzai(i);
        int[] iArr = this.zzbzi;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zztx();
        zzai(i);
        int[] iArr = this.zzbzi;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzp(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ zzvs zzak(int i) {
        if (i >= this.size) {
            return new zzvn(Arrays.copyOf(this.zzbzi, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzvn zzvn = new zzvn();
        zzbzh = zzvn;
        zzvn.zzsm();
    }
}
