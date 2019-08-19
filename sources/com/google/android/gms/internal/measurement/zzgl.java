package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgl extends zzza<zzgl> {
    private static volatile zzgl[] zzayk;
    public String name;
    public String zzamp;
    private Float zzaug;
    public Double zzauh;
    public Long zzawx;
    public Long zzayl;

    public static zzgl[] zzmu() {
        if (zzayk == null) {
            synchronized (zzze.zzcfl) {
                if (zzayk == null) {
                    zzayk = new zzgl[0];
                }
            }
        }
        return zzayk;
    }

    public zzgl() {
        this.zzayl = null;
        this.name = null;
        this.zzamp = null;
        this.zzawx = null;
        this.zzaug = null;
        this.zzauh = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgl)) {
            return false;
        }
        zzgl zzgl = (zzgl) obj;
        Long l = this.zzayl;
        if (l == null) {
            if (zzgl.zzayl != null) {
                return false;
            }
        } else if (!l.equals(zzgl.zzayl)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzgl.name != null) {
                return false;
            }
        } else if (!str.equals(zzgl.name)) {
            return false;
        }
        String str2 = this.zzamp;
        if (str2 == null) {
            if (zzgl.zzamp != null) {
                return false;
            }
        } else if (!str2.equals(zzgl.zzamp)) {
            return false;
        }
        Long l2 = this.zzawx;
        if (l2 == null) {
            if (zzgl.zzawx != null) {
                return false;
            }
        } else if (!l2.equals(zzgl.zzawx)) {
            return false;
        }
        Float f = this.zzaug;
        if (f == null) {
            if (zzgl.zzaug != null) {
                return false;
            }
        } else if (!f.equals(zzgl.zzaug)) {
            return false;
        }
        Double d = this.zzauh;
        if (d == null) {
            if (zzgl.zzauh != null) {
                return false;
            }
        } else if (!d.equals(zzgl.zzauh)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgl.zzcfc);
        }
        if (zzgl.zzcfc == null || zzgl.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Long l = this.zzayl;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzamp;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.zzawx;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Float f = this.zzaug;
        int hashCode6 = (hashCode5 + (f == null ? 0 : f.hashCode())) * 31;
        Double d = this.zzauh;
        int hashCode7 = (hashCode6 + (d == null ? 0 : d.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode7 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Long l = this.zzayl;
        if (l != null) {
            zzyy.zzi(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzyy.zzb(2, str);
        }
        String str2 = this.zzamp;
        if (str2 != null) {
            zzyy.zzb(3, str2);
        }
        Long l2 = this.zzawx;
        if (l2 != null) {
            zzyy.zzi(4, l2.longValue());
        }
        Float f = this.zzaug;
        if (f != null) {
            zzyy.zza(5, f.floatValue());
        }
        Double d = this.zzauh;
        if (d != null) {
            zzyy.zza(6, d.doubleValue());
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Long l = this.zzayl;
        if (l != null) {
            zzf += zzyy.zzd(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzf += zzyy.zzc(2, str);
        }
        String str2 = this.zzamp;
        if (str2 != null) {
            zzf += zzyy.zzc(3, str2);
        }
        Long l2 = this.zzawx;
        if (l2 != null) {
            zzf += zzyy.zzd(4, l2.longValue());
        }
        Float f = this.zzaug;
        if (f != null) {
            f.floatValue();
            zzf += zzyy.zzbb(5) + 4;
        }
        Double d = this.zzauh;
        if (d == null) {
            return zzf;
        }
        d.doubleValue();
        return zzf + zzyy.zzbb(6) + 8;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                this.zzayl = Long.valueOf(zzyx.zzuz());
            } else if (zzug == 18) {
                this.name = zzyx.readString();
            } else if (zzug == 26) {
                this.zzamp = zzyx.readString();
            } else if (zzug == 32) {
                this.zzawx = Long.valueOf(zzyx.zzuz());
            } else if (zzug == 45) {
                this.zzaug = Float.valueOf(Float.intBitsToFloat(zzyx.zzva()));
            } else if (zzug == 49) {
                this.zzauh = Double.valueOf(Double.longBitsToDouble(zzyx.zzvb()));
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
