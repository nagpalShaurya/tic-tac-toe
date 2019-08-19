package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzga extends zzza<zzga> {
    private static volatile zzga[] zzawa;
    public String name;
    public Boolean zzawb;
    public Boolean zzawc;
    public Integer zzawd;

    public static zzga[] zzmm() {
        if (zzawa == null) {
            synchronized (zzze.zzcfl) {
                if (zzawa == null) {
                    zzawa = new zzga[0];
                }
            }
        }
        return zzawa;
    }

    public zzga() {
        this.name = null;
        this.zzawb = null;
        this.zzawc = null;
        this.zzawd = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzga)) {
            return false;
        }
        zzga zzga = (zzga) obj;
        String str = this.name;
        if (str == null) {
            if (zzga.name != null) {
                return false;
            }
        } else if (!str.equals(zzga.name)) {
            return false;
        }
        Boolean bool = this.zzawb;
        if (bool == null) {
            if (zzga.zzawb != null) {
                return false;
            }
        } else if (!bool.equals(zzga.zzawb)) {
            return false;
        }
        Boolean bool2 = this.zzawc;
        if (bool2 == null) {
            if (zzga.zzawc != null) {
                return false;
            }
        } else if (!bool2.equals(zzga.zzawc)) {
            return false;
        }
        Integer num = this.zzawd;
        if (num == null) {
            if (zzga.zzawd != null) {
                return false;
            }
        } else if (!num.equals(zzga.zzawd)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzga.zzcfc);
        }
        if (zzga.zzcfc == null || zzga.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzawb;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzawc;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.zzawd;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        String str = this.name;
        if (str != null) {
            zzyy.zzb(1, str);
        }
        Boolean bool = this.zzawb;
        if (bool != null) {
            zzyy.zzb(2, bool.booleanValue());
        }
        Boolean bool2 = this.zzawc;
        if (bool2 != null) {
            zzyy.zzb(3, bool2.booleanValue());
        }
        Integer num = this.zzawd;
        if (num != null) {
            zzyy.zzd(4, num.intValue());
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
        Boolean bool = this.zzawb;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(2) + 1;
        }
        Boolean bool2 = this.zzawc;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzyy.zzbb(3) + 1;
        }
        Integer num = this.zzawd;
        if (num != null) {
            return zzf + zzyy.zzh(4, num.intValue());
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
                this.name = zzyx.readString();
            } else if (zzug == 16) {
                this.zzawb = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 24) {
                this.zzawc = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 32) {
                this.zzawd = Integer.valueOf(zzyx.zzuy());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
