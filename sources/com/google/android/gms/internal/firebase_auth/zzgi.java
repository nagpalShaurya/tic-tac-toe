package com.google.android.gms.internal.firebase_auth;

public class zzgi {
    private static final zzff zzsj = zzff.zzgp();
    private zzeh zzyo;
    private volatile zzhb zzyp;
    private volatile zzeh zzyq;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgi)) {
            return false;
        }
        zzgi zzgi = (zzgi) obj;
        zzhb zzhb = this.zzyp;
        zzhb zzhb2 = zzgi.zzyp;
        if (zzhb == null && zzhb2 == null) {
            return zzer().equals(zzgi.zzer());
        }
        if (zzhb != null && zzhb2 != null) {
            return zzhb.equals(zzhb2);
        }
        if (zzhb != null) {
            return zzhb.equals(zzgi.zzi(zzhb.zzhh()));
        }
        return zzi(zzhb2.zzhh()).equals(zzhb2);
    }

    public int hashCode() {
        return 1;
    }

    private final zzhb zzi(zzhb zzhb) {
        if (this.zzyp == null) {
            synchronized (this) {
                if (this.zzyp == null) {
                    try {
                        this.zzyp = zzhb;
                        this.zzyq = zzeh.zzso;
                    } catch (zzgb e) {
                        this.zzyp = zzhb;
                        this.zzyq = zzeh.zzso;
                    }
                }
            }
        }
        return this.zzyp;
    }

    public final zzhb zzj(zzhb zzhb) {
        zzhb zzhb2 = this.zzyp;
        this.zzyo = null;
        this.zzyq = null;
        this.zzyp = zzhb;
        return zzhb2;
    }

    public final int zzgv() {
        if (this.zzyq != null) {
            return this.zzyq.size();
        }
        if (this.zzyp != null) {
            return this.zzyp.zzgv();
        }
        return 0;
    }

    public final zzeh zzer() {
        if (this.zzyq != null) {
            return this.zzyq;
        }
        synchronized (this) {
            if (this.zzyq != null) {
                zzeh zzeh = this.zzyq;
                return zzeh;
            }
            if (this.zzyp == null) {
                this.zzyq = zzeh.zzso;
            } else {
                this.zzyq = this.zzyp.zzer();
            }
            zzeh zzeh2 = this.zzyq;
            return zzeh2;
        }
    }
}
