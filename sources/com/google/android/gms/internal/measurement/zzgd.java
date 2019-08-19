package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgd extends zzza<zzgd> {
    private static volatile zzgd[] zzawl;
    public Integer zzauy;
    public zzgj zzawm;
    public zzgj zzawn;
    public Boolean zzawo;

    public static zzgd[] zzmo() {
        if (zzawl == null) {
            synchronized (zzze.zzcfl) {
                if (zzawl == null) {
                    zzawl = new zzgd[0];
                }
            }
        }
        return zzawl;
    }

    public zzgd() {
        this.zzauy = null;
        this.zzawm = null;
        this.zzawn = null;
        this.zzawo = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgd)) {
            return false;
        }
        zzgd zzgd = (zzgd) obj;
        Integer num = this.zzauy;
        if (num == null) {
            if (zzgd.zzauy != null) {
                return false;
            }
        } else if (!num.equals(zzgd.zzauy)) {
            return false;
        }
        zzgj zzgj = this.zzawm;
        if (zzgj == null) {
            if (zzgd.zzawm != null) {
                return false;
            }
        } else if (!zzgj.equals(zzgd.zzawm)) {
            return false;
        }
        zzgj zzgj2 = this.zzawn;
        if (zzgj2 == null) {
            if (zzgd.zzawn != null) {
                return false;
            }
        } else if (!zzgj2.equals(zzgd.zzawn)) {
            return false;
        }
        Boolean bool = this.zzawo;
        if (bool == null) {
            if (zzgd.zzawo != null) {
                return false;
            }
        } else if (!bool.equals(zzgd.zzawo)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgd.zzcfc);
        }
        if (zzgd.zzcfc == null || zzgd.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzauy;
        int i = 0;
        int hashCode2 = hashCode + (num == null ? 0 : num.hashCode());
        zzgj zzgj = this.zzawm;
        int hashCode3 = (hashCode2 * 31) + (zzgj == null ? 0 : zzgj.hashCode());
        zzgj zzgj2 = this.zzawn;
        int hashCode4 = ((hashCode3 * 31) + (zzgj2 == null ? 0 : zzgj2.hashCode())) * 31;
        Boolean bool = this.zzawo;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzauy;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        zzgj zzgj = this.zzawm;
        if (zzgj != null) {
            zzyy.zza(2, (zzzg) zzgj);
        }
        zzgj zzgj2 = this.zzawn;
        if (zzgj2 != null) {
            zzyy.zza(3, (zzzg) zzgj2);
        }
        Boolean bool = this.zzawo;
        if (bool != null) {
            zzyy.zzb(4, bool.booleanValue());
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzauy;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        zzgj zzgj = this.zzawm;
        if (zzgj != null) {
            zzf += zzyy.zzb(2, (zzzg) zzgj);
        }
        zzgj zzgj2 = this.zzawn;
        if (zzgj2 != null) {
            zzf += zzyy.zzb(3, (zzzg) zzgj2);
        }
        Boolean bool = this.zzawo;
        if (bool == null) {
            return zzf;
        }
        bool.booleanValue();
        return zzf + zzyy.zzbb(4) + 1;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                this.zzauy = Integer.valueOf(zzyx.zzuy());
            } else if (zzug == 18) {
                if (this.zzawm == null) {
                    this.zzawm = new zzgj();
                }
                zzyx.zza((zzzg) this.zzawm);
            } else if (zzug == 26) {
                if (this.zzawn == null) {
                    this.zzawn = new zzgj();
                }
                zzyx.zza((zzzg) this.zzawn);
            } else if (zzug == 32) {
                this.zzawo = Boolean.valueOf(zzyx.zzum());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
