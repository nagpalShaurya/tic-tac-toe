package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgg extends zzza<zzgg> {
    private static volatile zzgg[] zzaww;
    public String name;
    public String zzamp;
    private Float zzaug;
    public Double zzauh;
    public Long zzawx;

    public static zzgg[] zzmr() {
        if (zzaww == null) {
            synchronized (zzze.zzcfl) {
                if (zzaww == null) {
                    zzaww = new zzgg[0];
                }
            }
        }
        return zzaww;
    }

    public zzgg() {
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
        if (!(obj instanceof zzgg)) {
            return false;
        }
        zzgg zzgg = (zzgg) obj;
        String str = this.name;
        if (str == null) {
            if (zzgg.name != null) {
                return false;
            }
        } else if (!str.equals(zzgg.name)) {
            return false;
        }
        String str2 = this.zzamp;
        if (str2 == null) {
            if (zzgg.zzamp != null) {
                return false;
            }
        } else if (!str2.equals(zzgg.zzamp)) {
            return false;
        }
        Long l = this.zzawx;
        if (l == null) {
            if (zzgg.zzawx != null) {
                return false;
            }
        } else if (!l.equals(zzgg.zzawx)) {
            return false;
        }
        Float f = this.zzaug;
        if (f == null) {
            if (zzgg.zzaug != null) {
                return false;
            }
        } else if (!f.equals(zzgg.zzaug)) {
            return false;
        }
        Double d = this.zzauh;
        if (d == null) {
            if (zzgg.zzauh != null) {
                return false;
            }
        } else if (!d.equals(zzgg.zzauh)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgg.zzcfc);
        }
        if (zzgg.zzcfc == null || zzgg.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzamp;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.zzawx;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Float f = this.zzaug;
        int hashCode5 = (hashCode4 + (f == null ? 0 : f.hashCode())) * 31;
        Double d = this.zzauh;
        int hashCode6 = (hashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode6 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        String str = this.name;
        if (str != null) {
            zzyy.zzb(1, str);
        }
        String str2 = this.zzamp;
        if (str2 != null) {
            zzyy.zzb(2, str2);
        }
        Long l = this.zzawx;
        if (l != null) {
            zzyy.zzi(3, l.longValue());
        }
        Float f = this.zzaug;
        if (f != null) {
            zzyy.zza(4, f.floatValue());
        }
        Double d = this.zzauh;
        if (d != null) {
            zzyy.zza(5, d.doubleValue());
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        String str = this.name;
        if (str != null) {
            zzf += zzyy.zzc(1, str);
        }
        String str2 = this.zzamp;
        if (str2 != null) {
            zzf += zzyy.zzc(2, str2);
        }
        Long l = this.zzawx;
        if (l != null) {
            zzf += zzyy.zzd(3, l.longValue());
        }
        Float f = this.zzaug;
        if (f != null) {
            f.floatValue();
            zzf += zzyy.zzbb(4) + 4;
        }
        Double d = this.zzauh;
        if (d == null) {
            return zzf;
        }
        d.doubleValue();
        return zzf + zzyy.zzbb(5) + 8;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 10) {
                this.name = zzyx.readString();
            } else if (zzug == 18) {
                this.zzamp = zzyx.readString();
            } else if (zzug == 24) {
                this.zzawx = Long.valueOf(zzyx.zzuz());
            } else if (zzug == 37) {
                this.zzaug = Float.valueOf(Float.intBitsToFloat(zzyx.zzva()));
            } else if (zzug == 41) {
                this.zzauh = Double.valueOf(Double.longBitsToDouble(zzyx.zzvb()));
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
