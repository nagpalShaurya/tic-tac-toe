package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzub extends zztz<Boolean> implements zzvs<Boolean>, zzxe, RandomAccess {
    private static final zzub zzbtx;
    private int size;
    private boolean[] zzbty;

    zzub() {
        this(new boolean[10], 0);
    }

    private zzub(boolean[] zArr, int i) {
        this.zzbty = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zztx();
        if (i2 >= i) {
            boolean[] zArr = this.zzbty;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzub)) {
            return super.equals(obj);
        }
        zzub zzub = (zzub) obj;
        if (this.size != zzub.size) {
            return false;
        }
        boolean[] zArr = zzub.zzbty;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbty[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzvo.zzw(this.zzbty[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    private final void zza(int i, boolean z) {
        zztx();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                boolean[] zArr = this.zzbty;
                if (i2 < zArr.length) {
                    System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
                } else {
                    boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(zArr, 0, zArr2, 0, i);
                    System.arraycopy(this.zzbty, i, zArr2, i + 1, this.size - i);
                    this.zzbty = zArr2;
                }
                this.zzbty[i] = z;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzaj(i));
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zztx();
        zzvo.checkNotNull(collection);
        if (!(collection instanceof zzub)) {
            return super.addAll(collection);
        }
        zzub zzub = (zzub) collection;
        int i = zzub.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzbty;
            if (i3 > zArr.length) {
                this.zzbty = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzub.zzbty, 0, this.zzbty, this.size, zzub.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zztx();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzbty[i]))) {
                boolean[] zArr = this.zzbty;
                System.arraycopy(zArr, i + 1, zArr, i, this.size - i);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zztx();
        zzai(i);
        boolean[] zArr = this.zzbty;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zztx();
        zzai(i);
        boolean[] zArr = this.zzbty;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zza(i, ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ zzvs zzak(int i) {
        if (i >= this.size) {
            return new zzub(Arrays.copyOf(this.zzbty, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzai(i);
        return Boolean.valueOf(this.zzbty[i]);
    }

    static {
        zzub zzub = new zzub();
        zzbtx = zzub;
        zzub.zzsm();
    }
}
