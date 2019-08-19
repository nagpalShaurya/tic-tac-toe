package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfy extends zzza<zzfy> {
    private static volatile zzfy[] zzavt;
    public Boolean zzavb;
    public Boolean zzavc;
    public Integer zzave;
    public String zzavu;
    public zzfw zzavv;

    public static zzfy[] zzml() {
        if (zzavt == null) {
            synchronized (zzze.zzcfl) {
                if (zzavt == null) {
                    zzavt = new zzfy[0];
                }
            }
        }
        return zzavt;
    }

    public zzfy() {
        this.zzave = null;
        this.zzavu = null;
        this.zzavv = null;
        this.zzavb = null;
        this.zzavc = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfy = (zzfy) obj;
        Integer num = this.zzave;
        if (num == null) {
            if (zzfy.zzave != null) {
                return false;
            }
        } else if (!num.equals(zzfy.zzave)) {
            return false;
        }
        String str = this.zzavu;
        if (str == null) {
            if (zzfy.zzavu != null) {
                return false;
            }
        } else if (!str.equals(zzfy.zzavu)) {
            return false;
        }
        zzfw zzfw = this.zzavv;
        if (zzfw == null) {
            if (zzfy.zzavv != null) {
                return false;
            }
        } else if (!zzfw.equals(zzfy.zzavv)) {
            return false;
        }
        Boolean bool = this.zzavb;
        if (bool == null) {
            if (zzfy.zzavb != null) {
                return false;
            }
        } else if (!bool.equals(zzfy.zzavb)) {
            return false;
        }
        Boolean bool2 = this.zzavc;
        if (bool2 == null) {
            if (zzfy.zzavc != null) {
                return false;
            }
        } else if (!bool2.equals(zzfy.zzavc)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzfy.zzcfc);
        }
        if (zzfy.zzcfc == null || zzfy.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzave;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzavu;
        int hashCode3 = hashCode2 + (str == null ? 0 : str.hashCode());
        zzfw zzfw = this.zzavv;
        int hashCode4 = ((hashCode3 * 31) + (zzfw == null ? 0 : zzfw.hashCode())) * 31;
        Boolean bool = this.zzavb;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzavc;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode6 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzave;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        String str = this.zzavu;
        if (str != null) {
            zzyy.zzb(2, str);
        }
        zzfw zzfw = this.zzavv;
        if (zzfw != null) {
            zzyy.zza(3, (zzzg) zzfw);
        }
        Boolean bool = this.zzavb;
        if (bool != null) {
            zzyy.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzavc;
        if (bool2 != null) {
            zzyy.zzb(5, bool2.booleanValue());
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
        String str = this.zzavu;
        if (str != null) {
            zzf += zzyy.zzc(2, str);
        }
        zzfw zzfw = this.zzavv;
        if (zzfw != null) {
            zzf += zzyy.zzb(3, (zzzg) zzfw);
        }
        Boolean bool = this.zzavb;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(4) + 1;
        }
        Boolean bool2 = this.zzavc;
        if (bool2 == null) {
            return zzf;
        }
        bool2.booleanValue();
        return zzf + zzyy.zzbb(5) + 1;
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
                this.zzavu = zzyx.readString();
            } else if (zzug == 26) {
                if (this.zzavv == null) {
                    this.zzavv = new zzfw();
                }
                zzyx.zza((zzzg) this.zzavv);
            } else if (zzug == 32) {
                this.zzavb = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 40) {
                this.zzavc = Boolean.valueOf(zzyx.zzum());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
