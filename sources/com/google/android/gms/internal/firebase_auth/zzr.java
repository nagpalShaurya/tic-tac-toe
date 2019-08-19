package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs.zzb;
import java.util.List;

public final class zzr extends zzfs<zzr, zza> implements zzhd {
    /* access modifiers changed from: private */
    public static final zzr zzfl = new zzr();
    private static volatile zzhl<zzr> zzm;
    private String zzao;
    private String zzat;
    private String zzby;
    private String zzcd;
    private zzga<String> zzcf = zzfs.zzhe();
    private boolean zzcg;
    private String zzcn;
    private long zzcs;
    private long zzct;
    private zzga<zzm> zzcv;
    private boolean zzcy;
    private String zzdp;
    private String zzdq;
    private String zzdr;
    private String zzei;
    private zzeh zzfe;
    private zzeh zzff;
    private int zzfg;
    private long zzfh;
    private long zzfi;
    private boolean zzfj;
    private String zzfk;
    private int zzi;

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzr, zza> implements zzhd {
        private zza() {
            super(zzr.zzfl);
        }

        /* synthetic */ zza(zzs zzs) {
            this();
        }
    }

    private zzr() {
        String str = "";
        this.zzao = str;
        this.zzat = str;
        this.zzcd = str;
        this.zzdp = str;
        this.zzcn = str;
        this.zzdq = str;
        this.zzdr = str;
        this.zzfe = zzeh.zzso;
        this.zzff = zzeh.zzso;
        this.zzcv = zzhe();
        this.zzei = str;
        this.zzfk = str;
        this.zzby = str;
    }

    public final String getLocalId() {
        return this.zzao;
    }

    public final String getEmail() {
        return this.zzat;
    }

    public final String getDisplayName() {
        return this.zzcd;
    }

    public final String zzal() {
        return this.zzcn;
    }

    public final boolean zzan() {
        return this.zzcg;
    }

    public final List<zzm> zzak() {
        return this.zzcv;
    }

    public final long zzbk() {
        return this.zzcs;
    }

    public final long zzbl() {
        return this.zzct;
    }

    public final String zzbm() {
        return this.zzfk;
    }

    public final String getPhoneNumber() {
        return this.zzby;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzs.zzn[i - 1]) {
            case 1:
                return new zzr();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzhb) zzfl, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u001a\u0005\b\u0003\u0006\b\u0004\u0007\b\u0005\b\b\u0006\t\n\u0007\n\n\b\u000b\u0004\t\f\u0007\n\r\u0002\u000b\u000e\u001b\u000f\u0002\f\u0010\u0007\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\b\u0013", new Object[]{"zzi", "zzao", "zzat", "zzcd", "zzcf", "zzdp", "zzcn", "zzdq", "zzdr", "zzfe", "zzff", "zzfg", "zzcg", "zzfh", "zzcv", zzm.class, "zzfi", "zzcy", "zzcs", "zzct", "zzei", "zzfj", "zzfk", "zzby"});
            case 4:
                return zzfl;
            case 5:
                zzhl<zzr> zzhl = zzm;
                if (zzhl == null) {
                    synchronized (zzr.class) {
                        zzhl = zzm;
                        if (zzhl == null) {
                            zzhl = new zzb<>(zzfl);
                            zzm = zzhl;
                        }
                    }
                }
                return zzhl;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzfs.zza(zzr.class, zzfl);
    }
}
