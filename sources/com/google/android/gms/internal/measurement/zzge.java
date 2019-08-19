package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzge extends zzza<zzge> {
    private static volatile zzge[] zzawp;
    public Integer zzawq;
    public Long zzawr;

    public static zzge[] zzmp() {
        if (zzawp == null) {
            synchronized (zzze.zzcfl) {
                if (zzawp == null) {
                    zzawp = new zzge[0];
                }
            }
        }
        return zzawp;
    }

    public zzge() {
        this.zzawq = null;
        this.zzawr = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzge)) {
            return false;
        }
        zzge zzge = (zzge) obj;
        Integer num = this.zzawq;
        if (num == null) {
            if (zzge.zzawq != null) {
                return false;
            }
        } else if (!num.equals(zzge.zzawq)) {
            return false;
        }
        Long l = this.zzawr;
        if (l == null) {
            if (zzge.zzawr != null) {
                return false;
            }
        } else if (!l.equals(zzge.zzawr)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzge.zzcfc);
        }
        if (zzge.zzcfc == null || zzge.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzawq;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.zzawr;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode3 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzawq;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        Long l = this.zzawr;
        if (l != null) {
            zzyy.zzi(2, l.longValue());
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
        Long l = this.zzawr;
        if (l != null) {
            return zzf + zzyy.zzd(2, l.longValue());
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
                this.zzawq = Integer.valueOf(zzyx.zzuy());
            } else if (zzug == 16) {
                this.zzawr = Long.valueOf(zzyx.zzuz());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
