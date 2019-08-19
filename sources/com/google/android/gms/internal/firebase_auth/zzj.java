package com.google.android.gms.internal.firebase_auth;

import java.util.List;

public final class zzj {

    public static final class zza extends zzfs<zza, C0528zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zza zzae = new zza();
        private static volatile zzhl<zza> zzm;
        private String zzaa;
        private zzga<zzh> zzab = zzhe();
        private String zzac;
        private long zzad;
        private int zzi;
        private String zzo;
        private String zzp;
        private String zzq;
        private String zzr;
        private String zzs;
        private String zzt;
        private String zzu;
        private String zzv;
        private String zzw;
        private String zzx;
        private String zzy;
        private String zzz;

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzj$zza$zza reason: collision with other inner class name */
        public static final class C0528zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zza, C0528zza> implements zzhd {
            private C0528zza() {
                super(zza.zzae);
            }

            public final C0528zza zzd(String str) {
                zzhi();
                ((zza) this.zzxc).zza(str);
                return this;
            }

            public final C0528zza zze(String str) {
                zzhi();
                ((zza) this.zzxc).zzb(str);
                return this;
            }

            public final C0528zza zzf(String str) {
                zzhi();
                ((zza) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ C0528zza(zzk zzk) {
                this();
            }
        }

        private zza() {
            String str = "";
            this.zzo = str;
            this.zzp = str;
            this.zzq = str;
            this.zzr = str;
            this.zzs = str;
            this.zzt = str;
            this.zzu = str;
            this.zzv = str;
            this.zzw = str;
            this.zzx = str;
            this.zzy = str;
            this.zzz = str;
            this.zzaa = str;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzo = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzp = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 8192;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C0528zza zzc() {
            return (C0528zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzae.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0528zza(null);
                case 3:
                    return zza((zzhb) zzae, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u001b\u000f\b\r\u0010\u0003\u000e", new Object[]{"zzi", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", zzh.class, "zzac", "zzad"});
                case 4:
                    return zzae;
                case 5:
                    zzhl<zza> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zza.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzae);
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
            zzfs.zza(zza.class, zzae);
        }
    }

    public static final class zzb extends zzfs<zzb, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzb zzan = new zzb();
        private static volatile zzhl<zzb> zzm;
        private String zzaf;
        private String zzag;
        private zzga<String> zzah;
        private boolean zzai;
        private boolean zzaj;
        private boolean zzak;
        private zzga<String> zzal;
        private byte zzam = 2;
        private int zzi;
        private String zzr;
        private String zzz;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzb, zza> implements zzhd {
            private zza() {
                super(zzb.zzan);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzb() {
            String str = "";
            this.zzaf = str;
            this.zzag = str;
            this.zzah = zzfs.zzhe();
            this.zzr = str;
            this.zzz = str;
            this.zzal = zzfs.zzhe();
        }

        public final String zze() {
            return this.zzag;
        }

        public final List<String> zzf() {
            return this.zzah;
        }

        public final int zzg() {
            return this.zzah.size();
        }

        public final boolean zzh() {
            return this.zzai;
        }

        public final String getProviderId() {
            return this.zzr;
        }

        public final boolean zzi() {
            return this.zzaj;
        }

        public final List<String> zzj() {
            return this.zzal;
        }

        public final int zzk() {
            return this.zzal.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzan, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\u001a\u0004\u0007\u0002\u0005\b\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\b\u0006\t\u001a", new Object[]{"zzi", "zzaf", "zzag", "zzah", "zzai", "zzr", "zzaj", "zzak", "zzz", "zzal"});
                case 4:
                    return zzan;
                case 5:
                    zzhl<zzb> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzb.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzan);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zzb> zzl() {
            return (zzhl) zzan.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzb.class, zzan);
        }
    }

    public static final class zzc extends zzfs<zzc, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzc zzar = new zzc();
        private static volatile zzhl<zzc> zzm;
        private String zzao;
        private long zzap;
        private String zzaq;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzc, zza> implements zzhd {
            private zza() {
                super(zzc.zzar);
            }

            public final zza zzh(String str) {
                zzhi();
                ((zzc) this.zzxc).zzg(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzc() {
            String str = "";
            this.zzao = str;
            this.zzaq = str;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 4;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzn() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzar.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzar, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002", new Object[]{"zzi", "zzao", "zzap", "zzaq"});
                case 4:
                    return zzar;
                case 5:
                    zzhl<zzc> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzc.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzar);
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
            zzfs.zza(zzc.class, zzar);
        }
    }

    public static final class zzd extends zzfs<zzd, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzd zzau = new zzd();
        private static volatile zzhl<zzd> zzm;
        private String zzac;
        private long zzad;
        private String zzaq;
        private String zzas;
        private String zzat;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzd, zza> implements zzhd {
            private zza() {
                super(zzd.zzau);
            }

            public final zza zzk(String str) {
                zzhi();
                ((zzd) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzl(String str) {
                zzhi();
                ((zzd) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzm(String str) {
                zzhi();
                ((zzd) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzn(String str) {
                zzhi();
                ((zzd) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzd() {
            String str = "";
            this.zzas = str;
            this.zzat = str;
            this.zzaq = str;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzas = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 4;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 8;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzp() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzau.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzau, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0006\b\u0003\u0007\u0003\u0004", new Object[]{"zzi", "zzas", "zzat", "zzaq", "zzac", "zzad"});
                case 4:
                    return zzau;
                case 5:
                    zzhl<zzd> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzd.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzau);
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
            zzfs.zza(zzd.class, zzau);
        }
    }

    public static final class zze extends zzfs<zze, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zze zzay = new zze();
        private static volatile zzhl<zze> zzm;
        private String zzaf;
        private byte zzam = 2;
        private String zzao;
        private String zzaq;
        private String zzat;
        private String zzav;
        private long zzaw;
        private boolean zzax;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zze, zza> implements zzhd {
            private zza() {
                super(zze.zzay);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zze() {
            String str = "";
            this.zzaf = str;
            this.zzaq = str;
            this.zzat = str;
            this.zzav = str;
            this.zzao = str;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        public final boolean zzt() {
            return this.zzax;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzay, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0002\u0004\u0006\b\u0005\u0007\u0007\u0006", new Object[]{"zzi", "zzaf", "zzaq", "zzat", "zzav", "zzaw", "zzao", "zzax"});
                case 4:
                    return zzay;
                case 5:
                    zzhl<zze> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zze.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzay);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zze> zzl() {
            return (zzhl) zzay.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zze.class, zzay);
        }
    }

    public static final class zzf extends zzfs<zzf, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzf zzbb = new zzf();
        private static volatile zzhl<zzf> zzm;
        private long zzap;
        private String zzaq = "";
        private zzga<String> zzaz = zzfs.zzhe();
        private zzga<String> zzba = zzfs.zzhe();
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzf, zza> implements zzhd {
            private zza() {
                super(zzf.zzbb);
            }

            public final zza zzo(String str) {
                zzhi();
                ((zzf) this.zzxc).zzg(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzf() {
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzv() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzbb.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\b\u0000\u0002\u001a\u0003\u001a\u0004\u0002\u0001", new Object[]{"zzi", "zzaq", "zzaz", "zzba", "zzap"});
                case 4:
                    return zzbb;
                case 5:
                    zzhl<zzf> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzf.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzbb);
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
            zzfs.zza(zzf.class, zzbb);
        }
    }

    public static final class zzg extends zzfs<zzg, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzg zzbd = new zzg();
        private static volatile zzhl<zzg> zzm;
        private String zzaf = "";
        private byte zzam = 2;
        private zzga<zzr> zzbc = zzhe();
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzg, zza> implements zzhd {
            private zza() {
                super(zzg.zzbd);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzg() {
        }

        public final int zzx() {
            return this.zzbc.size();
        }

        public final zzr zza(int i) {
            return (zzr) this.zzbc.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzbd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001b", new Object[]{"zzi", "zzaf", "zzbc", zzr.class});
                case 4:
                    return zzbd;
                case 5:
                    zzhl<zzg> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzg.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzbd);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zzg> zzl() {
            return (zzhl) zzbd.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzg.class, zzbd);
        }
    }

    public static final class zzh extends zzfs<zzh, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzh zzbs = new zzh();
        private static volatile zzhl<zzh> zzm;
        private String zzac;
        private long zzad;
        private String zzaq;
        private String zzat;
        private int zzbe;
        private String zzbf;
        private String zzbg;
        private String zzbh;
        private String zzbi;
        private String zzbj;
        private String zzbk;
        private String zzbl;
        private String zzbm;
        private boolean zzbn;
        private String zzbo;
        private boolean zzbp;
        private String zzbq;
        private boolean zzbr;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzh, zza> implements zzhd {
            private zza() {
                super(zzh.zzbs);
            }

            public final zza zzb(zzjn zzjn) {
                zzhi();
                ((zzh) this.zzxc).zza(zzjn);
                return this;
            }

            public final zza zzv(String str) {
                zzhi();
                ((zzh) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzw(String str) {
                zzhi();
                ((zzh) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzx(String str) {
                zzhi();
                ((zzh) this.zzxc).zzp(str);
                return this;
            }

            public final zza zzy(String str) {
                zzhi();
                ((zzh) this.zzxc).zzq(str);
                return this;
            }

            public final zza zzz(String str) {
                zzhi();
                ((zzh) this.zzxc).zzr(str);
                return this;
            }

            public final zza zzaa(String str) {
                zzhi();
                ((zzh) this.zzxc).zzs(str);
                return this;
            }

            public final zza zzc(boolean z) {
                zzhi();
                ((zzh) this.zzxc).zza(z);
                return this;
            }

            public final zza zzab(String str) {
                zzhi();
                ((zzh) this.zzxc).zzt(str);
                return this;
            }

            public final zza zzd(boolean z) {
                zzhi();
                ((zzh) this.zzxc).zzb(z);
                return this;
            }

            public final zza zzac(String str) {
                zzhi();
                ((zzh) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzad(String str) {
                zzhi();
                ((zzh) this.zzxc).zzu(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzh() {
            String str = "";
            this.zzat = str;
            this.zzbf = str;
            this.zzbg = str;
            this.zzbh = str;
            this.zzbi = str;
            this.zzaq = str;
            this.zzbj = str;
            this.zzbk = str;
            this.zzbl = str;
            this.zzbm = str;
            this.zzbo = str;
            this.zzac = str;
            this.zzbq = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzjn zzjn) {
            if (zzjn != null) {
                this.zzi |= 1;
                this.zzbe = zzjn.zzbi();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 64;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            if (str != null) {
                this.zzi |= 128;
                this.zzbj = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzq(String str) {
            if (str != null) {
                this.zzi |= 256;
                this.zzbk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzr(String str) {
            if (str != null) {
                this.zzi |= 512;
                this.zzbl = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzs(String str) {
            if (str != null) {
                this.zzi |= 1024;
                this.zzbm = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzi |= 2048;
            this.zzbn = z;
        }

        /* access modifiers changed from: private */
        public final void zzt(String str) {
            if (str != null) {
                this.zzi |= 4096;
                this.zzbo = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzi |= 8192;
            this.zzbp = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 16384;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzu(String str) {
            if (str != null) {
                this.zzi |= 65536;
                this.zzbq = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzz() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzbs.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzbs, "\u0001\u0012\u0000\u0001\u0001\u0013\u0012\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\u0007\u000b\r\b\f\u000e\u0007\r\u000f\b\u000e\u0010\u0003\u000f\u0012\b\u0010\u0013\u0007\u0011", new Object[]{"zzi", "zzbe", zzjn.zzbj(), "zzat", "zzbf", "zzbg", "zzbh", "zzbi", "zzaq", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo", "zzbp", "zzac", "zzad", "zzbq", "zzbr"});
                case 4:
                    return zzbs;
                case 5:
                    zzhl<zzh> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzh.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzbs);
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
            zzfs.zza(zzh.class, zzbs);
        }
    }

    public static final class zzi extends zzfs<zzi, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzi zzbv = new zzi();
        private static volatile zzhl<zzi> zzm;
        private String zzac;
        private long zzad;
        private String zzas;
        private String zzat;
        private String zzbt;
        private String zzbu;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzi, zza> implements zzhd {
            private zza() {
                super(zzi.zzbv);
            }

            public final zza zzaf(String str) {
                zzhi();
                ((zzi) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzag(String str) {
                zzhi();
                ((zzi) this.zzxc).zzae(str);
                return this;
            }

            public final zza zzah(String str) {
                zzhi();
                ((zzi) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzi() {
            String str = "";
            this.zzas = str;
            this.zzbt = str;
            this.zzbu = str;
            this.zzat = str;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzas = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzae(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzbt = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzab() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzbv.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzbv, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0006\b\u0004\u0007\u0003\u0005", new Object[]{"zzi", "zzas", "zzbt", "zzbu", "zzat", "zzac", "zzad"});
                case 4:
                    return zzbv;
                case 5:
                    zzhl<zzi> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzi.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzbv);
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
            zzfs.zza(zzi.class, zzbv);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase_auth.zzj$zzj reason: collision with other inner class name */
    public static final class C0529zzj extends zzfs<C0529zzj, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final C0529zzj zzbx = new C0529zzj();
        private static volatile zzhl<C0529zzj> zzm;
        private String zzaf;
        private byte zzam = 2;
        private String zzat;
        private String zzbi;
        private int zzbw;
        private int zzi;

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzj$zzj$zza */
        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<C0529zzj, zza> implements zzhd {
            private zza() {
                super(C0529zzj.zzbx);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private C0529zzj() {
            String str = "";
            this.zzaf = str;
            this.zzat = str;
            this.zzbi = str;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzad() {
            return this.zzbi;
        }

        public final zzjn zzae() {
            zzjn zzbf = zzjn.zzbf(this.zzbw);
            return zzbf == null ? zzjn.OOB_REQ_TYPE_UNSPECIFIED : zzbf;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new C0529zzj();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzbx, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\f\u0003", new Object[]{"zzi", "zzaf", "zzat", "zzbi", "zzbw", zzjn.zzbj()});
                case 4:
                    return zzbx;
                case 5:
                    zzhl<C0529zzj> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (C0529zzj.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzbx);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<C0529zzj> zzl() {
            return (zzhl) zzbx.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(C0529zzj.class, zzbx);
        }
    }

    public static final class zzk extends zzfs<zzk, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzk zzcc = new zzk();
        private static volatile zzhl<zzk> zzm;
        private String zzac;
        private long zzad;
        private String zzby;
        private String zzbz;
        private String zzca;
        private String zzcb;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzk, zza> implements zzhd {
            private zza() {
                super(zzk.zzcc);
            }

            public final zza zzaj(String str) {
                zzhi();
                ((zzk) this.zzxc).zzai(str);
                return this;
            }

            public final zza zzak(String str) {
                zzhi();
                ((zzk) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzk() {
            String str = "";
            this.zzby = str;
            this.zzbz = str;
            this.zzca = str;
            this.zzcb = str;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzai(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzby = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzag() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzcc.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzcc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0003\u0005", new Object[]{"zzi", "zzby", "zzbz", "zzca", "zzcb", "zzac", "zzad"});
                case 4:
                    return zzcc;
                case 5:
                    zzhl<zzk> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzk.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzcc);
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
            zzfs.zza(zzk.class, zzcc);
        }
    }

    public static final class zzl extends zzfs<zzl, zza> implements zzhd {
        private static final zzfz<Integer, zzo> zzcp = new zzl();
        /* access modifiers changed from: private */
        public static final zzl zzcu = new zzl();
        private static volatile zzhl<zzl> zzm;
        private String zzac;
        private long zzad;
        private String zzao;
        private long zzap;
        private String zzaq;
        private String zzas;
        private String zzat;
        private String zzcd;
        private String zzce;
        private zzga<String> zzcf = zzfs.zzhe();
        private boolean zzcg;
        private boolean zzch;
        private String zzci;
        private String zzcj;
        private zzim zzck;
        private boolean zzcl;
        private String zzcm;
        private String zzcn;
        private zzfy zzco;
        private boolean zzcq;
        private zzga<String> zzcr;
        private long zzcs;
        private long zzct;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzl, zza> implements zzhd {
            private zza() {
                super(zzl.zzcu);
            }

            public final zza zzan(String str) {
                zzhi();
                ((zzl) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzao(String str) {
                zzhi();
                ((zzl) this.zzxc).zzal(str);
                return this;
            }

            public final zza zzap(String str) {
                zzhi();
                ((zzl) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzaq(String str) {
                zzhi();
                ((zzl) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzar(String str) {
                zzhi();
                ((zzl) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzas(String str) {
                zzhi();
                ((zzl) this.zzxc).zzam(str);
                return this;
            }

            public final zza zzc(Iterable<? extends zzo> iterable) {
                zzhi();
                ((zzl) this.zzxc).zza(iterable);
                return this;
            }

            public final zza zzf(boolean z) {
                zzhi();
                ((zzl) this.zzxc).zze(z);
                return this;
            }

            public final zza zzd(Iterable<String> iterable) {
                zzhi();
                ((zzl) this.zzxc).zzb(iterable);
                return this;
            }

            public final zza zzat(String str) {
                zzhi();
                ((zzl) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzl() {
            String str = "";
            this.zzaq = str;
            this.zzao = str;
            this.zzcd = str;
            this.zzat = str;
            this.zzce = str;
            this.zzas = str;
            this.zzci = str;
            this.zzcj = str;
            this.zzcm = str;
            this.zzcn = str;
            this.zzco = zzhd();
            this.zzcr = zzfs.zzhe();
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzal(String str) {
            if (str != null) {
                this.zzi |= 4;
                this.zzcd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 8;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void setPassword(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzce = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzi |= 32;
                this.zzas = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzam(String str) {
            if (str != null) {
                this.zzi |= 16384;
                this.zzcn = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzo> iterable) {
            if (!this.zzco.zzeu()) {
                zzfy zzfy = this.zzco;
                int size = zzfy.size();
                this.zzco = zzfy.zzaq(size == 0 ? 10 : size << 1);
            }
            for (zzo zzbi : iterable) {
                this.zzco.zzar(zzbi.zzbi());
            }
        }

        /* access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 32768;
            this.zzcq = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<String> iterable) {
            if (!this.zzcr.zzeu()) {
                zzga<String> zzga = this.zzcr;
                int size = zzga.size();
                this.zzcr = zzga.zzj(size == 0 ? 10 : size << 1);
            }
            zzdz.zza(iterable, this.zzcr);
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 262144;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzai() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzcu.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzcu, "\u0001\u0017\u0000\u0001\u0002\u001a\u0017\u0000\u0003\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u001a\b\b\u0005\t\u0007\u0006\n\u0007\u0007\u000b\b\b\f\b\t\r\t\n\u000e\u0007\u000b\u000f\b\f\u0010\u0002\r\u0011\b\u000e\u0012\u001e\u0013\u0007\u000f\u0014\u001a\u0015\u0002\u0010\u0016\u0002\u0011\u0019\b\u0012\u001a\u0003\u0013", new Object[]{"zzi", "zzaq", "zzao", "zzcd", "zzat", "zzce", "zzcf", "zzas", "zzcg", "zzch", "zzci", "zzcj", "zzck", "zzcl", "zzcm", "zzap", "zzcn", "zzco", zzo.zzbj(), "zzcq", "zzcr", "zzcs", "zzct", "zzac", "zzad"});
                case 4:
                    return zzcu;
                case 5:
                    zzhl<zzl> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzl.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzcu);
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
            zzfs.zza(zzl.class, zzcu);
        }
    }

    public static final class zzm extends zzfs<zzm, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzm zzcx = new zzm();
        private static volatile zzhl<zzm> zzm;
        private String zzaf;
        private byte zzam = 2;
        private String zzao;
        private String zzaq;
        private String zzat;
        private String zzav;
        private long zzaw;
        private String zzbi;
        private String zzcd;
        private zzga<String> zzcf;
        private boolean zzcg;
        private String zzcn;
        private zzga<zzm> zzcv;
        private String zzcw;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzm, zza> implements zzhd {
            private zza() {
                super(zzm.zzcx);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzm() {
            String str = "";
            this.zzaf = str;
            this.zzao = str;
            this.zzat = str;
            this.zzcd = str;
            this.zzcf = zzfs.zzhe();
            this.zzaq = str;
            this.zzcv = zzhe();
            this.zzbi = str;
            this.zzcn = str;
            this.zzav = str;
            this.zzcw = str;
        }

        @Deprecated
        public final String getEmail() {
            return this.zzat;
        }

        @Deprecated
        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        @Deprecated
        public final List<zzm> zzak() {
            return this.zzcv;
        }

        @Deprecated
        public final String zzal() {
            return this.zzcn;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzam() {
            return this.zzcw;
        }

        public final boolean zzan() {
            return this.zzcg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzcx, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u001a\u0006\b\u0004\u0007\u001b\b\b\u0005\t\b\u0006\n\b\u0007\u000b\u0002\b\f\b\t\r\u0007\n", new Object[]{"zzi", "zzaf", "zzao", "zzat", "zzcd", "zzcf", "zzaq", "zzcv", zzm.class, "zzbi", "zzcn", "zzav", "zzaw", "zzcw", "zzcg"});
                case 4:
                    return zzcx;
                case 5:
                    zzhl<zzm> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzm.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzcx);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zzm> zzl() {
            return (zzhl) zzcx.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzm.class, zzcx);
        }
    }

    public static final class zzn extends zzfs<zzn, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzn zzcz = new zzn();
        private static volatile zzhl<zzn> zzm;
        private String zzac;
        private long zzad;
        private String zzaq;
        private String zzat;
        private String zzcd;
        private String zzce;
        private boolean zzcg;
        private String zzci;
        private String zzcj;
        private String zzcm;
        private String zzcn;
        private boolean zzcy;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzn, zza> implements zzhd {
            private zza() {
                super(zzn.zzcz);
            }

            public final zza zzau(String str) {
                zzhi();
                ((zzn) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzav(String str) {
                zzhi();
                ((zzn) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzaw(String str) {
                zzhi();
                ((zzn) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzn() {
            String str = "";
            this.zzat = str;
            this.zzce = str;
            this.zzcd = str;
            this.zzci = str;
            this.zzcj = str;
            this.zzcm = str;
            this.zzaq = str;
            this.zzcn = str;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void setPassword(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzce = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 1024;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzap() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzcz.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzcz, "\u0001\f\u0000\u0001\u0001\u000e\f\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0007\u0007\t\b\b\n\u0007\t\r\b\n\u000e\u0003\u000b", new Object[]{"zzi", "zzat", "zzce", "zzcd", "zzci", "zzcj", "zzcm", "zzaq", "zzcg", "zzcn", "zzcy", "zzac", "zzad"});
                case 4:
                    return zzcz;
                case 5:
                    zzhl<zzn> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzn.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzcz);
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
            zzfs.zza(zzn.class, zzcz);
        }
    }

    public static final class zzo extends zzfs<zzo, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzo zzda = new zzo();
        private static volatile zzhl<zzo> zzm;
        private String zzaf;
        private byte zzam = 2;
        private String zzao;
        private String zzaq;
        private String zzat;
        private String zzav;
        private long zzaw;
        private String zzcd;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzo, zza> implements zzhd {
            private zza() {
                super(zzo.zzda);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzo() {
            String str = "";
            this.zzaf = str;
            this.zzaq = str;
            this.zzcd = str;
            this.zzat = str;
            this.zzav = str;
            this.zzao = str;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzda, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005\b\b\u0006", new Object[]{"zzi", "zzaf", "zzaq", "zzcd", "zzat", "zzav", "zzaw", "zzao"});
                case 4:
                    return zzda;
                case 5:
                    zzhl<zzo> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzo.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzda);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zzo> zzl() {
            return (zzhl) zzda.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzo.class, zzda);
        }
    }

    public static final class zzp extends zzfs<zzp, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzp zzdi = new zzp();
        private static volatile zzhl<zzp> zzm;
        private String zzac;
        private long zzad;
        private long zzap;
        private String zzaq;
        private String zzcm;
        private boolean zzcq;
        private String zzdb;
        private String zzdc;
        private String zzdd;
        private boolean zzde;
        private boolean zzdf;
        private boolean zzdg = true;
        private String zzdh;
        private int zzi;
        private String zzz;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzp, zza> implements zzhd {
            private zza() {
                super(zzp.zzdi);
            }

            public final zza zzbb(String str) {
                zzhi();
                ((zzp) this.zzxc).zzax(str);
                return this;
            }

            public final zza zzbc(String str) {
                zzhi();
                ((zzp) this.zzxc).zzay(str);
                return this;
            }

            public final zza zzbd(String str) {
                zzhi();
                ((zzp) this.zzxc).zzaz(str);
                return this;
            }

            public final zza zzbe(String str) {
                zzhi();
                ((zzp) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzi(boolean z) {
                zzhi();
                ((zzp) this.zzxc).zze(z);
                return this;
            }

            public final zza zzj(boolean z) {
                zzhi();
                ((zzp) this.zzxc).zzg(z);
                return this;
            }

            public final zza zzk(boolean z) {
                zzhi();
                ((zzp) this.zzxc).zzh(z);
                return this;
            }

            public final zza zzbf(String str) {
                zzhi();
                ((zzp) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzbg(String str) {
                zzhi();
                ((zzp) this.zzxc).zzba(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzp() {
            String str = "";
            this.zzdb = str;
            this.zzdc = str;
            this.zzdd = str;
            this.zzz = str;
            this.zzcm = str;
            this.zzaq = str;
            this.zzac = str;
            this.zzdh = str;
        }

        /* access modifiers changed from: private */
        public final void zzax(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzdb = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzay(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzdc = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzaz(String str) {
            if (str != null) {
                this.zzi |= 16;
                this.zzz = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzi |= 128;
                this.zzaq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 256;
            this.zzcq = z;
        }

        /* access modifiers changed from: private */
        public final void zzg(boolean z) {
            this.zzi |= 512;
            this.zzdf = z;
        }

        /* access modifiers changed from: private */
        public final void zzh(boolean z) {
            this.zzi |= 1024;
            this.zzdg = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 2048;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzba(String str) {
            if (str != null) {
                this.zzi |= 8192;
                this.zzdh = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzas() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzdi.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzdi, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\u0002\u0006\b\b\u0007\t\u0007\b\n\u0007\t\u000b\u0007\n\r\b\u000b\u000e\u0003\f\u000f\b\r", new Object[]{"zzi", "zzdb", "zzdc", "zzdd", "zzde", "zzz", "zzcm", "zzap", "zzaq", "zzcq", "zzdf", "zzdg", "zzac", "zzad", "zzdh"});
                case 4:
                    return zzdi;
                case 5:
                    zzhl<zzp> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzp.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzdi);
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
            zzfs.zza(zzp.class, zzdi);
        }
    }

    public static final class zzq extends zzfs<zzq, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzq zzel = new zzq();
        private static volatile zzhl<zzq> zzm;
        private String zzao;
        private String zzaq;
        private String zzat;
        private String zzav;
        private long zzaw;
        private boolean zzax;
        private String zzcd;
        private boolean zzcg;
        private String zzcn;
        private String zzdh;
        private int zzdj;
        private String zzdk;
        private String zzdl;
        private String zzdm;
        private String zzdn;
        private String zzdo;
        private String zzdp;
        private String zzdq;
        private String zzdr;
        private String zzds;
        private String zzdt;
        private String zzdu;
        private boolean zzdv;
        private String zzdw;
        private zzga<String> zzdx = zzfs.zzhe();
        private boolean zzdy;
        private String zzdz;
        private String zzea;
        private String zzeb;
        private String zzec;
        private long zzed;
        private String zzee;
        private boolean zzef;
        private String zzeg;
        private String zzeh;
        private String zzei;
        private String zzej;
        private String zzek;
        private int zzi;
        private String zzr;
        private String zzt;
        private String zzv;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzq, zza> implements zzhd {
            private zza() {
                super(zzq.zzel);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzq() {
            String str = "";
            this.zzdk = str;
            this.zzr = str;
            this.zzat = str;
            this.zzdl = str;
            this.zzdm = str;
            this.zzdn = str;
            this.zzdo = str;
            this.zzdp = str;
            this.zzdq = str;
            this.zzcn = str;
            this.zzdr = str;
            this.zzds = str;
            this.zzt = str;
            this.zzdt = str;
            this.zzdu = str;
            this.zzao = str;
            this.zzcd = str;
            this.zzaq = str;
            this.zzdw = str;
            this.zzv = str;
            this.zzdz = str;
            this.zzea = str;
            this.zzeb = str;
            this.zzec = str;
            this.zzee = str;
            this.zzeg = str;
            this.zzav = str;
            this.zzeh = str;
            this.zzei = str;
            this.zzej = str;
            this.zzek = str;
            this.zzdh = str;
        }

        public final String getProviderId() {
            return this.zzr;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzal() {
            return this.zzcn;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final boolean zzau() {
            return this.zzdy;
        }

        public final String zzav() {
            return this.zzeb;
        }

        public final boolean zzaw() {
            return this.zzef;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzax() {
            return this.zzeh;
        }

        public final String getRawUserInfo() {
            return this.zzej;
        }

        public final String getErrorMessage() {
            return this.zzek;
        }

        public final boolean zzt() {
            return this.zzax;
        }

        public final String zzay() {
            return this.zzdh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzel, "\u0001(\u0000\u0002\u0001*(\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\b\r\u000f\b\u000e\u0010\b\u000f\u0011\b\u0010\u0012\u0007\u0011\u0013\b\u0012\u0014\b\u0013\u0015\b\u0014\u0017\b\u0015\u0018\u001a\u0019\u0007\u0016\u001a\b\u0017\u001b\b\u0018\u001c\b\u0019\u001d\b\u001a\u001e\u0002\u001b\u001f\b\u001c \u0007\u001d!\b\u001e\"\b\u001f#\u0002 $\b!%\b\"&\b#'\b$(\u0007%*\b&", new Object[]{"zzi", "zzdj", "zzdk", "zzr", "zzat", "zzcg", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzcn", "zzdr", "zzds", "zzt", "zzdt", "zzdu", "zzao", "zzdv", "zzcd", "zzaq", "zzdw", "zzv", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzav", "zzaw", "zzeh", "zzei", "zzej", "zzek", "zzax", "zzdh"});
                case 4:
                    return zzel;
                case 5:
                    zzhl<zzq> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzq.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzel);
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

        public static zzhl<zzq> zzl() {
            return (zzhl) zzel.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzq.class, zzel);
        }
    }

    public static final class zzr extends zzfs<zzr, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzr zzen = new zzr();
        private static volatile zzhl<zzr> zzm;
        private long zzap;
        private String zzcm;
        private boolean zzcq;
        private String zzem;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzr, zza> implements zzhd {
            private zza() {
                super(zzr.zzen);
            }

            public final zza zzbi(String str) {
                zzhi();
                ((zzr) this.zzxc).zzbh(str);
                return this;
            }

            public final zza zzl(boolean z) {
                zzhi();
                ((zzr) this.zzxc).zze(z);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzr() {
            String str = "";
            this.zzem = str;
            this.zzcm = str;
        }

        /* access modifiers changed from: private */
        public final void zzbh(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzem = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 4;
            this.zzcq = z;
        }

        public static zza zzba() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzen.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzen, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u0002\u0003", new Object[]{"zzi", "zzem", "zzcm", "zzcq", "zzap"});
                case 4:
                    return zzen;
                case 5:
                    zzhl<zzr> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzr.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzen);
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
            zzfs.zza(zzr.class, zzen);
        }
    }

    public static final class zzs extends zzfs<zzs, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzs zzeo = new zzs();
        private static volatile zzhl<zzs> zzm;
        private String zzaf;
        private byte zzam = 2;
        private String zzaq;
        private String zzav;
        private long zzaw;
        private boolean zzax;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzs, zza> implements zzhd {
            private zza() {
                super(zzs.zzeo);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzs() {
            String str = "";
            this.zzaf = str;
            this.zzaq = str;
            this.zzav = str;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final boolean zzt() {
            return this.zzax;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzeo, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0007\u0004", new Object[]{"zzi", "zzaf", "zzaq", "zzav", "zzaw", "zzax"});
                case 4:
                    return zzeo;
                case 5:
                    zzhl<zzs> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzs.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzeo);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zzs> zzl() {
            return (zzhl) zzeo.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzs.class, zzeo);
        }
    }

    public static final class zzt extends zzfs<zzt, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzt zzeq = new zzt();
        private static volatile zzhl<zzt> zzm;
        private String zzac;
        private long zzad;
        private long zzap;
        private String zzaq;
        private String zzat;
        private String zzce;
        private String zzci;
        private String zzcj;
        private String zzcm;
        private boolean zzcq;
        private String zzdd;
        private String zzep;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzt, zza> implements zzhd {
            private zza() {
                super(zzt.zzeq);
            }

            public final zza zzbj(String str) {
                zzhi();
                ((zzt) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzbk(String str) {
                zzhi();
                ((zzt) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzm(boolean z) {
                zzhi();
                ((zzt) this.zzxc).zze(z);
                return this;
            }

            public final zza zzbl(String str) {
                zzhi();
                ((zzt) this.zzxc).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzt() {
            String str = "";
            this.zzat = str;
            this.zzce = str;
            this.zzdd = str;
            this.zzci = str;
            this.zzcj = str;
            this.zzep = str;
            this.zzcm = str;
            this.zzaq = str;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzi |= 1;
                this.zzat = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void setPassword(String str) {
            if (str != null) {
                this.zzi |= 2;
                this.zzce = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zzi |= 512;
            this.zzcq = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzi |= 1024;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzbd() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzeq.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzeq, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0007\t\u000b\b\n\f\u0003\u000b", new Object[]{"zzi", "zzat", "zzce", "zzdd", "zzci", "zzcj", "zzep", "zzcm", "zzap", "zzaq", "zzcq", "zzac", "zzad"});
                case 4:
                    return zzeq;
                case 5:
                    zzhl<zzt> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzt.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzeq);
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
            zzfs.zza(zzt.class, zzeq);
        }
    }

    public static final class zzu extends zzfs<zzu, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzu zzer = new zzu();
        private static volatile zzhl<zzu> zzm;
        private String zzaf;
        private boolean zzai;
        private byte zzam = 2;
        private String zzao;
        private String zzaq;
        private String zzat;
        private String zzav;
        private long zzaw;
        private String zzcd;
        private String zzcn;
        private String zzeb;
        private long zzed;
        private String zzee;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzu, zza> implements zzhd {
            private zza() {
                super(zzu.zzer);
            }

            /* synthetic */ zza(zzk zzk) {
                this();
            }
        }

        private zzu() {
            String str = "";
            this.zzaf = str;
            this.zzao = str;
            this.zzat = str;
            this.zzcd = str;
            this.zzaq = str;
            this.zzcn = str;
            this.zzeb = str;
            this.zzee = str;
            this.zzav = str;
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

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String zzal() {
            return this.zzcn;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzer, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0007\u0005\u0007\b\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u0002\u000b", new Object[]{"zzi", "zzaf", "zzao", "zzat", "zzcd", "zzaq", "zzai", "zzcn", "zzeb", "zzed", "zzee", "zzav", "zzaw"});
                case 4:
                    return zzer;
                case 5:
                    zzhl<zzu> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzu.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzer);
                                zzm = zzhl;
                            }
                        }
                    }
                    return zzhl;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhl<zzu> zzl() {
            return (zzhl) zzer.zza(com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzu.class, zzer);
        }
    }
}
