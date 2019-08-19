package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs.zze;

public final class zzjl {

    public static final class zza extends zzfs<zza, C0530zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zza zzadx = new zza();
        private static volatile zzhl<zza> zzm;
        private String zzadt;
        private String zzadu;
        private String zzadv;
        private String zzadw;
        private String zzav;

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzjl$zza$zza reason: collision with other inner class name */
        public static final class C0530zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zza, C0530zza> implements zzhd {
            private C0530zza() {
                super(zza.zzadx);
            }

            public final C0530zza zzdf(String str) {
                zzhi();
                ((zza) this.zzxc).zzde(str);
                return this;
            }

            public final C0530zza zzdg(String str) {
                zzhi();
                ((zza) this.zzxc).zzce(str);
                return this;
            }

            /* synthetic */ C0530zza(zzjm zzjm) {
                this();
            }
        }

        private zza() {
            String str = "";
            this.zzadt = str;
            this.zzadu = str;
            this.zzav = str;
            this.zzadv = str;
            this.zzadw = str;
        }

        /* access modifiers changed from: private */
        public final void zzde(String str) {
            if (str != null) {
                this.zzadt = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzce(String str) {
            if (str != null) {
                this.zzav = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C0530zza zzjy() {
            return (C0530zza) ((com.google.android.gms.internal.firebase_auth.zzfs.zza) zzadx.zza(zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzjm.zzn[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0530zza(null);
                case 3:
                    return zza((zzhb) zzadx, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"zzadt", "zzadu", "zzav", "zzadv", "zzadw"});
                case 4:
                    return zzadx;
                case 5:
                    zzhl<zza> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zza.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzadx);
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
            zzfs.zza(zza.class, zzadx);
        }
    }

    public static final class zzb extends zzfs<zzb, zza> implements zzhd {
        /* access modifiers changed from: private */
        public static final zzb zzaec = new zzb();
        private static volatile zzhl<zzb> zzm;
        private String zzady;
        private String zzadz;
        private String zzaea;
        private long zzaeb;
        private String zzaq;
        private String zzav;
        private long zzaw;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzfs.zza<zzb, zza> implements zzhd {
            private zza() {
                super(zzb.zzaec);
            }

            /* synthetic */ zza(zzjm zzjm) {
                this();
            }
        }

        private zzb() {
            String str = "";
            this.zzady = str;
            this.zzadz = str;
            this.zzav = str;
            this.zzaq = str;
            this.zzaea = str;
        }

        public final String zzdw() {
            return this.zzady;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzdx() {
            return this.zzadz;
        }

        public final String zzr() {
            return this.zzav;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzjm.zzn[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzhb) zzaec, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002", new Object[]{"zzady", "zzaw", "zzadz", "zzav", "zzaq", "zzaea", "zzaeb"});
                case 4:
                    return zzaec;
                case 5:
                    zzhl<zzb> zzhl = zzm;
                    if (zzhl == null) {
                        synchronized (zzb.class) {
                            zzhl = zzm;
                            if (zzhl == null) {
                                zzhl = new com.google.android.gms.internal.firebase_auth.zzfs.zzb<>(zzaec);
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

        public static zzhl<zzb> zzl() {
            return (zzhl) zzaec.zza(zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzfs.zza(zzb.class, zzaec);
        }
    }
}
