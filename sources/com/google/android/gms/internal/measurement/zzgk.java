package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgk extends zzza<zzgk> {
    private static volatile zzgk[] zzayi;
    public Integer zzawq;
    public long[] zzayj;

    public static zzgk[] zzmt() {
        if (zzayi == null) {
            synchronized (zzze.zzcfl) {
                if (zzayi == null) {
                    zzayi = new zzgk[0];
                }
            }
        }
        return zzayi;
    }

    public zzgk() {
        this.zzawq = null;
        this.zzayj = zzzj.zzcfr;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgk)) {
            return false;
        }
        zzgk zzgk = (zzgk) obj;
        Integer num = this.zzawq;
        if (num == null) {
            if (zzgk.zzawq != null) {
                return false;
            }
        } else if (!num.equals(zzgk.zzawq)) {
            return false;
        }
        if (!zzze.equals(this.zzayj, zzgk.zzayj)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgk.zzcfc);
        }
        if (zzgk.zzcfc == null || zzgk.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzawq;
        int i = 0;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzze.hashCode(this.zzayj)) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode2 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzawq;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        long[] jArr = this.zzayj;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.zzayj;
                if (i >= jArr2.length) {
                    break;
                }
                zzyy.zzi(2, jArr2[i]);
                i++;
            }
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzawq;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        long[] jArr = this.zzayj;
        if (jArr == null || jArr.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long[] jArr2 = this.zzayj;
            if (i >= jArr2.length) {
                return zzf + i2 + (jArr2.length * 1);
            }
            i2 += zzyy.zzbi(jArr2[i]);
            i++;
        }
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                this.zzawq = Integer.valueOf(zzyx.zzuy());
            } else if (zzug == 16) {
                int zzb = zzzj.zzb(zzyx, 16);
                long[] jArr = this.zzayj;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzayj, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = zzyx.zzuz();
                    zzyx.zzug();
                    length++;
                }
                jArr2[length] = zzyx.zzuz();
                this.zzayj = jArr2;
            } else if (zzug == 18) {
                int zzaq = zzyx.zzaq(zzyx.zzuy());
                int position = zzyx.getPosition();
                int i = 0;
                while (zzyx.zzyr() > 0) {
                    zzyx.zzuz();
                    i++;
                }
                zzyx.zzby(position);
                long[] jArr3 = this.zzayj;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzayj, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = zzyx.zzuz();
                    length2++;
                }
                this.zzayj = jArr4;
                zzyx.zzar(zzaq);
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
