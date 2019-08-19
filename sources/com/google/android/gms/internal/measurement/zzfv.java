package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfv extends zzza<zzfv> {
    private static volatile zzfv[] zzavd;
    public Boolean zzavb;
    public Boolean zzavc;
    public Integer zzave;
    public String zzavf;
    public zzfw[] zzavg;
    private Boolean zzavh;
    public zzfx zzavi;

    public static zzfv[] zzmj() {
        if (zzavd == null) {
            synchronized (zzze.zzcfl) {
                if (zzavd == null) {
                    zzavd = new zzfv[0];
                }
            }
        }
        return zzavd;
    }

    public zzfv() {
        this.zzave = null;
        this.zzavf = null;
        this.zzavg = zzfw.zzmk();
        this.zzavh = null;
        this.zzavi = null;
        this.zzavb = null;
        this.zzavc = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfv = (zzfv) obj;
        Integer num = this.zzave;
        if (num == null) {
            if (zzfv.zzave != null) {
                return false;
            }
        } else if (!num.equals(zzfv.zzave)) {
            return false;
        }
        String str = this.zzavf;
        if (str == null) {
            if (zzfv.zzavf != null) {
                return false;
            }
        } else if (!str.equals(zzfv.zzavf)) {
            return false;
        }
        if (!zzze.equals((Object[]) this.zzavg, (Object[]) zzfv.zzavg)) {
            return false;
        }
        Boolean bool = this.zzavh;
        if (bool == null) {
            if (zzfv.zzavh != null) {
                return false;
            }
        } else if (!bool.equals(zzfv.zzavh)) {
            return false;
        }
        zzfx zzfx = this.zzavi;
        if (zzfx == null) {
            if (zzfv.zzavi != null) {
                return false;
            }
        } else if (!zzfx.equals(zzfv.zzavi)) {
            return false;
        }
        Boolean bool2 = this.zzavb;
        if (bool2 == null) {
            if (zzfv.zzavb != null) {
                return false;
            }
        } else if (!bool2.equals(zzfv.zzavb)) {
            return false;
        }
        Boolean bool3 = this.zzavc;
        if (bool3 == null) {
            if (zzfv.zzavc != null) {
                return false;
            }
        } else if (!bool3.equals(zzfv.zzavc)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzfv.zzcfc);
        }
        if (zzfv.zzcfc == null || zzfv.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzave;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzavf;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + zzze.hashCode((Object[]) this.zzavg)) * 31;
        Boolean bool = this.zzavh;
        int hashCode4 = hashCode3 + (bool == null ? 0 : bool.hashCode());
        zzfx zzfx = this.zzavi;
        int hashCode5 = ((hashCode4 * 31) + (zzfx == null ? 0 : zzfx.hashCode())) * 31;
        Boolean bool2 = this.zzavb;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.zzavc;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode7 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzave;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        String str = this.zzavf;
        if (str != null) {
            zzyy.zzb(2, str);
        }
        zzfw[] zzfwArr = this.zzavg;
        if (zzfwArr != null && zzfwArr.length > 0) {
            int i = 0;
            while (true) {
                zzfw[] zzfwArr2 = this.zzavg;
                if (i >= zzfwArr2.length) {
                    break;
                }
                zzfw zzfw = zzfwArr2[i];
                if (zzfw != null) {
                    zzyy.zza(3, (zzzg) zzfw);
                }
                i++;
            }
        }
        Boolean bool = this.zzavh;
        if (bool != null) {
            zzyy.zzb(4, bool.booleanValue());
        }
        zzfx zzfx = this.zzavi;
        if (zzfx != null) {
            zzyy.zza(5, (zzzg) zzfx);
        }
        Boolean bool2 = this.zzavb;
        if (bool2 != null) {
            zzyy.zzb(6, bool2.booleanValue());
        }
        Boolean bool3 = this.zzavc;
        if (bool3 != null) {
            zzyy.zzb(7, bool3.booleanValue());
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzave;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        String str = this.zzavf;
        if (str != null) {
            zzf += zzyy.zzc(2, str);
        }
        zzfw[] zzfwArr = this.zzavg;
        if (zzfwArr != null && zzfwArr.length > 0) {
            int i = 0;
            while (true) {
                zzfw[] zzfwArr2 = this.zzavg;
                if (i >= zzfwArr2.length) {
                    break;
                }
                zzfw zzfw = zzfwArr2[i];
                if (zzfw != null) {
                    zzf += zzyy.zzb(3, (zzzg) zzfw);
                }
                i++;
            }
        }
        Boolean bool = this.zzavh;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(4) + 1;
        }
        zzfx zzfx = this.zzavi;
        if (zzfx != null) {
            zzf += zzyy.zzb(5, (zzzg) zzfx);
        }
        Boolean bool2 = this.zzavb;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzyy.zzbb(6) + 1;
        }
        Boolean bool3 = this.zzavc;
        if (bool3 == null) {
            return zzf;
        }
        bool3.booleanValue();
        return zzf + zzyy.zzbb(7) + 1;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                this.zzave = Integer.valueOf(zzyx.zzuy());
            } else if (zzug == 18) {
                this.zzavf = zzyx.readString();
            } else if (zzug == 26) {
                int zzb = zzzj.zzb(zzyx, 26);
                zzfw[] zzfwArr = this.zzavg;
                int length = zzfwArr == null ? 0 : zzfwArr.length;
                zzfw[] zzfwArr2 = new zzfw[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzavg, 0, zzfwArr2, 0, length);
                }
                while (length < zzfwArr2.length - 1) {
                    zzfwArr2[length] = new zzfw();
                    zzyx.zza((zzzg) zzfwArr2[length]);
                    zzyx.zzug();
                    length++;
                }
                zzfwArr2[length] = new zzfw();
                zzyx.zza((zzzg) zzfwArr2[length]);
                this.zzavg = zzfwArr2;
            } else if (zzug == 32) {
                this.zzavh = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 42) {
                if (this.zzavi == null) {
                    this.zzavi = new zzfx();
                }
                zzyx.zza((zzzg) this.zzavi);
            } else if (zzug == 48) {
                this.zzavb = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 56) {
                this.zzavc = Boolean.valueOf(zzyx.zzum());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
