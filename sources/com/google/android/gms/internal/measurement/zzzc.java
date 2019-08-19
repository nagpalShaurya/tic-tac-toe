package com.google.android.gms.internal.measurement;

public final class zzzc implements Cloneable {
    private static final zzzd zzcff = new zzzd();
    private int mSize;
    private boolean zzcfg;
    private int[] zzcfh;
    private zzzd[] zzcfi;

    zzzc() {
        this(10);
    }

    private zzzc(int i) {
        this.zzcfg = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcfh = new int[idealIntArraySize];
        this.zzcfi = new zzzd[idealIntArraySize];
        this.mSize = 0;
    }

    /* access modifiers changed from: 0000 */
    public final zzzd zzcb(int i) {
        int zzcd = zzcd(i);
        if (zzcd >= 0) {
            zzzd[] zzzdArr = this.zzcfi;
            if (zzzdArr[zzcd] != zzcff) {
                return zzzdArr[zzcd];
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i, zzzd zzzd) {
        int zzcd = zzcd(i);
        if (zzcd >= 0) {
            this.zzcfi[zzcd] = zzzd;
            return;
        }
        int i2 = zzcd ^ -1;
        if (i2 < this.mSize) {
            zzzd[] zzzdArr = this.zzcfi;
            if (zzzdArr[i2] == zzcff) {
                this.zzcfh[i2] = i;
                zzzdArr[i2] = zzzd;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzcfh.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzzd[] zzzdArr2 = new zzzd[idealIntArraySize];
            int[] iArr2 = this.zzcfh;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzzd[] zzzdArr3 = this.zzcfi;
            System.arraycopy(zzzdArr3, 0, zzzdArr2, 0, zzzdArr3.length);
            this.zzcfh = iArr;
            this.zzcfi = zzzdArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzcfh;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzzd[] zzzdArr4 = this.zzcfi;
            System.arraycopy(zzzdArr4, i2, zzzdArr4, i5, this.mSize - i2);
        }
        this.zzcfh[i2] = i;
        this.zzcfi[i2] = zzzd;
        this.mSize++;
    }

    /* access modifiers changed from: 0000 */
    public final int size() {
        return this.mSize;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: 0000 */
    public final zzzd zzcc(int i) {
        return this.zzcfi[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzzc)) {
            return false;
        }
        zzzc zzzc = (zzzc) obj;
        int i = this.mSize;
        if (i != zzzc.mSize) {
            return false;
        }
        int[] iArr = this.zzcfh;
        int[] iArr2 = zzzc.zzcfh;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzzd[] zzzdArr = this.zzcfi;
            zzzd[] zzzdArr2 = zzzc.zzcfi;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzzdArr[i4].equals(zzzdArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcfh[i2]) * 31) + this.zzcfi[i2].hashCode();
        }
        return i;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzcd(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcfh[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzzc zzzc = new zzzc(i);
        System.arraycopy(this.zzcfh, 0, zzzc.zzcfh, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzzd[] zzzdArr = this.zzcfi;
            if (zzzdArr[i2] != null) {
                zzzc.zzcfi[i2] = (zzzd) zzzdArr[i2].clone();
            }
        }
        zzzc.mSize = i;
        return zzzc;
    }
}
