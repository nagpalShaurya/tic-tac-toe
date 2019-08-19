package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgp extends zzed<Long> implements zzga<Long>, zzhm, RandomAccess {
    private static final zzgp zzyx;
    private int size;
    private long[] zzyy;

    zzgp() {
        this(new long[10], 0);
    }

    private zzgp(long[] jArr, int i) {
        this.zzyy = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            long[] jArr = this.zzyy;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
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
        if (!(obj instanceof zzgp)) {
            return super.equals(obj);
        }
        zzgp zzgp = (zzgp) obj;
        if (this.size != zzgp.size) {
            return false;
        }
        long[] jArr = zzgp.zzyy;
        for (int i = 0; i < this.size; i++) {
            if (this.zzyy[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfu.zzk(this.zzyy[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzh(i);
        return this.zzyy[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzl(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        zzew();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.zzyy;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.zzyy, i, jArr2, i + 1, this.size - i);
                    this.zzyy = jArr2;
                }
                this.zzyy[i] = j;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzgp)) {
            return super.addAll(collection);
        }
        zzgp zzgp = (zzgp) collection;
        int i = zzgp.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzyy;
            if (i3 > jArr.length) {
                this.zzyy = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzgp.zzyy, 0, this.zzyy, this.size, zzgp.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzyy[i]))) {
                long[] jArr = this.zzyy;
                System.arraycopy(jArr, i + 1, jArr, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }

    private final String zzi(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzew();
        zzh(i);
        long[] jArr = this.zzyy;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        long[] jArr = this.zzyy;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= this.size) {
            return new zzgp(Arrays.copyOf(this.zzyy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzgp zzgp = new zzgp();
        zzyx = zzgp;
        zzgp.zzev();
    }
}
