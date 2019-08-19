package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs.zzb;

public final class zzh extends zzfs<zzh, zza> implements zzhd {
    /* access modifiers changed from: private */
    public static final zzh zzl = new zzh();
    private static volatile zzhl<zzh> zzm;
    private int zzi;
    private String zzj;
    private String zzk;

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzh, zza> implements zzhd {
        private zza() {
            super(zzh.zzl);
        }

        /* synthetic */ zza(zzi zzi) {
            this();
        }
    }

    private zzh() {
        String str = "";
        this.zzj = str;
        this.zzk = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzi.zzn[i - 1]) {
            case 1:
                return new zzh();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzhb) zzl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                zzhl<zzh> zzhl = zzm;
                if (zzhl == null) {
                    synchronized (zzh.class) {
                        zzhl = zzm;
                        if (zzhl == null) {
                            zzhl = new zzb<>(zzl);
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
        zzfs.zza(zzh.class, zzl);
    }
}
