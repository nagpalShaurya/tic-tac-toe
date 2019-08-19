package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfp extends zzed<Float> implements zzga<Float>, zzhm, RandomAccess {
    private static final zzfp zzwu;
    private int size;
    private float[] zzwv;

    zzfp() {
        this(new float[10], 0);
    }

    private zzfp(float[] fArr, int i) {
        this.zzwv = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            float[] fArr = this.zzwv;
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
        if (!(obj instanceof zzfp)) {
            return super.equals(obj);
        }
        zzfp zzfp = (zzfp) obj;
        if (this.size != zzfp.size) {
            return false;
        }
        float[] fArr = zzfp.zzwv;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzwv[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzwv[i2]);
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
        zzew();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                float[] fArr = this.zzwv;
                if (i2 < fArr.length) {
                    System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
                } else {
                    float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(fArr, 0, fArr2, 0, i);
                    System.arraycopy(this.zzwv, i, fArr2, i + 1, this.size - i);
                    this.zzwv = fArr2;
                }
                this.zzwv[i] = f;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzfp)) {
            return super.addAll(collection);
        }
        zzfp zzfp = (zzfp) collection;
        int i = zzfp.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzwv;
            if (i3 > fArr.length) {
                this.zzwv = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzfp.zzwv, 0, this.zzwv, this.size, zzfp.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzwv[i]))) {
                float[] fArr = this.zzwv;
                System.arraycopy(fArr, i + 1, fArr, i, this.size - i);
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
        float floatValue = ((Float) obj).floatValue();
        zzew();
        zzh(i);
        float[] fArr = this.zzwv;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        float[] fArr = this.zzwv;
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

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= this.size) {
            return new zzfp(Arrays.copyOf(this.zzwv, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Float.valueOf(this.zzwv[i]);
    }

    static {
        zzfp zzfp = new zzfp();
        zzwu = zzfp;
        zzfp.zzev();
    }
}
