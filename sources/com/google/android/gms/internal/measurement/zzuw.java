package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzuw extends zztz<Double> implements zzvs<Double>, zzxe, RandomAccess {
    private static final zzuw zzbvg;
    private int size;
    private double[] zzbvh;

    zzuw() {
        this(new double[10], 0);
    }

    private zzuw(double[] dArr, int i) {
        this.zzbvh = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zztx();
        if (i2 >= i) {
            double[] dArr = this.zzbvh;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzuw)) {
            return super.equals(obj);
        }
        zzuw zzuw = (zzuw) obj;
        if (this.size != zzuw.size) {
            return false;
        }
        double[] dArr = zzuw.zzbvh;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbvh[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzvo.zzbf(Double.doubleToLongBits(this.zzbvh[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        zztx();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                double[] dArr = this.zzbvh;
                if (i2 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
                } else {
                    double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i);
                    System.arraycopy(this.zzbvh, i, dArr2, i + 1, this.size - i);
                    this.zzbvh = dArr2;
                }
                this.zzbvh[i] = d;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzaj(i));
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zztx();
        zzvo.checkNotNull(collection);
        if (!(collection instanceof zzuw)) {
            return super.addAll(collection);
        }
        zzuw zzuw = (zzuw) collection;
        int i = zzuw.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzbvh;
            if (i3 > dArr.length) {
                this.zzbvh = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzuw.zzbvh, 0, this.zzbvh, this.size, zzuw.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zztx();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzbvh[i]))) {
                double[] dArr = this.zzbvh;
                System.arraycopy(dArr, i + 1, dArr, i, this.size - i);
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
        double doubleValue = ((Double) obj).doubleValue();
        zztx();
        zzai(i);
        double[] dArr = this.zzbvh;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zztx();
        zzai(i);
        double[] dArr = this.zzbvh;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final /* synthetic */ zzvs zzak(int i) {
        if (i >= this.size) {
            return new zzuw(Arrays.copyOf(this.zzbvh, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzai(i);
        return Double.valueOf(this.zzbvh[i]);
    }

    static {
        zzuw zzuw = new zzuw();
        zzbvg = zzuw;
        zzuw.zzsm();
    }
}
