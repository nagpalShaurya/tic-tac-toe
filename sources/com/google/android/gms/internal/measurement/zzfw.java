package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfw extends zzza<zzfw> {
    private static volatile zzfw[] zzavj;
    public zzfz zzavk;
    public zzfx zzavl;
    public Boolean zzavm;
    public String zzavn;

    public static zzfw[] zzmk() {
        if (zzavj == null) {
            synchronized (zzze.zzcfl) {
                if (zzavj == null) {
                    zzavj = new zzfw[0];
                }
            }
        }
        return zzavj;
    }

    public zzfw() {
        this.zzavk = null;
        this.zzavl = null;
        this.zzavm = null;
        this.zzavn = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfw = (zzfw) obj;
        zzfz zzfz = this.zzavk;
        if (zzfz == null) {
            if (zzfw.zzavk != null) {
                return false;
            }
        } else if (!zzfz.equals(zzfw.zzavk)) {
            return false;
        }
        zzfx zzfx = this.zzavl;
        if (zzfx == null) {
            if (zzfw.zzavl != null) {
                return false;
            }
        } else if (!zzfx.equals(zzfw.zzavl)) {
            return false;
        }
        Boolean bool = this.zzavm;
        if (bool == null) {
            if (zzfw.zzavm != null) {
                return false;
            }
        } else if (!bool.equals(zzfw.zzavm)) {
            return false;
        }
        String str = this.zzavn;
        if (str == null) {
            if (zzfw.zzavn != null) {
                return false;
            }
        } else if (!str.equals(zzfw.zzavn)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzfw.zzcfc);
        }
        if (zzfw.zzcfc == null || zzfw.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = getClass().getName().hashCode() + 527;
        zzfz zzfz = this.zzavk;
        int i = 0;
        int hashCode2 = (hashCode * 31) + (zzfz == null ? 0 : zzfz.hashCode());
        zzfx zzfx = this.zzavl;
        int hashCode3 = ((hashCode2 * 31) + (zzfx == null ? 0 : zzfx.hashCode())) * 31;
        Boolean bool = this.zzavm;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzavn;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        zzfz zzfz = this.zzavk;
        if (zzfz != null) {
            zzyy.zza(1, (zzzg) zzfz);
        }
        zzfx zzfx = this.zzavl;
        if (zzfx != null) {
            zzyy.zza(2, (zzzg) zzfx);
        }
        Boolean bool = this.zzavm;
        if (bool != null) {
            zzyy.zzb(3, bool.booleanValue());
        }
        String str = this.zzavn;
        if (str != null) {
            zzyy.zzb(4, str);
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        zzfz zzfz = this.zzavk;
        if (zzfz != null) {
            zzf += zzyy.zzb(1, (zzzg) zzfz);
        }
        zzfx zzfx = this.zzavl;
        if (zzfx != null) {
            zzf += zzyy.zzb(2, (zzzg) zzfx);
        }
        Boolean bool = this.zzavm;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(3) + 1;
        }
        String str = this.zzavn;
        if (str != null) {
            return zzf + zzyy.zzc(4, str);
        }
        return zzf;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 10) {
                if (this.zzavk == null) {
                    this.zzavk = new zzfz();
                }
                zzyx.zza((zzzg) this.zzavk);
            } else if (zzug == 18) {
                if (this.zzavl == null) {
                    this.zzavl = new zzfx();
                }
                zzyx.zza((zzzg) this.zzavl);
            } else if (zzug == 24) {
                this.zzavm = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 34) {
                this.zzavn = zzyx.readString();
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
