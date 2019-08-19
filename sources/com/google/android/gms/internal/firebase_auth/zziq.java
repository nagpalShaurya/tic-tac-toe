package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs.zze;
import java.io.IOException;
import java.util.Arrays;

public final class zziq {
    private static final zziq zzabm = new zziq(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzabn;
    private boolean zzsh;
    private int zzwz;
    private Object[] zzzm;

    public static zziq zzjn() {
        return zzabm;
    }

    static zziq zzjo() {
        return new zziq();
    }

    static zziq zza(zziq zziq, zziq zziq2) {
        int i = zziq.count + zziq2.count;
        int[] copyOf = Arrays.copyOf(zziq.zzabn, i);
        System.arraycopy(zziq2.zzabn, 0, copyOf, zziq.count, zziq2.count);
        Object[] copyOf2 = Arrays.copyOf(zziq.zzzm, i);
        System.arraycopy(zziq2.zzzm, 0, copyOf2, zziq.count, zziq2.count);
        return new zziq(i, copyOf, copyOf2, true);
    }

    private zziq() {
        this(0, new int[8], new Object[8], true);
    }

    private zziq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwz = -1;
        this.count = i;
        this.zzabn = iArr;
        this.zzzm = objArr;
        this.zzsh = z;
    }

    public final void zzev() {
        this.zzsh = false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzjk zzjk) throws IOException {
        if (zzjk.zzgk() == zze.zzxr) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzjk.zza(this.zzabn[i] >>> 3, this.zzzm[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzjk.zza(this.zzabn[i2] >>> 3, this.zzzm[i2]);
        }
    }

    public final void zzb(zzjk zzjk) throws IOException {
        if (this.count != 0) {
            if (zzjk.zzgk() == zze.zzxq) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzabn[i], this.zzzm[i], zzjk);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzabn[i2], this.zzzm[i2], zzjk);
            }
        }
    }

    private static void zzb(int i, Object obj, zzjk zzjk) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjk.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzjk.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzjk.zza(i2, (zzeh) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzjk.zzj(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgb.zzhu());
        } else if (zzjk.zzgk() == zze.zzxq) {
            zzjk.zzao(i2);
            ((zziq) obj).zzb(zzjk);
            zzjk.zzap(i2);
        } else {
            zzjk.zzap(i2);
            ((zziq) obj).zzb(zzjk);
            zzjk.zzao(i2);
        }
    }

    public final int zzjp() {
        int i = this.zzwz;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzez.zzd(this.zzabn[i3] >>> 3, (zzeh) this.zzzm[i3]);
        }
        this.zzwz = i2;
        return i2;
    }

    public final int zzgv() {
        int i;
        int i2 = this.zzwz;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzabn[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzez.zze(i6, ((Long) this.zzzm[i4]).longValue());
            } else if (i7 == 1) {
                i = zzez.zzg(i6, ((Long) this.zzzm[i4]).longValue());
            } else if (i7 == 2) {
                i = zzez.zzc(i6, (zzeh) this.zzzm[i4]);
            } else if (i7 == 3) {
                i = (zzez.zzaf(i6) << 1) + ((zziq) this.zzzm[i4]).zzgv();
            } else if (i7 == 5) {
                i = zzez.zzn(i6, ((Integer) this.zzzm[i4]).intValue());
            } else {
                throw new IllegalStateException(zzgb.zzhu());
            }
            i3 += i;
        }
        this.zzwz = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zziq)) {
            return false;
        }
        zziq zziq = (zziq) obj;
        int i = this.count;
        if (i == zziq.count) {
            int[] iArr = this.zzabn;
            int[] iArr2 = zziq.zzabn;
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
                Object[] objArr = this.zzzm;
                Object[] objArr2 = zziq.zzzm;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z2) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzabn;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzzm;
        for (int i7 = 0; i7 < this.count; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhe.zza(sb, i, String.valueOf(this.zzabn[i2] >>> 3), this.zzzm[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(int i, Object obj) {
        if (this.zzsh) {
            int i2 = this.count;
            if (i2 == this.zzabn.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzabn = Arrays.copyOf(this.zzabn, i3);
                this.zzzm = Arrays.copyOf(this.zzzm, i3);
            }
            int[] iArr = this.zzabn;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzzm[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
