package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzvj extends zztz<Float> implements zzvs<Float>, zzxe, RandomAccess {
    private static final zzvj zzbyi;
    private int size;
    private float[] zzbyj;

    zzvj() {
        this(new float[10], 0);
    }

    private zzvj(float[] fArr, int i) {
        this.zzbyj = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zztx();
        if (i2 >= i) {
            float[] fArr = this.zzbyj;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzvj)) {
            return super.equals(obj);
        }
        zzvj zzvj = (zzvj) obj;
        if (this.size != zzvj.size) {
            return false;
        }
        float[] fArr = zzvj.zzbyj;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbyj[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzbyj[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        zztx();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                float[] fArr = this.zzbyj;
                if (i2 < fArr.length) {
                    System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
                } else {
                    float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(fArr, 0, fArr2, 0, i);
                    System.arraycopy(this.zzbyj, i, fArr2, i + 1, this.size - i);
                    this.zzbyj = fArr2;
                }
                this.zzbyj[i] = f;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzaj(i));
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zztx();
        zzvo.checkNotNull(collection);
        if (!(collection instanceof zzvj)) {
            return super.addAll(collection);
        }
        zzvj zzvj = (zzvj) collection;
        int i = zzvj.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzbyj;
            if (i3 > fArr.length) {
                this.zzbyj = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzvj.zzbyj, 0, this.zzbyj, this.size, zzvj.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zztx();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzbyj[i]))) {
                float[] fArr = this.zzbyj;
                System.arraycopy(fArr, i + 1, fArr, i, this.size - i);
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
        float floatValue = ((Float) obj).floatValue();
        zztx();
        zzai(i);
        float[] fArr = this.zzbyj;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zztx();
        zzai(i);
        float[] fArr = this.zzbyj;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzvs zzak(int i) {
        if (i >= this.size) {
            return new zzvj(Arrays.copyOf(this.zzbyj, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzai(i);
        return Float.valueOf(this.zzbyj[i]);
    }

    static {
        zzvj zzvj = new zzvj();
        zzbyi = zzvj;
        zzvj.zzsm();
    }
}
