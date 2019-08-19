package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfc extends zzed<Double> implements zzga<Double>, zzhm, RandomAccess {
    private static final zzfc zztr;
    private int size;
    private double[] zzts;

    zzfc() {
        this(new double[10], 0);
    }

    private zzfc(double[] dArr, int i) {
        this.zzts = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            double[] dArr = this.zzts;
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
        if (!(obj instanceof zzfc)) {
            return super.equals(obj);
        }
        zzfc zzfc = (zzfc) obj;
        if (this.size != zzfc.size) {
            return false;
        }
        double[] dArr = zzfc.zzts;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzts[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfu.zzk(Double.doubleToLongBits(this.zzts[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        zzew();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                double[] dArr = this.zzts;
                if (i2 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
                } else {
                    double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i);
                    System.arraycopy(this.zzts, i, dArr2, i + 1, this.size - i);
                    this.zzts = dArr2;
                }
                this.zzts[i] = d;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzfc)) {
            return super.addAll(collection);
        }
        zzfc zzfc = (zzfc) collection;
        int i = zzfc.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzts;
            if (i3 > dArr.length) {
                this.zzts = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzfc.zzts, 0, this.zzts, this.size, zzfc.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzts[i]))) {
                double[] dArr = this.zzts;
                System.arraycopy(dArr, i + 1, dArr, i, this.size - i);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzew();
        zzh(i);
        double[] dArr = this.zzts;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        double[] dArr = this.zzts;
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

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= this.size) {
            return new zzfc(Arrays.copyOf(this.zzts, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Double.valueOf(this.zzts[i]);
    }

    static {
        zzfc zzfc = new zzfc();
        zztr = zzfc;
        zzfc.zzev();
    }
}
