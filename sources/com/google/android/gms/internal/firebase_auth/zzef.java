package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzef extends zzed<Boolean> implements zzga<Boolean>, zzhm, RandomAccess {
    private static final zzef zzsm;
    private int size;
    private boolean[] zzsn;

    zzef() {
        this(new boolean[10], 0);
    }

    private zzef(boolean[] zArr, int i) {
        this.zzsn = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            boolean[] zArr = this.zzsn;
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
        if (!(obj instanceof zzef)) {
            return super.equals(obj);
        }
        zzef zzef = (zzef) obj;
        if (this.size != zzef.size) {
            return false;
        }
        boolean[] zArr = zzef.zzsn;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsn[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfu.zzu(this.zzsn[i2]);
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
        zzew();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                boolean[] zArr = this.zzsn;
                if (i2 < zArr.length) {
                    System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
                } else {
                    boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(zArr, 0, zArr2, 0, i);
                    System.arraycopy(this.zzsn, i, zArr2, i + 1, this.size - i);
                    this.zzsn = zArr2;
                }
                this.zzsn[i] = z;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzef)) {
            return super.addAll(collection);
        }
        zzef zzef = (zzef) collection;
        int i = zzef.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzsn;
            if (i3 > zArr.length) {
                this.zzsn = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzef.zzsn, 0, this.zzsn, this.size, zzef.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzsn[i]))) {
                boolean[] zArr = this.zzsn;
                System.arraycopy(zArr, i + 1, zArr, i, this.size - i);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzew();
        zzh(i);
        boolean[] zArr = this.zzsn;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        boolean[] zArr = this.zzsn;
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

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= this.size) {
            return new zzef(Arrays.copyOf(this.zzsn, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Boolean.valueOf(this.zzsn[i]);
    }

    static {
        zzef zzef = new zzef();
        zzsm = zzef;
        zzef.zzev();
    }
}
