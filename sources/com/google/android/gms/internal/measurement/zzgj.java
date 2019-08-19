package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgj extends zzza<zzgj> {
    public long[] zzaye;
    public long[] zzayf;
    public zzge[] zzayg;
    public zzgk[] zzayh;

    public zzgj() {
        this.zzaye = zzzj.zzcfr;
        this.zzayf = zzzj.zzcfr;
        this.zzayg = zzge.zzmp();
        this.zzayh = zzgk.zzmt();
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgj)) {
            return false;
        }
        zzgj zzgj = (zzgj) obj;
        if (!zzze.equals(this.zzaye, zzgj.zzaye) || !zzze.equals(this.zzayf, zzgj.zzayf) || !zzze.equals((Object[]) this.zzayg, (Object[]) zzgj.zzayg) || !zzze.equals((Object[]) this.zzayh, (Object[]) zzgj.zzayh)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgj.zzcfc);
        }
        if (zzgj.zzcfc == null || zzgj.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzze.hashCode(this.zzaye)) * 31) + zzze.hashCode(this.zzayf)) * 31) + zzze.hashCode((Object[]) this.zzayg)) * 31) + zzze.hashCode((Object[]) this.zzayh)) * 31;
        if (this.zzcfc == null || this.zzcfc.isEmpty()) {
            i = 0;
        } else {
            i = this.zzcfc.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        long[] jArr = this.zzaye;
        int i = 0;
        if (jArr != null && jArr.length > 0) {
            int i2 = 0;
            while (true) {
                long[] jArr2 = this.zzaye;
                if (i2 >= jArr2.length) {
                    break;
                }
                zzyy.zza(1, jArr2[i2]);
                i2++;
            }
        }
        long[] jArr3 = this.zzayf;
        if (jArr3 != null && jArr3.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr4 = this.zzayf;
                if (i3 >= jArr4.length) {
                    break;
                }
                zzyy.zza(2, jArr4[i3]);
                i3++;
            }
        }
        zzge[] zzgeArr = this.zzayg;
        if (zzgeArr != null && zzgeArr.length > 0) {
            int i4 = 0;
            while (true) {
                zzge[] zzgeArr2 = this.zzayg;
                if (i4 >= zzgeArr2.length) {
                    break;
                }
                zzge zzge = zzgeArr2[i4];
                if (zzge != null) {
                    zzyy.zza(3, (zzzg) zzge);
                }
                i4++;
            }
        }
        zzgk[] zzgkArr = this.zzayh;
        if (zzgkArr != null && zzgkArr.length > 0) {
            while (true) {
                zzgk[] zzgkArr2 = this.zzayh;
                if (i >= zzgkArr2.length) {
                    break;
                }
                zzgk zzgk = zzgkArr2[i];
                if (zzgk != null) {
                    zzyy.zza(4, (zzzg) zzgk);
                }
                i++;
            }
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        long[] jArr;
        long[] jArr2;
        int zzf = super.zzf();
        long[] jArr3 = this.zzaye;
        int i = 0;
        if (jArr3 != null && jArr3.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                jArr2 = this.zzaye;
                if (i2 >= jArr2.length) {
                    break;
                }
                i3 += zzyy.zzbi(jArr2[i2]);
                i2++;
            }
            zzf = zzf + i3 + (jArr2.length * 1);
        }
        long[] jArr4 = this.zzayf;
        if (jArr4 != null && jArr4.length > 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                jArr = this.zzayf;
                if (i4 >= jArr.length) {
                    break;
                }
                i5 += zzyy.zzbi(jArr[i4]);
                i4++;
            }
            zzf = zzf + i5 + (jArr.length * 1);
        }
        zzge[] zzgeArr = this.zzayg;
        if (zzgeArr != null && zzgeArr.length > 0) {
            int i6 = zzf;
            int i7 = 0;
            while (true) {
                zzge[] zzgeArr2 = this.zzayg;
                if (i7 >= zzgeArr2.length) {
                    break;
                }
                zzge zzge = zzgeArr2[i7];
                if (zzge != null) {
                    i6 += zzyy.zzb(3, (zzzg) zzge);
                }
                i7++;
            }
            zzf = i6;
        }
        zzgk[] zzgkArr = this.zzayh;
        if (zzgkArr != null && zzgkArr.length > 0) {
            while (true) {
                zzgk[] zzgkArr2 = this.zzayh;
                if (i >= zzgkArr2.length) {
                    break;
                }
                zzgk zzgk = zzgkArr2[i];
                if (zzgk != null) {
                    zzf += zzyy.zzb(4, (zzzg) zzgk);
                }
                i++;
            }
        }
        return zzf;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                int zzb = zzzj.zzb(zzyx, 8);
                long[] jArr = this.zzaye;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzaye, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = zzyx.zzuz();
                    zzyx.zzug();
                    length++;
                }
                jArr2[length] = zzyx.zzuz();
                this.zzaye = jArr2;
            } else if (zzug == 10) {
                int zzaq = zzyx.zzaq(zzyx.zzuy());
                int position = zzyx.getPosition();
                int i = 0;
                while (zzyx.zzyr() > 0) {
                    zzyx.zzuz();
                    i++;
                }
                zzyx.zzby(position);
                long[] jArr3 = this.zzaye;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzaye, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = zzyx.zzuz();
                    length2++;
                }
                this.zzaye = jArr4;
                zzyx.zzar(zzaq);
            } else if (zzug == 16) {
                int zzb2 = zzzj.zzb(zzyx, 16);
                long[] jArr5 = this.zzayf;
                int length3 = jArr5 == null ? 0 : jArr5.length;
                long[] jArr6 = new long[(zzb2 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzayf, 0, jArr6, 0, length3);
                }
                while (length3 < jArr6.length - 1) {
                    jArr6[length3] = zzyx.zzuz();
                    zzyx.zzug();
                    length3++;
                }
                jArr6[length3] = zzyx.zzuz();
                this.zzayf = jArr6;
            } else if (zzug == 18) {
                int zzaq2 = zzyx.zzaq(zzyx.zzuy());
                int position2 = zzyx.getPosition();
                int i2 = 0;
                while (zzyx.zzyr() > 0) {
                    zzyx.zzuz();
                    i2++;
                }
                zzyx.zzby(position2);
                long[] jArr7 = this.zzayf;
                int length4 = jArr7 == null ? 0 : jArr7.length;
                long[] jArr8 = new long[(i2 + length4)];
                if (length4 != 0) {
                    System.arraycopy(this.zzayf, 0, jArr8, 0, length4);
                }
                while (length4 < jArr8.length) {
                    jArr8[length4] = zzyx.zzuz();
                    length4++;
                }
                this.zzayf = jArr8;
                zzyx.zzar(zzaq2);
            } else if (zzug == 26) {
                int zzb3 = zzzj.zzb(zzyx, 26);
                zzge[] zzgeArr = this.zzayg;
                int length5 = zzgeArr == null ? 0 : zzgeArr.length;
                zzge[] zzgeArr2 = new zzge[(zzb3 + length5)];
                if (length5 != 0) {
                    System.arraycopy(this.zzayg, 0, zzgeArr2, 0, length5);
                }
                while (length5 < zzgeArr2.length - 1) {
                    zzgeArr2[length5] = new zzge();
                    zzyx.zza((zzzg) zzgeArr2[length5]);
                    zzyx.zzug();
                    length5++;
                }
                zzgeArr2[length5] = new zzge();
                zzyx.zza((zzzg) zzgeArr2[length5]);
                this.zzayg = zzgeArr2;
            } else if (zzug == 34) {
                int zzb4 = zzzj.zzb(zzyx, 34);
                zzgk[] zzgkArr = this.zzayh;
                int length6 = zzgkArr == null ? 0 : zzgkArr.length;
                zzgk[] zzgkArr2 = new zzgk[(zzb4 + length6)];
                if (length6 != 0) {
                    System.arraycopy(this.zzayh, 0, zzgkArr2, 0, length6);
                }
                while (length6 < zzgkArr2.length - 1) {
                    zzgkArr2[length6] = new zzgk();
                    zzyx.zza((zzzg) zzgkArr2[length6]);
                    zzyx.zzug();
                    length6++;
                }
                zzgkArr2[length6] = new zzgk();
                zzyx.zza((zzzg) zzgkArr2[length6]);
                this.zzayh = zzgkArr2;
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
